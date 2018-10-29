package com.perry.service;

import java.util.List;

import com.perry.model.User;

public interface UserService {

    List<User> getUserList();

    User getById(String id);
}
