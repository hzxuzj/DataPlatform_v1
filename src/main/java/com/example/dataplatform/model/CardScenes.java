package com.example.dataplatform.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.dataplatform.services.CardSceneService;
import com.example.dataplatform.services.impl.CardSceneServiceImpl;
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
@RestController
@Configurable
@Component
public  class CardScenes  extends AbstractScenes{
//    @Autowired
//    Task task;
//    @Autowired
//    DynamicControl dynamicControl;
//    @Autowired
//    PersonalSynth personalSynth;
//    @Autowired
//    Phones phones;
//    @Autowired
//    RuleControl ruleControl;
//    @Autowired
//    Rules rules;
    @Autowired
    CardSceneServiceImpl cardSceneService;
    private List<CardScene> cardScenes;
    public List<CardScene> getCardScenes() {
        return cardScenes;
    }

    public void setCardScenes(List<CardScene> cardScenes) {
        this.cardScenes = cardScenes;
    }

    public Task formateTaskRule(){
        return super.formateTaskRule();
    }
    public Task formateTask(){//将场景数据进行统一转换为接口调用数据
        task=formateTaskRule();
        //CardSceneService cardSceneService=new CardSceneServiceImpl();
        List<CardScene> list=cardSceneService.get();
        this.cardScenes=list;

        List<String> dynamicproperties = new ArrayList<String>();
        dynamicproperties.add("name");
        dynamicproperties.add("department");
        dynamicproperties.add("departmentphone");
        dynamicproperties.add("time");
        dynamicproperties.add("gender");
        task.setDynamicProperties(dynamicproperties);
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

    @RequestMapping(value="/dataplatform/result",method = RequestMethod.POST)
    public String resultWrite(@RequestBody JSONObject jsonParam){
        System.out.println(jsonParam.toJSONString());
        return jsonParam.toJSONString();
    }
    public String SendToRemoteAPI(){
        return super.SendToRemoteAPI();
    }

}