package com.example.dataplatform;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.dataplatform.model.CardScene;
import com.example.dataplatform.model.CardScenes;
import com.example.dataplatform.model.Task;
import com.example.dataplatform.services.CardSceneService;
import com.example.dataplatform.util.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DataplatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataplatformApplication.class, args);

    }

}
