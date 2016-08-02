package com.ytud.provider.starter;

/**
 * 启动类
 * Created by jacklin on 16/2/29.
 */
public class SocialProviderStarter {

    public static void main(String[] args) {

        // 加载spring
        SpringManager.getInstance().init();

        // 常驻线程
        new DaemonThread().start();

    }

}
