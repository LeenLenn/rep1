package com.xzm.springbootjpa.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//必须让IOC读取到
@Component
public class Demo {

    //定义定时执行的方法，名称自定义
    @Scheduled(cron="0 0 16 * * *")
    public void ScheduledMethod(){
        System.out.println("定时任务执行了！");
    }

}
