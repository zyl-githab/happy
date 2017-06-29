package com.test.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 
 * @author Administrator jdbc练习
 */
public class JDBCTest {

	private static Connection con;
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql = "select * from t_user";
	private static String url="jdbc:mysql://localhost:3306/crm?useUnicode=true&characterEncoding=utf-8";
	public static void getCollection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/crm?useUnicode=true&characterEncoding=utf-8";
			con = DriverManager.getConnection(url, "root", "123456");
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getInt("id")+"----"+rs.getString("username"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(st!=null){
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void getCollection(String sql){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "123456");
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("id")+"----"+rs.getString("username"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(st!=null){
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		getCollection();
		getCollection(sql);
		
	}
}
