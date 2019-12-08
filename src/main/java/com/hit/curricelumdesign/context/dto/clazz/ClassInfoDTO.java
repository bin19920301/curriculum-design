package com.hit.curricelumdesign.context.dto.clazz;

/**
 * @author xbr
 * @Date 2019-12-08
 * @ClassName ClassInfoDTO
 * @Description
 */
public class ClassInfoDTO {

    /**
     * 班级id
     */
    private Integer id;

    /**
     * 班级名称
     */
    private String name;

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

    @Override
    public String toString() {
        return "ClassInfoDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
