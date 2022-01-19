package org.davidtrimmer.pantry.controller;

import org.davidtrimmer.pantry.entity.Item;
import org.davidtrimmer.pantry.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private ItemServiceImpl itemService;

    @Autowired
    public ItemController(ItemServiceImpl itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/list-items")
    public List<Item> getAllItems() {
      return  itemService.getItems();
    }
}
