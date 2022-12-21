package com.example.mysql;


public class Contact {
    int id;
    String name;
    String ph;

    public Contact(int id , String name, String ph){
        this.id = id;
        this.name = name;
        this.ph = ph;
    }
    public int getID(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getPhoneNumber(){
        return this.ph;
    }
}