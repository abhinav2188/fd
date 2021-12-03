package com.example.fportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fportal.dao.UserDao;
import com.example.fportal.modals.User;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public void addUser(User u) {
        userDao.addUser(u);
    }

    @Override
    public User findByEmail(String e) {
        User u=userDao.findByEmail(e);
        return u;
    }

    @Override
    public void removeUser(User u) {
        userDao.removeUser(u);
    }

    @Override
    public User updateUser(User u) {
        User u1=userDao.updateUser(u);
        return u1;
    }
}
