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
     * 关联的课程设计的id
     */
    @Column(name = "f_teaching_id")
    private Integer teachingId;

    /**
     * 关联的作业id
     */
    @Column(name = "f_project_id")
    private Integer projectId;

    /**
     * 消息的具体内容
     */
    @Column(name = "f_message_content")
    private String messageContent;

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
     * 消息发送者的用户类型，1为学生，2为教师，3为管理员
     */
    @Column(name = "f_sender_type")
    private Integer senderType;

    /**
     * 消息的接收者id
     */
    @Column(name = "f_receiver_id")
    private Integer receiverId;

    /**
     * 消息接收者的用户类型，1为学生，2为教师，3为管理员
     */
    @Column(name = "f_receiver_type")
    private Integer receiverType;

    /**
     * 创建时间
     */
    @Column(name = "f_create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * 创建者的id
     */
    @Column(name = "f_creator_id")
    private Integer creatorId;

    /**
     * 更新时间
     */
    @Column(name = "f_update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    /**
     * 修改时操作者的id
     */
    @Column(name = "f_updater_id")
    private Integer updaterId;

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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Integer updaterId) {
        this.updaterId = updaterId;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}