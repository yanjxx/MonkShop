package com.seaide.servlet.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seaide.entity.Cart;
import com.seaide.entity.Product;
import com.seaide.entity.User;
import com.seaide.service.CARTDao;
import com.seaide.service.PRODUCTDao;

/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/cartadd")
public class CartAdd extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product p = null;
		//��ȡ��ƷID
		String pid = request.getParameter("id");
		//��ȡ��Ʒ����
		String count = request.getParameter("count");
		//��ȡ��Ʒ�۸�
		String url = request.getParameter("url");
		System.out.println("δ�ɹ�");
		//�ж��Ƿ��¼
		HttpSession session = request.getSession();
		String isLogin = (String)session.getAttribute("isLogin");
		
		User user = (User)session.getAttribute("name");
		
		if(user!=null && isLogin.equals("1")) {
			
			String uid = (String)user.getUSER_ID();
			//Cart srcsp = CARTDao.getCartShop(uid,pid);
			
			if(pid !=null) {
				p = PRODUCTDao.selectById(Integer.parseInt(pid));
			}
			System.out.println("δ�ɹ�1");
			Cart cart = new Cart(
					0,
					p.getPRODUCT_FILENAME(),
					p.getPRODUCT_NAME(),
					p.getPRODUCT_PRICE(),
					Integer.parseInt(count),
					p.getPRODUCT_STOCK(),
					p.getPRODUCT_ID(),
					uid,
					1
					);
			
		CARTDao.insert(cart);
		System.out.println("�ɹ�");
		
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('���ﳵ���ʧ��')");
			out.write("location.href='index.jsp'");
			out.write("</script>");
		}
		
		if(url.equals("z")) {
			response.sendRedirect("showcart");
		}else {
			response.sendRedirect("selectproductview?id="+pid);
		}
	}

	

}
