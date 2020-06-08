package com.hit.curricelumdesign.context.dto.processingmethod;

public class ProcessingMethodDTO {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 加工形式名称
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
        return "ProcessingMethodDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
