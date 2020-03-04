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

/**
 * Servlet implementation class DoUserDel
 */
@WebServlet("/admin/admin_douserdel")
public class DoUserDel extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		
		//加入数据库中
		int count = USERDao.del(id);
		//成功或失败重定向
		if(count > 0 ) {
			response.sendRedirect("admin_douserselect？cp="+request.getParameter("cpage"));
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('用户删除失败')");
			out.write("location.href='admin/admin_douserselect？cp="+request.getParameter("cpage")+"'");
			out.write("</script>");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String ids[] = request.getParameterValues("id[]");
		//加入数据库中
		for(int i=0; i<ids.length;i++) {
		USERDao.del(ids[i]);
		}
		//成功或失败重定向
		
			response.sendRedirect("admin_douserselect");
		
	}

}
