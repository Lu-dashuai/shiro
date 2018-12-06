package com.aaa.rent.service;

import java.util.List;
import java.util.Map;

/**
 * className:UserService
 * discription:
 * author:luRuiHua
 * createTime:2018-12-01 14:51
 */
public interface UserService {
    /**
     * 查询用户
     * @return
     */
    public List<Map> selectUserList(String userName);
}
