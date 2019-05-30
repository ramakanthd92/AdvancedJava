package com.adobe.prj.client;

import java.util.ResourceBundle;

import com.adobe.prj.dao.MobileDao;

public class MobileDaoFactory {
	private static String CLASS_NAME = "";
	
	static {
		ResourceBundle res = ResourceBundle.getBundle("config");
		CLASS_NAME = res.getString("MOBILE_CLASS").trim();
	}
	
	public static MobileDao getMobileDao() {
		try {
			return (MobileDao) Class.forName(CLASS_NAME).newInstance();
		} catch(Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

}
