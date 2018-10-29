package com.perry.service.impl;

import org.springframework.stereotype.Service;

import com.perry.dao.UserMapper;
import com.perry.model.User;
import com.perry.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Ethel_oo on 2017/12/6.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.selectAll();
    }
}
