package com.adobe.prj.service;

import com.adobe.prj.dao.OrderDao;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.entity.Item;
import com.adobe.prj.entity.Order;
import com.adobe.prj.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderDao orderDao;

    @Transactional
    public void placeOrder (Order order) {
        orderDao.placeOrder(order);
        List<Item> items= order.getItems();
        double total = 0;
        for (Item i: items) {
            Product p = productDao.getProduct(i.getProduct().getId());
            p.setCount(p.getCount() - i.getQty());
            total += i.getAmount();
        }
        order.setTotal(total);
    }

    public List<Order> getOrders() {
        return orderDao.getOrders();
    }

    @Transactional
    public void insertProduct(Product p) {
        productDao.addProduct(p);
    }

    public Product fetchProduct(int id) {
        return productDao.getProduct(id);
    }

    public List<Product> getAllProducts() {
        return productDao.getProducts();
    }
}
