package com.hit.curricelumdesign.context.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "t_work_message")
public class WorkMessage {
    /**
     * id主键自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private Integer id;

    /**
     * 教学的id
     */
    @Column(name = "f_teaching_id")
    private Integer teachingId;

    /**
     * 作业id
     */
    @Column(name = "f_work_id")
    private Integer workId;

    /**
     * 消息的具体内容
     */
    @Column(name = "f_content")
    private String content;

    /**
     * 消息是否阅读
     */
    @Column(name = "f_is_read")
    private Boolean isRead;

    /**
     * 消息发送者的id
     */
    @Column(name = "f_sender_id")
    private Integer senderId;

    /**
     * 消息发送者的用户类型，1为学生，2为教师
     */
    @Column(name = "f_sender_type")
    private Integer senderType;

    /**
     * 消息的接收者id
     */
    @Column(name = "f_receiver_id")
    private Integer receiverId;

    /**
     * 消息接收者的用户类型，1为学生，2为教师
     */
    @Column(name = "f_receiver_type")
    private Integer receiverType;

    /**
     * 创建时间
     */
    @Column(name = "f_createtime")
    private Date createtime;

    /**
     * 更新时间
     */
    @Column(name = "f_updatetime")
    private Date updatetime;

    /**
     * 是否删除 0：否 1：是
     */
    @Column(name = "f_is_delete")
    private Boolean isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeachingId() {
        return teachingId;
    }

    public void setTeachingId(Integer teachingId) {
        this.teachingId = teachingId;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getSenderType() {
        return senderType;
    }

    public void setSenderType(Integer senderType) {
        this.senderType = senderType;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Integer getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(Integer receiverType) {
        this.receiverType = receiverType;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}