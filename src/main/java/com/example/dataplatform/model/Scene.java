package com.example.dataplatform.model;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;

public interface Scene {
    public  Task  formateTaskRule(String id);
    public Task   formateTask();
    public String resultWrite(JSONObject jsonParam);
    public String SendToRemoteAPI();
}
