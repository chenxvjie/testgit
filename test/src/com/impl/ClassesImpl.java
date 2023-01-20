package com.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.BuyerDao;
import com.dao.ClassesDao;
import com.vo.Buyer;
import com.vo.Classes;

public class ClassesImpl implements ClassesDao{
	Connection getConnection() {
	    Connection conn = null;
	    try {
	      conn =new DbConfig().dbConfig();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } 
	    return conn;
	  }
	
	 public Classes insertclass(Classes cs) throws SQLException {
		    Connection conn = getConnection();
		    String sql = "insert into classes(mainclass,otherclass) values(?,?)";
		    PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1, cs.getMainclass());
		    ps.setString(2, cs.getOtherclass());
		
		    ps.execute();
		    ps.close();
		    conn.close();
		    return cs;
		  }
		  
		  public void updateclasses(Classes cs) throws SQLException {
		    Connection conn = getConnection();
		    String sql = "update classes set otherclass=? where mainclass=?";
		    PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1,cs.getOtherclass());
		    ps.setString(2, cs.getMainclass());
		   
		    ps.execute();
		    ps.close();
		    conn.close();
		  }
		 
		  public void deleteclasses(String mainclass) throws SQLException {
			    Connection conn = getConnection();
			    String sql = "delete from classes where mainclass=?";
			    PreparedStatement ps = conn.prepareStatement(sql);
			    ps.setString(1, mainclass);		   
			    ps.execute();
			    ps.close();
			    conn.close();			    
			  }
		  public List<Classes> selectclasses() throws SQLException {
			    String sql = "select * from classes";
			    Connection conn = getConnection();
			    Statement stat = conn.createStatement();
			    ResultSet rs = stat.executeQuery(sql);
			    List<Classes> asd = new ArrayList<>();
			    Classes classes = null;
			    while (rs.next()) {
			    classes = new Classes();
			    classes.setMainclass(rs.getString(1));
			    classes.setOtherclass(rs.getString(2));
			    asd.add(classes);
			    } 
			    rs.close();
			    stat.close();
			    conn.close();
			    return asd;
			  }
		  public Classes selectclass(String mianclass) throws SQLException {
			    Connection conn = getConnection();
			    String sql = "select * from buyer where mainclass=?";
			    PreparedStatement ps = conn.prepareStatement(sql);
			    ps.setString(1,mianclass);
			    ResultSet rs = ps.executeQuery();
			    Classes classes = null;
			    while (rs.next()) {
			    classes = new Classes();
			    classes.setMainclass(rs.getString(1));
			    classes.setOtherclass(rs.getString(2));
			      
			    } 
			    rs.close();
			    ps.close();
			    conn.close();
			    return classes;
			  }
		
}
