package com.hit.curricelumdesign.context.dto.workmessage;

/**
 * @author xbr
 * @Date 2019-12-22
 * @ClassName WorkMessageDTO
 * @Description
 */
public class WorkMessageDTO {

    /**
     * 作业id
     */
    private Integer workId;

    /**
     * 教学id
     */
    private Integer teachingId;

    /**
     * 教学名称
     */
    private String teachingName;

    /**
     * 发送人名称
     */
    private String senderName;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 创建时间
     */
    private String createtime;

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Integer getTeachingId() {
        return teachingId;
    }

    public void setTeachingId(Integer teachingId) {
        this.teachingId = teachingId;
    }

    public String getTeachingName() {
        return teachingName;
    }

    public void setTeachingName(String teachingName) {
        this.teachingName = teachingName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "WorkMessageDTO{" +
                "workId=" + workId +
                ", teachingId=" + teachingId +
                ", teachingName='" + teachingName + '\'' +
                ", senderName='" + senderName + '\'' +
                ", content='" + content + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
