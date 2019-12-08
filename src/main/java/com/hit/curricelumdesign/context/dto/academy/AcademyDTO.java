package com.hit.curricelumdesign.context.dto.academy;

import com.hit.curricelumdesign.context.dto.clazz.ClassInfoDTO;

import java.util.List;

/**
 * @author xbr
 * @Date 2019-12-08
 * @ClassName AcademyDTO
 * @Description
 */
public class AcademyDTO {

    /**
     * 学院id
     */
    private Integer id;

    /**
     * 学院名称
     */
    private String name;

    /**
     * 班级列表
     */
    private List<ClassInfoDTO> classList;

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

    public List<ClassInfoDTO> getClassList() {
        return classList;
    }

    public void setClassList(List<ClassInfoDTO> classList) {
        this.classList = classList;
    }

    @Override
    public String toString() {
        return "AcademyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classList=" + classList +
                '}';
    }
}
