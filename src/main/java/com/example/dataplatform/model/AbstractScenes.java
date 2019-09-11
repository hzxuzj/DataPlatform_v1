package com.example.dataplatform.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.dataplatform.services.CardSceneService;
import com.example.dataplatform.util.DateUtil;
import com.example.dataplatform.util.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;
@Component
public abstract class AbstractScenes implements Scene{
    @Autowired
    protected Task task;
    @Autowired
    protected DynamicControl dynamicControl;
    @Autowired
    protected PersonalSynth personalSynth;
    @Autowired
    protected  Phones phones;
    @Autowired
    protected  RuleControl ruleControl;
    @Autowired
    protected  Rules rules;
    @Autowired
    protected  CardSceneService cardSceneService;

    public Task formateTaskRule(){
        task=new Task();
        task.setTemplateId(2000003);
        SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        task.setName("身份证过期通知"+df.format(new Date()));
        task.setThreshold(2);
        task.setSynPhaseTimeOut(3600000);
        task.setSynTaskCreateTimeOut(180000);
        task.setSynTaskSplitFlag(false);
        task.setApiSwitch(true);
        task.setCalloutResultSyncUrl("http://10.16.213.160:8080/dataplatform/result");
        //设置rulecontrol
        ruleControl=new RuleControl();
        ruleControl.setRedialPeriod(0);
        ruleControl.setRedialPeriod(24);
        List<String> rediareason =new ArrayList<>();
        rediareason.add("无法接通");
        rediareason.add("呼叫失败(分类失败)");
        ruleControl.setRedialReason(rediareason);
        task.setRuleControl(ruleControl);
        //设置personlsynth
        personalSynth=new PersonalSynth();
        personalSynth.setVoicePacketId("5d5e3118655fdf306067f682");
        personalSynth.setVolume("3");
        personalSynth.setSpeed("25");
        personalSynth.setTone("50");
        task.setPersonalSynth(personalSynth);
        //设置rules
        List<Rules> ruleslist=new ArrayList<>();
        rules=new Rules();
        for (int i=2;i<7;i++)
        {
            rules.setDayOfWeek(i);
            rules.setStartTime("15:30");
            rules.setEndTime("20:01");
            ruleslist.add(rules);
        }
        task.setRules(ruleslist);
        return  task;
    }
    public abstract Task formateTask();//{//将场景数据进行统一转换为接口调用数据

  //  @RequestMapping(value="/dataplatform/result",method = RequestMethod.POST)
    public String resultWrite(@RequestBody JSONObject jsonParam){
        System.out.println(jsonParam.toJSONString());
        return jsonParam.toJSONString();
    }

    public String SendToRemoteAPI(){
        task=formateTask();
        JSONObject jsontask=(JSONObject) JSON.toJSON(task);
        String jsonstr=JSON.toJSONString(jsontask);
        System.out.println(jsonstr);
        RestTemplateUtil restTemplateUtil=new RestTemplateUtil();
        String url="http://10.16.213.138:8088/callout-adapter/adapter/tasks";
        String result =restTemplateUtil.PostJsonData(url,jsontask);
        System.out.println(result);
        return result;
    };

}