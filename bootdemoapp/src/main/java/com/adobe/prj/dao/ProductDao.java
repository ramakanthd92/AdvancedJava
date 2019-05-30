package com.adobe.prj.dao;

import com.adobe.prj.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    List<Product> findByCategory(String Category);
    List<Product> findByCategoryAndPrice(String category, double price);

    @Query("select p from Product p where p.price >= :pr")
    List<Product> getByPrice(@PathVariable("pr") double price);
}
