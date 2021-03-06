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
import com.sun.media.sound.SoftSynthesizer;

/**
 * Servlet implementation class ShowCart
 */
@WebServlet("/showcart")
public class ShowCart extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		
		String isLogin = (String)session.getAttribute("isLogin");
		
		User user = (User)session.getAttribute("name");
		System.out.println("shoucat1");
		if(user!=null && isLogin.equals("1")) {
			String uid = (String)user.getUSER_ID();
			
			ArrayList<Cart> list = CARTDao.getCart(uid);
			
			request.setAttribute("shoplist", list);
			System.out.println("shoucat2");
			
			request.getRequestDispatcher("cart.jsp").forward(request, response);
			System.out.println("shoucat3");
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('���ﳵ����ʧ��')");
			out.write("location.href='index.jsp'");
			out.write("</script>");
		}
	}

	

}
