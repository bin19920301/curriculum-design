package com.hit.curricelumdesign.context.dto.teachermessage;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author xbr
 * @Date 2019-12-24
 * @ClassName WorkMessageInfoDTO
 * @Description
 */
public class TeacherMessageInfoDTO {
    /**
     * id主键自增
     */
    private Integer id;

    /**
     * 消息的具体内容
     */
    private String content;

    /**
     * 消息创建者的id
     */
    private Integer creatorId;

    /**
     * 发送者名称
     */
    private String creatorName;

    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
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

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "TeacherMessageInfoDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", creatorId=" + creatorId +
                ", creatorName='" + creatorName + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
