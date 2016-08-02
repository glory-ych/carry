package com.ytud.provider.impl;

import com.ytud.api.ProjectApi;
import com.ytud.common.model.ProjectModel;
import com.ytud.dao.mybatis.po.Project;
import com.ytud.provider.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * yangch 2016/7/27
 */
public class ProjectApiImpl implements ProjectApi {

    @Resource
    private ProjectService projectService;

    
    public ProjectModel getProject(int id) {
        Project project = projectService.getProject(id);
        return new ProjectModel(project.getId(), project.getProjectCode(), project.getProjectName());
    }
}
