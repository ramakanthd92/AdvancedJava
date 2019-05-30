package com.adobe.prj.dao;

import com.adobe.prj.entity.Mobile;

public class MobileMongoDBImpl implements MobileDao{

    @Override
    public void addMobile(Mobile m) {
        System.out.println("added to NoSQL !! ");
    }
}
