package com.example.dataplatform;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.dataplatform.model.CardScene;
import com.example.dataplatform.model.CardScenes;
import com.example.dataplatform.model.Task;
import com.example.dataplatform.services.CardSceneService;
import com.example.dataplatform.services.impl.CardSceneServiceImpl;
import com.example.dataplatform.util.ChineseNumUtil;
import com.example.dataplatform.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.dataplatform.util.RestTemplateUtil;
import org.springframework.util.unit.DataUnit;

import javax.annotation.PostConstruct;
import javax.xml.crypto.Data;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataplatformApplicationTests {
    @Autowired
    Task task;
    @Autowired
    CardSceneService cardSceneService;
    @Autowired
    CardScenes cardScenes;
    @Test
    public void test() throws Exception {
        RestTemplateUtil restTemplateUtil=new RestTemplateUtil();
        String url="http://127.0.0.1:8080/departments";
        Map<String, String> param =new HashMap<>();
        for (int i =0; i<3;i++)
        {

                System.out.println(restTemplateUtil.GetData(url,param));

            Thread.sleep(500);

        }

    }
    @Test
    public void test2() throws Exception {
        RestTemplateUtil restTemplateUtil=new RestTemplateUtil();
        String url="http://127.0.0.1:8080/job/norempl/1?offset={offset}&limit={limit}";
        Map<String, String> param =new HashMap<>();
        param.put("offset","10");
        param.put("limit","8");
        for (int i =0; i<3;i++)
        {
            System.out.println(restTemplateUtil.GetData(url,param));
            Thread.sleep(500);
        }
    }
    @Test
    public void test3() throws Exception {//测试json
        String str=" \n" +
                "{\n" +
                "    \"name\":\"任务名\",\n" +
                "    \"templateId\":1233,\n" +
                "    \"threshold\":2,\n" +
                "    \"dynamicProperties\":[\n" +
                "        \"动态字段名称1\",\n" +
                "        \"动态字段名称2\"\n" +
                "    ],\n" +
                "    \"dynamicControl\":[\n" +
                "      {\n" +
                "        \"name\":\"动态字段名称1\",\n" +
                "        \"chineseName\":\"动态字段中文名\",\n" +
                "        \"readMethod\":\"normal\",\n" +
                "        \"unitFlag\":2,\n" +
                "        \"unitName\":\"元\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"phones\":[\n" +
                "        {\n" +
                "            \"phone\":\"136xxxxx\",\n" +
                "            \"userData\":{\n" +
                "                \"key\":\"value\"\n" +
                "            },\n" +
                "            \"properties\":{\n" +
                "                \"动态字段名称1\":{\n" +
                "                    \"text\":\"aaaa\"\n" +
                "                },\n" +
                "                \"动态字段名称2\":{\n" +
                "                    \"text\":\"bbbb\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"telQueue\":[\n" +
                "        \"#,1\",\n" +
                "        \"#,1,5\"\n" +
                "    ],\n" +
                "    \"rules\":[\n" +
                "        {\n" +
                "            \"dayOfWeek\":3,\n" +
                "            \"startTime\":\"09:00\",\n" +
                "            \"endTime\":\"14:00\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"ruleControl\":{\n" +
                "        \"redialTimes\":0,\n" +
                "        \"redialPeriod\":24,\n" +
                "        \"redialReason\":[\n" +
                "            \"无法接通\"\n" +
                "        ]\n" +
                "    },\n" +
                "    \"personalSynth\":{\n" +
                "        \"voicePacketId\":\"2222\",\n" +
                "        \"volume\":\"5\",\n" +
                "        \"speed\":\"30\",\n" +
                "        \"tone\":\"50\"\n" +
                "    },  \n" +
                "   \"calloutResultSyncUrl\":\"外呼结果回调url\",\n" +
                "   \"apiSwitch\":true,\n" +
                "   \"synPhaseTimeOut\":3600000,\n" +
                "   \"synTaskCreateTimeOut\":180000,\n" +
                "   \"synTaskSplitFlag\":false\n" +
                "}";
        task= JSON.parseObject(str,Task.class);
        System.out.println(task.toString());
        String str2=JSON.toJSONString(task);
        System.out.println(str2);
    }
    @Test
    public void test4() throws Exception {
        List<String> list= new ArrayList<>();
        String a="hhhhh";
        list.add(a);
        a="bbbb";
        list.add(a);
        System.out.println(list);
    }
    @Test
    public void test5() throws Exception {

        String s = DateUtil.parseStrToChineseStr("19911012","yyyyMMdd");
        System.out.println(s);
        s= DateUtil.parseStrToChineseStr("19910112","yyyyMMdd");
        System.out.println(s);
        s= DateUtil.parseStrToChineseStr("19911123","yyyyMMdd");
        System.out.println(s);
        s= DateUtil.parseStrToChineseStr("21010519","yyyyMMdd");
        System.out.println(s);

    }

    @Test
    public void test6() throws Exception {

        List<CardScene> list=cardSceneService.get();
        cardScenes.setCardScenes(list);
        task=cardScenes.formateTask();
      //  System.out.println(task.toString());
//        String s =JSON.toJSONString(task);
//        System.out.println(s);
        JSONObject jsontask=(JSONObject) JSON.toJSON(task);
        String jsonstr=JSON.toJSONString(jsontask);
        System.out.println(jsonstr);

    }
    @Test
    @PostConstruct
    public void test7() throws Exception {

        List<CardScene> list=cardSceneService.get();
        cardScenes.setCardScenes(list);
        task=cardScenes.formateTask();
        //  System.out.println(task.toString());
//        String s =JSON.toJSONString(task);
//        System.out.println(s);
        JSONObject jsontask=(JSONObject) JSON.toJSON(task);
        String jsonstr=JSON.toJSONString(jsontask);
        System.out.println(jsonstr);

        RestTemplateUtil restTemplateUtil=new RestTemplateUtil();
        String url="http://10.16.213.138:8088/callout-adapter/adapter/tasks";
        System.out.println(restTemplateUtil.PostJsonData(url,jsontask));

    }
}
