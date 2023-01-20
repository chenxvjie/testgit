<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.vo.Wares"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>已上传商品</title>
<meta charset="UTF-8">
    <link rel="stylesheet" href="page.css">
</head>

<body class="allbody">
<c:if test="${empty sessionScope.user}">
<%response.sendRedirect("admin_login.jsp"); %>
</c:if>
<c:if test="${not empty sessionScope.user}">
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_yhspxx">商品预览</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_spxx">商品记录</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_jl">申请记录</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_admin_cus">用户信息</a>
    <a class="us_a" href="admin_change.jsp">修改密码</a>
    <a class="us_a" href="servlet_fl">上传商品</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_classmanage?opp=chaxun">类别管理</a>
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
            <%=qwe.getWaresprice() %>元
        </div>
        <div class="showdd2_4">
            <%=qwe.getWaresstate() %>
        </div>
        <div class="showdd2_4">
            <a href="servlet_lsjl?wid=<%= qwe.getWaresid()%>">查看历史申请</a><br/>
        </div>
 
 </div>      
   <%} %>
</c:if>
</body>
</html>