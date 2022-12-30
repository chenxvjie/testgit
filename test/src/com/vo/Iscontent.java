package com.vo;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import com.dao.BuyerDao;
import com.impl.BuyerImpl;

public class Iscontent {
  public String sjdl(Iterator<Seller> it, Seller temple) {
    Seller qwe = null;
    String dl_result = "用户名或密码错误";
    while (it.hasNext()) {
      qwe = new Seller();
      qwe = it.next();
      String dd = String.valueOf(qwe.getSellerid());
      System.out.println(dd);
      if (dd.equals(temple.getSellerid())) {
        if (qwe.getSellerpw().equals(temple.getSellerpw())) {
          dl_result = "登录成功";
          temple = qwe;
          continue;
        } 
        dl_result = "密码错误";
      } 
    } 
    return dl_result;
  }
  public String cusdl(Iterator<Buyer> it, Buyer temple) {
	    Buyer qwe = null;
	    String cus_dl_result = "用户名或密码错误";
	    while (it.hasNext()) {
	      qwe = new Buyer();
	      qwe = it.next();
	      String dd = String.valueOf(qwe.getBuyerid());
	      if (dd.equals(temple.getBuyerid())) {
	        if (qwe.getBuyerpw().equals(temple.getBuyerpw())) {
	          cus_dl_result = "登录成功";
	          temple = qwe;
	          continue;
	        } 
	        cus_dl_result = "密码错误";
	      } 
	    } 
	    return cus_dl_result;
	  }
  public String xgsjmm(Seller seller, String pwd1, String pwd2, String pwd3) {
    String xgsjmm_result = "修改成功";
    if (seller.getSellerpw().equals(pwd1)) {
      if (pwd2.length() < 6) {
        xgsjmm_result = "新密码长度过短";
      } else if (pwd2.length() > 12) {
        xgsjmm_result = "新密码长度过长";
      } else {
        int kinds = 0;
        for (int i = 0; i < pwd2.length(); i++) {
          if ('0' <= pwd2.charAt(i) && pwd2.charAt(i) <= '9') {
            kinds++;
            break;
          } 
        } 
        for (int i = 0; i < pwd2.length(); i++) {
          if ('a' <= pwd2.charAt(i) && pwd2.charAt(i) <= 'z') {
            kinds++;
            break;
          } 
          if ('A' <= pwd2.charAt(i) && pwd2.charAt(i) <= 'Z') {
            kinds++;
            break;
          } 
        } 
        if (kinds < 2) {
          xgsjmm_result = "新密码类型单一";
        } else {
        	if (!pwd2.equals(pwd3)) {
        		xgsjmm_result = "确认密码错误";
        	} 
        }
      } 
    } else {
      xgsjmm_result = "旧密码错误";
    } 
    return xgsjmm_result;
  }
  public String fabu(Wares wa){
	  String result="发布成功";
	  if(wa.getWaresname().equals("")&&result.equals("发布成功")){
		  result="商品名称不能为空";
	  }
	  if(wa.getWaresprice()==null&&result.equals("发布成功")){
		  result="商品价格不能为空";
	  }
	  if(wa.getWarespicture()==null&&result.equals("发布成功")){
		  result="商品图片未上传";
	  }
	  if(result.equals("发布成功")){
		  if(wa.getWaresname().length()>20&&result.equals("发布成功")){
			  result="商品名长度不能超过20";
		  }
		  if(wa.getWaresprice()<0&&result.equals("发布成功")){
			  result="商品价格不能小于0";
		  }
		  if(wa.getWaresnumber()<=0&&result.equals("发布成功")){
			  result="商品数量必须是大于0的整数";
		  }
		  if(wa.getMatkering().length()>100&&result.equals("发布成功")){
			  result="商品描述长度不能超过100";
		  }
	  }
	  return result;
  }
  public static boolean isNumeric(String str){
	  Pattern pattern =Pattern.compile("[0-9]*");
	  return pattern.matcher(str).matches();
  }
  public String buyit(Order order){
	  String result="购买成功";
	  if(order.getBuyerid().equals("")&&result.equals("购买成功")){
		  result="客户名不能为空";
	  }
	  if(order.getBuyerid().length()>10&&result.equals("购买成功")){
		  result="客户名过长";
	  }
	  if(order.getWaresnumber()<=0&&result.equals("购买成功")){
		  result="购买数量必须大于0";
	  }
	  if(order.getBuyeraddress().equals("")&&result.equals("购买成功")){
		  result="交易地址不能为空";
	  }
	  if(order.getBuyerphone().equals("")&&result.equals("购买成功")){
		  result="联系电话不能为空";
	  }
	  if(!isNumeric(order.getBuyerphone())&&result.equals("购买成功")){
		  result="联系电话只能包含数字";
	  }
	  if(order.getBuyerphone().length()!=11&&result.equals("购买成功")){
		  result="联系电话错误";
	  }
	  return result;
  }
  public String cuszc(Buyer by) {
	    String zhuce_result = "注册成功";
	    BuyerDao bydao=new BuyerImpl();
	    List<Buyer> bys = null;
		try {
			bys = bydao.selectbuyerpw();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    for(Buyer b:bys){
	    	if(b.getBuyerid().equals(by.getBuyerid())){
	    		zhuce_result = "用户名重复";
	    		break;
	    	}
	    }
	    if (zhuce_result.equals("注册成功")) {
	        if (by.getBuyerpw().length() < 6) {
	        	zhuce_result = "密码长度少于6";
	        } else if (by.getBuyerpw().length() > 12) {
	        	zhuce_result = "密码长度超过12";
	        } else {
	          int kinds = 0;
	          for (int i = 0; i < by.getBuyerpw().length(); i++) {
	            if ('0' <= by.getBuyerpw().charAt(i) && by.getBuyerpw().charAt(i) <= '9') {
	              kinds++;
	              break;
	            } 
	          } 
	          for (int i = 0; i < by.getBuyerpw().length(); i++) {
	            if ('a' <= by.getBuyerpw().charAt(i) && by.getBuyerpw().charAt(i) <= 'z') {
	              kinds++;
	              break;
	            } 
	            if ('A' <= by.getBuyerpw().charAt(i) && by.getBuyerpw().charAt(i) <= 'Z') {
	              kinds++;
	              break;
	            } 
	          } 
	          if (kinds < 2) {
	        	  zhuce_result = "密码必须包含字母和数字";
	          }
	        }
	    }
	    if (zhuce_result.equals("注册成功")){
	        String regEx = "[\\u4e00-\\u9fa5]";
	        String term= by.getBuyername().replaceAll(regEx, "aa");
	        int count= term.length()-by.getBuyername().length();
	        for (int i = term.length()-1; i >= 0; i--) {
	            if (!(term.charAt(i)=='a')) {
	            	zhuce_result="买家姓名含非中文字符";
	            	break;
	            }
	        }
	        if (zhuce_result.equals("注册成功")) {
	        	if(count<2){
	        		zhuce_result = "买家姓名长度不能小于2";
	        	}
	        	else if(count>6){
	        		zhuce_result = "买家姓名长度不能大于6";
	        	}
	        }
	    }
	    if(!isNumeric(by.getBuyerphone())&&zhuce_result.equals("注册成功")){
	    	zhuce_result="联系电话只能包含数字";
		}
		if(by.getBuyerphone().length()!=11&&zhuce_result.equals("注册成功")){
			zhuce_result="联系电话错误";
		}
	    return zhuce_result;
	  }
}
