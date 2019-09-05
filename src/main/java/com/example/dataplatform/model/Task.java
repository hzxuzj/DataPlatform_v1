/**
  * Copyright 2019 bejson.com 
  */
package com.example.dataplatform.model;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Date;
import java.util.Map;
@Component
public class Task {

    private String name;
    private int templateId;
    private int threshold;
    private List<String> dynamicProperties;
    private List<DynamicControl> dynamicControl;
    private List<Phones> phones;
    private List<String> telQueue;
    private List<Rules> rules;
    private RuleControl ruleControl;
    private PersonalSynth personalSynth;
    private String calloutResultSyncUrl;
    private boolean apiSwitch;
    private long synPhaseTimeOut;
    private long synTaskCreateTimeOut;
    private boolean synTaskSplitFlag;
    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setTemplateId(int templateId) {
         this.templateId = templateId;
     }
     public int getTemplateId() {
         return templateId;
     }

    public void setThreshold(int threshold) {
         this.threshold = threshold;
     }
     public int getThreshold() {
         return threshold;
     }

    public void setDynamicProperties(List<String> dynamicProperties) {
         this.dynamicProperties = dynamicProperties;
     }
     public List<String> getDynamicProperties() {
         return dynamicProperties;
     }

    public void setDynamicControl(List<DynamicControl> dynamicControl) {
         this.dynamicControl = dynamicControl;
     }
     public List<DynamicControl> getDynamicControl() {
         return dynamicControl;
     }

    public void setPhones(List<Phones> phones) {
         this.phones = phones;
     }
     public List<Phones> getPhones() {
         return phones;
     }

    public void setTelQueue(List<String> telQueue) {
         this.telQueue = telQueue;
     }
     public List<String> getTelQueue() {
         return telQueue;
     }

    public void setRules(List<Rules> rules) {
         this.rules = rules;
     }
     public List<Rules> getRules() {
         return rules;
     }

    public void setRuleControl(RuleControl ruleControl) {
         this.ruleControl = ruleControl;
     }
     public RuleControl getRuleControl() {
         return ruleControl;
     }

    public void setPersonalSynth(PersonalSynth personalSynth) {
         this.personalSynth = personalSynth;
     }
     public PersonalSynth getPersonalSynth() {
         return personalSynth;
     }

    public void setCalloutResultSyncUrl(String calloutResultSyncUrl) {
         this.calloutResultSyncUrl = calloutResultSyncUrl;
     }
     public String getCalloutResultSyncUrl() {
         return calloutResultSyncUrl;
     }

    public void setApiSwitch(boolean apiSwitch) {
         this.apiSwitch = apiSwitch;
     }
     public boolean getApiSwitch() {
         return apiSwitch;
     }

    public void setSynPhaseTimeOut(long synPhaseTimeOut) {
         this.synPhaseTimeOut = synPhaseTimeOut;
     }
     public long getSynPhaseTimeOut() {
         return synPhaseTimeOut;
     }

    public void setSynTaskCreateTimeOut(long synTaskCreateTimeOut) {
         this.synTaskCreateTimeOut = synTaskCreateTimeOut;
     }
     public long getSynTaskCreateTimeOut() {
         return synTaskCreateTimeOut;
     }

    public void setSynTaskSplitFlag(boolean synTaskSplitFlag) {
         this.synTaskSplitFlag = synTaskSplitFlag;
     }
     public boolean getSynTaskSplitFlag() {
         return synTaskSplitFlag;
     }
    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", templateId=" + templateId +
                ", threshold=" + threshold +
                ", dynamicProperties=" + dynamicProperties +
                ", dynamicControl=" + dynamicControl +
                ", phones=" + phones.toString() +
                ", telQueue=" + telQueue +
                ", rules=" + rules +
                ", ruleControl=" + ruleControl +
                ", personalSynth=" + personalSynth +
                ", calloutResultSyncUrl='" + calloutResultSyncUrl + '\'' +
                ", apiSwitch=" + apiSwitch +
                ", synPhaseTimeOut=" + synPhaseTimeOut +
                ", synTaskCreateTimeOut=" + synTaskCreateTimeOut +
                ", synTaskSplitFlag=" + synTaskSplitFlag +
                '}';
    }
}

@Component
class Rules {

    private int dayOfWeek;
    private String startTime;
    private String endTime;
    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getStartTime() {
        return startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public String getEndTime() {
        return endTime;
    }

}
@Component
class RuleControl {

    private int redialTimes;
    private int redialPeriod;
    private List<String> redialReason;
    public void setRedialTimes(int redialTimes) {
        this.redialTimes = redialTimes;
    }
    public int getRedialTimes() {
        return redialTimes;
    }

    public void setRedialPeriod(int redialPeriod) {
        this.redialPeriod = redialPeriod;
    }
    public int getRedialPeriod() {
        return redialPeriod;
    }

    public void setRedialReason(List<String> redialReason) {
        this.redialReason = redialReason;
    }
    public List<String> getRedialReason() {
        return redialReason;
    }

}
@Component
class Phones {
    @Override
    public String toString() {
        return "Phones{" +
                "phone='" + phone + '\'' +
                ", userData=" + userData +
                ", properties=" + properties +
                '}';
    }

    private String phone;
    private Map userData;
    private Map properties;
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }

    public void setUserData(Map userData) {
        this.userData = userData;
    }
    public Map getUserData() {
        return userData;
    }

    public void setProperties(Map properties) {
        this.properties = properties;
    }
    public Map getProperties() {
        return properties;
    }

}
@Component
class PersonalSynth {

    private String voicePacketId;
    private String volume;
    private String speed;
    private String tone;
    public void setVoicePacketId(String voicePacketId) {
        this.voicePacketId = voicePacketId;
    }
    public String getVoicePacketId() {
        return voicePacketId;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
    public String getVolume() {
        return volume;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
    public String getSpeed() {
        return speed;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }
    public String getTone() {
        return tone;
    }

}
@Component
class DynamicControl {

    private String name;
    private String chineseName;
    private String readMethod;
    private int unitFlag;
    private String unitName;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }
    public String getChineseName() {
        return chineseName;
    }

    public void setReadMethod(String readMethod) {
        this.readMethod = readMethod;
    }
    public String getReadMethod() {
        return readMethod;
    }

    public void setUnitFlag(int unitFlag) {
        this.unitFlag = unitFlag;
    }
    public int getUnitFlag() {
        return unitFlag;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    public String getUnitName() {
        return unitName;
    }

}