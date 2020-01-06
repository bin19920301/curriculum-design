package com.hit.curricelumdesign.context.dto.enrollmentYear;

public class EnrollmentYearDTO {
    /**
     * 入学年份id
     */
    private Integer id;

    /**
     * 年级年份
     */
    private Integer enrollmentYear;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(Integer enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    @Override
    public String toString() {
        return "EnrollmentYearDTO{" +
                "id=" + id +
                ", enrollmentYear=" + enrollmentYear +
                '}';
    }
}
