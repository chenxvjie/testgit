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

import com.impl.ClassesImpl;
import com.impl.WaresImpl;
import com.vo.Classes;
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
	    List<Wares> asd1 = new ArrayList<>();
	    ClassesImpl cs = new ClassesImpl();
	    List<Classes> abc = new ArrayList<>();
	    HttpSession session = request.getSession();
	    try {
	      abc = cs.selectclasses();
	    } catch (Exception exception) {}
	    try {
	      asd = war.selectwares();
	    } catch (Exception exception) {}
	    for(int i=0;i<asd.size();i++) {
	    	if(asd.get(i).getWaresstate().equals("remove")) {
	    		
	    	}else {
	    		asd1.add(asd.get(i));
	    	}
	    }
	    session.setAttribute("fl", abc);
	    session.setAttribute("yhspxx", asd);
	    request.getRequestDispatcher("admin_shop.jsp").forward((ServletRequest)request, (ServletResponse)response);
	  }

}
