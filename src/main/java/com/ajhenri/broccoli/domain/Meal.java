package com.ajhenri.broccoli.domain;

public class Meal {
    private int id;
    private String name;
    private int prepTime;
    private int cookTime;
    private int eatTime;

    public Meal(){}

    public Meal(int id, String name, int prepTime, int cookTime, int eatTime){
        super();
        this.id = id;
        this.name = name;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.eatTime = eatTime;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getPrepTime(){
        return this.prepTime;
    }

    public void setPrepTime(int prepTime){
        this.prepTime = prepTime;
    }

    public int getCookTime(){
        return this.cookTime;
    }

    public void setCookTime(int cookTime){
        this.cookTime = cookTime;
    }

    public int getEatTime(){
        return this.eatTime;
    }

    public void setEatTime(int eatTime){
        this.eatTime = eatTime;
    }
}
