package com.incvo;

public class Console {

    public static void main(String[] args) {

        for(String iteration:args){
            System.out.println(iteration);

        }
    
    }

    public static void main(Integer[] input) {
        System.out.println("Hello");
        for(Integer items:input){
            System.out.println(items);
        }
    }



}
