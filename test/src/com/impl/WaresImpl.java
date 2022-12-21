package com.impl;

import com.dao.WaresDao;
import com.vo.Wares;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WaresImpl implements WaresDao {
	Connection getConnection() {
	    Connection conn = null;
	    try {
	      conn =new DbConfig().dbConfig();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } 
	    return conn;
	  }
  
  public String insertwares(Wares w) throws SQLException {
	  String result="发布成功";
    Connection conn = getConnection();   
    String sql = "insert into wares(waresname,waresprice,waresnumber,shopid,waresstate,warespicture,waresclass,matketing) values(?,?,?,?,?,?,?,?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, w.getWaresname());
    ps.setDouble(2, w.getWaresprice().doubleValue());
    ps.setInt(3, w.getWaresnumber());
    ps.setInt(4, w.getShopid());
    ps.setString(5, w.getWaresstate());
    ps.setString(6, w.getWarespicture());
    ps.setString(7, w.getWaresclass());
    ps.setString(8, w.getMatkering());
    ps.execute();
    ps.close();
    conn.close();
    return result;
  }
  
  public List<Wares> selectwares() throws SQLException {
    Connection conn = getConnection();
    String sql = "select * from wares";
    Statement stat = conn.createStatement();
    ResultSet rs = stat.executeQuery(sql);
    List<Wares> asd = new ArrayList<>();
    Wares wares = null;
    while (rs.next()) {
      wares = new Wares();
      wares.setWaresid(rs.getInt(1));
      wares.setWaresname(rs.getString(2));
      wares.setWaresprice(Double.valueOf(rs.getDouble(3)));
      wares.setWaresnumber(rs.getInt(4));
      wares.setShopid(rs.getInt(5));
      wares.setWaresstate(rs.getString(6));
      wares.setWarespicture(rs.getString(7));
      wares.setWaresclass(rs.getString(8));
      wares.setMatkering(rs.getString(9));
      wares.setOldprice(Double.valueOf(rs.getDouble(10)));
      asd.add(wares);
    } 
    rs.close();
    stat.close();
    conn.close();
    rs.close();
    conn.close();
    return asd;
  }
  
  public void updatezt(Wares w) throws SQLException {
    Connection conn = getConnection();
    String sql = "update wares set waresstate=? where waresid=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(2, w.getWaresid());
    ps.setString(1, w.getWaresstate());
    ps.execute();
    ps.close();
    conn.close();
  }
  
  public void deleteware_name(Wares w) throws SQLException {
	    Connection conn = getConnection();
	    String sql = "delete from wares where waresname=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1, w.getWaresname());
	    ps.execute();
	    ps.close();
	    conn.close();
	  }
  
  public Wares getperwares(Wares w) throws SQLException {
    Connection conn = getConnection();
    String sql = "select waresid,waresname,waresprice,waresnumber,shopid,waresstate,warespicture,waresclass,matketing,oldprice from wares where waresid=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, w.getWaresid());
    ResultSet rs = ps.executeQuery();
    Wares wares = new Wares();
    while (rs.next()) {
      wares.setWaresid(rs.getInt(1));
      wares.setWaresname(rs.getString(2));
      wares.setWaresprice(rs.getDouble(3));
      wares.setWaresnumber(rs.getInt(4));
      wares.setShopid(rs.getInt(5));
      wares.setWaresstate(rs.getString(6));
      wares.setWarespicture(rs.getString(7));
      wares.setWaresclass(rs.getString(8));
      wares.setMatkering(rs.getString(9));
      wares.setOldprice(rs.getDouble(10));
    } 
    //System.out.print(wares+"sjk");
    rs.close();
    ps.close();
    conn.close();
    return wares;
  }
}
