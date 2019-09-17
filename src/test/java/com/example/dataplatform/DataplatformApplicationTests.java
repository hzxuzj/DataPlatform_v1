package com.example.dataplatform;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.dataplatform.model.*;
import com.example.dataplatform.services.CardSceneService;
import com.example.dataplatform.services.impl.CardSceneServiceImpl;
import com.example.dataplatform.util.*;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.unit.DataUnit;

import javax.annotation.PostConstruct;
import javax.xml.crypto.Data;
import java.io.File;
import java.sql.Time;
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
        s = DateUtil.parseTodaytoStr("2019-01-21 15:55:20","yyyy-MM-dd HH:mm:ss");
        System.out.println(s);
        s = DateUtil.parseTodaytimetoStr("2019-01-21 15:55:20","yyyy-MM-dd HH:mm:ss");
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
    @Test
    public void test8() throws Exception {
        Scene sc =  ScenesFactory.getScene("CardScenes");
        //System.out.println(sc.toString());
        //sc.formateTaskRule();
        sc.SendToRemoteAPI();
    }
    @Test
    public  void  test9() throws  Exception{

            //创建SAXReader对象

            SAXReader reader = new SAXReader();
            //读取文件 转换成Document
         //   Document document = reader.read(new File("sceneconfig.xml"));
            Document document =reader.read(DataplatformApplicationTests.class.getClassLoader().getResourceAsStream("sceneconfig.xml"));
            //document转换为String字符串
            String documentStr = document.asXML();
            //System.out.println("document 字符串：" + documentStr);
            //获取根节点
            Element root = document.getRootElement();
            //根节点转换为String字符串
            String rootStr = root.asXML();
            //System.out.println("root 字符串：" + rootStr);
            //获取其中student1节点
            Element student1Node = root.element("scene");
            //student1节点转换为String字符串
            String student1Str = student1Node.asXML();
            System.out.println("scene 字符串：" + student1Str);
    }

    @Test
    public  void  test10() throws  Exception{

        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document
        //   Document document = reader.read(new File("sceneconfig.xml"));
        Document document =reader.read(DataplatformApplicationTests.class.getClassLoader().getResourceAsStream("sceneconfig.xml"));
        //document转换为String字符串
        String documentStr = document.asXML();
        //System.out.println("document 字符串：" + documentStr);
        //获取根节点
        String id ="ShareScene";
        Element root = (Element)document.selectSingleNode("//scene[@id='"+id+"']");
        //根节点转换为String字符串
        String rootStr = root.asXML();
       // System.out.println("root 字符串：" + rootStr);
        //获取其中student1节点
        Element student1Node =root;
                //= root.element("//scene[@id='"+id+"']");
        //student1节点转换为String字符串
        String student1Str = student1Node.asXML();
        System.out.println(student1Str);
       // System.out.println("scene 字符串：" + student1Str);
        Task task=(Task) XmlUtil.toBean(Task.class,student1Str);

        JSONObject jsontask=(JSONObject) JSON.toJSON(task);
        String jsonstr=JSON.toJSONString(jsontask);
        System.out.println(jsonstr);
    }
}