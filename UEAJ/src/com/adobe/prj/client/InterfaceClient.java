package com.adobe.prj.client;

import com.adobe.prj.dao.MobileDao;
import com.adobe.prj.entity.Book;
import com.adobe.prj.entity.Mobile;
import com.adobe.prj.util.Utility;

public class InterfaceClient {

    public static void main(String[] args) {
        Mobile m = new Mobile();
        MobileDao mobileDao = MobileDaoFactory.getMobileDao();
        mobileDao.addMobile(m);

        String[] names = {"Angelina", "Brad", "Namo", "YSR", "Chandra"};
        Utility.sort(names);

//        for(String n: names) {
//            System.out.println(n);
//        }

        String SQL = Utility.getCreateStatement(Book.class);
        System.out.println(SQL);
    }
}
