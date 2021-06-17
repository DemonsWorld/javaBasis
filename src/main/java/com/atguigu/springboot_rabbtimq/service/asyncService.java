package com.atguigu.springboot_rabbtimq.service;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * @author Kakrolot
 * @date 2020/5/8 16:23
 */
public class asyncService {

    public void hello() throws Exception{
        Thread.sleep(3000);
        System.out.println("耗时任务完成...");
    }
}
