package com.seaide.servlet.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seaide.entity.Product;
import com.seaide.service.PRODUCTDao;



/**
 * Servlet implementation class ProductSelect
 */
@WebServlet("/admin/admin_productselect")
public class ProductSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Product> plist = PRODUCTDao.selectAll();
		request.setAttribute("plist", plist);
		System.out.println(plist);
		request.getRequestDispatcher("admin_product.jsp").forward(request, response);
	}



}
