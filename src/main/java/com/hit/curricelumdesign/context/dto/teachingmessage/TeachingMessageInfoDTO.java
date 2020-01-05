package com.hit.curricelumdesign.context.dto.teachingmessage;

/**
 * @author
 * @Date
 * @ClassName
 * @Description
 */
public class TeachingMessageInfoDTO {
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

    @Override
    public String toString() {
        return "WorkMessageInfoDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", senderId=" + senderId +
                ", senderName='" + senderName + '\'' +
                ", senderType=" + senderType +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
