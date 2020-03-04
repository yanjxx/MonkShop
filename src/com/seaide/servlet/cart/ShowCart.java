package com.seaide.servlet.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seaide.entity.Cart;
import com.seaide.entity.User;
import com.seaide.service.CARTDao;

/**
 * Servlet implementation class ShowCart
 */
@WebServlet("/ShowCart")
public class ShowCart extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String isLogin = (String)session.getAttribute("isLogin");
		
		User user = (User)session.getAttribute("name");
		
		if(user!=null && isLogin.equals("1")) {
			String uid = (String)user.getUSER_ID();
			
			ArrayList<Cart> list = CARTDao.getCart(uid);
			
			request.setAttribute("shoplist", list);
			
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('π∫ŒÔ≥µÃÌº” ß∞‹')");
			out.write("location.href='index.jsp'");
			out.write("</script>");
		}
	}

	

}
