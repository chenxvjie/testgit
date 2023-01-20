<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息填写</title>
<link rel="stylesheet" href="buyit.css">
<script type="text/javascript">
<%
String result=(String)session.getAttribute("buyit_result");
if(result!=null){%>
	alert("<%=result%>");
	<%session.setAttribute("buyit_result", null);
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

<% 
	String wid= request.getParameter("wid");
	String shopid = request.getParameter("shopid");
	String wnumber = request.getParameter("wnumber");
%>
<h1>商品ID:<%=wid%>&nbsp;
店铺ID:<%=shopid %></h1>
<h1>自动获取：</h1>
<h1>客户ID:1</h1>


<div>
    <div class="box">
        <div class="left"></div>
        <div class="right">
            <h4>填写个人信息</h4>
            <form action="servlet_scjl">              
		            <input class="acc" type="hidden" name="waresid" value=<%=wid %>>
					<input  class="acc" type="hidden" name="shopid" value=<%=shopid %>>
					<input class="acc" type="text" name="buyerid"  placeholder="客户名"><br/><%--之后系统自动获取 --%>
					<input class="acc" type="text" name="waresnumber" placeholder="购买数量">
					<input class="acc" type="hidden" name="wnumber" value=<%=wnumber %>>
					<input class="acc" type="text" name="buyeraddress" placeholder="收货地址(必填)"><br/>
					<input class="acc" type="text" name="buyerphone" placeholder="电话号码(必填)"><br/>
                <input class="submit" type="submit" name="submit" value="确认">
            </form>
        </div>
    </div>
</div>
</c:if>
</body>
</html>