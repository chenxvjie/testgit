<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.vo.Wares"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城</title>
<link rel="stylesheet" href="page.css">
</head>
<body class="allbody">
<c:if test="${empty sessionScope.user}">
<%response.sendRedirect("admin_login.jsp"); %>
</c:if>
<c:if test="${not empty sessionScope.user}">
<%
Wares w=(Wares)session.getAttribute("ware");
int id=w.getWaresid();
String[] picture=w.getWarespicture().split(";");
%>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_yhspxx">商品预览</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_spxx">商品记录</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_jl">申请记录</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_admin_cus">用户信息</a>
    <a class="us_a" href="admin_change.jsp">修改密码</a>
    <a class="us_a" href="servlet_fl">上传商品</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_classmanage?opp=chaxun">类别管理</a>
    <a class="us_a" href="servlet_tcdl">退出登录</a>
    <hr />
    <div class="spxq1">
        <div class="spxq1_1">
            <div class="content" num="<%=picture.length %>">
            <!-- 轮播图片 -->
            <ul>
                <%for(int i=0;i<picture.length;i++){%>
                    <li><img src="upload1/<%= picture[i]%>" alt=""></li>
                <%} %>
            </ul>
            <!-- 轮播图的点 -->
            <ol>
                <%for(int i=0;i<picture.length;i++){%>
                    <li></li>
                <%} %>
            </ol>
            </div>   
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
            <form action="cus_buyit.jsp">
                <input type="hidden" name="wid" value="<%=w.getWaresid() %>">
                <input type="hidden" name="shopid" value="<%=w.getShopid() %>">
                <input type="hidden" name="wnumber" value="<%=w.getWaresnumber() %>">
                <%if(w.getWaresstate().equals("putaway")){ %>
                <input class="spxqgm" type="submit" name="submit" value="购买并填写个人信息">
                <%}else{ %>
                <%="商品已冻结" %>
                <%} %>
            </form>
            <div class="spxq1_1_1">
            </div>
        </div>
    </div>
    <div class="spxq2">
        <a class="us_a" href="">商品详情</a>
        <hr/>
        <%= w.getMatkering()%>
        <div class="spxq2_1">
    </div>
    </div>
<script src="lunbotu.js"></script>
</c:if>
</body>
</html>
