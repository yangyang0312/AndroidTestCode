package com.example.admin.testproj;

public class Item {
    private String name;
    private int id;
    Item(int id,String name){
        this.id = id;
        this.name = name;
    }
    String getName(){
        return name;
    }
    int getId(){
        return id;
    }
}
