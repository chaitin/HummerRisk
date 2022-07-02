package com.hummerrisk.dto;

import com.hummerrisk.base.domain.PackageResult;

/**
 * @author harris
 */
public class PackageResultDTO extends PackageResult {

    private String name;

    private String tagKey;

    private String tagName;

    private String user;

    private String resources;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagKey() {
        return tagKey;
    }

    public void setTagKey(String tagKey) {
        this.tagKey = tagKey;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }
}
