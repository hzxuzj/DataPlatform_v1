package com.example.dataplatform.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.dataplatform.model.Task;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlUtil {
    public static Object toBean(Class<?> clazz, String xml) throws Exception {
        Object xmlObject = null;
        XStream xstream = new XStream();
        xstream.processAnnotations(clazz);
        XStream.setupDefaultSecurity(xstream);
        Class<?>[] classes = new Class[] { clazz };
        xstream.allowTypes(classes);
        xstream.autodetectAnnotations(true);
        xmlObject= xstream.fromXML(xml);
        return xmlObject;
    }
    public static Task xmltoTask(String id)throws Exception {
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document
        //   Document document = reader.read(new File("sceneconfig.xml"));
        Document document =reader.read(XmlUtil.class.getClassLoader().getResourceAsStream("sceneconfig.xml"));
        //document转换为String字符串
        String documentStr = document.asXML();
        //System.out.println("document 字符串：" + documentStr);
        //获取根节点
        Element root = (Element)document.selectSingleNode("//scene[@id='"+id+"']");
        //根节点转换为String字符串
        String rootStr = root.asXML();
        // System.out.println("root 字符串：" + rootStr);
        //获取其中student1节点
        Element student1Node =root;
        //= root.element("//scene[@id='"+id+"']");
        //student1节点转换为String字符串
        String student1Str = student1Node.asXML();
        //System.out.println(student1Str);
        // System.out.println("scene 字符串：" + student1Str);
        Task task=(Task) XmlUtil.toBean(Task.class,student1Str);
//        JSONObject jsontask=(JSONObject) JSON.toJSON(task);
//        String jsonstr=JSON.toJSONString(jsontask);
//        System.out.println(jsonstr);
        return task;
    }

}