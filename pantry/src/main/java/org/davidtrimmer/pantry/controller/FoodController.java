package org.davidtrimmer.pantry.controller;

import org.davidtrimmer.pantry.entity.Food;
import org.davidtrimmer.pantry.service.FoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
@RequestMapping("/api")
public class FoodController {

    private FoodServiceImpl foodService;
//    private ProductService productService;

    @Autowired
    private WebClient.Builder webClientBuilder;


    @Autowired
    public FoodController(FoodServiceImpl foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/products")
    public Food[] getFoodsPlainJSON(@RequestBody String ingr){

        return foodService.getFoodsPlainJSON(ingr);
    }

//    @GetMapping("/products/{ingr}")
//    public Food getProducts(@PathVariable String ingr){
//
//        return productService.getProducts(ingr);
//    }
    @GetMapping("/foods/{ingr}")
    public Food getFoods(@PathVariable("ingr") String ingr){
        String url = "https://edamam-food-and-grocery-database.p.rapidapi.com/parser?ingr=" + ingr;
//        WebClient client = WebClient.create();
        return webClientBuilder.build()
                .get()
                .uri(url)
                .header("x-rapidapi-host", "edamam-food-and-grocery-database.p.rapidapi.com")
                .header("x-rapidapi-key", "61bb88ebfdmsha63d011273af2ecp1ee1fbjsn0f34bce7ec8a")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Food.class)
                .block();
    }


}
