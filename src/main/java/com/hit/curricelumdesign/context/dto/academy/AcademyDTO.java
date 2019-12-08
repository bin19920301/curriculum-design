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
     * 学院名称
     */
    private String name;

    /**
     * 班级列表
     */
    private List<ClassInfoDTO> classList;

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
                "name='" + name + '\'' +
                ", classList=" + classList +
                '}';
    }
}
