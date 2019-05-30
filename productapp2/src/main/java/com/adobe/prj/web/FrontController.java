package com.adobe.prj.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adobe.prj.dao.FetchException;
import com.adobe.prj.dao.PersistanceException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();   //"...../getProducts.do"
		ProductDao productDao = new ProductDaoJdbcImpl();
		
		if(uri.endsWith("getProducts.do")) {
			try {
				List<Product> list =  productDao.getProducts();
				request.setAttribute("products",list);
				request.getRequestDispatcher("list1.jsp").forward(request, response);
			} catch (FetchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect("index.html");
			}
		}
		
		else if(uri.endsWith("addProduct.do")) {
			String name = request.getParameter("name");
			double price = Double.parseDouble(request.getParameter("price"));
			String category = request.getParameter("category");
			
			Product p = new Product(0, name, price, category);
			
			try {
				productDao.addProduct(p);
			} catch (PersistanceException e) {
				e.printStackTrace();
			}
			
			response.sendRedirect("getProducts.do");
		}
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
