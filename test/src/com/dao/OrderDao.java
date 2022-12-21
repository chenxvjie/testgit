package com.dao;

import com.vo.Order;
import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
  void insertorder(Order paramOrder) throws SQLException;
  Order fullorder(Order paramOrder) throws SQLException;
  List<Order> selectorder() throws SQLException;
  List<Order> selectorderbuyerid(String buyerid) throws SQLException;
}
