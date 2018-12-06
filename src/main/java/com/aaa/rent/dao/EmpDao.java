package com.aaa.rent.dao;

import com.aaa.rent.entity.Emp;

import java.util.List;

/**
 * className:EmpDao
 * discription:
 * author:luRuiHua
 * createTime:2018-11-29 09:54
 */
public interface EmpDao {
    /**
     * 查询员工
     * @return
     */
    public List<Emp> selectEmpList();
}
