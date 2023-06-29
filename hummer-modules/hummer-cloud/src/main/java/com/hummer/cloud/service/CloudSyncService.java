package com.hummer.cloud.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hummer.cloud.mapper.*;
import com.hummer.cloud.mapper.ext.ExtCloudResourceRelaMapper;
import com.hummer.cloud.mapper.ext.ExtCloudResourceSyncItemMapper;
import com.hummer.cloud.mapper.ext.ExtCloudResourceSyncMapper;
import com.hummer.common.core.constant.CloudTaskConstants;
import com.hummer.common.core.constant.CommandEnum;
import com.hummer.common.core.constant.ResourceOperation;
import com.hummer.common.core.constant.ResourceTypeConstants;
import com.hummer.common.core.domain.*;
import com.hummer.common.core.domain.request.cloudResource.CloudResourceSyncRequest;
import com.hummer.common.core.domain.request.sync.CloudTopology;
import com.hummer.common.core.dto.CloudResourceRelaDTO;
import com.hummer.common.core.dto.CloudResourceSyncItemDTO;
import com.hummer.common.core.dto.TopoChartDTO;
import com.hummer.common.core.exception.HRException;
import com.hummer.common.core.i18n.Translator;
import com.hummer.common.core.utils.*;
import com.hummer.system.api.IOperationLogService;
import com.hummer.system.api.ISystemProviderService;
import com.hummer.system.api.model.LoginUser;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.alibaba.fastjson.JSON.parseArray;
import static com.alibaba.fastjson.JSON.parseObject;


@Service
@Transactional(rollbackFor = Exception.class)
public class CloudSyncService {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private CloudResourceSyncMapper cloudResourceSyncMapper;
    @Autowired
    private ExtCloudResourceSyncMapper extCloudResourceSyncMapper;
    @Autowired
    private CloudResourceSyncItemMapper cloudResourceSyncItemMapper;
    @Autowired
    private CloudResourceSyncItemLogMapper cloudResourceSyncItemLogMapper;
    @Autowired
    private CloudResourceMapper cloudResourceMapper;
    @Autowired
    private CloudResourceItemMapper cloudResourceItemMapper;
    @Autowired
    private CommonThreadPool commonThreadPool;
    @Autowired
    private ProxyMapper proxyMapper;
    @Autowired
    private ExtCloudResourceSyncItemMapper extCloudResourceSyncItemMapper;
    @Autowired
    private CloudResourceRelaMapper cloudResourceRelaMapper;
    @Autowired
    private ExtCloudResourceRelaMapper extCloudResourceRelaMapper;
    @Autowired
    private CloudResourceRelaLinkMapper cloudResourceRelaLinkMapper;
    @DubboReference
    private IOperationLogService operationLogService;
    @DubboReference
    private ISystemProviderService systemProviderService;
    @Autowired
    @Qualifier("loadBalanced")
    private RestTemplate restTemplate;

    /**
     * 获取同步日志
     *
     * @param resourceSyncRequest
     * @return
     */
    public List<CloudResourceSync> getCloudResourceSyncLogs(CloudResourceSyncRequest resourceSyncRequest) {
        return extCloudResourceSyncMapper.selectByRequest(resourceSyncRequest);
    }

    public List<Map<String, Object>> getResourceType(String syncId) {
        return extCloudResourceSyncItemMapper.selectResourceTypeBySyncId(syncId);
    }

    public List<CloudResourceSyncItemDTO> getCloudResourceSyncItem(String syncId) {
        List<CloudResourceSyncItemDTO> cloudResourceSyncItemDtos = extCloudResourceSyncItemMapper.selectBySyncId(syncId);
        List<CloudResourceSyncItemLog> cloudResourceSyncItemLogs = extCloudResourceSyncItemMapper.selectSyncItemLogBySyncId(syncId);
        Map<String, CloudResourceSyncItemDTO> cloudResourceSyncItemDtoMap = cloudResourceSyncItemDtos.stream().collect(Collectors.toMap(CloudResourceSyncItemDTO::getId, Function.identity()));
        for (CloudResourceSyncItemLog cloudResourceSyncItemLog : cloudResourceSyncItemLogs) {
            CloudResourceSyncItemDTO cloudResourceSyncItemDto = cloudResourceSyncItemDtoMap.get(cloudResourceSyncItemLog.getSyncItemId());
            if (cloudResourceSyncItemDto != null) {
                List<CloudResourceSyncItemLog> cloudResourceSyncItemLogs1 = cloudResourceSyncItemDto.getCloudResourceSyncItemLogs();
                if (cloudResourceSyncItemLogs1 == null) {
                    cloudResourceSyncItemLogs1 = new ArrayList<>();
                    cloudResourceSyncItemDto.setCloudResourceSyncItemLogs(cloudResourceSyncItemLogs1);
                }
                cloudResourceSyncItemLogs1.add(cloudResourceSyncItemLog);
            }
        }
        return cloudResourceSyncItemDtos;
    }

    public void sync(String accountId, LoginUser loginUser) throws Exception {
        LoginUser user = loginUser;
        //先清理后插入
        deleteResourceSync(accountId);

        CloudResourceSync cloudResourceSync = new CloudResourceSync();
        AccountWithBLOBs account = accountMapper.selectByPrimaryKey(accountId);
        String id = UUIDUtil.newUUID();
        String[] resourceTypes = PlatformUtils.checkoutResourceType(account.getPluginId());
        JSONArray jsonArray = JSON.parseArray(account.getRegions());
        JSONObject object;
        List<String> regions = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            try {
                object = jsonArray.getJSONObject(i);
                String value = object.getString("regionId");
                regions.add(value);
            } catch (Exception e) {
                String value = jsonArray.get(0).toString();
                regions.add(value);
            }
        }
        cloudResourceSync.setId(id);
        cloudResourceSync.setPluginId(account.getPluginId());
        cloudResourceSync.setPluginIcon(account.getPluginIcon());
        cloudResourceSync.setPluginName(account.getPluginName());
        cloudResourceSync.setAccountId(accountId);
        cloudResourceSync.setCreateTime(System.currentTimeMillis());
        cloudResourceSync.setApplyUser(user.getUserId());
        cloudResourceSync.setResourceTypes(StringUtils.join(resourceTypes, ","));
        cloudResourceSync.setStatus(CloudTaskConstants.TASK_STATUS.APPROVED.name());
        //云资源同步主表
        cloudResourceSyncMapper.insertSelective(cloudResourceSync);

