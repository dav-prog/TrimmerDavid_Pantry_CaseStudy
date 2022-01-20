package org.davidtrimmer.pantry.controller;

import org.davidtrimmer.pantry.entity.Item;
import org.davidtrimmer.pantry.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ItemController {

    private ItemServiceImpl itemService;

    @Autowired
    public ItemController(ItemServiceImpl itemService) {
        this.itemService = itemService;
    }
    @GetMapping("/")
    public String landingPage(Model theModel) {
        List<Item> theItems = itemService.getItems();

        List<Item> items = theItems.stream()
                .limit(8)
                .collect(Collectors.toList());



        theModel.addAttribute("items", items);

        return "index";
    }

    @GetMapping("/list-items")
    public String getAllItems(Model theModel) {
        // get items from the db
      List<Item> theItems = itemService.getItems();

      // add to the spring model
        theModel.addAttribute("items", theItems);


        return "index";
    }

    @GetMapping("/item-name/{name}")
    public Item retrieveItemByName(@PathVariable String name){
        return itemService.findItemByName(name);
    }

}
