package com.servlet;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.impl.WaresImpl;
import com.vo.Classes;
import com.vo.Iscontent;
import com.vo.Shop;
import com.vo.Wares;


@WebServlet("/servlet_tjsp")
public class servlet_tjsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_tjsp() {
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
		HttpSession session = request.getSession();
		Shop shop = (Shop)session.getAttribute("shop");
	    String waresname=request.getParameter("waresname");
	    String waresprice=request.getParameter("waresprice");
	    String waresnumber=request.getParameter("waresnumber");
	    String matketing=request.getParameter("editor");
	    String province=request.getParameter("province");
	    String fabu_result="发布成功";
	     
	     List<Classes> asd =new ArrayList<>();
	  asd=(List<Classes>)session.getAttribute("fl");
	  Iterator it =asd.iterator();
	  Classes qwe;
	  String mainclass = null;
	  for(int i=0;i<asd.size();i++){
	   qwe=new Classes();
	   qwe=(Classes)it.next();
	   if(qwe.getOtherclass().equals(province))
	   {
	    mainclass=qwe.getMainclass();
	   }
	  }
	     System.out.println("mainclass::"+mainclass);
	     if(mainclass==null){
	    	 if(fabu_result.equals("发布成功")){
	    		 fabu_result="商品类别未选择";
	    	 }
	     }
	     String otherclass=request.getParameter("city");
	     System.out.println("city::"+otherclass);
	     if(otherclass.equals("0")){
	    	 if(fabu_result.equals("发布成功")){
	    		 fabu_result="商品副类未选择";
	    	 }
	     }
	     String waresclass=mainclass+";"+otherclass;
	     System.out.println("waresclass:"+waresclass);
	    Wares wa = new Wares();
	    wa.setWaresname(waresname);
	    if(fabu_result.equals("发布成功")){
	    	if(waresprice!=""){
	    		try{
	    			wa.setWaresprice(Double.valueOf(waresprice));
	    		}catch(NumberFormatException e){
	    			fabu_result="商品价格不为数字";
	    			session.setAttribute("fabu_result", fabu_result);
	    			request.getRequestDispatcher("admin_waresup.jsp").forward((ServletRequest)request, (ServletResponse)response);
	    		}
	    	}
	    }
	    if(fabu_result.equals("发布成功")){
	    	if(waresnumber!=""){
	    		try{
	    			wa.setWaresnumber(Integer.valueOf(waresnumber));
	    		}catch(NumberFormatException e){
	    			fabu_result="商品库存不为整数";
	    			session.setAttribute("fabu_result", fabu_result);
	    			request.getRequestDispatcher("admin_waresup.jsp").forward((ServletRequest)request, (ServletResponse)response);
	    		}
	    	}else{
	    		fabu_result="商品库存不能为空";
	    		session.setAttribute("fabu_result", fabu_result);
	    		request.getRequestDispatcher("admin_waresup.jsp").forward((ServletRequest)request, (ServletResponse)response);
	    	}
	    }
	    wa.setShopid(1);
	    wa.setWaresstate("putaway");
	    wa.setWarespicture((String)session.getAttribute("fn"));
	    wa.setWaresclass(waresclass);
	    
	    wa.setMatkering(matketing);
	    System.out.println(wa+"!");
	    
	    Iscontent iscontent=new Iscontent();
	    if(fabu_result.equals("发布成功")){
	    	fabu_result=iscontent.fabu(wa);
	    }
	    session.setAttribute("fabu_result", fabu_result);
	    if(fabu_result.equals("发布成功")){
	    	WaresImpl war = new WaresImpl();
	    	try {
	    		fabu_result=war.insertwares(wa);
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	} 
	    	session.setAttribute("fabu_result", fabu_result);
	    	request.getRequestDispatcher("admin_waresup.jsp").forward((ServletRequest)request, (ServletResponse)response);
	    }else{
	    	request.getRequestDispatcher("admin_waresup.jsp").forward((ServletRequest)request, (ServletResponse)response);
	    }
	}

}