        for (String resourceType : resourceTypes) {
            for (String region : regions) {
                CloudResourceSyncItem cloudResourceSyncItem = new CloudResourceSyncItem();
                String uuid = UUIDUtil.newUUID();
                cloudResourceSyncItem.setId(uuid);
                cloudResourceSyncItem.setSyncId(id);
                cloudResourceSyncItem.setStatus(CloudTaskConstants.TASK_STATUS.UNCHECKED.name());
                cloudResourceSyncItem.setCreateTime(System.currentTimeMillis());
                cloudResourceSyncItem.setAccountId(accountId);
                cloudResourceSyncItem.setAccountUrl(account.getPluginIcon());
                cloudResourceSyncItem.setAccountLabel(account.getName());
                cloudResourceSyncItem.setResourceType(resourceType);
                cloudResourceSyncItem.setRegionId(region);
                cloudResourceSyncItem.setRegionName(PlatformUtils.tranforRegionId2RegionName(region, account.getPluginId()));
                //云资源同步子表（区分区域与资源类型）
                cloudResourceSyncItemMapper.insertSelective(cloudResourceSyncItem);

                saveCloudResourceSyncItemLog(cloudResourceSyncItem.getId(), "i18n_start_sync_resource", "", true, accountId, user.getUserId());

                final String finalScript = CloudTaskConstants.policy.replace("{resourceType}", resourceType);

                commonThreadPool.addTask(() -> {
                    if (!PlatformUtils.checkAvailableRegion(account.getPluginId(), resourceType, region)) {
                        cloudResourceSyncItem.setCount(0);
                        cloudResourceSyncItem.setStatus(CloudTaskConstants.TASK_STATUS.FINISHED.name());
                        cloudResourceSyncItemMapper.updateByPrimaryKey(cloudResourceSyncItem);
                        saveCloudResourceSyncItemLog(cloudResourceSyncItem.getId(), "i18n_end_sync_resource", "不支持该区域", true, accountId, user.getUserId());
                        return;
                    }
                    String dirPath = "", resultStr = "", fileName = "policy.yml";
                    boolean readResource = true;
                    try {
                        long nowDate = new Date().getTime();

                        String resources = "[]";
                        String custodianRun = "";
                        String metadata = "";

                        Map<String, String> map = PlatformUtils.getAccount(account, region, proxyMapper.selectByPrimaryKey(account.getProxyId()));

                        if (systemProviderService.license()) {
                            HttpHeaders headers = new HttpHeaders();
                            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                            JSONObject jsonObject = PlatformUtils.fixedScanner(finalScript, map, account.getPluginId());
                            LogUtil.warn("sync all resource {scanner}[api body]: " + jsonObject.toJSONString());

                            HttpEntity<?> httpEntity = new HttpEntity<>(jsonObject, headers);
                            String result = restTemplate.postForObject("http://hummer-scaner/run", httpEntity, String.class);
                            JSONObject resultJson = JSONObject.parseObject(result);
                            String resultCode = resultJson.getString("code").toString();
                            String resultMsg = resultJson.getString("msg").toString();
                            if (!StringUtils.equals(resultCode, "200")) {
                                HRException.throwException(Translator.get("i18n_create_resource_failed") + ": " + resultMsg);
                            }

                            resultStr = resultJson.getString("data").toString();

                            if (PlatformUtils.isUserForbidden(resultStr)) {
                                resultStr = Translator.get("i18n_create_resource_region_failed");
                                readResource = false;
                            }
                            if (resultStr.contains("ERROR"))
                                HRException.throwException(Translator.get("i18n_create_resource_failed") + " 「api server」: " + resultStr);

                            custodianRun = jsonObject.toJSONString();
                            metadata = jsonObject.toJSONString();

                            if (readResource) {
                                resources = resultStr;
                            }

                        } else {
                            dirPath = CloudTaskConstants.RESULT_FILE_PATH_PREFIX + uuid + "/" + region;
                            CommandUtils.saveAsFile(finalScript, dirPath, "policy.yml", false);
                            String command = PlatformUtils.fixedCommand(CommandEnum.custodian.getCommand(), CommandEnum.run.getCommand(), dirPath, fileName, map);
                            LogUtil.warn(account.getId() + " {}[command]: " + command);
                            resultStr = CommandUtils.commonExecCmdWithResult(command, dirPath);
                            if (LogUtil.getLogger().isDebugEnabled()) {
                                LogUtil.getLogger().debug("resource created: {}", resultStr);
                            }
                            if (PlatformUtils.isUserForbidden(resultStr)) {
                                resultStr = Translator.get("i18n_create_resource_region_failed");
                                readResource = false;
                            }
                            if (resultStr.contains("ERROR"))
                                HRException.throwException(Translator.get("i18n_create_resource_failed") + "「cloud」: " + resultStr);

                            custodianRun = ReadFileUtils.readToBuffer(dirPath + "/all-resources/" + CloudTaskConstants.CUSTODIAN_RUN_RESULT_FILE);
                            metadata = ReadFileUtils.readJsonFile(dirPath + "/all-resources/", CloudTaskConstants.METADATA_RESULT_FILE);

                            if (readResource) {
                                resources = ReadFileUtils.readJsonFile(dirPath + "/all-resources/", CloudTaskConstants.RESOURCES_RESULT_FILE);
                            }
                        }

                        CloudResourceWithBLOBs cloudResourceWithBLOBs = new CloudResourceWithBLOBs();
                        cloudResourceWithBLOBs.setId(UUIDUtil.newUUID());
                        cloudResourceWithBLOBs.setCustodianRunLog(custodianRun);
                        cloudResourceWithBLOBs.setMetadata(metadata);
                        cloudResourceWithBLOBs.setResources(resources);
                        cloudResourceWithBLOBs.setResourceType(resourceType);
                        cloudResourceWithBLOBs.setPluginIcon(account.getPluginIcon());
                        cloudResourceWithBLOBs.setPluginId(account.getPluginId());
                        cloudResourceWithBLOBs.setPluginName(account.getPluginName());
                        cloudResourceWithBLOBs.setAccountId(accountId);
                        cloudResourceWithBLOBs.setRegionId(region);
                        cloudResourceWithBLOBs.setCreateTime(nowDate);
                        cloudResourceWithBLOBs.setUpdateTime(nowDate);
                        cloudResourceWithBLOBs.setRegionName(cloudResourceSyncItem.getRegionName());
                        JSONArray resourcesArr = parseArray(resources);
                        cloudResourceWithBLOBs.setResourcesSum((long) resourcesArr.size());

                        //云资源同步资源表（查看返回结果与log）
                        cloudResourceMapper.insertSelective(cloudResourceWithBLOBs);

                        for (Object obj : resourcesArr) {
                            //资源详情
                            JSONObject jsonObject = parseObject(obj.toString());
                            String hummerId = jsonObject.getString("hummerId") != null ? jsonObject.getString("hummerId") : jsonObject.getString("id");
                            String hummerName = jsonObject.getString("hummerName") != null ? jsonObject.getString("hummerName") : jsonObject.getString("id");
                            CloudResourceItem cloudResourceItem = new CloudResourceItem();
                            cloudResourceItem.setId(UUIDUtil.newUUID());
                            cloudResourceItem.setAccountId(accountId);
                            cloudResourceItem.setUpdateTime(System.currentTimeMillis());
                            cloudResourceItem.setPluginIcon(account.getPluginIcon());
                            cloudResourceItem.setPluginId(account.getPluginId());
                            cloudResourceItem.setPluginName(account.getPluginName());
                            cloudResourceItem.setRegionId(region);
                            cloudResourceItem.setRegionName(cloudResourceSyncItem.getRegionName());
                            cloudResourceItem.setResourceId(cloudResourceWithBLOBs.getId());
                            cloudResourceItem.setResourceType(resourceType);
                            cloudResourceItem.setHummerId(hummerId);
                            cloudResourceItem.setHummerName(hummerName);
                            cloudResourceItem.setCreateTime(nowDate);
                            cloudResourceItem.setResource(jsonObject.toJSONString());

                            //云资源同步资源详情表
                            cloudResourceItemMapper.insertSelective(cloudResourceItem);

                            //计算云资源关系拓扑图数据
                            dealWithResourceRelation(cloudResourceItem);
                        }
                        cloudResourceSyncItem.setCount(resourcesArr.size());
                        cloudResourceSyncItem.setStatus(CloudTaskConstants.TASK_STATUS.FINISHED.name());
                        cloudResourceSyncItemMapper.updateByPrimaryKey(cloudResourceSyncItem);
                        saveCloudResourceSyncItemLog(cloudResourceSyncItem.getId(), "i18n_end_sync_resource", "资源总数:" + resourcesArr.size(), true, accountId, user.getUserId());

                    } catch (Exception e) {
                        e.printStackTrace();
                        cloudResourceSyncItem.setStatus(CloudTaskConstants.TASK_STATUS.ERROR.name());
                        cloudResourceSyncItemMapper.updateByPrimaryKey(cloudResourceSyncItem);
                        saveCloudResourceSyncItemLog(cloudResourceSyncItem.getId(), "i18n_error_sync_resource", e.getMessage(), false, accountId, user.getUserId());
                        LogUtil.error("Sync Resources error :{}", uuid + "/" + region, e.getMessage());
                    }

                });
                //向首页活动添加操作信息
                operationLogService.log(user, id, account.getName(), ResourceTypeConstants.SYNC.name(), ResourceOperation.SYNC, "i18n_start_sync_resource");
            }
        }
    }

    void saveCloudResourceSyncItemLog(String syncItemId, String operation, String output, boolean result, String accountId, String operator) {
        CloudResourceSyncItemLog log = new CloudResourceSyncItemLog();
        log.setOperator(operator == null ? "system" : operator);
        log.setSyncItemId(syncItemId);
        log.setCreateTime(System.currentTimeMillis());
        log.setOperation(operation);
        log.setOutput(output);
        log.setResult(result);
        log.setAccountId(accountId);
        cloudResourceSyncItemLogMapper.insertSelective(log);
    }

    public void deleteResourceSync(String accountId) throws Exception {
        CloudResourceSyncExample cloudResourceSyncExample = new CloudResourceSyncExample();
        cloudResourceSyncExample.createCriteria().andAccountIdEqualTo(accountId);
        cloudResourceSyncMapper.deleteByExample(cloudResourceSyncExample);

        CloudResourceSyncItemExample cloudResourceSyncItemExample = new CloudResourceSyncItemExample();
        cloudResourceSyncItemExample.createCriteria().andAccountIdEqualTo(accountId);
        cloudResourceSyncItemMapper.deleteByExample(cloudResourceSyncItemExample);

        CloudResourceSyncItemLogExample cloudResourceSyncItemLogExample = new CloudResourceSyncItemLogExample();
        cloudResourceSyncItemLogExample.createCriteria().andAccountIdEqualTo(accountId);
        cloudResourceSyncItemLogMapper.deleteByExample(cloudResourceSyncItemLogExample);

        CloudResourceExample cloudResourceExample = new CloudResourceExample();
        cloudResourceExample.createCriteria().andAccountIdEqualTo(accountId);
        cloudResourceMapper.deleteByExample(cloudResourceExample);

        CloudResourceItemExample cloudResourceItemExample = new CloudResourceItemExample();
        cloudResourceItemExample.createCriteria().andAccountIdEqualTo(accountId);
        cloudResourceItemMapper.deleteByExample(cloudResourceItemExample);

        CloudResourceRelaExample cloudResourceRelaExample = new CloudResourceRelaExample();
        cloudResourceRelaExample.createCriteria().andAccountIdEqualTo(accountId);
        List<CloudResourceRela> cloudResourceRelaList = cloudResourceRelaMapper.selectByExample(cloudResourceRelaExample);

        for (CloudResourceRela cloudResourceRela : cloudResourceRelaList) {
            CloudResourceRelaLinkExample cloudResourceRelaLinkExample = new CloudResourceRelaLinkExample();
            cloudResourceRelaLinkExample.createCriteria().andResourceItemIdEqualTo(cloudResourceRela.getResourceItemId());
            cloudResourceRelaLinkMapper.deleteByExample(cloudResourceRelaLinkExample);

            cloudResourceRelaMapper.deleteByPrimaryKey(cloudResourceRela.getId());
        }
    }

    public void syncResources(LoginUser loginUser) throws Exception {
        AccountExample example = new AccountExample();
        example.createCriteria().andStatusEqualTo("VALID");
        List<Account> accounts = accountMapper.selectByExample(example);
        for (Account account : accounts) {
            sync(account.getId(), loginUser);
        }
    }

    public void deleteSync(String id) {
        CloudResourceSync cloudResourceSync = cloudResourceSyncMapper.selectByPrimaryKey(id);
        cloudResourceSyncMapper.deleteByPrimaryKey(id);
        CloudResourceSyncItemExample cloudResourceSyncItemExample = new CloudResourceSyncItemExample();
        cloudResourceSyncItemExample.createCriteria().andSyncIdEqualTo(id);
        cloudResourceSyncItemMapper.deleteByExample(cloudResourceSyncItemExample);
        CloudResourceSyncItemLogExample cloudResourceSyncItemLogExample = new CloudResourceSyncItemLogExample();
        cloudResourceSyncItemLogExample.createCriteria().andAccountIdEqualTo(cloudResourceSync.getAccountId());
        cloudResourceSyncItemLogMapper.deleteByExample(cloudResourceSyncItemLogExample);
    }

    public void deleteLogs(List<String> ids) throws Exception {
        ids.forEach(id -> {
            try {
                deleteSync(id);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        });
    }

    public CloudTopology cloudTopology(String accountId) {
        return extCloudResourceSyncMapper.cloudTopology(accountId);
    }

    public TopoChartDTO cloudTopologyRela(String resourceItemId) {

        TopoChartDTO topoChartDTO = new TopoChartDTO();

        List<CloudResourceRelaDTO> cloudResourceRelaList = extCloudResourceRelaMapper.selectCloudTopologyRela(resourceItemId);

        CloudResourceRelaLinkExample cloudResourceRelaLinkExample = new CloudResourceRelaLinkExample();
        cloudResourceRelaLinkExample.createCriteria().andResourceItemIdEqualTo(resourceItemId);
        List<CloudResourceRelaLink> cloudResourceRelaLinkList = cloudResourceRelaLinkMapper.selectByExample(cloudResourceRelaLinkExample);

        topoChartDTO.setCloudResourceRelaList(cloudResourceRelaList);
        topoChartDTO.setCloudResourceRelaLinkList(cloudResourceRelaLinkList);

        return topoChartDTO;
    }

    public void dealWithResourceRelation(CloudResourceItem cloudResourceItem) throws Exception {
        try {
            //计算云资源关系拓扑图数据
            LogUtil.info("开始：计算云资源关系拓扑图数据" + cloudResourceItem.getResourceType() + " " + cloudResourceItem.getHummerName());

            CloudResourceRelaExample cloudResourceRelaExample = new CloudResourceRelaExample();
            cloudResourceRelaExample.createCriteria().andResourceItemIdEqualTo(cloudResourceItem.getId());
            cloudResourceRelaMapper.deleteByExample(cloudResourceRelaExample);

            CloudResourceRelaLinkExample cloudResourceRelaLinkExample = new CloudResourceRelaLinkExample();
            cloudResourceRelaLinkExample.createCriteria().andResourceItemIdEqualTo(cloudResourceItem.getId());
            cloudResourceRelaLinkMapper.deleteByExample(cloudResourceRelaLinkExample);
            String pluginId = cloudResourceItem.getPluginId();
            if (StringUtils.equals(pluginId, "hummer-aws-plugin")) {
                dealAws(cloudResourceItem);
            } else if (StringUtils.equals(pluginId, "hummer-azure-plugin")) {
                dealAzure(cloudResourceItem);
            } else if (StringUtils.equals(pluginId, "hummer-aliyun-plugin")) {
                dealAliyun(cloudResourceItem);
            } else if (StringUtils.equals(pluginId, "hummer-huawei-plugin")) {
                dealHuawei(cloudResourceItem);
            } else if (StringUtils.equals(pluginId, "hummer-qcloud-plugin")) {
                dealQcloud(cloudResourceItem);
            } else if (StringUtils.equals(pluginId, "hummer-vsphere-plugin")) {
                dealVsphere(cloudResourceItem);
            } else if (StringUtils.equals(pluginId, "hummer-openstack-plugin")) {
                dealOpenstack(cloudResourceItem);
            } else if (StringUtils.equals(pluginId, "hummer-gcp-plugin")) {
                dealGcp(cloudResourceItem);
            } else if (StringUtils.equals(pluginId, "hummer-huoshan-plugin")) {
                dealHuoshan(cloudResourceItem);
            } else if (StringUtils.equals(pluginId, "hummer-baidu-plugin")) {
                dealBaidu(cloudResourceItem);
            } else if (StringUtils.equals(pluginId, "hummer-qiniu-plugin")) {
                dealQiniu(cloudResourceItem);
            } else if (StringUtils.equals(pluginId, "hummer-qingcloud-plugin")) {
                dealQingcloud(cloudResourceItem);
            } else if (StringUtils.equals(pluginId, "hummer-ucloud-plugin")) {
                dealUcloud(cloudResourceItem);
            } else if (StringUtils.equals(pluginId, "hummer-jdcloud-plugin")) {
                dealJdcloud(cloudResourceItem);
            } else if (StringUtils.equals(pluginId, "hummer-ksyun-plugin")) {
                dealKsyun(cloudResourceItem);
            }
            LogUtil.info("结束：计算云资源关系拓扑图数据");
        } catch (Exception e) {
            LogUtil.info("报错：计算云资源关系拓扑图数据" + e.getMessage());
            throw e;
        }
    }

    public void dealAws(CloudResourceItem cloudResourceItem) throws Exception {
        String json = cloudResourceItem.getResource();
        if (StringUtils.isEmpty(json)) return;

        String resourceType = cloudResourceItem.getResourceType();
        String accountId = cloudResourceItem.getAccountId();
        String regionId = cloudResourceItem.getRegionId();
        String hummerId = cloudResourceItem.getHummerId();
        JSONObject jsonObject = JSONObject.parseObject(json);

        Long x = 200L, y = 200L;

        CloudResourceRela cloudResourceRela = new CloudResourceRela();
        cloudResourceRela.setResourceItemId(cloudResourceItem.getId());
        cloudResourceRela.setPluginId(cloudResourceItem.getPluginId());
        cloudResourceRela.setAccountId(accountId);
        cloudResourceRela.setRegionId(regionId);
        cloudResourceRela.setResourceType(resourceType);
        cloudResourceRela.setHummerId(hummerId);
        cloudResourceRela.setName(cloudResourceItem.getHummerName());
        cloudResourceRela.setxAxis(x);//100
        cloudResourceRela.setyAxis(y);//100

        CloudResourceRelaLink cloudResourceRelaLink = new CloudResourceRelaLink();
        cloudResourceRelaLink.setResourceItemId(cloudResourceItem.getId());
        String Internet = UUIDUtil.newUUID();

        switch (resourceType) {
            case "aws.ec2":
                String PublicIpAddress = jsonObject.getString("PublicIpAddress");

                if (StringUtils.isEmpty(PublicIpAddress)) {

                    cloudResourceRela.setId(Internet);
                    cloudResourceRela.setName("No Internet");
                    cloudResourceRela.setResourceType("internet");
                    cloudResourceRela.setHummerId("No Internet");
                    cloudResourceRela.setxAxis(x);//200
                    cloudResourceRela.setyAxis(y);//200

                    insertCloudResourceRela(cloudResourceRela);
                } else {

                    cloudResourceRela.setId(Internet);
                    cloudResourceRela.setName("Internet");
                    cloudResourceRela.setResourceType("internet");
                    cloudResourceRela.setHummerId("Internet");
                    cloudResourceRela.setxAxis(x);//200
                    cloudResourceRela.setyAxis(y);//200

                    insertCloudResourceRela(cloudResourceRela);
                }

                JSONArray networkInterfaces = JSONArray.parseArray(!StringUtils.isEmpty(jsonObject.getString("NetworkInterfaces")) ? jsonObject.getString("NetworkInterfaces") : "[]");
                JSONArray BlockDeviceMappings = JSONArray.parseArray(!StringUtils.isEmpty(jsonObject.getString("BlockDeviceMappings")) ? jsonObject.getString("BlockDeviceMappings") : "[]");

                y = y -100L;

                for (Object obj : networkInterfaces) {
                    JSONObject jsonObj = JSONObject.parseObject(obj.toString());
                    String SubnetId = !jsonObj.getString("SubnetId").isEmpty()?jsonObj.getString("SubnetId"):"default";
                    String VpcId = !jsonObj.getString("VpcId").isEmpty()?jsonObj.getString("VpcId"):"default";
                    JSONObject Association = JSONObject.parseObject(!StringUtils.isEmpty(jsonObj.getString("Association")) ? jsonObj.getString("Association") : "{}");
                    String PublicIp = !Association.getString("PublicIp").isEmpty()?jsonObj.getString("PublicIp"):"";;
                    JSONArray Groups = JSONArray.parseArray(!StringUtils.isEmpty(jsonObj.getString("Groups")) ? jsonObj.getString("Groups") : "[]");

                    String SubnetRelaId = UUIDUtil.newUUID();
                    String VpcRelaId = UUIDUtil.newUUID();
                    String PublicRelaIp = UUIDUtil.newUUID();


                    cloudResourceRela.setId(SubnetRelaId);
                    cloudResourceRela.setName(SubnetId);
                    cloudResourceRela.setResourceType("aws.subnet");
                    cloudResourceRela.setHummerId(SubnetId);
                    cloudResourceRela.setxAxis(x + 100L);//300
                    cloudResourceRela.setyAxis(y + 100L);//200
                    cloudResourceRela = insertCloudResourceRela(cloudResourceRela);

                    cloudResourceRelaLink.setSource(Internet);
                    cloudResourceRelaLink.setTarget(SubnetRelaId);
                    insertCloudResourceRelaLink(cloudResourceRelaLink);

                    cloudResourceRela.setId(VpcRelaId);
                    cloudResourceRela.setName(VpcId);
                    cloudResourceRela.setResourceType("aws.vpc");
                    cloudResourceRela.setHummerId(VpcId);
                    cloudResourceRela.setxAxis(x + 200L);//400
                    cloudResourceRela.setyAxis(y + 100L);//200
                    cloudResourceRela = insertCloudResourceRela(cloudResourceRela);

                    cloudResourceRelaLink.setSource(SubnetRelaId);
                    cloudResourceRelaLink.setTarget(VpcRelaId);
                    insertCloudResourceRelaLink(cloudResourceRelaLink);

                    if (!StringUtils.isEmpty(PublicIp)) {

                        cloudResourceRela.setId(PublicRelaIp);
                        cloudResourceRela.setName(PublicIp);
                        cloudResourceRela.setResourceType("aws.publicip");
                        cloudResourceRela.setHummerId(PublicIp);
                        cloudResourceRela.setxAxis(x + 300L);//500
                        cloudResourceRela.setyAxis(y + 100L);//200
                        cloudResourceRela = insertCloudResourceRela(cloudResourceRela);

                        cloudResourceRelaLink.setSource(VpcRelaId);
                        cloudResourceRelaLink.setTarget(PublicRelaIp);
                        insertCloudResourceRelaLink(cloudResourceRelaLink);

                        String EcsRelaId = UUIDUtil.newUUID();

                        if (Groups.size() > 0) {

                            cloudResourceRela.setId(EcsRelaId);
                            cloudResourceRela.setName(cloudResourceItem.getHummerName());
                            cloudResourceRela.setResourceType(resourceType);
                            cloudResourceRela.setHummerId(hummerId);
                            cloudResourceRela.setxAxis(x + 500L);//700
                            cloudResourceRela.setyAxis(y + 100L);//200
                            cloudResourceRela = insertCloudResourceRela(cloudResourceRela);

                            for (Object o : Groups) {
                                JSONObject jsonO = JSONObject.parseObject(o.toString());
                                String GroupId = jsonO.getString("GroupId");
                                String GroupName = jsonO.getString("GroupName");
                                String GroupRelaId = UUIDUtil.newUUID();

                                cloudResourceRela.setId(GroupRelaId);
                                cloudResourceRela.setName(GroupName);
                                cloudResourceRela.setResourceType("aws.security-group");
                                cloudResourceRela.setHummerId(GroupId);
                                cloudResourceRela.setxAxis(x + 400L);//400
                                cloudResourceRela.setyAxis(y + 100L);//200
                                cloudResourceRela = insertCloudResourceRela(cloudResourceRela);

                                cloudResourceRelaLink.setSource(PublicRelaIp);
                                cloudResourceRelaLink.setTarget(GroupRelaId);
                                insertCloudResourceRelaLink(cloudResourceRelaLink);

                                cloudResourceRelaLink.setSource(GroupRelaId);
                                cloudResourceRelaLink.setTarget(EcsRelaId);
                                insertCloudResourceRelaLink(cloudResourceRelaLink);

                            }

                            Long i = y;

                            for (Object b : BlockDeviceMappings) {
                                String id = UUIDUtil.newUUID();
                                JSONObject j = JSONObject.parseObject(b.toString());
                                String DeviceName = j.getString("DeviceName");
                                JSONObject Ebs = JSONObject.parseObject(j.getString("Ebs"));
                                String VolumeId = Ebs.getString("VolumeId");

                                cloudResourceRela.setId(id);
                                cloudResourceRela.setName(DeviceName);
                                cloudResourceRela.setResourceType("aws.ebs");
                                cloudResourceRela.setHummerId(VolumeId);
                                cloudResourceRela.setxAxis(x + 600L);//800
                                cloudResourceRela.setyAxis(i + 100L);//200
                                cloudResourceRela = insertCloudResourceRela(cloudResourceRela);

                                cloudResourceRelaLink.setSource(EcsRelaId);
                                cloudResourceRelaLink.setTarget(id);
                                insertCloudResourceRelaLink(cloudResourceRelaLink);

                                i = i + 100;
                            }

                        } else {

                            cloudResourceRela.setId(EcsRelaId);
                            cloudResourceRela.setName(cloudResourceItem.getHummerName());
                            cloudResourceRela.setResourceType(resourceType);
                            cloudResourceRela.setHummerId(hummerId);
                            cloudResourceRela.setxAxis(x + 400L);//600
                            cloudResourceRela.setyAxis(y + 100L);//200
                            cloudResourceRela = insertCloudResourceRela(cloudResourceRela);

                            cloudResourceRelaLink.setSource(cloudResourceRela.getId());
                            cloudResourceRelaLink.setTarget(cloudResourceRela.getId());
                            insertCloudResourceRelaLink(cloudResourceRelaLink);

                            Long i = y;

                            for (Object b : BlockDeviceMappings) {
                                String id = UUIDUtil.newUUID();
                                JSONObject j = JSONObject.parseObject(b.toString());
                                String DeviceName = j.getString("DeviceName");
                                JSONObject Ebs = JSONObject.parseObject(j.getString("Ebs"));
                                String VolumeId = Ebs.getString("VolumeId");

                                cloudResourceRela.setId(id);
                                cloudResourceRela.setName(DeviceName);
                                cloudResourceRela.setResourceType("aws.ebs");
                                cloudResourceRela.setHummerId(VolumeId);
                                cloudResourceRela.setxAxis(x + 500L);//700
                                cloudResourceRela.setyAxis(i + 100L);//200
                                cloudResourceRela = insertCloudResourceRela(cloudResourceRela);

                                cloudResourceRelaLink.setSource(EcsRelaId);
                                cloudResourceRelaLink.setTarget(id);
                                insertCloudResourceRelaLink(cloudResourceRelaLink);

                                i = i + 100;
                            }
                        }

                    } else {

                        String EcsRelaId = UUIDUtil.newUUID();

                        if (Groups.size() > 0) {

                            cloudResourceRela.setId(EcsRelaId);
                            cloudResourceRela.setName(cloudResourceItem.getHummerName());
                            cloudResourceRela.setResourceType(resourceType);
                            cloudResourceRela.setHummerId(cloudResourceItem.getHummerId());
                            cloudResourceRela.setxAxis(x + 400L);//400
                            cloudResourceRela.setyAxis(y + 100L);//200
                            insertCloudResourceRela(cloudResourceRela);

                            for (Object o : Groups) {
                                JSONObject jsonO = JSONObject.parseObject(o.toString());
                                String GroupId = jsonO.getString("GroupId");
                                String GroupName = jsonO.getString("GroupName");
                                String GroupRelaId = UUIDUtil.newUUID();

                                cloudResourceRela.setId(GroupRelaId);
                                cloudResourceRela.setName(GroupName);
                                cloudResourceRela.setResourceType("aws.security-group");
                                cloudResourceRela.setHummerId(GroupId);
                                cloudResourceRela.setxAxis(x + 300L);//400
                                cloudResourceRela.setyAxis(y + 100L);//200
                                cloudResourceRela = insertCloudResourceRela(cloudResourceRela);

                                cloudResourceRelaLink.setSource(PublicRelaIp);
                                cloudResourceRelaLink.setTarget(GroupRelaId);
                                insertCloudResourceRelaLink(cloudResourceRelaLink);

                                cloudResourceRelaLink.setSource(GroupRelaId);
                                cloudResourceRelaLink.setTarget(EcsRelaId);
                                insertCloudResourceRelaLink(cloudResourceRelaLink);

                            }

                            Long i = y;

                            for (Object b : BlockDeviceMappings) {
                                String id = UUIDUtil.newUUID();
                                JSONObject j = JSONObject.parseObject(b.toString());
                                String DeviceName = j.getString("DeviceName");
                                JSONObject Ebs = JSONObject.parseObject(j.getString("Ebs"));
                                String VolumeId = Ebs.getString("VolumeId");

                                cloudResourceRela.setId(id);
                                cloudResourceRela.setName(DeviceName);
                                cloudResourceRela.setResourceType("aws.ebs");
                                cloudResourceRela.setHummerId(VolumeId);
                                cloudResourceRela.setxAxis(x + 500L);//800
                                cloudResourceRela.setyAxis(i + 100L);//200
                                cloudResourceRela = insertCloudResourceRela(cloudResourceRela);

                                cloudResourceRelaLink.setSource(EcsRelaId);
                                cloudResourceRelaLink.setTarget(id);
                                insertCloudResourceRelaLink(cloudResourceRelaLink);

                                i = i + 100;
                            }

                        } else {

                            cloudResourceRela.setId(EcsRelaId);
                            cloudResourceRela.setName(cloudResourceItem.getHummerName());
                            cloudResourceRela.setResourceType(resourceType);
                            cloudResourceRela.setHummerId(hummerId);
                            cloudResourceRela.setxAxis(x + 300L);//600
                            cloudResourceRela.setyAxis(y + 100L);//200
                            cloudResourceRela = insertCloudResourceRela(cloudResourceRela);

                            cloudResourceRelaLink.setSource(cloudResourceRela.getId());
                            cloudResourceRelaLink.setTarget(cloudResourceRela.getId());
                            insertCloudResourceRelaLink(cloudResourceRelaLink);

                            Long i = y;

                            for (Object b : BlockDeviceMappings) {
                                String id = UUIDUtil.newUUID();
                                JSONObject j = JSONObject.parseObject(b.toString());
                                String DeviceName = j.getString("DeviceName");
                                JSONObject Ebs = JSONObject.parseObject(j.getString("Ebs"));
                                String VolumeId = Ebs.getString("VolumeId");

                                cloudResourceRela.setId(id);
                                cloudResourceRela.setName(DeviceName);
                                cloudResourceRela.setResourceType("aws.ebs");
                                cloudResourceRela.setHummerId(VolumeId);
                                cloudResourceRela.setxAxis(x + 200L);//700
                                cloudResourceRela.setyAxis(i + 100L);//200
                                cloudResourceRela = insertCloudResourceRela(cloudResourceRela);

                                cloudResourceRelaLink.setSource(EcsRelaId);
                                cloudResourceRelaLink.setTarget(id);
                                insertCloudResourceRelaLink(cloudResourceRelaLink);

                                i = i + 100;
                            }
                        }
                    }

                    y = y + 100L;

                }
                break;
            case "aws.ebs":

                String ebsRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(ebsRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(200L);//100
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                String State = jsonObject.getString("State");

                if (StringUtils.equals(State, "in-use")) {
                    String Attachments = jsonObject.getString("Attachments");
                    for (Object o : JSONArray.parseArray(Attachments)) {
                        JSONObject Attachment = JSONObject.parseObject(o.toString());
                        String InstanceId = Attachment.getString("InstanceId");
                        String ebsInstanceRelaId = UUIDUtil.newUUID();

                        cloudResourceRela.setId(ebsInstanceRelaId);
                        cloudResourceRela.setName(InstanceId);
                        cloudResourceRela.setResourceType("aliyun.ecs");
                        cloudResourceRela.setHummerId(InstanceId);
                        cloudResourceRela.setxAxis(x + 100L);//100
                        cloudResourceRela.setyAxis(200L);//100
                        insertCloudResourceRela(cloudResourceRela);

                        cloudResourceRelaLink.setSource(ebsRelaId);
                        cloudResourceRelaLink.setTarget(ebsInstanceRelaId);
                        insertCloudResourceRelaLink(cloudResourceRelaLink);

                        x = x + 100L;
                    }

                }
                break;
            case "aws.elb":
                break;
            case "aws.network-addr":

                cloudResourceRela.setId(Internet);
                cloudResourceRela.setName("Internet");
                cloudResourceRela.setResourceType("internet");
                cloudResourceRela.setHummerId("Internet");
                cloudResourceRela.setxAxis(200L);//100
                cloudResourceRela.setyAxis(200L);//100
                insertCloudResourceRela(cloudResourceRela);

                String PublicIp = jsonObject.getString("PublicIp");
                String addrRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(addrRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(PublicIp);
                cloudResourceRela.setName(PublicIp);
                cloudResourceRela.setxAxis(300L);//100
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRelaLink.setSource(Internet);
                cloudResourceRelaLink.setTarget(addrRelaId);
                insertCloudResourceRelaLink(cloudResourceRelaLink);

                break;
            case "aws.rds":
                break;
            case "aws.s3":

                String s3RelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(s3RelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(200L);//100
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                break;
            case "aws.security-group":
                cloudResourceRela.setId(Internet);
                cloudResourceRela.setName("Internet");
                cloudResourceRela.setResourceType("internet");
                cloudResourceRela.setHummerId("Internet");
                cloudResourceRela.setxAxis(200L);//100
                cloudResourceRela.setyAxis(200L);//100
                insertCloudResourceRela(cloudResourceRela);

                String VpcId = jsonObject.getString("VpcId");
                String vpcRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(vpcRelaId);
                cloudResourceRela.setResourceType("aws.vpc");
                cloudResourceRela.setHummerId(VpcId);
                cloudResourceRela.setName(VpcId);
                cloudResourceRela.setxAxis(300L);//100
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRelaLink.setSource(Internet);
                cloudResourceRelaLink.setTarget(vpcRelaId);
                insertCloudResourceRelaLink(cloudResourceRelaLink);

                String sgRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(sgRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(400L);//100
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRelaLink.setSource(vpcRelaId);
                cloudResourceRelaLink.setTarget(sgRelaId);
                insertCloudResourceRelaLink(cloudResourceRelaLink);

                break;
            case "aws.vpc":

                String vpcRelaId_ = UUIDUtil.newUUID();

                cloudResourceRela.setId(vpcRelaId_);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(200L);//100
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                break;
            default:
                break;
        }
    }

    public void dealAzure(CloudResourceItem cloudResourceItem) throws Exception {
    }

    public void dealAliyun(CloudResourceItem cloudResourceItem) throws Exception {

        String json = cloudResourceItem.getResource();
        if (StringUtils.isEmpty(json)) return;

        String resourceType = cloudResourceItem.getResourceType();
        String accountId = cloudResourceItem.getAccountId();
        String regionId = cloudResourceItem.getRegionId();
        String hummerId = cloudResourceItem.getHummerId();
        JSONObject jsonObject = JSONObject.parseObject(json);
        String Internet = UUIDUtil.newUUID();

        Long x = 200L, y = 200L;

        CloudResourceRela cloudResourceRela = new CloudResourceRela();
        cloudResourceRela.setResourceItemId(cloudResourceItem.getId());
        cloudResourceRela.setPluginId(cloudResourceItem.getPluginId());
        cloudResourceRela.setAccountId(accountId);
        cloudResourceRela.setRegionId(regionId);
        cloudResourceRela.setResourceType(resourceType);
        cloudResourceRela.setHummerId(hummerId);
        cloudResourceRela.setName(cloudResourceItem.getHummerName());
        cloudResourceRela.setCreateTime(System.currentTimeMillis());
        cloudResourceRela.setxAxis(x);//100
        cloudResourceRela.setyAxis(y);//100

        CloudResourceRelaLink cloudResourceRelaLink = new CloudResourceRelaLink();
        cloudResourceRelaLink.setResourceItemId(cloudResourceItem.getId());

        switch (resourceType) {
            case "aliyun.ecs":
                String PublicIpAddress = jsonObject.getString("PublicIpAddress");
                JSONArray IpAddress = JSONArray.parseArray(!JSONObject.parseObject(PublicIpAddress).getString("IpAddress").isEmpty() ? JSONObject.parseObject(PublicIpAddress).getString("IpAddress") : "[]");

                String VpcAttributes = jsonObject.getString("VpcAttributes");
                String VpcId = JSONObject.parseObject(VpcAttributes).getString("VpcId");

                String SecurityGroupIds = jsonObject.getString("SecurityGroupIds");
                JSONArray SecurityGroupId = JSONArray.parseArray(!JSONObject.parseObject(SecurityGroupIds).getString("SecurityGroupId").isEmpty() ? JSONObject.parseObject(SecurityGroupIds).getString("SecurityGroupId") : "[]");

                if (IpAddress.size() == 0) {

                    cloudResourceRela.setId(Internet);
                    cloudResourceRela.setName("No Internet");
                    cloudResourceRela.setResourceType("internet");
                    cloudResourceRela.setHummerId("No Internet");
                    cloudResourceRela.setxAxis(x);//200
                    cloudResourceRela.setyAxis(y);//200

                    cloudResourceRelaMapper.insertSelective(cloudResourceRela);
                } else {

                    cloudResourceRela.setId(Internet);
                    cloudResourceRela.setName("Internet");
                    cloudResourceRela.setResourceType("internet");
                    cloudResourceRela.setHummerId("Internet");
                    cloudResourceRela.setxAxis(x);//200
                    cloudResourceRela.setyAxis(y);//200

                    insertCloudResourceRela(cloudResourceRela);
                }

                String VpcRelaId = UUIDUtil.newUUID();

                if (!StringUtils.isEmpty(VpcId)) {

                    cloudResourceRela.setId(VpcId);
                    cloudResourceRela.setName(VpcId);
                    cloudResourceRela.setResourceType("aliyun.vpc");
                    cloudResourceRela.setHummerId(VpcId);
                    cloudResourceRela.setxAxis(x + 100L);//300
                    cloudResourceRela.setyAxis(y);//200
                    cloudResourceRela = insertCloudResourceRela(cloudResourceRela);

                    cloudResourceRelaLink.setSource(Internet);
                    cloudResourceRelaLink.setTarget(VpcId);
                    insertCloudResourceRelaLink(cloudResourceRelaLink);

                    String EcsRelaId = UUIDUtil.newUUID();

                    cloudResourceRela.setId(EcsRelaId);
                    cloudResourceRela.setName(cloudResourceItem.getHummerName());
                    cloudResourceRela.setResourceType(resourceType);
                    cloudResourceRela.setHummerId(hummerId);
                    cloudResourceRela.setxAxis(x + 300L);//500
                    cloudResourceRela.setyAxis(y);//200
                    insertCloudResourceRela(cloudResourceRela);

                    if (IpAddress.size() > 0) {

                        y = 100L;
                        x = 200L;

                        for (Object obj : IpAddress) {
                            String Ip = obj.toString();
                            String PublicRelaIp = UUIDUtil.newUUID();

                            cloudResourceRela.setId(PublicRelaIp);
                            cloudResourceRela.setName(Ip);
                            cloudResourceRela.setResourceType("aliyun.eip");
                            cloudResourceRela.setHummerId(Ip);
                            cloudResourceRela.setxAxis(x + 200L);//400
                            cloudResourceRela.setyAxis(y + 100L);//200
                            cloudResourceRela = insertCloudResourceRela(cloudResourceRela);

                            cloudResourceRelaLink.setSource(VpcRelaId);
                            cloudResourceRelaLink.setTarget(PublicRelaIp);
                            insertCloudResourceRelaLink(cloudResourceRelaLink);

                            cloudResourceRelaLink.setSource(PublicRelaIp);
                            cloudResourceRelaLink.setTarget(EcsRelaId);
                            insertCloudResourceRelaLink(cloudResourceRelaLink);

                            y = y + 100L;
                        }

                        if (SecurityGroupId.size() > 0) {

                            y = 100L;
                            x = 500L;

                            for (Object sg : SecurityGroupId) {
                                String Sg = sg.toString();
                                String GroupRelaId = UUIDUtil.newUUID();

                                cloudResourceRela.setId(GroupRelaId);
                                cloudResourceRela.setName(Sg);
                                cloudResourceRela.setResourceType("aliyun.security-group");
                                cloudResourceRela.setHummerId(Sg);
                                cloudResourceRela.setxAxis(x);//400
                                cloudResourceRela.setyAxis(y + 100L);//200
                                cloudResourceRela = insertCloudResourceRela(cloudResourceRela);

                                cloudResourceRelaLink.setSource(EcsRelaId);
                                cloudResourceRelaLink.setTarget(GroupRelaId);
                                insertCloudResourceRelaLink(cloudResourceRelaLink);

                                y = y + 100L;
                            }
                        }

                    } else {

                        if (SecurityGroupId.size() > 0) {

                            y = 100L;
                            x = 200L;

                            for (Object sg : SecurityGroupId) {
                                String Sg = sg.toString();
                                String GroupRelaId = UUIDUtil.newUUID();

                                cloudResourceRela.setId(GroupRelaId);
                                cloudResourceRela.setName(Sg);
                                cloudResourceRela.setResourceType("aliyun.security-group");
                                cloudResourceRela.setHummerId(Sg);
                                cloudResourceRela.setxAxis(x + 100L);//400
                                cloudResourceRela.setyAxis(y + 100L);//200
                                insertCloudResourceRela(cloudResourceRela);

                                cloudResourceRelaLink.setSource(EcsRelaId);
                                cloudResourceRelaLink.setTarget(GroupRelaId);
                                insertCloudResourceRelaLink(cloudResourceRelaLink);

                                y = y + 100L;
                            }
                        }
                    }

                }
                break;
            case "aliyun.cdn":

                String cdnRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(cdnRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(200L);//200
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                break;
            case "aliyun.disk":
                String InstanceId = jsonObject.getString("InstanceId");
                String EcsRelaId = UUIDUtil.newUUID();
                String DiskRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(EcsRelaId);
                cloudResourceRela.setName(InstanceId);
                cloudResourceRela.setResourceType("aliyun.ecs");
                cloudResourceRela.setHummerId(InstanceId);
                cloudResourceRela.setxAxis(200L);//100
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRela.setId(DiskRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(300L);//200
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRelaLink.setSource(EcsRelaId);
                cloudResourceRelaLink.setTarget(DiskRelaId);
                insertCloudResourceRelaLink(cloudResourceRelaLink);
                break;
            case "aliyun.eip":
                String Eip2EcsInstanceId = jsonObject.getString("InstanceId");
                String EIPEcsRelaId = UUIDUtil.newUUID();
                String EIPRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(EIPEcsRelaId);
                cloudResourceRela.setName(Eip2EcsInstanceId);
                cloudResourceRela.setResourceType("aliyun.ecs");
                cloudResourceRela.setHummerId(Eip2EcsInstanceId);
                cloudResourceRela.setxAxis(200L);//100
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRela.setId(EIPRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(300L);//200
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRelaLink.setSource(EIPEcsRelaId);
                cloudResourceRelaLink.setTarget(EIPRelaId);
                insertCloudResourceRelaLink(cloudResourceRelaLink);
                break;
            case "aliyun.mongodb":
                break;
            case "aliyun.oss":
                cloudResourceRela.setId(Internet);
                cloudResourceRela.setName("Internet");
                cloudResourceRela.setResourceType("internet");
                cloudResourceRela.setHummerId("Internet");
                cloudResourceRela.setxAxis(200L);//100
                cloudResourceRela.setyAxis(200L);//100
                insertCloudResourceRela(cloudResourceRela);

                String extranet_endpoint = jsonObject.getString("extranet_endpoint");
                String extranet_endpoint_id = UUIDUtil.newUUID();

                cloudResourceRela.setId(extranet_endpoint_id);
                cloudResourceRela.setName(extranet_endpoint);
                cloudResourceRela.setResourceType("aliyun.domain");
                cloudResourceRela.setHummerId(extranet_endpoint);
                cloudResourceRela.setxAxis(300L);//100
                cloudResourceRela.setyAxis(200L);//100
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRelaLink.setSource(Internet);
                cloudResourceRelaLink.setTarget(extranet_endpoint_id);
                insertCloudResourceRelaLink(cloudResourceRelaLink);

                String ossRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(ossRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(400L);//100
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRelaLink.setSource(extranet_endpoint_id);
                cloudResourceRelaLink.setTarget(ossRelaId);
                insertCloudResourceRelaLink(cloudResourceRelaLink);

                break;
            case "aliyun.polardb":
                cloudResourceRela.setId(Internet);
                cloudResourceRela.setName("Internet");
                cloudResourceRela.setResourceType("internet");
                cloudResourceRela.setHummerId("Internet");
                cloudResourceRela.setxAxis(200L);//100
                cloudResourceRela.setyAxis(200L);//100
                insertCloudResourceRela(cloudResourceRela);

                String polardbVpcId = jsonObject.getString("VpcId");
                String polardbVpcRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(polardbVpcRelaId);
                cloudResourceRela.setName(polardbVpcId);
                cloudResourceRela.setResourceType("aliyun.vpc");
                cloudResourceRela.setHummerId(polardbVpcId);
                cloudResourceRela.setxAxis(300L);//100
                cloudResourceRela.setyAxis(200L);//100
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRelaLink.setSource(Internet);
                cloudResourceRelaLink.setTarget(polardbVpcRelaId);
                insertCloudResourceRelaLink(cloudResourceRelaLink);

                String polardbRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(polardbRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(400L);//100
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRelaLink.setSource(polardbVpcRelaId);
                cloudResourceRelaLink.setTarget(polardbRelaId);
                insertCloudResourceRelaLink(cloudResourceRelaLink);
                break;
            case "aliyun.ram":
                String ramRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(ramRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(400L);//100
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);
                break;
            case "aliyun.rds":
                String DBInstanceNetType = jsonObject.getString("DBInstanceNetType");

                if (StringUtils.equals(DBInstanceNetType, "Intranet")) {
                    cloudResourceRela.setId(Internet);
                    cloudResourceRela.setName("No Internet");
                    cloudResourceRela.setResourceType("internet");
                    cloudResourceRela.setHummerId("No Internet");
                    cloudResourceRela.setxAxis(200L);//100
                    cloudResourceRela.setyAxis(200L);//100
                    insertCloudResourceRela(cloudResourceRela);
                } else {
                    cloudResourceRela.setId(Internet);
                    cloudResourceRela.setName("Internet");
                    cloudResourceRela.setResourceType("internet");
                    cloudResourceRela.setHummerId("Internet");
                    cloudResourceRela.setxAxis(200L);//100
                    cloudResourceRela.setyAxis(200L);//100
                    insertCloudResourceRela(cloudResourceRela);
                }

                String VpcIdVpcId = jsonObject.getString("VpcId");
                String VpcIdVpcRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(VpcIdVpcRelaId);
                cloudResourceRela.setName(VpcIdVpcId);
                cloudResourceRela.setResourceType("aliyun.vpc");
                cloudResourceRela.setHummerId(VpcIdVpcId);
                cloudResourceRela.setxAxis(300L);//100
                cloudResourceRela.setyAxis(200L);//100
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRelaLink.setSource(Internet);
                cloudResourceRelaLink.setTarget(VpcIdVpcRelaId);
                insertCloudResourceRelaLink(cloudResourceRelaLink);

                String rdsRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(rdsRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(400L);//100
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRelaLink.setSource(VpcIdVpcRelaId);
                cloudResourceRelaLink.setTarget(rdsRelaId);
                insertCloudResourceRelaLink(cloudResourceRelaLink);

                break;
            case "aliyun.redis":

                cloudResourceRela.setId(Internet);
                cloudResourceRela.setName("Internet");
                cloudResourceRela.setResourceType("internet");
                cloudResourceRela.setHummerId("Internet");
                cloudResourceRela.setxAxis(200L);//100
                cloudResourceRela.setyAxis(200L);//100
                insertCloudResourceRela(cloudResourceRela);

                String redisVpcId = jsonObject.getString("VpcId");
                String redisVpcRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(redisVpcRelaId);
                cloudResourceRela.setName(redisVpcId);
                cloudResourceRela.setResourceType("aliyun.vpc");
                cloudResourceRela.setHummerId(redisVpcId);
                cloudResourceRela.setxAxis(300L);//100
                cloudResourceRela.setyAxis(200L);//100
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRelaLink.setSource(Internet);
                cloudResourceRelaLink.setTarget(redisVpcRelaId);
                insertCloudResourceRelaLink(cloudResourceRelaLink);

                String ConnectionDomain = jsonObject.getString("ConnectionDomain");
                String redisDomainRelaId = UUIDUtil.newUUID();
                cloudResourceRela.setId(redisDomainRelaId);
                cloudResourceRela.setResourceType("aliyun.domain");
                cloudResourceRela.setHummerId(ConnectionDomain);
                cloudResourceRela.setName(ConnectionDomain);
                cloudResourceRela.setxAxis(400L);//100
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRelaLink.setSource(redisVpcRelaId);
                cloudResourceRelaLink.setTarget(redisDomainRelaId);
                insertCloudResourceRelaLink(cloudResourceRelaLink);

                String redisRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(redisRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(500L);//100
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRelaLink.setSource(redisDomainRelaId);
                cloudResourceRelaLink.setTarget(redisRelaId);
                insertCloudResourceRelaLink(cloudResourceRelaLink);

                break;
            case "aliyun.security-group":

                cloudResourceRela.setId(Internet);
                cloudResourceRela.setName("Internet");
                cloudResourceRela.setResourceType("internet");
                cloudResourceRela.setHummerId("Internet");
                cloudResourceRela.setxAxis(200L);//100
                cloudResourceRela.setyAxis(200L);//100
                insertCloudResourceRela(cloudResourceRela);

                String sgVpcId = jsonObject.getString("VpcId");
                String sgVpcRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(sgVpcRelaId);
                cloudResourceRela.setName(sgVpcId);
                cloudResourceRela.setResourceType("aliyun.vpc");
                cloudResourceRela.setHummerId(sgVpcId);
                cloudResourceRela.setxAxis(300L);//100
                cloudResourceRela.setyAxis(200L);//100
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRelaLink.setSource(Internet);
                cloudResourceRelaLink.setTarget(sgVpcRelaId);
                insertCloudResourceRelaLink(cloudResourceRelaLink);

                String sgRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(sgRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(400L);//100
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRelaLink.setSource(sgVpcRelaId);
                cloudResourceRelaLink.setTarget(sgRelaId);
                insertCloudResourceRelaLink(cloudResourceRelaLink);

                break;
            case "aliyun.slb":
                String AddressType = jsonObject.getString("AddressType");
                String Address = jsonObject.getString("Address");

                if (StringUtils.equals(AddressType, "intranet")) {
                    cloudResourceRela.setId(Internet);
                    cloudResourceRela.setName("No Internet");
                    cloudResourceRela.setResourceType("internet");
                    cloudResourceRela.setHummerId("No Internet");
                    cloudResourceRela.setxAxis(100L);//100
                    cloudResourceRela.setyAxis(200L);//100
                    insertCloudResourceRela(cloudResourceRela);
                } else {
                    cloudResourceRela.setId(Internet);
                    cloudResourceRela.setName("Internet");
                    cloudResourceRela.setResourceType("internet");
                    cloudResourceRela.setHummerId("Internet");
                    cloudResourceRela.setxAxis(100L);//100
                    cloudResourceRela.setyAxis(200L);//200
                    insertCloudResourceRela(cloudResourceRela);
                }

                String slbVpcId = jsonObject.getString("VpcId");

                if (!slbVpcId.isEmpty()) {
                    String slbVpcRelaId = UUIDUtil.newUUID();

                    cloudResourceRela.setId(slbVpcRelaId);
                    cloudResourceRela.setName(slbVpcId);
                    cloudResourceRela.setResourceType("aliyun.vpc");
                    cloudResourceRela.setHummerId(slbVpcId);
                    cloudResourceRela.setxAxis(300L);//300
                    cloudResourceRela.setyAxis(200L);//200
                    insertCloudResourceRela(cloudResourceRela);

                    cloudResourceRelaLink.setSource(Internet);
                    cloudResourceRelaLink.setTarget(slbVpcRelaId);
                    insertCloudResourceRelaLink(cloudResourceRelaLink);

                    String slbIpRelaId = UUIDUtil.newUUID();

                    cloudResourceRela.setId(slbIpRelaId);
                    cloudResourceRela.setName(Address);
                    cloudResourceRela.setResourceType("aliyun.ip");
                    cloudResourceRela.setHummerId(Address);
                    cloudResourceRela.setxAxis(400L);//300
                    cloudResourceRela.setyAxis(200L);//200
                    insertCloudResourceRela(cloudResourceRela);

                    cloudResourceRelaLink.setSource(slbVpcRelaId);
                    cloudResourceRelaLink.setTarget(slbIpRelaId);
                    insertCloudResourceRelaLink(cloudResourceRelaLink);

                    String slbRelaId = UUIDUtil.newUUID();

                    cloudResourceRela.setId(slbRelaId);
                    cloudResourceRela.setResourceType(resourceType);
                    cloudResourceRela.setHummerId(hummerId);
                    cloudResourceRela.setName(cloudResourceItem.getHummerName());
                    cloudResourceRela.setxAxis(500L);//100
                    cloudResourceRela.setyAxis(200L);//200
                    insertCloudResourceRela(cloudResourceRela);

                    cloudResourceRelaLink.setSource(slbIpRelaId);
                    cloudResourceRelaLink.setTarget(slbRelaId);
                    insertCloudResourceRelaLink(cloudResourceRelaLink);

                } else {
                    String slbIpRelaId = UUIDUtil.newUUID();

                    cloudResourceRela.setId(slbIpRelaId);
                    cloudResourceRela.setName(Address);
                    cloudResourceRela.setResourceType("aliyun.ip");
                    cloudResourceRela.setHummerId(Address);
                    cloudResourceRela.setxAxis(300L);//300
                    cloudResourceRela.setyAxis(200L);//200
                    insertCloudResourceRela(cloudResourceRela);

                    cloudResourceRelaLink.setSource(Internet);
                    cloudResourceRelaLink.setTarget(slbIpRelaId);
                    insertCloudResourceRelaLink(cloudResourceRelaLink);

                    String slbRelaId = UUIDUtil.newUUID();

                    cloudResourceRela.setId(slbRelaId);
                    cloudResourceRela.setResourceType(resourceType);
                    cloudResourceRela.setHummerId(hummerId);
                    cloudResourceRela.setName(cloudResourceItem.getHummerName());
                    cloudResourceRela.setxAxis(400L);//100
                    cloudResourceRela.setyAxis(200L);//200
                    insertCloudResourceRela(cloudResourceRela);

                    cloudResourceRelaLink.setSource(slbIpRelaId);
                    cloudResourceRelaLink.setTarget(slbRelaId);
                    insertCloudResourceRelaLink(cloudResourceRelaLink);
                }

                break;
            case "aliyun.nas":
                x = 100L;
                y = 100L;
                String MountTargets = jsonObject.getString("MountTargets");
                JSONArray MountTarget = JSONArray.parseArray(!JSONObject.parseObject(MountTargets).getString("MountTarget").isEmpty()?JSONObject.parseObject(MountTargets).getString("MountTarget"):"[]");

                cloudResourceRela.setId(Internet);
                cloudResourceRela.setName("Internet");
                cloudResourceRela.setResourceType("internet");
                cloudResourceRela.setHummerId("Internet");
                cloudResourceRela.setxAxis(x);//100
                cloudResourceRela.setyAxis(y);//100

                insertCloudResourceRela(cloudResourceRela);

                String NasRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(NasRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(300L);//100
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                for (Object o : MountTarget) {
                    JSONObject jsonO = JSONObject.parseObject(o.toString());
                    String vpcId = jsonO.getString("VpcId");
                    String vRelaId = UUIDUtil.newUUID();

                    cloudResourceRela.setId(vRelaId);
                    cloudResourceRela.setName(vpcId);
                    cloudResourceRela.setResourceType("aliyun.vpc");
                    cloudResourceRela.setHummerId(vpcId);
                    cloudResourceRela.setxAxis(100L);//100
                    cloudResourceRela.setyAxis(y + 100L);//200
                    insertCloudResourceRela(cloudResourceRela);

                    String dRelaId = UUIDUtil.newUUID();
                    String MountTargetDomain = jsonO.getString("MountTargetDomain");

                    cloudResourceRela.setId(dRelaId);
                    cloudResourceRela.setName(MountTargetDomain);
                    cloudResourceRela.setResourceType("aliyun.domain");
                    cloudResourceRela.setHummerId(MountTargetDomain);
                    cloudResourceRela.setxAxis(200L);//100
                    cloudResourceRela.setyAxis(y + 100L);//200
                    insertCloudResourceRela(cloudResourceRela);

                    cloudResourceRelaLink.setSource(vRelaId);
                    cloudResourceRelaLink.setTarget(dRelaId);
                    insertCloudResourceRelaLink(cloudResourceRelaLink);

                    cloudResourceRelaLink.setSource(dRelaId);
                    cloudResourceRelaLink.setTarget(NasRelaId);
                    insertCloudResourceRelaLink(cloudResourceRelaLink);

                    y = y + 100L;

                }
                break;
            case "aliyun.mse":

                String mseRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(mseRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(200L);//200
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                break;
            case "aliyun.ack":

                String ackRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(ackRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(200L);//200
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                break;
            case "aliyun.vpc":

                String Status = jsonObject.getString("Status");

                if (StringUtils.equals(Status, "Available")) {
                    String vpcRelaId = UUIDUtil.newUUID();

                    cloudResourceRela.setId(vpcRelaId);
                    cloudResourceRela.setResourceType(resourceType);
                    cloudResourceRela.setHummerId(hummerId);
                    cloudResourceRela.setName(cloudResourceItem.getHummerName());
                    cloudResourceRela.setxAxis(200L);//200
                    cloudResourceRela.setyAxis(200L);//200
                    insertCloudResourceRela(cloudResourceRela);
                } else {

                }

                break;
            case "aliyun.event":

                String eventRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(eventRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(200L);//200
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                break;
            case "aliyun.postgre-sql":

                cloudResourceRela.setId(Internet);
                cloudResourceRela.setName("Internet");
                cloudResourceRela.setResourceType("internet");
                cloudResourceRela.setHummerId("Internet");
                cloudResourceRela.setxAxis(200L);//100
                cloudResourceRela.setyAxis(200L);//100
                insertCloudResourceRela(cloudResourceRela);

                String postgresqlVpcId = jsonObject.getString("VpcId");
                String postgresqlVpcRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(postgresqlVpcRelaId);
                cloudResourceRela.setName(postgresqlVpcId);
                cloudResourceRela.setResourceType("aliyun.vpc");
                cloudResourceRela.setHummerId(postgresqlVpcId);
                cloudResourceRela.setxAxis(300L);//100
                cloudResourceRela.setyAxis(200L);//100
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRelaLink.setSource(Internet);
                cloudResourceRelaLink.setTarget(postgresqlVpcRelaId);
                insertCloudResourceRelaLink(cloudResourceRelaLink);

                String postgresqlRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(postgresqlRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(400L);//100
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                cloudResourceRelaLink.setSource(postgresqlVpcRelaId);
                cloudResourceRelaLink.setTarget(postgresqlRelaId);
                insertCloudResourceRelaLink(cloudResourceRelaLink);

                break;
            default:

                String defaultRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(defaultRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(200L);//200
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                break;
        }

    }

    public void dealHuawei(CloudResourceItem cloudResourceItem) throws Exception {

        String json = cloudResourceItem.getResource();
        if (StringUtils.isEmpty(json)) return;

        String resourceType = cloudResourceItem.getResourceType();
        String accountId = cloudResourceItem.getAccountId();
        String regionId = cloudResourceItem.getRegionId();
        String hummerId = cloudResourceItem.getHummerId();
        JSONObject jsonObject = JSONObject.parseObject(json);
        String Internet = UUIDUtil.newUUID();

        Long x = 200L, y = 200L;

        CloudResourceRela cloudResourceRela = new CloudResourceRela();
        cloudResourceRela.setResourceItemId(cloudResourceItem.getId());
        cloudResourceRela.setPluginId(cloudResourceItem.getPluginId());
        cloudResourceRela.setAccountId(accountId);
        cloudResourceRela.setRegionId(regionId);
        cloudResourceRela.setResourceType(resourceType);
        cloudResourceRela.setHummerId(hummerId);
        cloudResourceRela.setName(cloudResourceItem.getHummerName());
        cloudResourceRela.setCreateTime(System.currentTimeMillis());
        cloudResourceRela.setxAxis(x);//100
        cloudResourceRela.setyAxis(y);//100

        CloudResourceRelaLink cloudResourceRelaLink = new CloudResourceRelaLink();
        cloudResourceRelaLink.setResourceItemId(cloudResourceItem.getId());

        switch (resourceType) {
            case "huawei.dds":
                break;
            case "huawei.disk":
                break;
            case "huawei.ecs":
                break;
            case "huawei.eip":
                break;
            case "huawei.elb":
                break;
            case "huawei.gaussdb":
                break;
            case "huawei.gaussdbfornosql":
                break;
            case "huawei.gaussdbforopengauss":
                break;
            case "huawei.iam":
                break;
            case "huawei.obs":
                break;
            case "huawei.rds":
                break;
            case "huawei.redis":
                break;
            case "huawei.security-group":
                break;
            default:

                String defaultRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(defaultRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(200L);//200
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                break;
        }

    }

    public void dealQcloud(CloudResourceItem cloudResourceItem) throws Exception {

        String json = cloudResourceItem.getResource();
        if (StringUtils.isEmpty(json)) return;

        String resourceType = cloudResourceItem.getResourceType();
        String accountId = cloudResourceItem.getAccountId();
        String regionId = cloudResourceItem.getRegionId();
        String hummerId = cloudResourceItem.getHummerId();
        JSONObject jsonObject = JSONObject.parseObject(json);
        String Internet = UUIDUtil.newUUID();

        Long x = 200L, y = 200L;

        CloudResourceRela cloudResourceRela = new CloudResourceRela();
        cloudResourceRela.setResourceItemId(cloudResourceItem.getId());
        cloudResourceRela.setPluginId(cloudResourceItem.getPluginId());
        cloudResourceRela.setAccountId(accountId);
        cloudResourceRela.setRegionId(regionId);
        cloudResourceRela.setResourceType(resourceType);
        cloudResourceRela.setHummerId(hummerId);
        cloudResourceRela.setName(cloudResourceItem.getHummerName());
        cloudResourceRela.setCreateTime(System.currentTimeMillis());
        cloudResourceRela.setxAxis(x);//100
        cloudResourceRela.setyAxis(y);//100

        CloudResourceRelaLink cloudResourceRelaLink = new CloudResourceRelaLink();
        cloudResourceRelaLink.setResourceItemId(cloudResourceItem.getId());

        switch (resourceType) {
            case "tencent.cdb":
                break;
            case "tencent.clb":
                break;
            case "tencent.cos":
                break;
            case "tencent.cvm":
                break;
            case "tencent.disk":
                break;
            case "tencent.eip":
                break;
            case "tencent.es":
                break;
            case "tencent.mongodb":
                break;
            case "tencent.redis":
                break;
            case "tencent.security-group":
                break;
            case "tencent.vpc":
                break;
            default:

                String defaultRelaId = UUIDUtil.newUUID();

                cloudResourceRela.setId(defaultRelaId);
                cloudResourceRela.setResourceType(resourceType);
                cloudResourceRela.setHummerId(hummerId);
                cloudResourceRela.setName(cloudResourceItem.getHummerName());
                cloudResourceRela.setxAxis(200L);//200
                cloudResourceRela.setyAxis(200L);//200
                insertCloudResourceRela(cloudResourceRela);

                break;
        }

    }

    public void dealVsphere(CloudResourceItem cloudResourceItem) throws Exception {
    }

    public void dealOpenstack(CloudResourceItem cloudResourceItem) throws Exception {
    }

    public void dealGcp(CloudResourceItem cloudResourceItem) throws Exception {
    }

    public void dealHuoshan(CloudResourceItem cloudResourceItem) throws Exception {
    }

    public void dealBaidu(CloudResourceItem cloudResourceItem) throws Exception {
    }

    public void dealQiniu(CloudResourceItem cloudResourceItem) throws Exception {
    }

    public void dealQingcloud(CloudResourceItem cloudResourceItem) throws Exception {
    }

    public void dealUcloud(CloudResourceItem cloudResourceItem) throws Exception {
    }

    public void dealJdcloud(CloudResourceItem cloudResourceItem) throws Exception {
    }

    public void dealKsyun(CloudResourceItem cloudResourceItem) throws Exception {
    }

    public CloudResourceRela insertCloudResourceRela(CloudResourceRela cloudResourceRela) throws Exception {
        cloudResourceRela.setCreateTime(System.currentTimeMillis());
        cloudResourceRelaMapper.insertSelective(cloudResourceRela);
        return cloudResourceRela;
    }

    public void insertCloudResourceRelaLink(CloudResourceRelaLink cloudResourceRelaLink) throws Exception {
        cloudResourceRelaLink.setCreateTime(System.currentTimeMillis());
        cloudResourceRelaLinkMapper.insertSelective(cloudResourceRelaLink);
    }

}
