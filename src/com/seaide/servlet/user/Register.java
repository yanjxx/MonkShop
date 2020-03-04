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
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//�����ַ���
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				//��ȡ�ֶ�		
				String username = request.getParameter("userName");
				
				String name = request.getParameter("name");
				String pwd = request.getParameter("passWord");
				String sex = request.getParameter("sex");
				String year = request.getParameter("year");
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");
				String address = request.getParameter("address");
				//�����û�ʵ��
				User u = new User(username,name,pwd,sex,year,null,email,mobile,address,1);
				//�������ݿ���
				int count = USERDao.insert(u);
				//�ɹ���ʧ���ض���
				if(count > 0 ) {
					response.sendRedirect("login.jsp");
				}else {
					PrintWriter out = response.getWriter();
					out.write("<script>");
					out.write("alert('�û�ע��ʧ��')");
					out.write("location.href='reg.jsp'");
					out.write("</script>");
				}
	}

	

}
