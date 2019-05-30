package com.adobe.prj.dao;

import com.adobe.prj.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrderDaoJpaImpl implements OrderDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void placeOrder(Order order) {
        em.persist(order);
    }

    @Override
    public List<Order> getOrders() {
        TypedQuery<Order> query = em.createQuery("from Order", Order.class);
        return query.getResultList();
    }
}
