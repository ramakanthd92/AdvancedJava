package com.adobe.prj.dao;

import com.adobe.prj.entity.Order;

import java.util.List;

public interface OrderDao {
    void placeOrder(Order order);
    List<Order> getOrders();
}
