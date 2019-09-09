package com.example.dataplatform.controller;

import com.example.dataplatform.model.CardScenes;
import com.example.dataplatform.model.Task;
import com.example.dataplatform.services.CardSceneService;
import javafx.application.Application;
import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Component;

@Component
@Configuration

public class ScheduleTask {
    @Autowired
    CardScenes cardScenes;
    @Autowired
    CardSceneService cardSceneService;
    @Autowired
    Task task;
    private final static Logger logger= LoggerFactory.getLogger(ScheduledTask.class);
    @Async("myExecutor")
    @Scheduled(fixedRate = 5000)
    public void taskrun()
    {
        cardScenes.SendToRemoteAPI();
        logger.info("测试login");
    }


}