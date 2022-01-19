package org.davidtrimmer.pantry.service;

import org.davidtrimmer.pantry.dao.ItemRepository;
import org.davidtrimmer.pantry.entity.Item;
import org.davidtrimmer.pantry.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{


    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(int theId) {
        Optional<Item> result = itemRepository.findById(theId);

        Item theItem = null;

        if (result.isPresent()) {
            theItem = result.get();
        }
        else {
            // we didn't find the item
            throw new RuntimeException("Did not find item id = " + theId);
        }
        return theItem;
    }

    @Override
    public void saveItem(Item theItem) {
        itemRepository.save(theItem);
    }

    @Override
    public void deleteItem(int theId) {
        itemRepository.deleteById(theId);
    }
}
