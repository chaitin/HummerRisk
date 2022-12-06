package com.hummerrisk.base.domain;

import java.io.Serializable;

public class Image implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.id
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.name
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.plugin_icon
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private String pluginIcon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.status
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.create_time
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private Long createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.update_time
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private Long updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.creator
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private String creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.repo_id
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private String repoId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.size
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private String size;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.type
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.image_url
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private String imageUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.image_tag
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private String imageTag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.path
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private String path;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.is_image_repo
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private Boolean isImageRepo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.is_image_icon
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private Boolean isImageIcon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.is_proxy
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private Boolean isProxy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.proxy_id
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private Integer proxyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.sbom_id
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private String sbomId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.sbom_version_id
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private String sbomVersionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.unfixed
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private Boolean unfixed;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.serverty
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private String serverty;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table image
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.id
     *
     * @return the value of image.id
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.id
     *
     * @param id the value for image.id
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.name
     *
     * @return the value of image.name
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.name
     *
     * @param name the value for image.name
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.plugin_icon
     *
     * @return the value of image.plugin_icon
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public String getPluginIcon() {
        return pluginIcon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.plugin_icon
     *
     * @param pluginIcon the value for image.plugin_icon
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setPluginIcon(String pluginIcon) {
        this.pluginIcon = pluginIcon == null ? null : pluginIcon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.status
     *
     * @return the value of image.status
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.status
     *
     * @param status the value for image.status
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.create_time
     *
     * @return the value of image.create_time
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.create_time
     *
     * @param createTime the value for image.create_time
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.update_time
     *
     * @return the value of image.update_time
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.update_time
     *
     * @param updateTime the value for image.update_time
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.creator
     *
     * @return the value of image.creator
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.creator
     *
     * @param creator the value for image.creator
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.repo_id
     *
     * @return the value of image.repo_id
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public String getRepoId() {
        return repoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.repo_id
     *
     * @param repoId the value for image.repo_id
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setRepoId(String repoId) {
        this.repoId = repoId == null ? null : repoId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.size
     *
     * @return the value of image.size
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public String getSize() {
        return size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.size
     *
     * @param size the value for image.size
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.type
     *
     * @return the value of image.type
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.type
     *
     * @param type the value for image.type
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.image_url
     *
     * @return the value of image.image_url
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.image_url
     *
     * @param imageUrl the value for image.image_url
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.image_tag
     *
     * @return the value of image.image_tag
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public String getImageTag() {
        return imageTag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.image_tag
     *
     * @param imageTag the value for image.image_tag
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setImageTag(String imageTag) {
        this.imageTag = imageTag == null ? null : imageTag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.path
     *
     * @return the value of image.path
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.path
     *
     * @param path the value for image.path
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.is_image_repo
     *
     * @return the value of image.is_image_repo
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public Boolean getIsImageRepo() {
        return isImageRepo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.is_image_repo
     *
     * @param isImageRepo the value for image.is_image_repo
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setIsImageRepo(Boolean isImageRepo) {
        this.isImageRepo = isImageRepo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.is_image_icon
     *
     * @return the value of image.is_image_icon
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public Boolean getIsImageIcon() {
        return isImageIcon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.is_image_icon
     *
     * @param isImageIcon the value for image.is_image_icon
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setIsImageIcon(Boolean isImageIcon) {
        this.isImageIcon = isImageIcon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.is_proxy
     *
     * @return the value of image.is_proxy
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public Boolean getIsProxy() {
        return isProxy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.is_proxy
     *
     * @param isProxy the value for image.is_proxy
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setIsProxy(Boolean isProxy) {
        this.isProxy = isProxy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.proxy_id
     *
     * @return the value of image.proxy_id
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public Integer getProxyId() {
        return proxyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.proxy_id
     *
     * @param proxyId the value for image.proxy_id
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setProxyId(Integer proxyId) {
        this.proxyId = proxyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.sbom_id
     *
     * @return the value of image.sbom_id
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public String getSbomId() {
        return sbomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.sbom_id
     *
     * @param sbomId the value for image.sbom_id
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setSbomId(String sbomId) {
        this.sbomId = sbomId == null ? null : sbomId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.sbom_version_id
     *
     * @return the value of image.sbom_version_id
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public String getSbomVersionId() {
        return sbomVersionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.sbom_version_id
     *
     * @param sbomVersionId the value for image.sbom_version_id
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setSbomVersionId(String sbomVersionId) {
        this.sbomVersionId = sbomVersionId == null ? null : sbomVersionId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.unfixed
     *
     * @return the value of image.unfixed
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public Boolean getUnfixed() {
        return unfixed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.unfixed
     *
     * @param unfixed the value for image.unfixed
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setUnfixed(Boolean unfixed) {
        this.unfixed = unfixed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.serverty
     *
     * @return the value of image.serverty
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public String getServerty() {
        return serverty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.serverty
     *
     * @param serverty the value for image.serverty
     *
     * @mbg.generated Tue Sep 20 12:35:32 CST 2022
     */
    public void setServerty(String serverty) {
        this.serverty = serverty == null ? null : serverty.trim();
    }
}