package com.example.fportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fportal.dao.ItemDao;
import com.example.fportal.modals.Item;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> listOfItems() {
        return itemDao.listOfItems();
    }

    @Override
    public void addItem(Item item) {
        itemDao.addItem(item);
    }

    @Override
    public void deleteItem(Item item) {
        itemDao.deleteItem(item);
    }

    @Override
    public Item findItemById(int id) {
        Item item=itemDao.findById(id);
        return item;
    }

    @Override
    public void updateItem(Item item) {
        itemDao.updateItem(item);
    }

    public void updateItemQuantity(List<Item> items)
    {
        itemDao.updateItemQuantity(items);
    }
}
