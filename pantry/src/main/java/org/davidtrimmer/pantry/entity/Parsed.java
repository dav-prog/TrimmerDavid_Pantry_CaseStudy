package org.davidtrimmer.pantry.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;

@JsonRootName("parsed")
public class Parsed implements Serializable {

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private Food food;

    public Parsed() {
    }

    public Parsed(Food food) {
        this.food = food;
    }

    @JsonProperty("food")
    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
