package com.adobe.prj.client;

import java.lang.reflect.Method;

import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Tv;

public class ProductClient {

	public static void main(String[] args) {
		Product[] products = new Product[4];
		products[0] = new Tv(1, "Sony Bravia", 120000.00, "4HD");
		products[1] = new Mobile(2, "iPhone X", 130000.00, "4HD");
		products[2] = new Mobile(3, "One Plust 6t", 56000.00, "4G");
		products[3] = new Tv(4, "LG", 920000.00, "4HD");
		displayProducts(products);
		displayExpensive(products);
		System.out.println("***********");
		displayProductsOCP(products);
	}

	private static void displayProductsOCP(Product[] products) {
		for (Product p : products) {
			Class<?> clazz = p.getClass();
			Method[] methods = clazz.getMethods();
			for(Method m : methods) {
				if(m.getName().startsWith("get")) {
					try {
							Object ret = m.invoke(p);
							System.out.println(ret);
					} catch(Exception ex) {
						System.out.println(ex);
					}
				}
			}
		}
	}

	// OCP
	private static void displayExpensive(Product[] products) {
		for (Product p : products) {
			if(p.isExpensive()) { // dynamic bindig Runtime Polymoorphism
				System.out.println(p.getName() + " is expensive !!");
			}
		}
	}


	private static void displayProducts(Product[] products) {
		for (Product p : products) {
			System.out.println(p.getName() + ", " + p.getPrice());
			if (p instanceof Tv) {
				Tv t = (Tv) p;
				System.out.println(t.getScreenType());
			}
			if(p.getClass() == Mobile.class) {
				Mobile m = (Mobile) p;
				System.out.println(m.getConnectivity());
			}
		}
	}

}
