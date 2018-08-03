package com.pivotal.catalog.events;

public class ProductAddEvent {

    private String id;
    private String name;

    public ProductAddEvent(){}

    public ProductAddEvent(String id,String name){
        this.id = id;
        this.name = name;
    }

    public String getName(){return name;}

    public String getId(){return id;}
}
