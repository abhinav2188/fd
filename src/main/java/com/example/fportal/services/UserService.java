package com.example.fportal.services;

import com.example.fportal.modals.User;

public interface UserService {
    void addUser(User u);
    User findByEmail(String e);
    void removeUser(User u);
    User updateUser(User u);
}
