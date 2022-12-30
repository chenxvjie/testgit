<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.vo.historyorder"%>
<%@page import="com.vo.Order"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看申请记录</title>
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
    <a class="us_a" href="admin_waresup.jsp">上传商品</a>
    <a class="us_a" href="servlet_tcdl">退出登录</a>
    <hr />
	<table border="1">
	<tr>
		<td>订单id</td>
		<td>商品id</td>
		<td>客户名</td>
		<td>交易时间</td>
		<td>买家电话</td>
		<td>买家地址</td>
		<td>交易结果</td>
	</tr>
	<%
	List<Order> ord= new ArrayList<Order>();
	ord=(List<Order>)session.getAttribute("ord");
	Iterator oit =ord.iterator();
	Order oqwe=null;
	while(oit.hasNext()){
		oqwe=new Order();
		oqwe=(Order)oit.next();
		%>
			<tr>
				<td><%=oqwe.getOrderid() %></td>
				<td><%=oqwe.getWaresid() %></td>
				<td><%=oqwe.getBuyerid() %></td>
				<td><%=oqwe.getOrdertime() %></td>
				<td><%=oqwe.getBuyerphone() %></td>
				<td><%=oqwe.getBuyeraddress() %></td>
				<td><%=oqwe.getOrderstate() %></td>
			</tr>
		<%
	}
	%>
	</table>
</c:if>
</body>
</html>