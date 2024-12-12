package com.zula.Abstract;

public abstract class Config {

    public String name;

    public Config(String name){
        this.name = name;
        System.out.println("Config Constructor Called");
    }

    public Config(String name1,String name2){
        System.out.println("Config Constructor Called");
    }

    public abstract void initialize();
    
}
