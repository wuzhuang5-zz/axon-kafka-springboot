package com.pivotal.catalog.commands;

public class AddProductToCatalogCommand {
    private String id;
    private String name;

    public AddProductToCatalogCommand(String id,String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){return id;}

    public String getName(){return name;}

    @Override
    public String toString() {
        return "AddProductToCatalogCommand{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
