package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.impl.OrderImpl;
import com.impl.WaresImpl;
import com.vo.Order;
import com.vo.Wares;

/**
 * Servlet implementation class servlet_pergoods2
 */
@WebServlet("/servlet_pergood2")
public class servlet_pergood2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_pergood2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int wid=Integer.parseInt(request.getParameter("wid"));
		int orid=Integer.parseInt(request.getParameter("orid"));
	    
	    Order o = new Order();
	    o.setOrderid(orid);
	    
	    OrderImpl ord = new OrderImpl();
	    try {
			o=ord.fullorder(o);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	    o.setOrderstate("已选择");
	    Wares w = new Wares();
	    w.setWaresid(o.getWaresid());
	    WaresImpl war = new WaresImpl();
	    try {
			w=war.getperwares(w);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    String order_result="订单状态修改错误";
	    if(w.getWaresnumber()<o.getWaresnumber()){
	    	order_result="库存不足";
	    }else{
	    	try {
	    		ord.updatezt(o);
	    		order_result="订单已选择";
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	} 
	    }
	    HttpSession session = request.getSession();
	    session.setAttribute("order_result", order_result);
	    request.getRequestDispatcher("servlet_jl").forward(request,response);
	}

}
