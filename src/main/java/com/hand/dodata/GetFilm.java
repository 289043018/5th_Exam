package com.hand.dodata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class GetFilm {

	public static void main(String[] args) {
//		//当前的数据库连接
//		  Connection conn = null;
//		  //发送sql语句
//		  Statement st = null;
//		  //结果集
//		  ResultSet rs = null;
//		  //创建一个字符串保存SQL语句
//		  String sql = "select film_id,title,description from film";
//		  String sql1 = "select * from film left join language on film.language_id=language.language_id";
//		  try { 
//		   //注册一个驱动
//		   Class.forName("com.mysql.jdbc.Driver");
//		   //获取数据库连接
//		   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","root");
//		   //发送SQL语句
//		   st = conn.createStatement();
//		   rs = st.executeQuery(sql1);
//		   List<String> filmid = new ArrayList<String>();
//		   List<String> filmtitle = new ArrayList<String>();
//		   List<String> filmdescription = new ArrayList<String>();
//		   List<String> language = new ArrayList<String>();
//		  while(rs.next()){
//			  filmid.add(rs.getString("film_id"));
//			  filmtitle.add(rs.getString("title"));
//			  filmdescription.add(rs.getString("description"));
//			  language.add(rs.getString("name"));
//		  }
//		  } catch (Exception e) {
//		   e.printStackTrace();
//		  }finally{
//		   try {//从由小到大的顺序关闭资源
//		    rs.close();
//		   } catch (Exception e2) {
//		   }
//		   try {
//		    st.close();
//		   } catch (Exception e3) {
//		   }
//		   try {
//		    conn.close();
//		   } catch (Exception e4) {
//		   
//		   }
//		  }
			
		}
	
	
	public void getdata(List<String> filmid, List<String> filmtitle,List<String> filmdescription,List<String> language) {
		//当前的数据库连接
		  Connection conn = null;
		  //发送sql语句
		  Statement st = null;
		  //结果集
		  ResultSet rs = null;
		  //创建一个字符串保存SQL语句
		  String sql = "select film_id,title,description from film";
		  String sql1 = "select * from film left join language on film.language_id=language.language_id";
		  try { 
		   //注册一个驱动
		   Class.forName("com.mysql.jdbc.Driver");
		   //获取数据库连接
		   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","root");
		   //发送SQL语句
		   st = conn.createStatement();
		   rs = st.executeQuery(sql1);
		   filmid = new ArrayList<String>();
		   filmtitle = new ArrayList<String>();
		   filmdescription = new ArrayList<String>();
		   language = new ArrayList<String>();
		  while(rs.next()){
			  filmid.add(rs.getString("film_id"));
			  filmtitle.add(rs.getString("title"));
			  filmdescription.add(rs.getString("description"));
			  language.add(rs.getString("name"));
		  }
		  } catch (Exception e) {
		   e.printStackTrace();
		  }finally{
		   try {//从由小到大的顺序关闭资源
		    rs.close();
		   } catch (Exception e2) {
		   }
		   try {
		    st.close();
		   } catch (Exception e3) {
		   }
		   try {
		    conn.close();
		   } catch (Exception e4) {
		   
		   }
		  }
	}
}


