package com.adobe.prj.client;

import java.util.Arrays;

public class ArrayExample {

	public static void main(String[] args) {
		String[] names = { "George", "Brad", "Angelina", "Lee", "Scarlett" };

		Arrays.sort(names);
		for (String name : names) {
			System.out.println(name);
		}

		Arrays.sort(names, (s1, s2) -> s1.length() - s2.length());
		for (String name : names) {
			System.out.println(name);
		}

	}

}
