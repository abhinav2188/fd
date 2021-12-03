package com.example.fportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fportal.dao.OrderDao;
import com.example.fportal.modals.Order;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> listOfOrders() {
        return orderDao.listOfOrders();
    }

    @Override
    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }

    @Override
    public Order findById(int id) {
        return orderDao.findById(id);
    }
}
