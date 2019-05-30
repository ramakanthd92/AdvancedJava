package com.adobe.prj.client;

import java.util.function.Consumer;

public class FunctionalExample {

	public static void main(String[] args) {
		String[] names = {"George","Brad","Angelina","Lee","Scarlett"};
		forEach(names, name -> System.out.println(name));
		forEach(names, System.out::println); // Method Reference
	}

	private static void forEach(String[] elems, Consumer<String> c) {
		for(String s : elems) {
			c.accept(s);
		}
	}
}
