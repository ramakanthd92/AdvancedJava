package com.adobe.prj.dao;

import com.adobe.prj.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductDaoJpaImpl implements ProductDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addProduct(Product p) {
        em.persist(p);
    }

    @Override
    public Product getProduct(int id) {
        return em.find(Product.class,id);
    }

    @Override
    public List<Product> getProducts() {
        TypedQuery<Product> query = em.createQuery("from Product", Product.class);
        return query.getResultList();
    }
}

