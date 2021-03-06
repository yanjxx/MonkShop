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
 * Servlet implementation class OrderSelect
 */
@WebServlet("/orderselect")
public class OrderSelect extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session =  request.getSession();
		
		String isLogin = (String)session.getAttribute("isLogin");
		
		User user = (User) session.getAttribute("name");
		
		String eids = request.getParameter("eids");
		
	
		
		if(user!=null && isLogin.equals("1")) {
			int totalprice = 0;
			
			String ids[] = eids.split(",");
			
			ArrayList<Cart> list = new ArrayList<Cart>();
			
			for(int i=0; i<ids.length; i++) {
				Cart es = CARTDao.getCartShop(ids[i]);
				
				int dprice = es.getCart_p_price() * es.getCart_quantity();
				
				totalprice += dprice;
				
				list.add(es);
			}
			
			request.setAttribute("shoplist", list);
			request.setAttribute("totalprice", totalprice);
			request.getRequestDispatcher("order.jsp").forward(request, response);
			
		}else{
			
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('��¼���ٹ���');");
			out.write("location.href='login.jsp'");
			out.write("</script>");
			out.close();
		}
	}

	

}
