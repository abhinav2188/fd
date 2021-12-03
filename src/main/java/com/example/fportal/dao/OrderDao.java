package com.example.fportal.dao;

import java.util.List;

import com.example.fportal.modals.Order;

public interface OrderDao {
    List<Order> listOfOrders();

    void addOrder(Order order);

    Order findById(int id);
}
