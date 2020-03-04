package com.seaide.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Basedao {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getconn() {
		Connection conn = null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/monkeyshop?useSSL=false&serverTimezone=CST","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
		
	}
	/**
	 * 数据库增加操作
	 * @param sql
	 * @param params
	 * @return
	 */
	
	public static int exectuIUD(String sql,Object[] params) {
		int count = 0;
		Connection conn = Basedao.getconn();
		
		//准备sql
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			System.out.println("测算7:"+ps);
			for(int i=0;i<params.length;i++) {
			ps.setObject(i+1,params[i]);
			}
			count = ps.executeUpdate();
			System.out.println("测算9"+count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(null,ps,conn);
		}
		return count;
		
	}
	public static void closeall(ResultSet rs,PreparedStatement ps,Connection conn) {
	
		try {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
				
			e.printStackTrace();
		}
		
	}
}
