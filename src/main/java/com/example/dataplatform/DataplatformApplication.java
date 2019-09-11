package com.example.dataplatform;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.dataplatform.model.CardScene;
import com.example.dataplatform.model.CardScenes;
import com.example.dataplatform.model.Task;
import com.example.dataplatform.services.CardSceneService;
import com.example.dataplatform.util.RestTemplateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.xml.crypto.Data;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class DataplatformApplication {
    public static ApplicationContext applicationContext;
    private final static Logger logger= LoggerFactory.getLogger(DataplatformApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context=  SpringApplication.run(DataplatformApplication.class, args);
        DataplatformApplication.applicationContext =context;
        logger.info("applicationcontext get");

    }

}
