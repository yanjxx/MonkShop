package com.seaide.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.seaide.dao.Basedao;
import com.seaide.entity.Category;
import com.seaide.entity.Category;

public class CATEGORYDao {
	public static ArrayList<Category> selectAll() {
		// 
		ArrayList<Category> list = new ArrayList<>();
		//声明结果集
		ResultSet rs = null;
		//获取链接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		try {
			String sql = "";

			sql = "select * from LMONKEY_CATEGORY";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			 System.out.println("测算1："+rs);
			while(rs.next()) {
				
				Category cate = new Category(
						rs.getInt("CATE_ID"),
					 	rs.getString("CATE_NAME"),
					 	rs.getInt("CATE_PARENT_ID")
						);
				
				list.add(cate);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
			
		}
		
		return list;
	}

	public static ArrayList<Category> selectCat(String flag) {
		// TODO Auto-generated method stub
		// 
				ArrayList<Category> list = new ArrayList<>();
				//声明结果集
				ResultSet rs = null;
				//获取链接对象
				Connection conn = Basedao.getconn();
				
				PreparedStatement ps = null;
				
				try {
					String sql = "";
					if(flag !=null && flag.equals("father")) {
						
						sql = "select * from LMONKEY_CATEGORY where Cate_PARENT_ID=0";
					}else {
						sql = "select * from LMONKEY_CATEGORY where Cate_PARENT_ID!=0";
					}
					

					
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					 
					while(rs.next()) {
						
						Category cate = new Category(
								rs.getInt("CATE_ID"),
							 	rs.getString("CATE_NAME"),
							 	rs.getInt("CATE_PARENT_ID")
								);
						
						list.add(cate);
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					Basedao.closeall(rs, ps, conn);
					
				}
				
				return list;
	}

	public static int del(int id) {
		// TODO Auto-generated method stub
		int count;
		
		String sql = "delete from LMONKEY_CATEGORY where CATE_ID=?";
		
		Object[] params = {id};
		return Basedao.exectuIUD(sql, params);
	}

	public static Category selectById(int id) {
		// TODO Auto-generated method stub
		Category cate = null;
		
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select *  from LMONKEY_CATEGORY  where CATE_ID=?";
			
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, id);
			
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 cate = new Category(
						 	rs.getInt("CATE_ID"),
						 	rs.getString("CATE_NAME"),
						 	rs.getInt("CATE_PARENT_ID")
			
						 );		 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return cate;
	}
}
