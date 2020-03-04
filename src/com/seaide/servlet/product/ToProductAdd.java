package com.seaide.servlet.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seaide.entity.Category;
import com.seaide.service.CATEGORYDao;

/**
 * Servlet implementation class ToProductAaa
 */
@WebServlet("/admin/admin_toproductadd")
public class ToProductAdd extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//父分类
		ArrayList<Category> flist =  CATEGORYDao.selectCat("father");
		request.setAttribute("flist", flist);
		//子分类
		ArrayList<Category> clist =  CATEGORYDao.selectCat("child");
		request.setAttribute("clist", clist);
	}

	

}
