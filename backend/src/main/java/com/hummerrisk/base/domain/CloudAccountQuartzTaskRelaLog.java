package com.hummerrisk.base.domain;

import java.io.Serializable;

public class CloudAccountQuartzTaskRelaLog implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_account_quartz_task_rela_log.id
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_account_quartz_task_rela_log.quartz_task_id
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    private String quartzTaskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_account_quartz_task_rela_log.quartz_task_rela_id
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    private String quartzTaskRelaId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_account_quartz_task_rela_log.source_id
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    private String sourceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_account_quartz_task_rela_log.create_time
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    private Long createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_account_quartz_task_rela_log.operator
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    private String operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_account_quartz_task_rela_log.qz_type
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    private String qzType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cloud_account_quartz_task_rela_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_account_quartz_task_rela_log.id
     *
     * @return the value of cloud_account_quartz_task_rela_log.id
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_account_quartz_task_rela_log.id
     *
     * @param id the value for cloud_account_quartz_task_rela_log.id
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_account_quartz_task_rela_log.quartz_task_id
     *
     * @return the value of cloud_account_quartz_task_rela_log.quartz_task_id
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    public String getQuartzTaskId() {
        return quartzTaskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_account_quartz_task_rela_log.quartz_task_id
     *
     * @param quartzTaskId the value for cloud_account_quartz_task_rela_log.quartz_task_id
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    public void setQuartzTaskId(String quartzTaskId) {
        this.quartzTaskId = quartzTaskId == null ? null : quartzTaskId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_account_quartz_task_rela_log.quartz_task_rela_id
     *
     * @return the value of cloud_account_quartz_task_rela_log.quartz_task_rela_id
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    public String getQuartzTaskRelaId() {
        return quartzTaskRelaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_account_quartz_task_rela_log.quartz_task_rela_id
     *
     * @param quartzTaskRelaId the value for cloud_account_quartz_task_rela_log.quartz_task_rela_id
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    public void setQuartzTaskRelaId(String quartzTaskRelaId) {
        this.quartzTaskRelaId = quartzTaskRelaId == null ? null : quartzTaskRelaId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_account_quartz_task_rela_log.source_id
     *
     * @return the value of cloud_account_quartz_task_rela_log.source_id
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_account_quartz_task_rela_log.source_id
     *
     * @param sourceId the value for cloud_account_quartz_task_rela_log.source_id
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_account_quartz_task_rela_log.create_time
     *
     * @return the value of cloud_account_quartz_task_rela_log.create_time
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_account_quartz_task_rela_log.create_time
     *
     * @param createTime the value for cloud_account_quartz_task_rela_log.create_time
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_account_quartz_task_rela_log.operator
     *
     * @return the value of cloud_account_quartz_task_rela_log.operator
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_account_quartz_task_rela_log.operator
     *
     * @param operator the value for cloud_account_quartz_task_rela_log.operator
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_account_quartz_task_rela_log.qz_type
     *
     * @return the value of cloud_account_quartz_task_rela_log.qz_type
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    public String getQzType() {
        return qzType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_account_quartz_task_rela_log.qz_type
     *
     * @param qzType the value for cloud_account_quartz_task_rela_log.qz_type
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    public void setQzType(String qzType) {
        this.qzType = qzType == null ? null : qzType.trim();
    }
}