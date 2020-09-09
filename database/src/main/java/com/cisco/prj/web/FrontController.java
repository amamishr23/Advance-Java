package com.cisco.prj.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cisco.prj.dao.DaoException;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.dao.ProductDaoJdbcImpl;
import com.cisco.prj.entity.Product;
import com.cisco.prj.entity.User;

 
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // addProduct.do listProduct.do, login.do
		if(uri != null ) {
			if(uri.endsWith("getProducts.do")) {
				ProductDao productDao = new ProductDaoJdbcImpl();
				try {
					List<Product> products = productDao.getProducts();
					request.setAttribute("products", products);
					//server side 
					request.getRequestDispatcher("list.jsp").forward(request, response);
				} catch(DaoException ex) {
					request.setAttribute("msg", ex.getMessage());
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			} else if (uri.endsWith("addProduct.do")) {
				String name = request.getParameter("name");
				double price = Double.parseDouble(request.getParameter("price"));
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				ProductDao productDao = new ProductDaoJdbcImpl();
				Product p = new Product(0, name, price, quantity);
				try {
					productDao.addProduct(p);
					response.sendRedirect("index.html"); // client side redirection
				} catch (DaoException e) {
					 response.getWriter().print("Error :" + e.getMessage());
				}
			} else if (uri.endsWith("login.do")) {
				ServletContext ctx = request.getServletContext();
				List<User> users = (List<User>)ctx.getAttribute("users");
				
				String u = request.getParameter("username");
				String p = request.getParameter("password");
				
				boolean valid = false;
				for(User user : users) {
					if(user.getUsername().equals(u) && user.getPassword().equals(p)) {
						valid = true;
					}
				}
				if(valid) {
					HttpSession ses = request.getSession();
					ses.setAttribute("user", u);
					response.sendRedirect("getProducts.do");
				} else {
					response.sendRedirect("login.html");
				}
			} else if (uri.endsWith("logout.do")) {
				HttpSession ses = request.getSession();
				ses.invalidate();
				response.sendRedirect("login.html");
			}
		}
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
