package com.seaide.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seaide.entity.User;
import com.seaide.service.USERDao;


@WebServlet("/admin/admin_douseradd")
public class DoUserAdd extends HttpServlet{
	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("userName");
		String name = request.getParameter("name");
		String pwd = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		String year = request.getParameter("year");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		//创建用户实体
		User u = new User(username,name,pwd,sex,year,null,email,mobile,address,1);
		//加入数据库中
		int count = USERDao.insert(u);
		//成功或失败重定向
		if(count > 0 ) {
			response.sendRedirect("admin_user.jsp");
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('用户添加失败')");
			out.write("location.href='admin/admin_useradd.jsp'");
			out.write("</script>");
		}
		
	}
}
