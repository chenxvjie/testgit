package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.impl.HistoryImpl;
import com.impl.OrderImpl;
import com.impl.WaresImpl;
import com.vo.Order;
import com.vo.Wares;
import com.vo.historyorder;

/**
 * Servlet implementation class servlet_xgzt
 */
@WebServlet("/servlet_xgzt")
public class servlet_xgzt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_xgzt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		int wid = Integer.parseInt(request.getParameter("wid"));
	    int oid =Integer.parseInt(request.getParameter("orid"));
	    String type = request.getParameter("type");
	    String order_result="订单状态修改错误";
	    
	    Wares w = new Wares();
	    w.setWaresid(wid);
	    Order order=new Order();
	    order.setOrderid(oid);
	    order.setWaresid(wid);
	    
	    WaresImpl war = new WaresImpl();
	    OrderImpl ord=new OrderImpl();
	    try {
			order=ord.fullorder(order);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	    
	    historyorder hisor=new historyorder();
	    
	    if(type.equals("解冻")){
	    	order.setOrderstate("未选择");
	    	order_result="订单已取消";
	    	hisor.setResult("交易失败");
	    	try {
			      ord.updatezt(order);
			    } catch (SQLException e) {
			      e.printStackTrace();
			    } 
	    }
	    else if(type.equals("下架")){
	    	w.setWaresstate("remove");
	    	order.setOrderstate("已完成");
	    	order_result="订单已完成";
	    	hisor.setResult("交易成功");
	    	try {
	    			ord.updatezt(order);
			    } catch (SQLException e) {
			      e.printStackTrace();
			    } 
	    }
	    try {
			order=ord.fullorder(order);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		hisor.setHistoryid(order.getOrderid());//这里之后需自动生成
		hisor.setWaresid(order.getWaresid());
		hisor.setShopid(order.getShopid());
		hisor.setBuyerid(order.getBuyerid());
		hisor.setWaresnumber(order.getWaresnumber());
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String str = format.format(date);
		hisor.setFinishtime(str);
		hisor.setBuyeraddress(order.getBuyeraddress());
		hisor.setBuyerphone(order.getBuyerphone());
		System.out.println("real:"+hisor);
		HistoryImpl hist=new HistoryImpl();
		try {
			hist.insertorder(hisor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    HttpSession session = request.getSession();
	    session.setAttribute("order_result", order_result);
	    request.getRequestDispatcher("admin_sqjl.jsp").forward(request,response);
	  }

}
