package com.seaide.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.seaide.dao.Basedao;
import com.seaide.entity.Product;

public class PRODUCTDao {

	public static ArrayList<Product> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Product> list = new ArrayList<Product>();
		ResultSet rs = null;
		
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		try {
			String sql = "select * from LMONKEY_PRODUCT";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("测算1："+rs.next());
			while(rs.next()) {
				Product p = new Product(
						rs.getInt("PRODUCT_ID"),
					 	rs.getString("PRODUCT_NAME"),
					 	rs.getString("PRODUCT_DESCRIPTION"),
					 	rs.getInt("PRODUCT_PRICE"),
					 	rs.getInt("PRODUCT_STOCK"),
					 	rs.getInt("PRODUCT_FID"),
					 	rs.getInt("PRODUCT_CID"),
					 	rs.getString("PRODUCT_FILENAME")
					 );
				list.add(p);
				System.out.println("测算3："+p);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		System.out.println("测算2："+list);
		return list;
	}

	public static ArrayList<Product> selectAllByFid(int fid) {
		// TODO Auto-generated method stub
		ArrayList<Product> list = new ArrayList<Product>();
		ResultSet rs = null;
		
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		try {
			String sql = "select * from LMONKEY_PRODUCT where PRODUCT_FID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fid);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Product p = new Product(
						rs.getInt("PRODUCT_ID"),
					 	rs.getString("PRODUCT_NAME"),
					 	rs.getString("PRODUCT_DESCRIPTION"),
					 	rs.getInt("PRODUCT_PRICE"),
					 	rs.getInt("PRODUCT_STOCK"),
					 	rs.getInt("PRODUCT_FID"),
					 	rs.getInt("PRODUCT_CID"),
					 	rs.getString("PRODUCT_FILENAME")
					 );
				list.add(p);
				System.out.println("测算3："+p);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}

	public static ArrayList<Product> selectAllByCid(int cid) {
		// TODO Auto-generated method stub
		ArrayList<Product> list = new ArrayList<Product>();
		ResultSet rs = null;
		
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		try {
			String sql = "select * from LMONKEY_PRODUCT where PRODUCT_CID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Product p = new Product(
						rs.getInt("PRODUCT_ID"),
					 	rs.getString("PRODUCT_NAME"),
					 	rs.getString("PRODUCT_DESCRIPTION"),
					 	rs.getInt("PRODUCT_PRICE"),
					 	rs.getInt("PRODUCT_STOCK"),
					 	rs.getInt("PRODUCT_FID"),
					 	rs.getInt("PRODUCT_CID"),
					 	rs.getString("PRODUCT_FILENAME")
					 );
				list.add(p);
				System.out.println("测算3："+p);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}

	public static ArrayList<Product> selectAllByid(ArrayList<Integer> ids) {
		// TODO Auto-generated method stub
		ArrayList<Product> lastlylist = new ArrayList<>();
		
		Product p = null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
		    for(int i=0; i<ids.size(); i++) {
			
				String sql = "select * from LMONKEY_PRODUCT where PRODUCT_ID=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, ids.get(i));
				rs = ps.executeQuery();
				 
				 while(rs.next()) {
					 p = new Product(
							 	rs.getInt("PRODUCT_ID"),
							 	rs.getString("PRODUCT_NAME"),
							 	rs.getString("PRODUCT_DESCRIPTION"),
							 	rs.getInt("PRODUCT_PRICE"),
							 	rs.getInt("PRODUCT_STOCK"),
							 	rs.getInt("PRODUCT_FID"),
							 	rs.getInt("PRODUCT_CID"),
							 	rs.getString("PRODUCT_FILENAME")
							 );
					 
					 
					 lastlylist.add(p);
					 
				 }
		    }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return lastlylist;
	
	}

	public static ArrayList<Product> selectAllById(ArrayList<Integer> ids) {
		// TODO Auto-generated method stub
		ArrayList<Product> lastlylist = new ArrayList<>();
		
		Product p = null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		try {
		    for(int i=0; i<ids.size(); i++) {
			
				String sql = "select * from LMONKEY_PRODUCT where PRODUCT_ID=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, ids.get(i));
				rs = ps.executeQuery();
				 
				 while(rs.next()) {
					 p = new Product(
							 	rs.getInt("PRODUCT_ID"),
							 	rs.getString("PRODUCT_NAME"),
							 	rs.getString("PRODUCT_DESCRIPTION"),
							 	rs.getInt("PRODUCT_PRICE"),
							 	rs.getInt("PRODUCT_STOCK"),
							 	rs.getInt("PRODUCT_FID"),
							 	rs.getInt("PRODUCT_CID"),
							 	rs.getString("PRODUCT_FILENAME")
							 );
					 
					 
					 lastlylist.add(p);
					 
				 }
		    }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return lastlylist;
	}

	public static Product selectById(int id) {
		// TODO Auto-generated method stub
		Product p = null;
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			String sql = "select * from LMONKEY_PRODUCT where PRODUCT_ID=?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				p = new Product(
						rs.getInt("PRODUCT_ID"),
					 	rs.getString("PRODUCT_NAME"),
					 	rs.getString("PRODUCT_DESCRIPTION"),
					 	rs.getInt("PRODUCT_PRICE"),
					 	rs.getInt("PRODUCT_STOCK"),
					 	rs.getInt("PRODUCT_FID"),
					 	rs.getInt("PRODUCT_CID"),
					 	rs.getString("PRODUCT_FILENAME")
					 );
			}
						
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return p;
	}

}
