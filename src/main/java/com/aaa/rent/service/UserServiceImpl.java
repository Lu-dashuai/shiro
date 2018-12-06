package com.aaa.rent.service;

import com.aaa.rent.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:UserServiceImpl
 * discription:
 * author:luRuiHua
 * createTime:2018-12-01 14:51
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 查询用户
     * @return
     */
    @Override
    public List<Map> selectUserList(String userName) {
        return userDao.selectUserList(userName);
    }
}
