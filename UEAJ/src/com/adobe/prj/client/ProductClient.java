package com.adobe.prj.client;

import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Tv;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductClient {

        public static void main(String[] args) {
            List<Product> products = new ArrayList<>();
            products.add(new Product(53, "iPhone", 89000.00, "mobile"));
            products.add(new Product(74, "Sony", 129000.00, "tv"));
            products.add(new Product(125, "Logitech Mouse", 622.00, "computer"));
            products.add(new Product(5, "OnePlus ", 56000.00, "mobile"));
            products.add(new Product(73, "LG", 69000.00, "tv"));

            Collections.sort(products, (p1,p2) -> (int)(p1.getPrice() - p2.getPrice()));

            for(Product p : products) {
                System.out.println(p);
            }


            System.out.println("******************");

            products.stream().filter(p -> p.getType().equals("tv")).forEach(System.out::println);

            System.out.println("******************");

            Stream <String> names =  products.stream().filter(p -> p.getType().equals("mobile")).map(p-> p.getName());

            names.forEach(System.out::println);

            Double total =  products.stream().map(p -> p.getPrice()).reduce(0.0, (p1,p2) -> p1 + p2);
            System.out.println(total);

            DoubleSummaryStatistics stats = products.stream().collect(Collectors.summarizingDouble(p->p.getPrice()));
            System.out.println("MAX : " + stats.getMax());
            System.out.println("MIN : " + stats.getMin());
            System.out.println("AVG " + stats.getAverage());
            System.out.println("Count : " + stats.getCount());

        }

    private static void displayProductsOCP(Product[] products) {
        for (Product p:products){
            Class<?> clazz=p.getClass(); //accessing any class
            Method[] methods=clazz.getMethods();
            for (Method m:methods){
                if (m.getName().startsWith( "get" )){
                    try{
                        Object ret=m.invoke( p );
                        System.out.println( ret );
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    private static void displayExpensive(Product[] products) {
        for (Product p: products) {
            if (p.isExpensive()) {
                System.out.println(p.getName() + " is Expensive !!");
            }
        }
    }

    private static void displayProducts(Product[] products) {
        for (Product p: products) {
            if (p instanceof Tv) {
                System.out.println(((Tv) p).getScreenType());
            }

            if (p.getClass() == Mobile.class) {
                System.out.println(((Mobile) p).getConnectivity());
            }
        }
    }
}
