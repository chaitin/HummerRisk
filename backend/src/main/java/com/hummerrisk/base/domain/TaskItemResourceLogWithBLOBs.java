package com.hummerrisk.base.domain;

import java.io.Serializable;

public class TaskItemResourceLogWithBLOBs extends TaskItemResourceLog implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_item_resource_log.operation
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    private String operation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_item_resource_log.output
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    private String output;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table task_item_resource_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_item_resource_log.operation
     *
     * @return the value of task_item_resource_log.operation
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    public String getOperation() {
        return operation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_item_resource_log.operation
     *
     * @param operation the value for task_item_resource_log.operation
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_item_resource_log.output
     *
     * @return the value of task_item_resource_log.output
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    public String getOutput() {
        return output;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_item_resource_log.output
     *
     * @param output the value for task_item_resource_log.output
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    public void setOutput(String output) {
        this.output = output == null ? null : output.trim();
    }
}