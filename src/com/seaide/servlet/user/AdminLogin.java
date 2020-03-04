package com.seaide.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seaide.entity.User;
import com.seaide.service.USERDao;



/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/admin/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		int count = USERDao.selectByNM(userName, passWord);
		
		//System.out.println(userName + "##"+passWord);
		
		if(count > 0) {
			
			User user = USERDao.selectAdmin(userName, passWord);
			HttpSession session = request.getSession();
			session.setAttribute("name", user);
			session.setAttribute("isLogin", "1");
			if(user.getUSER_STATUS() == 2) {
				session.setAttribute("isAdminLogin", "1");
				System.out.println(userName + "##"+passWord);
				response.sendRedirect("/MonkShop/admin/admin_index.jsp");
			}else{
				
				response.sendRedirect("/MonkShop/index.jsp");
			}
	
		
			
		}else{
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('鐢ㄦ埛鐧诲綍澶辫触锛�');");
			out.write("location.href='login.jsp'");
			out.write("</script>");
			out.close();
		}
	}

}
