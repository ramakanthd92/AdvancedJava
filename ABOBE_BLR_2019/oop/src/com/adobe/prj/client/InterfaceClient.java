package com.adobe.prj.client;

import com.adobe.prj.dao.MobileDao;
import com.adobe.prj.entity.Book;
import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Tv;
import com.adobe.prj.util.Utility;

public class InterfaceClient {

	public static void main(String[] args) {
		Mobile m = new Mobile();
//		MobileDao mobileDao = new MobileDaoMongoImpl();
		MobileDao mobileDao = MobileDaoFactory.getMobileDao();
		mobileDao.addMobile(m);
		
		String[] names = {"George","Brad","Angelina","Lee","Scarlett"};
		
		Utility.sort(names);
		
		for(String s : names) {
			System.out.println(s);
		}
		
		Product[] products = new Product[4];
		products[0] = new Tv(1, "Sony Bravia", 120000.00, "4HD");
		products[1] = new Mobile(2, "iPhone X", 130000.00, "4HD");
		products[2] = new Mobile(3, "One Plust 6t", 56000.00, "4G");
		products[3] = new Tv(4, "LG", 920000.00, "4HD");
		
		Utility.sort(products);
		
		for(Product p : products) {
			System.out.println(p);
		}
		
		String SQL = Utility.getCreateStatement(Book.class);
		System.out.println(SQL);
	}

}
