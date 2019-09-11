package com.example.dataplatform.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * shares_shortage
 * @author 
 */
@Component
public class SharesScene implements Serializable {
    private String guestId;

    private String createDate;

    private String createTime;

    private String guestName;

    private String guestGender;

    private String guestTelnum;

    private String capitalAccount;

    private String shareName;

    private String shareCode;

    private String buyNum;

    private String spec;

    private String payment;

    private String department;

    private String departmentCode;

    private String departmentPhone;

    private String status;

    private String telnum;

    private String callDuration;

    private String updateDate;

    private String updateTime;

    private String voicetext;

    private static final long serialVersionUID = 1L;

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
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

    public String getCapitalAccount() {
        return capitalAccount;
    }

    public void setCapitalAccount(String capitalAccount) {
        this.capitalAccount = capitalAccount;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    public String getShareCode() {
        return shareCode;
    }

    public void setShareCode(String shareCode) {
        this.shareCode = shareCode;
    }

    public String getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(String buyNum) {
        this.buyNum = buyNum;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
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

    public String getDepartmentPhone() {
        return departmentPhone;
    }

    public void setDepartmentPhone(String departmentPhone) {
        this.departmentPhone = departmentPhone;
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

    public String getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(String callDuration) {
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
        SharesScene other = (SharesScene) that;
        return (this.getGuestId() == null ? other.getGuestId() == null : this.getGuestId().equals(other.getGuestId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getGuestName() == null ? other.getGuestName() == null : this.getGuestName().equals(other.getGuestName()))
            && (this.getGuestGender() == null ? other.getGuestGender() == null : this.getGuestGender().equals(other.getGuestGender()))
            && (this.getGuestTelnum() == null ? other.getGuestTelnum() == null : this.getGuestTelnum().equals(other.getGuestTelnum()))
            && (this.getCapitalAccount() == null ? other.getCapitalAccount() == null : this.getCapitalAccount().equals(other.getCapitalAccount()))
            && (this.getShareName() == null ? other.getShareName() == null : this.getShareName().equals(other.getShareName()))
            && (this.getShareCode() == null ? other.getShareCode() == null : this.getShareCode().equals(other.getShareCode()))
            && (this.getBuyNum() == null ? other.getBuyNum() == null : this.getBuyNum().equals(other.getBuyNum()))
            && (this.getSpec() == null ? other.getSpec() == null : this.getSpec().equals(other.getSpec()))
            && (this.getPayment() == null ? other.getPayment() == null : this.getPayment().equals(other.getPayment()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getDepartmentCode() == null ? other.getDepartmentCode() == null : this.getDepartmentCode().equals(other.getDepartmentCode()))
            && (this.getDepartmentPhone() == null ? other.getDepartmentPhone() == null : this.getDepartmentPhone().equals(other.getDepartmentPhone()))
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
        result = prime * result + ((getGuestId() == null) ? 0 : getGuestId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getGuestName() == null) ? 0 : getGuestName().hashCode());
        result = prime * result + ((getGuestGender() == null) ? 0 : getGuestGender().hashCode());
        result = prime * result + ((getGuestTelnum() == null) ? 0 : getGuestTelnum().hashCode());
        result = prime * result + ((getCapitalAccount() == null) ? 0 : getCapitalAccount().hashCode());
        result = prime * result + ((getShareName() == null) ? 0 : getShareName().hashCode());
        result = prime * result + ((getShareCode() == null) ? 0 : getShareCode().hashCode());
        result = prime * result + ((getBuyNum() == null) ? 0 : getBuyNum().hashCode());
        result = prime * result + ((getSpec() == null) ? 0 : getSpec().hashCode());
        result = prime * result + ((getPayment() == null) ? 0 : getPayment().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getDepartmentCode() == null) ? 0 : getDepartmentCode().hashCode());
        result = prime * result + ((getDepartmentPhone() == null) ? 0 : getDepartmentPhone().hashCode());
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
        sb.append(", guestId=").append(guestId);
        sb.append(", createDate=").append(createDate);
        sb.append(", createTime=").append(createTime);
        sb.append(", guestName=").append(guestName);
        sb.append(", guestGender=").append(guestGender);
        sb.append(", guestTelnum=").append(guestTelnum);
        sb.append(", capitalAccount=").append(capitalAccount);
        sb.append(", shareName=").append(shareName);
        sb.append(", shareCode=").append(shareCode);
        sb.append(", buyNum=").append(buyNum);
        sb.append(", spec=").append(spec);
        sb.append(", payment=").append(payment);
        sb.append(", department=").append(department);
        sb.append(", departmentCode=").append(departmentCode);
        sb.append(", departmentPhone=").append(departmentPhone);
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