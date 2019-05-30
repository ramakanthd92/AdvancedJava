package com.adobe.prj.rest;

import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {
    @Autowired
    private OrderService service;

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public @ResponseBody List<Product> getProducts() {
        return service.getAllProducts();
    }

    @RequestMapping(value = "products/{id}", method = RequestMethod.GET)
    public @ResponseBody Product getProduct(@PathVariable("id") int id) {
        return service.fetchProduct(id);
    }

    @RequestMapping(value = "products", method = RequestMethod.POST)
    public ResponseEntity<Product> addProduct(@RequestBody Product p) {
        service.insertProduct(p);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }
}