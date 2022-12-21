package com.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vo.Seller;


public class test2 
{
	Connection getConnection() {
	    Connection conn = null;
	    try {
	      conn =new DbConfig().dbConfig();
	    } catch (SQLException e) {
	      e.printStackTrace();
	      System.out.println("连接失败");
	    } 
	    System.out.println("连接成功");
	    return conn;
	  }
	public List<Seller> selectsellerpw() throws SQLException {
	    String sql = "select * from seller";
	    Connection conn = getConnection();
	    Statement stat = conn.createStatement();
	    ResultSet rs = stat.executeQuery(sql);
	    List<Seller> asd = new ArrayList<>();
	    Seller seller = null;
	    while (rs.next()) {
	      seller = new Seller();
	      seller.setSellername(rs.getString(1));
	      seller.setSellerid(rs.getString(2));
	      seller.setSellerpw(rs.getString(3));
	      seller.setSellerphone(rs.getString(4));
	      seller.setShopid(rs.getInt(5));
	      asd.add(seller);
	    } 
	    System.out.println("aaa:"+asd.size());
	    rs.close();
	    stat.close();
	    conn.close();
	    return asd;
	  }
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
    	test2 t=new test2();
    	List<Seller> myt=t.selectsellerpw();
    	System.out.print(myt.get(0).getSellerid());
    }
}

