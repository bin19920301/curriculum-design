package com.hit.curricelumdesign.context.dto.admin;

/**
 * @author xbr
 * @Date 2019-12-08
 * @ClassName AdminListDTO
 * @Description
 */
public class AdminListDTO {
    /**
     * id主键自增非空唯一
     */
    private Integer id;

    /**
     * 管理员的名称
     */
    private String name;

    /**
     * 管理员的编号
     */
    private String number;

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

    @Override
    public String toString() {
        return "AdminListDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
