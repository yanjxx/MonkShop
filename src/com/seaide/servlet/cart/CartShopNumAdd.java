package com.seaide.servlet.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seaide.service.CARTDao;

public class CartShopNumAdd extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String count = request.getParameter("count");
		String esid = request.getParameter("esid");
		
		CARTDao.updatenum(Integer.parseInt(esid),Integer.parseInt(count));
		
	}
}
