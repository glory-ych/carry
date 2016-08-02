package com.ytud.web.controller;

import com.ytud.api.ProjectApi;
import com.ytud.common.model.ProjectModel;
import com.ytud.common.util.JacksonUtil;
import com.ytud.common.util.JsonAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * yangch 2016/7/27
 */
@Controller
@RequestMapping("/project")
public class ProjectController {
    @Resource
    private ProjectApi projectApi;

    @ResponseBody
    @RequestMapping(value = "get", method = RequestMethod.POST)
    public String get(int id) {
        ProjectModel projectModel = projectApi.getProject(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", projectModel);
        return JsonAdapter.object2string(map);
    }
}
