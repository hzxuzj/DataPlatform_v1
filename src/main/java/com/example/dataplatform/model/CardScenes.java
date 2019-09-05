package com.example.dataplatform.model;

import com.example.dataplatform.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;
@Component
public  class CardScenes{
    @Autowired
    Task task;
    @Autowired
    DynamicControl dynamicControl;
    @Autowired
    PersonalSynth personalSynth;
    @Autowired
    Phones phones;
    @Autowired
    RuleControl ruleControl;
    @Autowired
    Rules rules;
    private List<CardScene> cardScenes;
    public List<CardScene> getCardScenes() {
        return cardScenes;
    }

    public void setCardScenes(List<CardScene> cardScenes) {
        this.cardScenes = cardScenes;
    }
    public Task formateTask(){//将场景数据进行统一转换为接口调用数据
        task.setTemplateId(2000003);
        SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        task.setName("身份证过期通知"+df.format(new Date()));
        task.setThreshold(2);
        task.setSynPhaseTimeOut(3600000);
        task.setSynTaskCreateTimeOut(180000);
        task.setSynTaskSplitFlag(false);
        task.setApiSwitch(true);
        task.setCalloutResultSyncUrl("http://10.16.213.160:8080/dataplatform/result");
        //设置动态字段
        List<String> dynamicproperties = new ArrayList<String>();
        dynamicproperties.add("name");
        dynamicproperties.add("department");
        dynamicproperties.add("departmentphone");
        dynamicproperties.add("time");
        dynamicproperties.add("gender");
        task.setDynamicProperties(dynamicproperties);
        //设置rulecontrol
        ruleControl.setRedialPeriod(0);
        ruleControl.setRedialPeriod(24);
        List<String> rediareason =new ArrayList<>();
        rediareason.add("无法接通");
        rediareason.add("呼叫失败(分类失败)");
        ruleControl.setRedialReason(rediareason);
        task.setRuleControl(ruleControl);
        //设置personlsynth
        personalSynth.setVoicePacketId("5d5e3118655fdf306067f682");
        personalSynth.setVolume("3");
        personalSynth.setSpeed("25");
        personalSynth.setTone("50");
        task.setPersonalSynth(personalSynth);
        //设置rules
        List<Rules> ruleslist=new ArrayList<>();
        for (int i=2;i<7;i++)
        {
            rules.setDayOfWeek(i);
            rules.setStartTime("15:30");
            rules.setEndTime("20:01");
            ruleslist.add(rules);
        }
        task.setRules(ruleslist);
        //设置phones
        List<Phones> phoneslist=new ArrayList<Phones>();
        for (int i =0;i<cardScenes.size();i++){
            phones.setPhone(cardScenes.get(i).getGuestTelnum());
            Map<String, Map<String,String>> properties =new HashMap<>();
            Map<String,String> name=new HashMap<>();
            name.put("text",cardScenes.get(i).getGuestName());
            properties.put("name",name);
            Map<String,String> gender=new HashMap<>();
            if (cardScenes.get(i).getGuestGender().equals("男")){
                gender.put("text","先生");
            }
            else {
                gender.put("text","女士");
            }
            properties.put("gender",gender);
            Map<String,String> department=new HashMap<>();
            name.put("text",cardScenes.get(i).getDepartment());
            properties.put("department",department);
            Map<String,String> time=new HashMap<>();
            time.put("text", DateUtil.parseStrToChineseStr(cardScenes.get(i).getOverdueDate(),"yyyyMMdd"));
            properties.put("time",time);
            Map<String,String> departmentphone=new HashMap<>();
            departmentphone.put("text",cardScenes.get(i).getDepartmentTelnum());
            properties.put("departmentphone",departmentphone);
            phones.setProperties(properties);
            phoneslist.add(phones);
        }
        task.setPhones(phoneslist);
        return  task;

    }

}