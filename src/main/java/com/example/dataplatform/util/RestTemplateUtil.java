package com.example.dataplatform.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
/**
 * @author : xuzhengjun
 * @date : 2019.9.2
 */
import javax.xml.ws.http.HTTPException;
import javax.xml.ws.spi.http.HttpHandler;
import java.util.Map;

@Component
public class RestTemplateUtil {
    private RestTemplate restTemplate;

    public String GetData(String url, Map<String,String> param) throws HTTPException {//封装GET请求
        restTemplate=new RestTemplate();
        HttpHeaders headers =new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("clientId","61acaa82dde9474d8f9df3aec14bbdaf");
        headers.add("clientSecret", "625b0723d0044535ac0b2e5018fd0857");
        headers.add("grantType", "client_credentials");
        headers.add("Content-Type", "application/json;charset=utf-8");
        try {
            return restTemplate.getForEntity(url,String.class,param).getBody();
        }catch (HttpClientErrorException e){
            e.getStackTrace();
            e.printStackTrace();
            return  "httpClient请求失败，Url错误";
        }
        catch (Exception e){
            e.getStackTrace();
            e.printStackTrace();
            return "GET请求失败";
        }
    }
    public String PostJsonData(String url,JSONObject param){
        restTemplate=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("clientId","61acaa82dde9474d8f9df3aec14bbdaf");
        headers.add("clientSecret", "625b0723d0044535ac0b2e5018fd0857");
        headers.add("grantType", "client_credentials");
        headers.add("Content-Type", "application/json;charset=utf-8");
        HttpEntity<JSONObject> requestEntity = new HttpEntity<JSONObject>(param, headers);
       try {
           return restTemplate.postForEntity(url, requestEntity, String.class).getBody();
       }catch (HttpClientErrorException e){
           return  "httpClient请求失败，Url错误";
       }
       catch (Exception e){
           return "Post请求失败";
       }
    }
    public String PostFormData(String url,MultiValueMap<String,String> param){
        restTemplate=new RestTemplate();
        // 请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        try {
            return restTemplate.postForEntity(url,param,String.class).getBody();
        }catch (Exception e){
            return "请求失败";
        }
    }


}
