<%@page import="com.vo.Wares"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.vo.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看申请记录</title>
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
	<c:if test="${empty sessionScope.order_result}">
	
	
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_yhspxx">商品预览</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_spxx">商品记录</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_jl">申请记录</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_admin_cus">用户信息</a>
    <a class="us_a" href="admin_change.jsp">修改密码</a>
    <a class="us_a" href="admin_waresup.jsp">上传商品</a>
    <a class="us_a" href="servlet_tcdl">退出登录</a>
    <hr />
    <c:if test="${not empty sessionScope.ware_list}">
    <%--Wares w=(Wares)session.getAttribute("ware");
	int id=w.getWaresid(); --%>
    <%
	List<Wares> ware_list= (List<Wares>)session.getAttribute("ware_list");
    for(int i=0;i<ware_list.size();i++){
    	Wares w=ware_list.get(i);
    	int id=w.getWaresid();
	%>
	<div class="spxq1">
        <div class="spxq1_1">
            <img style="width: 100%;height:100%;" src="upload1/<%= w.getWarespicture()%>">
        </div>
        <div class="spxq1_2">
            <div class="spxq1_1_1">
            商品名：<%= w.getWaresname()%>
            </div>
            <div class="spxq1_1_1">
             商品价格：<%=w.getWaresprice()%>￥
            </div>
            <div class="spxq1_1_1">
             库存：<%=w.getWaresnumber()%>
            </div>
            <br/>
            <form action="admin_buyit.jsp">
            	<input type="hidden" name="wid" value="<%=w.getWaresid() %>">
            	<input type="hidden" name="shopid" value="<%=w.getShopid() %>">
            商品状态：<%=w.getWaresstate()%>
            </form>
            <div class="spxq1_1_1">
            </div>
        </div>
    </div>
    <div class="spxq2">
        <a class="us_a" href="">商品详情</a>
        <hr/>
        <%= w.getMatkering()%>
    </div>
<table border="1">
	<tr>
		<td>订单id</td>
		<td>商品id</td>
		<td>客户名</td>
		<td>申请时间</td>
		<td>买家电话</td>
		<td>买家地址</td>
		<td>购买数量</td>
		<td>选择交易对象</td>
	</tr>
	<%	
		List<Order> asd_nochoose= new ArrayList<Order>();
		List<Order> asd_choose= new ArrayList<Order>();
		List<Order> asd_nochoose2= new ArrayList<Order>();
		List<Order> asd_choose2= new ArrayList<Order>();
		asd_nochoose2=(List<Order>)session.getAttribute("asd_nochoose");
		asd_choose2=(List<Order>)session.getAttribute("asd_choose");
		asd_nochoose.clear();
		asd_choose.clear();
		for(Order o:asd_nochoose2){
			if(o.getWaresid()==w.getWaresid()){
				asd_nochoose.add(o);
			}
		}
		for(Order o:asd_choose2){
			if(o.getWaresid()==w.getWaresid()){
				asd_choose.add(o);
			}
		}
		
		Iterator it1=asd_nochoose.iterator();
		Order qwe=null;
		
		Iterator it2=asd_choose.iterator();
		while(it2.hasNext()){
			qwe=new Order();
			qwe=(Order)it2.next();
			%>
				<tr>
					<td><%=qwe.getOrderid() %></td>
					<td><%=qwe.getWaresid() %></td>
					<td><%=qwe.getBuyerid() %></td>
					<td><%=qwe.getOrdertime() %></td>
					<td><%=qwe.getBuyerphone() %></td>
					<td><%=qwe.getBuyeraddress() %></td>
					<td><%=qwe.getWaresnumber() %></td>
					<td><form action="servlet_xgzt" method="post">
						<input type="hidden" name="orid" value=<%=qwe.getOrderid()%>>
						<input type="hidden" name="wid" value=<%=qwe.getWaresid() %>>
						<input type="hidden" name="type" value="解冻">
						<input type="submit" name="unfreeze" value="取消订单">
					</form> 
					<form action="servlet_xgzt" method="post">
						<input type="hidden" name="orid" value=<%=qwe.getOrderid()%>>
						<input type="hidden" name="wid" value=<%=qwe.getWaresid() %>>
						<input type="hidden" name="type" value="下架">
						<input type="submit" name="remove" value="完成订单">
					</form> 
					</td>
				</tr>
			<%
		}
		while(it1.hasNext()){
			qwe=new Order();
			qwe=(Order)it1.next();
			%>
				<tr>
					<td><%=qwe.getOrderid() %></td>
					<td><%=qwe.getWaresid() %></td>
					<td><%=qwe.getBuyerid() %></td>
					<td><%=qwe.getOrdertime() %></td>
					<td><%=qwe.getBuyerphone() %></td>
					<td><%=qwe.getBuyeraddress() %></td>
					<td><%=qwe.getWaresnumber() %></td>
					<td>
					<%if(asd_choose.size()==0){ %>
					<form action="servlet_pergood2" method="post">
						<input type="hidden" name="orid" value=<%=qwe.getOrderid()%>>
						<input type="hidden" name="wid" value=<%=qwe.getWaresid() %>>
						<input type="submit" name="freeze" value="选择">
					</form> 
					<%} %>
					</td>
				</tr>
			<%
		}
	%>
</table>
<%} %>
</c:if>
<c:if test="${empty sessionScope.ware_list}">
<h1 style="text-align:center;">暂无出售商品</h1>
</c:if>
</c:if>
</c:if>
</body>
</html>