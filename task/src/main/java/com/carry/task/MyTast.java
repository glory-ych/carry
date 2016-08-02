package com.carry.task;

import com.ytud.api.ProjectApi;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * yangch 2016/7/29
 */
@Component
public class MyTast {

    @Resource
    private ProjectApi projectApi;

    /**
     * 1.注解方式
     */
    /**
     * 定时计算。10秒一次
     */
    @Scheduled(cron = "10 * * * * *")
    public void show() {
        System.out.println("Annotation：is show run..." + System.currentTimeMillis());
    }

    /**
     * 心跳更新。启动时执行一次，之后每隔2秒执行一次
     */
    @Scheduled(fixedRate = 1000 * 5)
    public void print() {
        System.out.println(projectApi.getProject(2).getProjectName());
        //System.out.println("Annotation：print run..." + System.currentTimeMillis());
    }

    /*2.xml配置方式
    <bean id="myTaskXml" class="com.spring.task.MyTaskXml"></bean>
    <task:scheduled-tasks>
    <task:scheduled ref="myTaskXml" method="show" cron="*5 * * * * ?" />
    <task:scheduled ref="myTaskXml" method="print" cron="*10 * * * * ?"/>
    </task:scheduled-tasks>*/
}
