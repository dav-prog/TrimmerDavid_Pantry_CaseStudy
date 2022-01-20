package org.davidtrimmer.pantry.controller;

import org.davidtrimmer.pantry.dao.ItemRepository;
import org.davidtrimmer.pantry.entity.Item;
import org.davidtrimmer.pantry.entity.User;
import org.davidtrimmer.pantry.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemRestController {

    private ItemServiceImpl itemService;


    @Autowired
    public ItemRestController(ItemServiceImpl itemService) {
        this.itemService = itemService;
    }

    @GetMapping("items")
    public List<Item> retrieveAllItems() {
        return itemService.getItems();
    }

    @PostMapping("item")
    public Item addItem(@RequestBody Item theItem) {

        itemService.saveItem(theItem);
        return theItem;

    }

    @GetMapping("/items/{name}")
    public Item retrieveItemByName(@PathVariable String name) {
        return itemService.findItemByName(name);
    }

    @DeleteMapping("items/{name}")
    public String deleteItemByName(@PathVariable String name) {
        itemService.deleteItemByName(name);
        return "Removed item : " + name;
    }

    @DeleteMapping("items/id/{id}")
    public String deleteItemById(@PathVariable int id) {
        itemService.deleteItem(id);
        return "Removed item with id: " + id;
    }

}

