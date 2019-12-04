package com.hit.curricelumdesign.context.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Student {
    /**
     * 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private Integer id;

    /**
     * 
     */
    @Column(name = "f_name")
    private String name;

    /**
     * 
     */
    @Column(name = "f_number")
    private String number;

    /**
     * 
     */
    @Column(name = "f_filterinfo_id")
    private Integer filterinfoId;

    /**
     * 
     */
    @Column(name = "f_is_delete")
    private Boolean isDelete;

    /**
     * 
     */
    @Column(name = "f_createtime")
    private Date createtime;

    /**
     * 
     */
    @Column(name = "f_updatetime")
    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getFilterinfoId() {
        return filterinfoId;
    }

    public void setFilterinfoId(Integer filterinfoId) {
        this.filterinfoId = filterinfoId;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
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
}