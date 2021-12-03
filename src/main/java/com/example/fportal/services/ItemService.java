package com.example.fportal.services;

import java.util.List;

import com.example.fportal.modals.Item;

public interface ItemService {
    List<Item> listOfItems();
    void addItem(Item item);
    void deleteItem(Item item);
    Item findItemById(int id);
    void updateItem(Item item);
    void updateItemQuantity(List<Item> items);
}
