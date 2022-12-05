package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.impl.WaresImpl;
import com.vo.Wares;

/**
 * Servlet implementation class servlet_yhspxx
 */
@WebServlet("/servlet_yhspxx")
public class servlet_yhspxx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_yhspxx() {
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
		WaresImpl war = new WaresImpl();
	    List<Wares> asd = new ArrayList<>();
	    HttpSession session = request.getSession();
	    try {
	      asd = war.selectwares();
	    } catch (Exception exception) {}
	    session.setAttribute("yhspxx", asd);
	    request.getRequestDispatcher("admin_shop.jsp").forward((ServletRequest)request, (ServletResponse)response);
	  }

}
