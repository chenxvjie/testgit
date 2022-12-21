package com.impl;

import com.dao.BuyerDao;
import com.vo.Buyer;
import com.vo.historyorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuyerImpl implements BuyerDao {
  Connection getConnection() {
    Connection conn = null;
    try {
      conn =new DbConfig().dbConfig();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return conn;
  }
  
  public Buyer insertbuyer(Buyer b) throws SQLException {
    Connection conn = getConnection();
    String sql = "insert into buyer(buyername,buyerid,buyerpw,buyeraddress,buyerphone,buyersex) values(?,?,?,?,?,?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, b.getBuyername());
    ps.setString(2, b.getBuyerid());
    ps.setString(3, b.getBuyerpw());
    ps.setString(4, b.getBuyeraddress());
    ps.setString(5,b.getBuyerphone());
    ps.setString(6, b.getBuyersex());
    ps.execute();
    ps.close();
    conn.close();
    return b;
  }
  
  public void updatebuyer(Buyer b) throws SQLException {
    Connection conn = getConnection();
    String sql = "update buyer set buyeraddress=?,buyerphone=? where buyerid=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, b.getBuyeraddress());
    ps.setString(2, b.getBuyerphone());
    ps.setString(3, b.getBuyerid());
    ps.execute();
    ps.close();
    conn.close();
  }

  public List<Buyer> selectbuyerpw() throws SQLException {
	    String sql = "select * from buyer";
	    Connection conn = getConnection();
	    Statement stat = conn.createStatement();
	    ResultSet rs = stat.executeQuery(sql);
	    List<Buyer> asd = new ArrayList<>();
	    Buyer buyer = null;
	    while (rs.next()) {
	      buyer = new Buyer();
	      buyer.setBuyername(rs.getString(1));
	      buyer.setBuyerid(rs.getString(2));
	      buyer.setBuyerpw(rs.getString(3));
	      buyer.setBuyeraddress(rs.getString(4));
	      buyer.setBuyerphone(rs.getString(5));
	      buyer.setBuyersex(rs.getString(6));
	      asd.add(buyer);
	    } 
	    rs.close();
	    stat.close();
	    conn.close();
	    return asd;
	  }
  public Buyer selectbuyerid(String buyerid) throws SQLException {
	    Connection conn = getConnection();
	    String sql = "select * from buyer where buyerid=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,buyerid);
	    ResultSet rs = ps.executeQuery();
	    Buyer buyer = null;
	    while (rs.next()) {
	      buyer = new Buyer();
	      buyer.setBuyername(rs.getString(1));
	      buyer.setBuyerid(rs.getString(2));
	      buyer.setBuyerpw(rs.getString(3));
	      buyer.setBuyeraddress(rs.getString(4));
	      buyer.setBuyerphone(rs.getString(5));
	      buyer.setBuyersex(rs.getString(6));
	    } 
	    rs.close();
	    ps.close();
	    conn.close();
	    return buyer;
	  }
}
