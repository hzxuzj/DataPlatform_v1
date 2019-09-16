package com.example.dataplatform.util;

import org.apache.ibatis.annotations.Case;

public class SceneUtil {
    public static String calculatestatus(String intention){
        switch(intention){
            case "结束_成功" : {
                return Integer.toString(3);
                }
            case "结束_失败":
            case "结束_已购买":
            case "结束_打错":
            case "用户接听":{
                return Integer.toString(4);
            }
            case "结束_不方便":
            case "用户不想被打扰":
                {
                return Integer.toString(5);
            }
            case "没有收到账号短信":
            {
                return Integer.toString(6);
            }
            default:{
                return Integer.toString(7);
            }
        }
    }
}
