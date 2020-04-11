package com.seaide.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.seaide.dao.Basedao;
import com.seaide.entity.Cart;

public class CARTDao {
	public static int insert(Cart cart) {
		String sql = "insert into lmonkey_cart values(null,?,?,?,?,?,?,?,1)";
		;
		Object[] params = {
				cart.getCart_p_filename(),
				cart.getCart_p_name(),
				cart.getCart_p_price(),
				cart.getCart_quantity(),
				cart.getCart_p_stock(),
				cart.getCart_p_id(),
				cart.getCart_u_id(),
		};
		return Basedao.exectuIUD(sql, params);
		
	}
	
	public static Cart getCartShop(String id) {
		Cart es =null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from LMONKEY_CART where CART_ID=? and CART_VALID=1 order by CART_ID desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
		
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 es = new Cart(
						 	rs.getInt("cart_id"),
						 	rs.getString("cart_p_filename"),
						 	rs.getString("cart_p_name"),
						 	rs.getInt("cart_p_price"),
						 	rs.getInt("cart_quantity"),
						 	rs.getInt("cart_p_stock"),
						 	rs.getInt("cart_p_id"),
						 	rs.getString("cart_u_id"),
						 	rs.getInt("cart_valid")
						 );
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return es;	
	}
	
	public static Cart getCartShop(String uid, String pid) {
		// TODO Auto-generated method stub
		Cart es = null;
		//声明结果集
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		try {
			String sql = "select * from LMONKEY_CART where CART_U_ID=? and CART_P_ID=? and CART_VALID=1 order by CART_ID desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setInt(2, Integer.parseInt(pid));
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 es = new Cart(
						 	rs.getInt("cart_id"),
						 	rs.getString("cart_p_filename"),
						 	rs.getString("cart_p_name"),
						 	rs.getInt("cart_p_price"),
						 	rs.getInt("cart_quantity"),
						 	rs.getInt("cart_p_stock"),
						 	rs.getInt("cart_p_id"),
						 	rs.getString("cart_u_id"),
						 	rs.getInt("cart_valid")
						 );
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return es;	
	}
	

	
	public static ArrayList<Cart> getCart(String id) {
		// TODO Auto-generated method stub
		ArrayList<Cart> list = new ArrayList<>();
		
		//声明结果集
		ResultSet rs = null;
		
		Connection conn = Basedao.getconn();
				
		PreparedStatement ps = null;
		
		try {
			
			String sql = "select * from LMONKEY_CART where CART_U_ID=? and CART_VALID=1 order by CART_ID desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 Cart c = new Cart(
						 	rs.getInt("cart_id"),
						 	rs.getString("cart_p_filename"),
						 	rs.getString("cart_p_name"),
						 	rs.getInt("cart_p_price"),
						 	rs.getInt("cart_quantity"),
						 	rs.getInt("cart_p_stock"),
						 	rs.getInt("cart_p_id"),
						 	rs.getString("cart_u_id"),
						 	rs.getInt("cart_valid")
						 );

				 list.add(c);
				 
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// TODO: handle finally clause
		}
		return list;
	}

	public static int updatenum(int count, int esid) {
		// TODO Auto-generated method stub
		String sql = "update lmonkey_cart set cart_quantity=? where cart_id=? ";
		
		Object[] params = {count, esid};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	public static int getDeleteDD(int id) {
		String sql="delete from lmonkey_cart where cart_id=?";
		
		Object[] params={id};
		
		return Basedao.exectuIUD(sql, params);
	}
}
