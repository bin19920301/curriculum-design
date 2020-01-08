package com.hit.curricelumdesign.context.dto.admin;

/**
 * @author xbr
 * @Date 2019-12-27
 * @ClassName AdminLoginDTO
 * @Description
 */
public class AdminLoginDTO {
    private String token;
    private Integer adminId;
    private String adminName;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Override
    public String toString() {
        return "AdminLoginDTO{" +
                "token='" + token + '\'' +
                ", adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                '}';
    }
}
