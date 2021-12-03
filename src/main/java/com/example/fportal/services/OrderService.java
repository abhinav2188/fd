package com.example.fportal.services;

import java.util.List;

import com.example.fportal.modals.Order;

public interface OrderService {
    void addOrder(Order order);
    Order findById(int id);
    List<Order> listOfOrders();

}
