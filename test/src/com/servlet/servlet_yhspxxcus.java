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
 * Servlet implementation class servlet_yhspxxcus
 */
@WebServlet("/servlet_yhspxxcus")
public class servlet_yhspxxcus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_yhspxxcus() {
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
		request.setCharacterEncoding("UTF-8");
		WaresImpl war = new WaresImpl();
	    List<Wares> asd = new ArrayList<>();
	    List<Wares> asd1 = new ArrayList<>();
	    HttpSession session = request.getSession();
	    try {
	      asd = war.selectwares();
	    } catch (Exception exception) {}
	    Wares w=new Wares();
	    for(int i=0;i<asd.size();i++) {
	    	if(asd.get(i).getWaresstate().equals("remove")) {
	    		
	    	}else {
	    		asd1.add(asd.get(i));
	    	}
	    }
	    session.setAttribute("yhspxxcus", asd1);
	    request.getRequestDispatcher("cus_shop.jsp").forward((ServletRequest)request, (ServletResponse)response);
	  
	}

}
