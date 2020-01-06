package com.hit.curricelumdesign.context.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class TeachingMessage {
    /**
     * 删除标志
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
     * 内容
     */
    @Column(name = "f_content")
    private String content;

    /**
     * 发送者id
     */
    @Column(name = "f_sender_id")
    private Integer senderId;

    /**
     * 发送者类型,1:学生 2:教师
     */
    @Column(name = "f_sender_type")
    private Integer senderType;

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
     * 删除标志,0:未删除 1:删除
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

    public Integer getSenderType() {
        return senderType;
    }

    public void setSenderType(Integer senderType) {
        this.senderType = senderType;
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

    @Override
    public String toString() {
        return "TeachingMessage{" +
                "id=" + id +
                ", teachingId=" + teachingId +
                ", content='" + content + '\'' +
                ", senderId=" + senderId +
                ", senderType=" + senderType +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", isDelete=" + isDelete +
                '}';
    }
}
