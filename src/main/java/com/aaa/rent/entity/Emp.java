package com.aaa.rent.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * className:Emp
 * discription:
 * author:luRuiHua
 * createTime:2018-11-29 09:54
 */

public class Emp {
    private Integer empNo;
    private String eName;

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }
}
