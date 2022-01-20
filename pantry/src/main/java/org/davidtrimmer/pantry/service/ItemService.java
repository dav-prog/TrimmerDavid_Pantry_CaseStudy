package org.davidtrimmer.pantry.service;

import org.davidtrimmer.pantry.entity.Item;

import java.util.List;

public interface ItemService {

    List<Item> getItems();

    Item getItemById(int theId);

    void saveItem(Item theItem);

    void deleteItem(int theId);

    Item findItemByName(String name);

    void deleteItemByName(String name);
}
