package com.example.fportal.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.fportal.modals.User;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User u) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(u);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User findByEmail(String e) {
        Session session=sessionFactory.openSession();
        User u=session.get(User.class,e);
        session.close();
        return u;
    }

    @Override
    public void removeUser(User u) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.delete(u);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User updateUser(User u) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(u);
        User u1=session.get(User.class,u.getEmail());

        session.getTransaction().commit();
        session.close();
        return u1;
    }
}
