package com.adobe.prj.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		 List<Integer> iList = Arrays.asList(25,77,2,67,66);
		 List<Integer> icList = new ArrayList<>();
		 List<String> sList = Arrays.asList("a","y","sample");
		 List<String> scList = new ArrayList<>();
		 print(iList);
		 print(sList);
		 
		 copy(icList, iList);
		 copy(scList, sList);
		 
		 System.out.println(scList);
		 System.out.println(icList);
	}
	
	private static <T> void copy(List<T> scList, List<T> sList) {
		for(T o : sList) {
			scList.add(o);
		}
	}

	private static void print(List<?> list) {
		for(Object o : list) {
			System.out.println(o);
		}
	}

}
