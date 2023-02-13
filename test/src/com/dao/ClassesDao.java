package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.vo.Buyer;
import com.vo.Classes;

public interface ClassesDao {
	 Classes insertclass(Classes cs) throws SQLException;
	  List<Classes> selectclasses() throws SQLException;
	  void updateclasses(Classes cs) throws SQLException;
	  void deleteclasses(String mianclass) throws SQLException;
	  Classes selectclass(String mianclass) throws SQLException;
}
