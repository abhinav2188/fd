package com.example.fportal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.fportal.modals.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Category> getCategories() {
        Session session=sessionFactory.openSession();
        List<Category> list=session.createQuery("from Categories").getResultList();
        return list;
    }
}
