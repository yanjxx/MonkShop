package com.seaide.servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seaide.entity.Category;
import com.seaide.entity.Product;
import com.seaide.service.CATEGORYDao;
import com.seaide.service.PRODUCTDao;

/**
 * Servlet implementation class SelectProductView
 */
@WebServlet("/selectproductview")
public class SelectProductView extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Category> flist =  CATEGORYDao.selectCat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<Category> clist =  CATEGORYDao.selectCat("child");
		request.setAttribute("clist", clist);
		
		String id = request.getParameter("id");
	
		//��ȡ�������
		
		HttpSession session = request.getSession();
		
		//��SSESSIOn��ȡһ�� ids
		
		ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");
		//��һ�η���
		if(ids == null){
			ids = new ArrayList<Integer>();
		}
			
		//����5�� ������5������һ��ɾ��
		if(ids.size() >= 5) {
			ids.remove(0);
		}
		
		// ����б�� ��ֻҪһ��
		if(id!=null && (!ids.contains(Integer.parseInt(id)))) {
			ids.add(Integer.parseInt(id));
		
		}
		
		session.setAttribute("ids", ids);
		
		ids= (ArrayList<Integer>)session.getAttribute("ids");
		
		if(ids!=null) {
				
			ArrayList<Product> lastlylist = PRODUCTDao.selectAllById(ids);
			request.setAttribute("lastlylist", lastlylist);
		}
		
		//��ȡ��Ʒ
		Product p = null;
		
		if(id !=null) {
			p = PRODUCTDao.selectById(Integer.parseInt(id));
			request.setAttribute("p", p);
		}
		
		//��Ʒ�Ƽ��б�
		if(p!=null) {
			int cid = p.getPRODUCT_CID();
			ArrayList<Product> classlist = PRODUCTDao.selectAllByCid(cid);
			request.setAttribute("classlist", classlist);
			
			Category cate = CATEGORYDao.selectById(cid);
			
			request.setAttribute("cate", cate);
		}
		
		
		request.getRequestDispatcher("productview.jsp").forward(request, response);
	}


}
