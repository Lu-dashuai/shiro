package com.aaa.rent.dao;


import java.util.List;
import java.util.Map;

/**
 * className:UserDao
 * discription:
 * author:luRuiHua
 * createTime:2018-11-29 09:54
 */
public interface UserDao {
    /**
     * 查询用户
     * @return
     */
    public List<Map> selectUserList(String userName);
}
