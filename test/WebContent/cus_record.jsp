<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.vo.historyorder"%>
<%@page import="com.vo.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>历史记录</title>
<link rel="stylesheet" href="page.css">
</head>
<body class="allbody">
<c:if test="${empty sessionScope.cus}">
<%response.sendRedirect("cus_login1.jsp"); %>
</c:if>
<c:if test="${not empty sessionScope.cus}">
<div class="spzhuye">
	<a class="us_a" href="servlet_yhspxxcus">商城首页</a>
	<a class="us_a" href="admin_login.jsp">商家页面</a>
	<a class="us_a" href="cus_record.jsp">个人中心</a>
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
	<%
		List<historyorder> hord= new ArrayList<historyorder>();
		hord=(List<historyorder>)session.getAttribute("hord");
		Iterator hit =hord.iterator();
		historyorder hqwe=null;
		while(hit.hasNext()){
			hqwe=new historyorder();
			hqwe=(historyorder)hit.next();
			%>
				<tr>
					<td><%=hqwe.getHistoryid() %></td>
					<td><%=hqwe.getWaresid() %></td>
					<td><%=hqwe.getBuyerid() %></td>
					<td><%=hqwe.getFinishtime() %></td>
					<td><%=hqwe.getBuyerphone() %></td>
					<td><%=hqwe.getBuyeraddress() %></td>
					<td><%=hqwe.getResult() %></td>
				</tr>
			<%
		}
	%>
	</table>
	<%
	int flag=hord.size()+ord.size();
	if(flag==0){
		%>
		<h1 style="text-align: center;">暂无历史记录</h1>
		<% 
	}
	%>
	    </div>
</c:if>
</body>
</html>