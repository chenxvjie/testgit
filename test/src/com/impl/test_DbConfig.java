package com.impl;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class test_DbConfig {
	public static final String DRIVER = "org.sqlite.JDBC";
	
	public static final String URL = "jdbc:sqlite:C:/Users/周/Desktop/验收待完善(1)/验收待完善/test/test.db";
	File f = new File(this.getClass().getResource("../..").getPath());
	public Connection dbConfig() throws SQLException{
		System.out.println(f);
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection(URL);
	}
}
