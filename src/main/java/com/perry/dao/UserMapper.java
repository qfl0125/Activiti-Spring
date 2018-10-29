package com.perry.dao;

import java.util.List;

import com.perry.model.User;

/**
 * Description:
 * <>
 * @Params :
 * @Return :
 * @Author : Perry
 * @Date : 2018/5/30 10:55
 *
 */

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}