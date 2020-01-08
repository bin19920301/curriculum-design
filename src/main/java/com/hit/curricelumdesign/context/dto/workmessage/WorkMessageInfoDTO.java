package com.hit.curricelumdesign.context.dto.workmessage;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author xbr
 * @Date 2019-12-24
 * @ClassName WorkMessageInfoDTO
 * @Description
 */
public class WorkMessageInfoDTO {
    /**
     * id主键自增
     */
    private Integer id;

    /**
     * 消息的具体内容
     */
    private String content;

    /**
     * 消息发送者的id
     */
    private Integer senderId;

    /**
     * 发送者名称
     */
    private String senderName;

    /**
     * 消息发送者的用户类型，1为学生，2为教师
     */
    private Integer senderType;

    /**
     * 创建时间
     */
    private String createtime;

    /**
     * 可以删除 0否 1是
     */
    private Integer canDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Integer getSenderType() {
        return senderType;
    }

    public void setSenderType(Integer senderType) {
        this.senderType = senderType;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Integer canDelete) {
        this.canDelete = canDelete;
    }

    @Override
    public String toString() {
        return "WorkMessageInfoDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", senderId=" + senderId +
                ", senderName='" + senderName + '\'' +
                ", senderType=" + senderType +
                ", createtime='" + createtime + '\'' +
                ", canDelete=" + canDelete +
                '}';
    }
}
