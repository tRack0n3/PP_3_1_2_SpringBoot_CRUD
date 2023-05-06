package com.vn.web.dao;


import com.vn.web.models.User;

import java.util.List;


public interface UserDao {

    List<User> getAllUsers();

    void createUser(User user);

    void deleteUser(Long id);

    void  updateUser(User user);

    User getUser(Long id);
}
