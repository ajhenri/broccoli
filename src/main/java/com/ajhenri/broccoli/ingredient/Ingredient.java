package com.ajhenri.broccoli.ingredient;

import lombok.Getter;
import lombok.Setter;

public class Ingredient {
    @Getter @Setter
    private int id;
    @Getter @Setter
    private String name;

    public Ingredient(){}

    public Ingredient(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }

}
