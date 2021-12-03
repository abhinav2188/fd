package com.example.fportal.dao;

import java.util.List;

import com.example.fportal.modals.Item;

public interface ItemDao {
    List<Item> listOfItems();
    void addItem(Item item);
    void deleteItem(Item item);
    Item findById(int id);
    void updateItem(Item item);
    void updateItemQuantity(List<Item> items);
}
