package com.example.dataplatform.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.dataplatform.model.CardScene;
import com.example.dataplatform.model.CardScenes;
import com.example.dataplatform.model.Scene;
import com.example.dataplatform.model.Task;
import com.example.dataplatform.services.CardSceneService;
import com.example.dataplatform.util.RestTemplateUtil;
import com.example.dataplatform.util.ScenesFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.web.bind.annotation.*;
import sun.reflect.CallerSensitive;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class SceneResultController {
    @Autowired
    CardScenes cardScenes;
    @Autowired
    CardSceneService cardSceneService;
    @Autowired
    Task task;
    private final static Logger logger= LoggerFactory.getLogger(SceneResultController.class);
//    @RequestMapping(value="/dataplatform/result",method = RequestMethod.POST)
//    public void getDepartmentbyid(@RequestBody JSONObject jsonParam){
//        System.out.println(jsonParam.toJSONString());
//    }

//    @PostConstruct
//    public void test7() throws Exception {
//       cardScenes.SendToRemoteAPI();

////        List<CardScene> list=cardSceneService.get();
////        cardScenes.setCardScenes(list);
////        task=cardScenes.formateTask();
//        //  System.out.println(task.toString());
////        String s =JSON.toJSONString(task);
////        System.out.println(s);
////        JSONObject jsontask=(JSONObject) JSON.toJSON(task);
////        String jsonstr=JSON.toJSONString(jsontask);
////        System.out.println(jsonstr);
////
////        RestTemplateUtil restTemplateUtil=new RestTemplateUtil();
////        String url="http://10.16.213.138:8088/callout-adapter/adapter/tasks";
////        System.out.println(restTemplateUtil.PostJsonData(url,jsontask));
//
//    }
    @Async("myExecutor")
    public void Scenerun(String id){
        Scene scene = ScenesFactory.getScene(id);
        String result =scene.SendToRemoteAPI();
        logger.info("Run "+id+" task, the result is："+result);
}
}
