package com.seaide.service;

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

	public static Cart getCartShop(String uid, String pid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static ArrayList<Cart> getCart(String uid) {
		// TODO Auto-generated method stub
		return null;
	}
}
