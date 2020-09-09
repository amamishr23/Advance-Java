package com.cisco.prj.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cisco.prj.dao.DaoException;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.dao.ProductDaoJdbcImpl;
import com.cisco.prj.entity.Product;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html"); // MIME
		PrintWriter out = response.getWriter(); // opens a character stream to browser
		// ServletOutputStream out = response.getOutputStream(); // byte stream to
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>Product List</h1>");
		ProductDao productDao = new ProductDaoJdbcImpl();
		try {
			List<Product> products = productDao.getProducts();
			out.print("<table border=\"1\">");
			out.print("<th>ID</th><th>Name</th>Price</th>");
			for (Product p : products) {
				out.print("<tr>");
				out.print("<td>" + p.getId() + " </td>");
				out.print("<td>" + p.getName() + " </td>");
				out.print("<td>" + p.getPrice() + " </td>");
				out.print("</tr>");
			}
			out.print("</table>");
		} catch (DaoException e) {
			e.printStackTrace(); // for Java developers
			out.println(e.getMessage()); // for Production stage
		}
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		ProductDao productDao = new ProductDaoJdbcImpl();
		
		Product p = new Product(0, name, price, quantity);
		
		try {
			productDao.addProduct(p);
			response.sendRedirect("index.html");
		} catch (DaoException e) {
			 response.getWriter().print("Error :" + e.getMessage());
		}
		
	}

}
