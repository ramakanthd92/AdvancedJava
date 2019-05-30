package com.adobe.prj.client;

import java.util.function.Consumer;

public class FunctionalExample {

    public static void main(String[] args) {
        String[] names = {"George","Brad","Angelina","Lee","Scarlett"};
        forEach(names, name -> System.out.println(name.length()));
        forEach(names, FunctionalExample::function); // Method Reference
    }

    private static void function(String name){
        System.out.println(name.length());
    }

    private static void forEach(String[] elems, Consumer<String> c) {
        for(String s : elems) {
            c.accept(s);
        }
    }
}
