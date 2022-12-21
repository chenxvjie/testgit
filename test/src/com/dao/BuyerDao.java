package com.dao;

import com.vo.Buyer;
import java.sql.SQLException;
import java.util.List;

public interface BuyerDao {
  Buyer insertbuyer(Buyer paramBuyer) throws SQLException;
  List<Buyer> selectbuyerpw() throws SQLException;
  void updatebuyer(Buyer paramBuyer) throws SQLException;
  Buyer selectbuyerid(String buyerid) throws SQLException;
}
