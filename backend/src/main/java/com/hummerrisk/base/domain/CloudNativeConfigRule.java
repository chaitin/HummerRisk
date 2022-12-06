package com.hummerrisk.base.domain;

import java.io.Serializable;

public class CloudNativeConfigRule implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_config_rule.id
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_config_rule.name
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_config_rule.status
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    private Boolean status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_config_rule.severity
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    private String severity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_config_rule.description
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_config_rule.parameter
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    private String parameter;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_config_rule.last_modified
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    private Long lastModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_config_rule.flag
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    private Boolean flag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_config_rule.script
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    private String script;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cloud_native_config_rule
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_config_rule.id
     *
     * @return the value of cloud_native_config_rule.id
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_config_rule.id
     *
     * @param id the value for cloud_native_config_rule.id
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_config_rule.name
     *
     * @return the value of cloud_native_config_rule.name
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_config_rule.name
     *
     * @param name the value for cloud_native_config_rule.name
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_config_rule.status
     *
     * @return the value of cloud_native_config_rule.status
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_config_rule.status
     *
     * @param status the value for cloud_native_config_rule.status
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_config_rule.severity
     *
     * @return the value of cloud_native_config_rule.severity
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    public String getSeverity() {
        return severity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_config_rule.severity
     *
     * @param severity the value for cloud_native_config_rule.severity
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    public void setSeverity(String severity) {
        this.severity = severity == null ? null : severity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_config_rule.description
     *
     * @return the value of cloud_native_config_rule.description
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_config_rule.description
     *
     * @param description the value for cloud_native_config_rule.description
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_config_rule.parameter
     *
     * @return the value of cloud_native_config_rule.parameter
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_config_rule.parameter
     *
     * @param parameter the value for cloud_native_config_rule.parameter
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    public void setParameter(String parameter) {
        this.parameter = parameter == null ? null : parameter.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_config_rule.last_modified
     *
     * @return the value of cloud_native_config_rule.last_modified
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    public Long getLastModified() {
        return lastModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_config_rule.last_modified
     *
     * @param lastModified the value for cloud_native_config_rule.last_modified
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_config_rule.flag
     *
     * @return the value of cloud_native_config_rule.flag
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_config_rule.flag
     *
     * @param flag the value for cloud_native_config_rule.flag
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_config_rule.script
     *
     * @return the value of cloud_native_config_rule.script
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    public String getScript() {
        return script;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_config_rule.script
     *
     * @param script the value for cloud_native_config_rule.script
     *
     * @mbg.generated Thu Sep 08 05:19:20 CST 2022
     */
    public void setScript(String script) {
        this.script = script == null ? null : script.trim();
    }
}