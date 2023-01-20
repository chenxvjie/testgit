package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.impl.BuyerImpl;
import com.impl.ClassesImpl;
import com.vo.Buyer;
import com.vo.Classes;

/**
 * Servlet implementation class servlet_classmanage
 */
@WebServlet("/servlet_classmanage")
public class servlet_classmanage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_classmanage() {
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
	protected void chaxun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		ClassesImpl cs = new ClassesImpl();
	    List<Classes> asd = new ArrayList<>();
	    HttpSession session = request.getSession();
	    try {
	      asd = cs.selectclasses();
	    } catch (Exception exception) {}
	    session.setAttribute("classes", asd);
	    request.getRequestDispatcher("admin_classmanage.jsp").forward(request, response);
	}
	protected void bianji(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String class_result="修改成功";
		String mainclass=request.getParameter("mainclass");
		String otherclasse="";
		String otherclasse1=request.getParameter("otherclasse1");
		String otherclasse2=request.getParameter("otherclasse2");
		String otherclasse3=request.getParameter("otherclasse3");
		String otherclasse4=request.getParameter("otherclasse4");
		String otherclasse5=request.getParameter("otherclasse5");
		if(!otherclasse1.equals(""))
		{
			otherclasse=otherclasse+otherclasse1+";";	
		}
		if(!otherclasse2.equals(""))
		{
			otherclasse=otherclasse+otherclasse2+";";	
		}
		if(!otherclasse3.equals(""))
		{
			otherclasse=otherclasse+otherclasse3+";";	
		}
		if(!otherclasse4.equals(""))
		{
			otherclasse=otherclasse+otherclasse4+";";	
		}
		if(!otherclasse5.equals(""))
		{
			otherclasse=otherclasse+otherclasse5+";";	
		}
		
		System.out.println("mainclass"+mainclass);
		 System.out.println("otherclasse"+otherclasse);
		ClassesImpl cs = new ClassesImpl();
	    Classes asd = new Classes();
	    HttpSession session = request.getSession();
	    asd.setMainclass(mainclass);
	    asd.setOtherclass(otherclasse);
	   
	    try {
	        cs.updateclasses(asd);
	    } catch (Exception exception) {
	    	class_result="修改失败";
	    	}
	    session.setAttribute("class_result", class_result);
	    System.out.println(".....");
	}	
	protected void shanchu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String mainclass=request.getParameter("mainclass");
		System.out.println("mainclass"+mainclass);
		String class_result="删除成功";
		ClassesImpl cs = new ClassesImpl();
		HttpSession session = request.getSession();
		    try {
		    	cs.deleteclasses(mainclass);
		    } catch (Exception exception) {
		    	class_result="删除失败";
		    }
		session.setAttribute("class_result", class_result); 
		 
	}	
	protected void charu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String mainclass=request.getParameter("mainclass");
		String class_result="插入成功";
		 System.out.println("mainclass"+mainclass);
		 String otherclasse="";
			String otherclasse1=request.getParameter("otherclasse1");
			String otherclasse2=request.getParameter("otherclasse2");
			String otherclasse3=request.getParameter("otherclasse3");
			String otherclasse4=request.getParameter("otherclasse4");
			String otherclasse5=request.getParameter("otherclasse5");
			if(!otherclasse1.equals(""))
			{
				otherclasse=otherclasse+otherclasse1+";";	
			}
			if(!otherclasse2.equals(""))
			{
				otherclasse=otherclasse+otherclasse2+";";	
			}
			if(!otherclasse3.equals(""))
			{
				otherclasse=otherclasse+otherclasse3+";";	
			}
			if(!otherclasse4.equals(""))
			{
				otherclasse=otherclasse+otherclasse4+";";	
			}
			if(!otherclasse5.equals(""))
			{
				otherclasse=otherclasse+otherclasse5+";";	
			}
			 System.out.println("otherclasse"+otherclasse);
			ClassesImpl cs = new ClassesImpl();
		    Classes asd = new Classes();
		    asd.setMainclass(mainclass);
		    if(otherclasse!=null)
		    {
		    asd.setOtherclass(otherclasse);
		    }
		    HttpSession session = request.getSession();
		    List<Classes> old_asd = (List<Classes>) session.getAttribute("classes");
			for(Classes c:old_asd){
				if(c.getMainclass().equals(asd.getMainclass())){
					class_result="主类不能重复";
				}
			}
			if(class_result.equals("插入成功")){
				try {
					if(!asd.getMainclass().equals("")){
						cs.insertclass(asd);
					}else{
						class_result="主类不能为空";
					}
				} catch (Exception exception) {}
			}
		    session.setAttribute("class_result", class_result); 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String opp=request.getParameter("opp");
		System.out.println(opp);
		if(opp!=null)
		{
		if(opp.equals("chaxun"))
		{
			chaxun(request,response);
		}
		else if(opp.equals("bianji"))
		{
			bianji(request,response);
			chaxun(request,response);
		}
		else if(opp.equals("shanchu"))
		{
			shanchu(request,response);
			chaxun(request,response);
		}
		else if(opp.equals("charu"))
		{
			charu(request,response);
			chaxun(request,response);
		}
		}
		else
		{
			chaxun(request,response);
		}
	
		
		
	}

}
