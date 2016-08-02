package com.ytud.common.model;

import java.io.Serializable;

/**
 * yangch 2016/7/27
 */
public class ProjectModel implements Serializable {

    private int Id;
    private String projectCode;
    private String projectName;

    public ProjectModel() {
    }

    public ProjectModel(int id, String projectCode, String projectName) {
        Id = id;
        this.projectCode = projectCode;
        this.projectName = projectName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
