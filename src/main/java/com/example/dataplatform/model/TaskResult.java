package com.example.dataplatform.model;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TaskResult {
    private String id;
    private String phone;
    private String result;

    @Override
    public String toString() {
        return "TaskResult{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", result='" + result + '\'' +
                ", callTime='" + callTime + '\'' +
                ", taskId='" + taskId + '\'' +
                ", callDuration=" + callDuration +
                ", voiceText='" + voiceText + '\'' +
                ", intention='" + intention + '\'' +
                ", telnum='" + telnum + '\'' +
                ", userData=" + userData +
                ", totalDuration=" + totalDuration +
                ", fdsfPath='" + fdsfPath + '\'' +
                ", intentionScore=" + intentionScore +
                ", intentionRoute='" + intentionRoute + '\'' +
                ", dialogueList=" + dialogueList +
                '}';
    }

    private String callTime;
    private String taskId;
    private int callDuration;
    private String voiceText;
    private String intention;
    private String telnum;
    private Map<String,Object> userData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCallTime() {
        return callTime;
    }

    public void setCallTime(String callTime) {
        this.callTime = callTime;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public int getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(int callDuration) {
        this.callDuration = callDuration;
    }

    public String getVoiceText() {
        return voiceText;
    }

    public void setVoiceText(String voiceText) {
        this.voiceText = voiceText;
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public String getTelnum() {
        return telnum;
    }

    public void setTelnum(String telnum) {
        this.telnum = telnum;
    }

    public Map<String, Object> getUserData() {
        return userData;
    }

    public void setUserData(Map<String, Object> userData) {
        this.userData = userData;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getFdsfPath() {
        return fdsfPath;
    }

    public void setFdsfPath(String fdsfPath) {
        this.fdsfPath = fdsfPath;
    }

    public Double getIntentionScore() {
        return intentionScore;
    }

    public void setIntentionScore(Double intentionScore) {
        this.intentionScore = intentionScore;
    }

    public String getIntentionRoute() {
        return intentionRoute;
    }

    public void setIntentionRoute(String intentionRoute) {
        this.intentionRoute = intentionRoute;
    }

    public List<Dialog> getDialogueList() {
        return dialogueList;
    }

    public void setDialogueList(List<Dialog> dialogueList) {
        this.dialogueList = dialogueList;
    }

    private int totalDuration;
    private String fdsfPath;
    private Double intentionScore;
    private String intentionRoute;
    private List<Dialog> dialogueList;
}
class Dialog{
    private String user;
    private String chat_text;

    @Override
    public String toString() {
        return "Dialog{" +
                "user='" + user + '\'' +
                ", chat_text='" + chat_text + '\'' +
                ", chat_time='" + chat_time + '\'' +
                ", intent_val='" + intent_val + '\'' +
                ", play_ratio='" + play_ratio + '\'' +
                ", answer_type=" + answer_type +
                ", fdfs_path='" + fdfs_path + '\'' +
                ", answerDesc='" + answerDesc + '\'' +
                '}';
    }

    private String chat_time;
    private String intent_val;
    private String play_ratio;
    private int answer_type;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getChat_text() {
        return chat_text;
    }

    public void setChat_text(String chat_text) {
        this.chat_text = chat_text;
    }

    public String getChat_time() {
        return chat_time;
    }

    public void setChat_time(String chat_time) {
        this.chat_time = chat_time;
    }

    public String getIntent_val() {
        return intent_val;
    }

    public void setIntent_val(String intent_val) {
        this.intent_val = intent_val;
    }

    public String getPlay_ratio() {
        return play_ratio;
    }

    public void setPlay_ratio(String play_ratio) {
        this.play_ratio = play_ratio;
    }

    public int getAnswer_type() {
        return answer_type;
    }

    public void setAnswer_type(int answer_type) {
        this.answer_type = answer_type;
    }

    public String getFdfs_path() {
        return fdfs_path;
    }

    public void setFdfs_path(String fdfs_path) {
        this.fdfs_path = fdfs_path;
    }

    public String getAnswerDesc() {
        return answerDesc;
    }

    public void setAnswerDesc(String answerDesc) {
        this.answerDesc = answerDesc;
    }

    private String fdfs_path;
    private String answerDesc;
}