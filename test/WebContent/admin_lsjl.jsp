<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.vo.historyorder"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看历史记录</title>
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
<table border="1">
	<tr>
		<td>订单id</td>
		<td>商品id</td>
		<td>客户名</td>
		<td>交易时间</td>
		<td>买家电话</td>
		<td>买家地址</td>
		<td>交易数量</td>
		<td>交易结果</td>
	</tr>
	<%
		List<historyorder> asd= new ArrayList<historyorder>();
		asd=(List<historyorder>)session.getAttribute("lsjlxx");
		Iterator it =asd.iterator();
		historyorder qwe=null;
		while(it.hasNext()){
			qwe=new historyorder();
			qwe=(historyorder)it.next();
			%>
				<tr>
					<td><%=qwe.getHistoryid() %></td>
					<td><%=qwe.getWaresid() %></td>
					<td><%=qwe.getBuyerid() %></td>
					<td><%=qwe.getFinishtime() %></td>
					<td><%=qwe.getBuyerphone() %></td>
					<td><%=qwe.getBuyeraddress() %></td>
					<td><%=qwe.getWaresnumber() %>
					<td><%=qwe.getResult() %></td>
				</tr>
			<%
		}
	%>
	</table>
	<%
	int flag=asd.size();
	if(flag==0){
		%>
		<h1 style="text-align: center;">暂无历史记录</h1>
		<% 
	}
	%>
</c:if>
</body>
</html>