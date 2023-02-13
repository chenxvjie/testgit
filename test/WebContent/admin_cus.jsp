<%@page import="com.vo.Wares"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.vo.Buyer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="page.css">
<script type="text/javascript">
<%
String result=(String)session.getAttribute("order_result");

if(result!=null){%>
	alert("<%=result%>");
	<%session.setAttribute("order_result", null);
	response.sendRedirect("servlet_jl");
}%>
</script>
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
		<td>用户名</td>
		<td>用户账号</td>
		<td>用户地址</td>
		<td>用户电话</td>
		<td>购买历史</td>
	</tr>
	<%	
		List<Buyer> asd= new ArrayList<Buyer>();
		asd=(List<Buyer>)session.getAttribute("buy");
		Buyer qwe=null;	
		Iterator it=asd.iterator();
		while(it.hasNext()){
			qwe=new Buyer();
			qwe=(Buyer)it.next();%>
				<tr>
					<td><%=qwe.getBuyername() %></td>
					<td><%=qwe.getBuyerid() %></td>
					<td><%=qwe.getBuyeraddress() %></td>
					<td><%=qwe.getBuyerphone() %></td>
					<td><form action="servlet_admin_cus_jl" method="post">
						<input type="hidden" name="buyerid" value=<%=qwe.getBuyerid()%>>
						<input type="submit" name="apply" value="查看申请">
					</form> 
					</td>
				</tr>
			<%
		}
		
	%>
</table>
</c:if>
</body>
</html>