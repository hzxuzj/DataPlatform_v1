package com.example.dataplatform.util;
import com.example.dataplatform.model.CardScenes;
import com.example.dataplatform.model.Scene;
import javafx.application.Application;
import org.apache.catalina.core.ApplicationContext;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.xml.sax.XMLReader;
import javax.sql.rowset.spi.XmlReader;
import javax.xml.parsers.SAXParserFactory;
import java.lang.reflect.Field;

public class ScenesFactory {
    public static Scene getScene(String id){//工厂类
        try {
            SAXReader reader=new SAXReader();
            Document document=reader.read(ScenesFactory.class.getClassLoader().getResourceAsStream("scene.xml"));
            Element element=(Element) document.selectSingleNode("//bean[@id='"+id+"']");
            String value =element.attributeValue("class");
            Class clazz = Class.forName(value);
//            return clazz.newInstance();
//            Field[] fields =clazz.getDeclaredFields();
//            Object bean=clazz.newInstance();
//            for (Field f:fields){
//                if (f.isAnnotationPresent(Autowired.class)){
//                    Class<?>c =f.getType();
//                    Object obj = c.newInstance();
//                    f.setAccessible(true);
//                    f.set(bean,obj);
//                }
//            }
//            return bean;
           Object obj= ApplicationContextHolder.getContext().getBean(clazz);
           return (Scene) obj;
        }catch (Exception e){
            e.printStackTrace();
            throw  new  RuntimeException();
        }
    }
}
