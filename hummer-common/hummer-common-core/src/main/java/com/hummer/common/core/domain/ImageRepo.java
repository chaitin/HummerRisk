package com.hummer.common.core.domain;

import java.io.Serializable;

public class ImageRepo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image_repo.id
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image_repo.name
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image_repo.status
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image_repo.create_time
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    private Long createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image_repo.update_time
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    private Long updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image_repo.creator
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    private String creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image_repo.repo
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    private String repo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image_repo.user_name
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image_repo.password
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image_repo.plugin_icon
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    private String pluginIcon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image_repo.account_id
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    private String accountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image_repo.is_bind_account
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    private Boolean isBindAccount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image_repo.credencial
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    private String credencial;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table image_repo
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image_repo.id
     *
     * @return the value of image_repo.id
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image_repo.id
     *
     * @param id the value for image_repo.id
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image_repo.name
     *
     * @return the value of image_repo.name
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image_repo.name
     *
     * @param name the value for image_repo.name
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image_repo.status
     *
     * @return the value of image_repo.status
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image_repo.status
     *
     * @param status the value for image_repo.status
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image_repo.create_time
     *
     * @return the value of image_repo.create_time
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image_repo.create_time
     *
     * @param createTime the value for image_repo.create_time
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image_repo.update_time
     *
     * @return the value of image_repo.update_time
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image_repo.update_time
     *
     * @param updateTime the value for image_repo.update_time
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image_repo.creator
     *
     * @return the value of image_repo.creator
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image_repo.creator
     *
     * @param creator the value for image_repo.creator
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image_repo.repo
     *
     * @return the value of image_repo.repo
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public String getRepo() {
        return repo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image_repo.repo
     *
     * @param repo the value for image_repo.repo
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public void setRepo(String repo) {
        this.repo = repo == null ? null : repo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image_repo.user_name
     *
     * @return the value of image_repo.user_name
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image_repo.user_name
     *
     * @param userName the value for image_repo.user_name
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image_repo.password
     *
     * @return the value of image_repo.password
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image_repo.password
     *
     * @param password the value for image_repo.password
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image_repo.plugin_icon
     *
     * @return the value of image_repo.plugin_icon
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public String getPluginIcon() {
        return pluginIcon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image_repo.plugin_icon
     *
     * @param pluginIcon the value for image_repo.plugin_icon
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public void setPluginIcon(String pluginIcon) {
        this.pluginIcon = pluginIcon == null ? null : pluginIcon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image_repo.account_id
     *
     * @return the value of image_repo.account_id
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image_repo.account_id
     *
     * @param accountId the value for image_repo.account_id
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image_repo.is_bind_account
     *
     * @return the value of image_repo.is_bind_account
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public Boolean getIsBindAccount() {
        return isBindAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image_repo.is_bind_account
     *
     * @param isBindAccount the value for image_repo.is_bind_account
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public void setIsBindAccount(Boolean isBindAccount) {
        this.isBindAccount = isBindAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image_repo.credencial
     *
     * @return the value of image_repo.credencial
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public String getCredencial() {
        return credencial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image_repo.credencial
     *
     * @param credencial the value for image_repo.credencial
     *
     * @mbg.generated Mon May 22 22:36:48 CST 2023
     */
    public void setCredencial(String credencial) {
        this.credencial = credencial == null ? null : credencial.trim();
    }
}