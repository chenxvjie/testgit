package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.impl.BuyerImpl;
import com.vo.Buyer;
import com.vo.Iscontent;

/**
 * Servlet implementation class servlet_cuszc
 */
@WebServlet("/servlet_cuszc")
public class servlet_cuszc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_cuszc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("cusid");
	    String pwd = request.getParameter("cuspw");
	    String name = request.getParameter("cusname");
	    String phone = request.getParameter("cusphone");
	    String address = request.getParameter("cusaddress");
	    String sex="man";
	    Buyer by = new Buyer();
	    by.setBuyerid(id);
	    by.setBuyerpw(pwd);
	    by.setBuyername(name);
	    by.setBuyerphone(phone);
	    by.setBuyeraddress(address);
	    by.setBuyersex(sex);
	    
	    String zhuce_result="注册成功";
	    if(by.getBuyerid().length()<1&&zhuce_result.equals("注册成功")){
	    	zhuce_result="用户名不能为空";
	    }
	    if(by.getBuyerpw().length()<1&&zhuce_result.equals("注册成功")){
	    	zhuce_result="密码不能为空";
	    }
	    if(by.getBuyername().length()<1&&zhuce_result.equals("注册成功")){
	    	zhuce_result="买家姓名不能为空";
	    }
	    if(by.getBuyerphone().length()<1&&zhuce_result.equals("注册成功")){
	    	zhuce_result="买家电话不能为空";
	    }
	    if(by.getBuyeraddress().length()<1&&zhuce_result.equals("注册成功")){
	    	zhuce_result="买家地址不能为空";
	    }
	    
	    BuyerImpl bi =new BuyerImpl();
	    Iscontent iscontent = new Iscontent();
	    if(zhuce_result.equals("注册成功")){
	    	zhuce_result = iscontent.cuszc(by);
	    }
	    if(zhuce_result.equals("注册成功")){
	    	try {
	    		bi.insertbuyer(by);
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	    System.out.println(by);
	    HttpSession session = request.getSession();
	    session.setAttribute("zhuce_result", zhuce_result);
	    if(zhuce_result.equals("注册成功")){
	    	request.getRequestDispatcher("cus_login1.jsp").forward(request, response);
	    }else{
	    	request.getRequestDispatcher("cus_zhuce.jsp").forward(request, response);
	    }
	}

}
