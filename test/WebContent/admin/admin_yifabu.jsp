<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.vo.Wares"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>已上传商品</title>
<meta charset="UTF-8">
    <link rel="stylesheet" href="page.css">
</head>

<body>
    <a class="us_a" href="servlet_yhspxx">商品首页</a>
    <a class="us_a" href="servlet_spxx">已上传商品</a>
    <a class="us_a" href="servlet_jl">查看申请记录</a>
    <a class="us_a" href="servlet_lsjl">查看历史记录</a>
    <a class="us_a" href="admin/admin_change.jsp">修改密码</a>
    <a class="us_a" href="admin/admin_waresup.jsp">上传商品</a>
    <a class="us_a" href="servlet_tcdl">退出登录</a>
    <hr />
<%
		List<Wares> asd= new ArrayList<Wares>();
		asd=(List<Wares>)session.getAttribute("zcxx");
		Iterator it=asd.iterator();
		Wares qwe=null;
		while(it.hasNext()){
			qwe=new Wares();
			qwe=(Wares)it.next();%>
    <div class="yifabu">
        <div class="showdd2_1">
            商品id：<%=qwe.getWaresid()%>
        </div>
        <hr>
            <div class="showdd1">
           <div class="showdd1_1">
            商品
        </div>
        <div class="showdd1_2">
            价格
        </div>
        <div class="showdd1_2">
            商品数量
        </div>
        <div class="showdd1_2">
            商品状态
        </div>
    </div>
    
        <div class="showdd2_2">
            <img src="upload1/<%=qwe.getWarespicture()%>">
        </div>
        <div class="showdd2_3">
           <%=qwe.getWaresname() %>
        </div>
        <div class="showdd2_4">
            <%=qwe.getWaresprice() %>￥
        </div>
        <div class="showdd2_4">
            <%=qwe.getWaresnumber()%>支
        </div>
        <div class="showdd2_4">
            <%=qwe.getWaresstate() %>
        </div>
        
 <div class="showdd11">
 			<div class="showdd1_2">
            	店铺id
      	    </div>
        	<div class="showdd1_2">
            	商品类别
      	    </div>
          	<div class="showdd1_2">
            	营销信息
       		 </div>
         	<div class="showdd1_2" style="width:500px;">
           	 	历史价格<br/>
        	</div>
 
 </div>
       		
       <div class="showdd2_4">
            <%=qwe.getShopid()%><br/>
        </div>
       <div class="showdd2_4">
            <%=qwe.getWaresclass() %>
        </div>
        <div class="showdd2_4">
            <%=qwe.getMatkering() %>
        </div>
        <div class="showdd2_4">
            <%=qwe.getOldprice() %>
        </div>
             
    </div><%} %>
</body>
</html>