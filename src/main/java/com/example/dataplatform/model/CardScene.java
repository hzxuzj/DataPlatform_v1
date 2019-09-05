package com.example.dataplatform.model;

import com.example.dataplatform.util.DateUtil;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.sun.org.apache.bcel.internal.generic.NEW;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.ranges.Range;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * card_overdue
 * @author 
 */
@Component
public class CardScene implements Serializable {

    private Long customerId;

    private String createDate;

    private String createTime;

    private String guestName;

    private String guestGender;

    private String guestTelnum;

    private String cardCategory;

    private String overdueDate;

    private String department;

    private String departmentCode;

    private String departmentTelnum;

    private String waiterName;

    private String waiterTelnum;

    private String status;

    private String telnum;

    private Integer callDuration;

    private String updateDate;

    private String updateTime;

    private String voicetext;

    private static final long serialVersionUID = 1L;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestGender() {
        return guestGender;
    }

    public void setGuestGender(String guestGender) {
        this.guestGender = guestGender;
    }

    public String getGuestTelnum() {
        return guestTelnum;
    }

    public void setGuestTelnum(String guestTelnum) {
        this.guestTelnum = guestTelnum;
    }

    public String getCardCategory() {
        return cardCategory;
    }

    public void setCardCategory(String cardCategory) {
        this.cardCategory = cardCategory;
    }

    public String getOverdueDate() {
        return overdueDate;
    }

    public void setOverdueDate(String overdueDate) {
        this.overdueDate = overdueDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentTelnum() {
        return departmentTelnum;
    }

    public void setDepartmentTelnum(String departmentTelnum) {
        this.departmentTelnum = departmentTelnum;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public String getWaiterTelnum() {
        return waiterTelnum;
    }

    public void setWaiterTelnum(String waiterTelnum) {
        this.waiterTelnum = waiterTelnum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelnum() {
        return telnum;
    }

    public void setTelnum(String telnum) {
        this.telnum = telnum;
    }

    public Integer getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(Integer callDuration) {
        this.callDuration = callDuration;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getVoicetext() {
        return voicetext;
    }

    public void setVoicetext(String voicetext) {
        this.voicetext = voicetext;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CardScene other = (CardScene) that;
        return (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getGuestName() == null ? other.getGuestName() == null : this.getGuestName().equals(other.getGuestName()))
            && (this.getGuestGender() == null ? other.getGuestGender() == null : this.getGuestGender().equals(other.getGuestGender()))
            && (this.getGuestTelnum() == null ? other.getGuestTelnum() == null : this.getGuestTelnum().equals(other.getGuestTelnum()))
            && (this.getCardCategory() == null ? other.getCardCategory() == null : this.getCardCategory().equals(other.getCardCategory()))
            && (this.getOverdueDate() == null ? other.getOverdueDate() == null : this.getOverdueDate().equals(other.getOverdueDate()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getDepartmentCode() == null ? other.getDepartmentCode() == null : this.getDepartmentCode().equals(other.getDepartmentCode()))
            && (this.getDepartmentTelnum() == null ? other.getDepartmentTelnum() == null : this.getDepartmentTelnum().equals(other.getDepartmentTelnum()))
            && (this.getWaiterName() == null ? other.getWaiterName() == null : this.getWaiterName().equals(other.getWaiterName()))
            && (this.getWaiterTelnum() == null ? other.getWaiterTelnum() == null : this.getWaiterTelnum().equals(other.getWaiterTelnum()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTelnum() == null ? other.getTelnum() == null : this.getTelnum().equals(other.getTelnum()))
            && (this.getCallDuration() == null ? other.getCallDuration() == null : this.getCallDuration().equals(other.getCallDuration()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getVoicetext() == null ? other.getVoicetext() == null : this.getVoicetext().equals(other.getVoicetext()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getGuestName() == null) ? 0 : getGuestName().hashCode());
        result = prime * result + ((getGuestGender() == null) ? 0 : getGuestGender().hashCode());
        result = prime * result + ((getGuestTelnum() == null) ? 0 : getGuestTelnum().hashCode());
        result = prime * result + ((getCardCategory() == null) ? 0 : getCardCategory().hashCode());
        result = prime * result + ((getOverdueDate() == null) ? 0 : getOverdueDate().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getDepartmentCode() == null) ? 0 : getDepartmentCode().hashCode());
        result = prime * result + ((getDepartmentTelnum() == null) ? 0 : getDepartmentTelnum().hashCode());
        result = prime * result + ((getWaiterName() == null) ? 0 : getWaiterName().hashCode());
        result = prime * result + ((getWaiterTelnum() == null) ? 0 : getWaiterTelnum().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTelnum() == null) ? 0 : getTelnum().hashCode());
        result = prime * result + ((getCallDuration() == null) ? 0 : getCallDuration().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getVoicetext() == null) ? 0 : getVoicetext().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", customerId=").append(customerId);
        sb.append(", createDate=").append(createDate);
        sb.append(", createTime=").append(createTime);
        sb.append(", guestName=").append(guestName);
        sb.append(", guestGender=").append(guestGender);
        sb.append(", guestTelnum=").append(guestTelnum);
        sb.append(", cardCategory=").append(cardCategory);
        sb.append(", overdueDate=").append(overdueDate);
        sb.append(", department=").append(department);
        sb.append(", departmentCode=").append(departmentCode);
        sb.append(", departmentTelnum=").append(departmentTelnum);
        sb.append(", waiterName=").append(waiterName);
        sb.append(", waiterTelnum=").append(waiterTelnum);
        sb.append(", status=").append(status);
        sb.append(", telnum=").append(telnum);
        sb.append(", callDuration=").append(callDuration);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", voicetext=").append(voicetext);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }


}

