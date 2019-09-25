package com.example.dataplatform.controller;

import com.example.dataplatform.model.*;
import com.example.dataplatform.services.CardSceneService;
import com.example.dataplatform.util.ScenesFactory;
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

import java.util.ArrayList;
import java.util.List;

@Component
@Configuration

public class ScheduleTask {
    @Autowired
    CardScenes cardScenes;
    @Autowired
    Task task;
    @Autowired
    SharesScenes sharesScenes;
    @Autowired
    SceneResultController sceneResultController;
    private final static Logger logger= LoggerFactory.getLogger(ScheduledTask.class);
    @Async("myExecutor")
    @Scheduled(fixedRate = 5000)
    public void CardScenerun()
    {
        List<String> list =new ArrayList<String>();
        list = ScenesFactory.getallScene();
        //System.out.println(list);
        for (String scene:list){
            sceneResultController.Scenerun(scene);
        }
        //cardScenes.SendToRemoteAPI();
//         Scene scene =ScenesFactory.getScene("CardScenes");
//         scene.SendToRemoteAPI();
//        logger.info("测试Cardscene场景定时任务");
    }
//    @Async("myExecutor")
//    @Scheduled(fixedRate = 5000)
//    public void SharesScenerun()
//    {
//        //sharesScenes.SendToRemoteAPI();
//        Scene scene =ScenesFactory.getScene("SharesScenes");
//        scene.SendToRemoteAPI();
//        logger.info("测试Sharescene场景定时任务");
//    }
//    @Async("myExecutor")
//    public void Scenerun(String id){
//        Scene scene =ScenesFactory.getScene(id);
//        String result =scene.SendToRemoteAPI();
//        logger.info("开启"+id+"场景定时任务容器池，运行结果："+result);
//        logger.info(Thread.currentThread().getName());
//    }

}
