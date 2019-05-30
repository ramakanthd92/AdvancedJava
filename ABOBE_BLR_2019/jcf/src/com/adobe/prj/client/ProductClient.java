package com.adobe.prj.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.adobe.prj.entity.Product;

public class ProductClient {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(53, "iPhone", 89000.00, "mobile"));
		products.add(new Product(74, "Sony", 129000.00, "tv"));
		products.add(new Product(125, "Logitech Mouse", 622.00, "computer"));
		products.add(new Product(5, "OnePlus ", 56000.00, "mobile"));
		products.add(new Product(73, "LG", 69000.00, "tv"));
		
		Collections.sort(products, (p1,p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
		
		for(Product p : products) {
			System.out.println(p);
		}
		
		System.out.println("************");
		
		products.stream().filter(p -> p.getCategory().equals("mobile")).forEach(System.out::println);
		
		System.out.println("************");
		Stream<String> names = 
				products.stream().filter(p -> p.getCategory().equals("mobile")).map(p->p.getName());
		
		names.forEach(System.out::println);
		
		System.out.println("************");
		
		double total = products.stream().map(p->p.getPrice()).reduce(0.0, (p1,p2) ->p1 + p2);
		System.out.println(total);
		
		System.out.println("************");
		
		List<Product> list = products.stream()
				.filter(p -> p.getCategory().equals("mobile"))
				.collect(Collectors.toList());
		
		for(Product p : list) {
			System.out.println(p);
		}
		
		System.out.println("*********");
		
		DoubleSummaryStatistics stats = products.stream().collect(Collectors.summarizingDouble(p->p.getPrice()));
		System.out.println("MAX : " + stats.getMax());
		System.out.println("MIN : " + stats.getMin());
		System.out.println("AVG " + stats.getAverage());
		System.out.println("Count : " + stats.getCount());
		
		System.out.println("***********");
		
		Map<String, List<Product>> productMap = 
				products.stream().collect(Collectors.groupingBy(p->p.getCategory()));
		
		for(String key : productMap.keySet()) {
			System.out.println(key);
			System.out.println(productMap.get(key));
		}
		
	}

}

