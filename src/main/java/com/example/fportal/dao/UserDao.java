package com.example.fportal.dao;

import com.example.fportal.modals.User;

public interface UserDao {
    void addUser(User u);
    User findByEmail(String e);
    void removeUser(User u);
    User updateUser(User u);
}
