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
import com.vo.Classes;


/**
 * Servlet implementation class servlet_fl
 */
@WebServlet("/servlet_fl")
public class servlet_fl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_fl() {
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
		request.setCharacterEncoding("UTF-8");
//		Classes qwe;
//		ArrayList<Classes> asd =new ArrayList<>();
//		HttpSession session = request.getSession();
//		for(int i=0;i<6;i++) {
//			qwe=new Classes();
//			qwe.setMainclass("设计");
//			qwe.setOtherclass("设计输入问题;设计差错;试验验证不充分;设计可靠性欠缺;设计接口不协调;技术未吃透;测试覆盖性不全");
//			asd.add(qwe);
//		}
//		qwe=new Classes();
//		qwe.setMainclass("asd");
//		qwe.setOtherclass("asdasdw;sdwe;88888;66666");
//		asd.add(qwe);
//		System.out.print(asd);
		ClassesImpl cs = new ClassesImpl();
	    List<Classes> asd = new ArrayList<>();
	    HttpSession session = request.getSession();
	    try {
	      asd = cs.selectclasses();
	    } catch (Exception exception) {}
	    session.setAttribute("fl", asd);
		
	    request.getRequestDispatcher("admin_waresup.jsp").forward((ServletRequest)request, (ServletResponse)response);

		
	}

}
