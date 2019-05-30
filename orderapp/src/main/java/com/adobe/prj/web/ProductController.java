package com.adobe.prj.web;

import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @Autowired
    private OrderService service;

    @RequestMapping("getProducts.do")
    public String getProducts(Model model) {
        model.addAttribute("products", service.getAllProducts());
        return "list.jsp";
    }

    @RequestMapping("productForm.do")
    public String getProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "form.jsp";
    }

    @RequestMapping("addProduct.do")
    public String addProduct(@ModelAttribute("product") Product p) {
        service.insertProduct(p);
        return "redirect:index.html";
    }
}
