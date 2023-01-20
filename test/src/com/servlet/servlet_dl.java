package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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
import com.impl.SellerImpl;
import com.impl.ShopImpl;
import com.impl.WaresImpl;
import com.vo.Classes;
import com.vo.Iscontent;
import com.vo.Seller;
import com.vo.Shop;
import com.vo.Wares;

/**
 * Servlet implementation class servlet_dl
 */
@WebServlet("/servlet_dl")
public class servlet_dl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_dl() {
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
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("uname");
	    String pwd = request.getParameter("pwd");
	    Seller temple = new Seller();
	    temple.setSellerid(id);
	    temple.setSellerpw(pwd);
	    ClassesImpl cs = new ClassesImpl();
	    List<Classes> abc = new ArrayList<>();
	    HttpSession session = request.getSession();
	    try {
	      abc = cs.selectclasses();
	    } catch (Exception exception) {}
	    session.setAttribute("fl", abc);
	    System.out.println(id);
	    System.out.println(pwd);
	    SellerImpl sel = new SellerImpl();
	    ShopImpl sho = new ShopImpl();
	    List<Seller> asd = new ArrayList<>();
	    try {
			asd=sel.selectsellerpw();
			System.out.println("size"+asd.size());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	    System.out.println("size"+asd.size());
	    Iterator<Seller> it = asd.iterator();
	    String dl_result = null;
	    Iscontent iscontent = new Iscontent();
	    dl_result = iscontent.sjdl(it, temple);
	    session.setAttribute("user", id);
	    session.setAttribute("dl_result", dl_result);
	    if (dl_result.equals("登录成功")) {
	      Shop shop = new Shop();
	      try {
	        shop = sho.fullshop(temple);
	      } catch (SQLException e) {
	        e.printStackTrace();
	      } 
	      session.setAttribute("seller", temple);
	      session.setAttribute("shop", shop);
	      session.setAttribute("dl_result", null); 
	      request.getRequestDispatcher("servlet_yhspxx").forward((ServletRequest)request, (ServletResponse)response);
	    } else{
	      request.getRequestDispatcher("admin_login.jsp").forward((ServletRequest)request, (ServletResponse)response);
	    }
	  }

}
