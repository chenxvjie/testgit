package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
 * Servlet implementation class servlet_userdl
 */
@WebServlet("/servlet_userdl")
public class servlet_userdl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_userdl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("uname");
	    String pwd = request.getParameter("pwd");
	    Buyer temple = new Buyer();
	    temple.setBuyerid(id);
	    temple.setBuyerpw(pwd);
	    HttpSession session = request.getSession();
	    System.out.println(id);
	    System.out.println(pwd);
	    BuyerImpl bl = new BuyerImpl();
	    List<Buyer> asd = new ArrayList<>();
	    try {
	      asd = bl.selectbuyerpw();
	    } catch (Exception exception) {}
	    Iterator<Buyer> it = asd.iterator();
	    String cus_dl_result = null;
	    Iscontent iscontent = new Iscontent();
	    cus_dl_result = iscontent.cusdl(it, temple);
	    session.setAttribute("user", id);
	    session.setAttribute("cus_dl_result", cus_dl_result);
	    if (cus_dl_result.equals("登录成功")) {
	    	try {
				temple=bl.selectbuyerid(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      session.setAttribute("cus", temple);
	      session.setAttribute("cus_dl_result", null); 
	      request.getRequestDispatcher("servlet_cusjl").forward(request, response);
	    } else{
	      request.getRequestDispatcher("cus_login1.jsp").forward(request, response);
	    }
	}

}
