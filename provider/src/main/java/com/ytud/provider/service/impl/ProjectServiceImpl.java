package com.ytud.provider.service.impl;

import com.ytud.dao.mybatis.mapper.ProjectMapper;
import com.ytud.dao.mybatis.po.Project;
import com.ytud.provider.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * yangch 2016/7/27
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectMapper projectMapper;

    public Project getProject(int id) {
        return projectMapper.getProject(id);
    }
}
