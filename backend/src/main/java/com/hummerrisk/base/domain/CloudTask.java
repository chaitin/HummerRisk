package com.hummerrisk.base.domain;

import java.io.Serializable;

public class CloudTask implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.id
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.status
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.apply_user
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String applyUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.create_time
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private Long createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.task_name
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String taskName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.description
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.cron
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String cron;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.trigger_id
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String triggerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.prev_fire_time
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private Long prevFireTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.last_fire_time
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private Long lastFireTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.type
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.severity
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String severity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.rule_id
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String ruleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.rule_tags
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String ruleTags;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.account_id
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String accountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.plugin_id
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String pluginId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.plugin_name
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String pluginName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.plugin_icon
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String pluginIcon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.resource_types
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String resourceTypes;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.resources_sum
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private Long resourcesSum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.return_sum
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private Long returnSum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.cron_desc
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String cronDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.scan_type
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String scanType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_task.suggestion
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private String suggestion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cloud_task
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.id
     *
     * @return the value of cloud_task.id
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.id
     *
     * @param id the value for cloud_task.id
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.status
     *
     * @return the value of cloud_task.status
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.status
     *
     * @param status the value for cloud_task.status
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.apply_user
     *
     * @return the value of cloud_task.apply_user
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getApplyUser() {
        return applyUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.apply_user
     *
     * @param applyUser the value for cloud_task.apply_user
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser == null ? null : applyUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.create_time
     *
     * @return the value of cloud_task.create_time
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.create_time
     *
     * @param createTime the value for cloud_task.create_time
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.task_name
     *
     * @return the value of cloud_task.task_name
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.task_name
     *
     * @param taskName the value for cloud_task.task_name
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.description
     *
     * @return the value of cloud_task.description
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.description
     *
     * @param description the value for cloud_task.description
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.cron
     *
     * @return the value of cloud_task.cron
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getCron() {
        return cron;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.cron
     *
     * @param cron the value for cloud_task.cron
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setCron(String cron) {
        this.cron = cron == null ? null : cron.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.trigger_id
     *
     * @return the value of cloud_task.trigger_id
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getTriggerId() {
        return triggerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.trigger_id
     *
     * @param triggerId the value for cloud_task.trigger_id
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setTriggerId(String triggerId) {
        this.triggerId = triggerId == null ? null : triggerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.prev_fire_time
     *
     * @return the value of cloud_task.prev_fire_time
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public Long getPrevFireTime() {
        return prevFireTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.prev_fire_time
     *
     * @param prevFireTime the value for cloud_task.prev_fire_time
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setPrevFireTime(Long prevFireTime) {
        this.prevFireTime = prevFireTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.last_fire_time
     *
     * @return the value of cloud_task.last_fire_time
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public Long getLastFireTime() {
        return lastFireTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.last_fire_time
     *
     * @param lastFireTime the value for cloud_task.last_fire_time
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setLastFireTime(Long lastFireTime) {
        this.lastFireTime = lastFireTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.type
     *
     * @return the value of cloud_task.type
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.type
     *
     * @param type the value for cloud_task.type
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.severity
     *
     * @return the value of cloud_task.severity
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getSeverity() {
        return severity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.severity
     *
     * @param severity the value for cloud_task.severity
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setSeverity(String severity) {
        this.severity = severity == null ? null : severity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.rule_id
     *
     * @return the value of cloud_task.rule_id
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getRuleId() {
        return ruleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.rule_id
     *
     * @param ruleId the value for cloud_task.rule_id
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.rule_tags
     *
     * @return the value of cloud_task.rule_tags
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getRuleTags() {
        return ruleTags;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.rule_tags
     *
     * @param ruleTags the value for cloud_task.rule_tags
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setRuleTags(String ruleTags) {
        this.ruleTags = ruleTags == null ? null : ruleTags.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.account_id
     *
     * @return the value of cloud_task.account_id
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.account_id
     *
     * @param accountId the value for cloud_task.account_id
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.plugin_id
     *
     * @return the value of cloud_task.plugin_id
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getPluginId() {
        return pluginId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.plugin_id
     *
     * @param pluginId the value for cloud_task.plugin_id
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setPluginId(String pluginId) {
        this.pluginId = pluginId == null ? null : pluginId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.plugin_name
     *
     * @return the value of cloud_task.plugin_name
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getPluginName() {
        return pluginName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.plugin_name
     *
     * @param pluginName the value for cloud_task.plugin_name
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setPluginName(String pluginName) {
        this.pluginName = pluginName == null ? null : pluginName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.plugin_icon
     *
     * @return the value of cloud_task.plugin_icon
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getPluginIcon() {
        return pluginIcon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.plugin_icon
     *
     * @param pluginIcon the value for cloud_task.plugin_icon
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setPluginIcon(String pluginIcon) {
        this.pluginIcon = pluginIcon == null ? null : pluginIcon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.resource_types
     *
     * @return the value of cloud_task.resource_types
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getResourceTypes() {
        return resourceTypes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.resource_types
     *
     * @param resourceTypes the value for cloud_task.resource_types
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setResourceTypes(String resourceTypes) {
        this.resourceTypes = resourceTypes == null ? null : resourceTypes.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.resources_sum
     *
     * @return the value of cloud_task.resources_sum
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public Long getResourcesSum() {
        return resourcesSum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.resources_sum
     *
     * @param resourcesSum the value for cloud_task.resources_sum
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setResourcesSum(Long resourcesSum) {
        this.resourcesSum = resourcesSum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.return_sum
     *
     * @return the value of cloud_task.return_sum
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public Long getReturnSum() {
        return returnSum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.return_sum
     *
     * @param returnSum the value for cloud_task.return_sum
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setReturnSum(Long returnSum) {
        this.returnSum = returnSum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.cron_desc
     *
     * @return the value of cloud_task.cron_desc
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getCronDesc() {
        return cronDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.cron_desc
     *
     * @param cronDesc the value for cloud_task.cron_desc
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setCronDesc(String cronDesc) {
        this.cronDesc = cronDesc == null ? null : cronDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.scan_type
     *
     * @return the value of cloud_task.scan_type
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getScanType() {
        return scanType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.scan_type
     *
     * @param scanType the value for cloud_task.scan_type
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setScanType(String scanType) {
        this.scanType = scanType == null ? null : scanType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_task.suggestion
     *
     * @return the value of cloud_task.suggestion
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public String getSuggestion() {
        return suggestion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_task.suggestion
     *
     * @param suggestion the value for cloud_task.suggestion
     *
     * @mbg.generated Tue Sep 20 12:33:42 CST 2022
     */
    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion == null ? null : suggestion.trim();
    }
}