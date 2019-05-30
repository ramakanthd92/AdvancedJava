package com.adobe.prj.rest;

import com.adobe.prj.entity.Order;
import com.adobe.prj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderRestController {

    @Autowired
    private OrderService service;

    @RequestMapping(value = "orders", method = RequestMethod.GET)
    public @ResponseBody List<Order> getOrders() {
        return service.getOrders();
    }

    @RequestMapping(value = "orders", method = RequestMethod.POST)
    public ResponseEntity<Order> placeOrder(@RequestBody Order o) {
        service.placeOrder(o);
        return new ResponseEntity<>(o, HttpStatus.CREATED);   // 201
    }
}
