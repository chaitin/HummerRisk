package com.hummerrisk.base.mapper;

import com.hummerrisk.base.domain.HistoryCloudNativeResultLog;
import com.hummerrisk.base.domain.HistoryCloudNativeResultLogExample;
import com.hummerrisk.base.domain.HistoryCloudNativeResultLogWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HistoryCloudNativeResultLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    long countByExample(HistoryCloudNativeResultLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int deleteByExample(HistoryCloudNativeResultLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int insert(HistoryCloudNativeResultLogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int insertSelective(HistoryCloudNativeResultLogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    List<HistoryCloudNativeResultLogWithBLOBs> selectByExampleWithBLOBs(HistoryCloudNativeResultLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    List<HistoryCloudNativeResultLog> selectByExample(HistoryCloudNativeResultLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    HistoryCloudNativeResultLogWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int updateByExampleSelective(@Param("record") HistoryCloudNativeResultLogWithBLOBs record, @Param("example") HistoryCloudNativeResultLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") HistoryCloudNativeResultLogWithBLOBs record, @Param("example") HistoryCloudNativeResultLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int updateByExample(@Param("record") HistoryCloudNativeResultLog record, @Param("example") HistoryCloudNativeResultLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int updateByPrimaryKeySelective(HistoryCloudNativeResultLogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(HistoryCloudNativeResultLogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int updateByPrimaryKey(HistoryCloudNativeResultLog record);
}