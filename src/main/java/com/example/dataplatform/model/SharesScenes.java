package com.example.dataplatform.model;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.dataplatform.services.CardSceneService;
import com.example.dataplatform.services.SharesSceneService;
import com.example.dataplatform.util.DateUtil;
import com.example.dataplatform.util.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;
@Component
@RestController
public  class SharesScenes extends AbstractScenes {
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
    @Autowired
    SharesSceneService sharesSceneService;

    private List<SharesScene> sharesScenes;
    public List<SharesScene> getSharesScenes() {
        return sharesScenes;
    }

    public void setSharesScenes(List<SharesScene> sharesScenes) {
        this.sharesScenes = sharesScenes;
    }

    public Task formateTaskRule(){
        return super.formateTaskRule();
    }
    public Task formateTask(){//将场景数据进行统一转换为接口调用数据
        task=formateTaskRule();
        List<SharesScene> list=sharesSceneService.get();
        this.sharesScenes=list;
        //设置动态字段
        SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        task.setName("新股中签通知"+df.format(new Date()));
        task.setCalloutResultSyncUrl("http://10.16.213.160:8080/dataplatform/result");
        List<String> dynamicproperties = new ArrayList<String>();
        dynamicproperties.add("name");
        dynamicproperties.add("stockname");
        dynamicproperties.add("stockcode");
        dynamicproperties.add("account");
        dynamicproperties.add("money");
        dynamicproperties.add("department");
        dynamicproperties.add("departmentphone");
        dynamicproperties.add("spec");
        task.setDynamicProperties(dynamicproperties);
        List<Phones> phoneslist=new ArrayList<Phones>();
        for (int i =0;i<sharesScenes.size();i++){
            phones.setPhone(sharesScenes.get(i).getGuestTelnum());
            Map<String, Map<String,String>> properties =new HashMap<>();
            Map<String,String> name=new HashMap<>();
            name.put("text",sharesScenes.get(i).getGuestName());
            properties.put("name",name);
            Map<String,String> stockname=new HashMap<>();
            stockname.put("text",sharesScenes.get(i).getShareName());
            properties.put("stockname",stockname);
            Map<String,String> stockcode=new HashMap<>();
            stockcode.put("text",sharesScenes.get(i).getShareCode());
            properties.put("stockcode",stockcode);
            Map<String,String> account=new HashMap<>();
            account.put("text",sharesScenes.get(i).getCapitalAccount());
            properties.put("account",account);
            Map<String,String> money=new HashMap<>();
            money.put("text",sharesScenes.get(i).getPayment());
            properties.put("account",money);
            Map<String,String> department=new HashMap<>();
            department.put("text",sharesScenes.get(i).getDepartment());
            properties.put("department",department);
            Map<String,String> departmentphone=new HashMap<>();
            departmentphone.put("text",sharesScenes.get(i).getDepartmentPhone());
            properties.put("departmentphone",departmentphone);
            Map<String,String> spec=new HashMap<>();
            spec.put("text",sharesScenes.get(i).getSpec());
            properties.put("spec",spec);
            phones.setProperties(properties);
            phoneslist.add(phones);
        }
        task.setPhones(phoneslist);
        return  task;
    }
    @RequestMapping(value="/dataplatform/sharescene/result",method = RequestMethod.POST)
    public String resultWrite(@RequestBody JSONObject jsonParam){
        System.out.println(jsonParam.toJSONString());
        return jsonParam.toJSONString();
    }


}