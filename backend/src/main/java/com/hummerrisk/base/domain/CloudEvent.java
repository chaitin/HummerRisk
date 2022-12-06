package com.hummerrisk.base.domain;

import java.io.Serializable;

public class CloudEvent implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.id
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.event_id
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String eventId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.cloud_account_id
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String cloudAccountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.sync_region
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String syncRegion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.acs_region
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String acsRegion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.event_name
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String eventName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.event_type
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String eventType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.event_category
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String eventCategory;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.event_version
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String eventVersion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.event_rw
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String eventRw;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.event_message
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String eventMessage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.event_source
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String eventSource;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.event_time
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private Long eventTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.source_ip_address
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String sourceIpAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.service_name
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String serviceName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.request_id
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String requestId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.resource_type
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String resourceType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.resource_name
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String resourceName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.api_version
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String apiVersion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.user_name
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.event_rating
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private Integer eventRating;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.resource_id
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String resourceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.location_info
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String locationInfo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.endpoint
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String endpoint;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.resource_url
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String resourceUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_event.region_name
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private String regionName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cloud_event
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.id
     *
     * @return the value of cloud_event.id
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.id
     *
     * @param id the value for cloud_event.id
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.event_id
     *
     * @return the value of cloud_event.event_id
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getEventId() {
        return eventId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.event_id
     *
     * @param eventId the value for cloud_event.event_id
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setEventId(String eventId) {
        this.eventId = eventId == null ? null : eventId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.cloud_account_id
     *
     * @return the value of cloud_event.cloud_account_id
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getCloudAccountId() {
        return cloudAccountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.cloud_account_id
     *
     * @param cloudAccountId the value for cloud_event.cloud_account_id
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setCloudAccountId(String cloudAccountId) {
        this.cloudAccountId = cloudAccountId == null ? null : cloudAccountId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.sync_region
     *
     * @return the value of cloud_event.sync_region
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getSyncRegion() {
        return syncRegion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.sync_region
     *
     * @param syncRegion the value for cloud_event.sync_region
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setSyncRegion(String syncRegion) {
        this.syncRegion = syncRegion == null ? null : syncRegion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.acs_region
     *
     * @return the value of cloud_event.acs_region
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getAcsRegion() {
        return acsRegion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.acs_region
     *
     * @param acsRegion the value for cloud_event.acs_region
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setAcsRegion(String acsRegion) {
        this.acsRegion = acsRegion == null ? null : acsRegion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.event_name
     *
     * @return the value of cloud_event.event_name
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.event_name
     *
     * @param eventName the value for cloud_event.event_name
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.event_type
     *
     * @return the value of cloud_event.event_type
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.event_type
     *
     * @param eventType the value for cloud_event.event_type
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setEventType(String eventType) {
        this.eventType = eventType == null ? null : eventType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.event_category
     *
     * @return the value of cloud_event.event_category
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getEventCategory() {
        return eventCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.event_category
     *
     * @param eventCategory the value for cloud_event.event_category
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory == null ? null : eventCategory.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.event_version
     *
     * @return the value of cloud_event.event_version
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getEventVersion() {
        return eventVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.event_version
     *
     * @param eventVersion the value for cloud_event.event_version
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setEventVersion(String eventVersion) {
        this.eventVersion = eventVersion == null ? null : eventVersion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.event_rw
     *
     * @return the value of cloud_event.event_rw
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getEventRw() {
        return eventRw;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.event_rw
     *
     * @param eventRw the value for cloud_event.event_rw
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setEventRw(String eventRw) {
        this.eventRw = eventRw == null ? null : eventRw.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.event_message
     *
     * @return the value of cloud_event.event_message
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getEventMessage() {
        return eventMessage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.event_message
     *
     * @param eventMessage the value for cloud_event.event_message
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setEventMessage(String eventMessage) {
        this.eventMessage = eventMessage == null ? null : eventMessage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.event_source
     *
     * @return the value of cloud_event.event_source
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getEventSource() {
        return eventSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.event_source
     *
     * @param eventSource the value for cloud_event.event_source
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setEventSource(String eventSource) {
        this.eventSource = eventSource == null ? null : eventSource.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.event_time
     *
     * @return the value of cloud_event.event_time
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public Long getEventTime() {
        return eventTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.event_time
     *
     * @param eventTime the value for cloud_event.event_time
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.source_ip_address
     *
     * @return the value of cloud_event.source_ip_address
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getSourceIpAddress() {
        return sourceIpAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.source_ip_address
     *
     * @param sourceIpAddress the value for cloud_event.source_ip_address
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setSourceIpAddress(String sourceIpAddress) {
        this.sourceIpAddress = sourceIpAddress == null ? null : sourceIpAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.service_name
     *
     * @return the value of cloud_event.service_name
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.service_name
     *
     * @param serviceName the value for cloud_event.service_name
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.request_id
     *
     * @return the value of cloud_event.request_id
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.request_id
     *
     * @param requestId the value for cloud_event.request_id
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId == null ? null : requestId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.resource_type
     *
     * @return the value of cloud_event.resource_type
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.resource_type
     *
     * @param resourceType the value for cloud_event.resource_type
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.resource_name
     *
     * @return the value of cloud_event.resource_name
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.resource_name
     *
     * @param resourceName the value for cloud_event.resource_name
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.api_version
     *
     * @return the value of cloud_event.api_version
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.api_version
     *
     * @param apiVersion the value for cloud_event.api_version
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion == null ? null : apiVersion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.user_name
     *
     * @return the value of cloud_event.user_name
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.user_name
     *
     * @param userName the value for cloud_event.user_name
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.event_rating
     *
     * @return the value of cloud_event.event_rating
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public Integer getEventRating() {
        return eventRating;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.event_rating
     *
     * @param eventRating the value for cloud_event.event_rating
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setEventRating(Integer eventRating) {
        this.eventRating = eventRating;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.resource_id
     *
     * @return the value of cloud_event.resource_id
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.resource_id
     *
     * @param resourceId the value for cloud_event.resource_id
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.location_info
     *
     * @return the value of cloud_event.location_info
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getLocationInfo() {
        return locationInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.location_info
     *
     * @param locationInfo the value for cloud_event.location_info
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setLocationInfo(String locationInfo) {
        this.locationInfo = locationInfo == null ? null : locationInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.endpoint
     *
     * @return the value of cloud_event.endpoint
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.endpoint
     *
     * @param endpoint the value for cloud_event.endpoint
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint == null ? null : endpoint.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.resource_url
     *
     * @return the value of cloud_event.resource_url
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.resource_url
     *
     * @param resourceUrl the value for cloud_event.resource_url
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_event.region_name
     *
     * @return the value of cloud_event.region_name
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_event.region_name
     *
     * @param regionName the value for cloud_event.region_name
     *
     * @mbg.generated Sun Nov 20 15:31:15 CST 2022
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }
}