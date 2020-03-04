package com.seaide.servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seaide.service.CATEGORYDao;
import com.seaide.entity.Category;

/**
 * Servlet implementation class IndexSelect
 */
@WebServlet("/indexselect")
public class IndexSelect extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//父分类
		ArrayList<Category> flist =  CATEGORYDao.selectCat("father");
		request.setAttribute("flist", flist);
		//子分类
		ArrayList<Category> clist =  CATEGORYDao.selectCat("child");
		request.setAttribute("clist", clist);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}



}
