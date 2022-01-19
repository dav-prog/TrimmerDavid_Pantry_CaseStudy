package org.davidtrimmer.pantry.service;

import org.davidtrimmer.pantry.entity.Food;

public interface FoodService {

    public Food[] getFoodsPlainJSON(String ingr);

    public Food getFoods(String ingr);
}
