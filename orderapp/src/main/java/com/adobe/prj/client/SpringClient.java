package com.adobe.prj.client;

import com.adobe.prj.AppConfig;
import com.adobe.prj.dao.ProductDaoJpaImpl;
import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringClient {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(OrderService.class);
        ctx.register(ProductDaoJpaImpl.class);
        ctx.register(AppConfig.class);
        ctx.refresh();

        OrderService service = ctx.getBean("orderService", OrderService.class);
        Product p = new Product(0,"HP Laptop Spectre", 135000.00,"computer");
        service.insertProduct(p);

        p = service.fetchProduct(1);
        System.out.println(p);
    }
}
