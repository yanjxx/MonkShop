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
 * Servlet implementation class DoUserUpadate
 */
@WebServlet("/admin/admin_douserupdate")
public class DoUserUpdate extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�����ַ���
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
				String userStatus = request.getParameter("userStatus");
				
				int status = 1;
				if(userStatus != null) {
					status = Integer.parseInt(userStatus);
				}
				//�����û�ʵ��
				User u = new User(username,name,pwd,sex,year,null,email,mobile,address,1);
				System.out.println("����4"+u);
				//�������ݿ���
				int count = USERDao.update(u);
				System.out.println("����"+count);
				//�ɹ���ʧ���ض���
				if(count > 0 ) {
					response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
				}else {
					PrintWriter out = response.getWriter();
					out.write("<script>");
					out.write("alert('�û��޸�ʧ��')");
					out.write("location.href='admin/admin_touseruodate?id="+username+"'");
					out.write("</script>");
				}
	}

}
