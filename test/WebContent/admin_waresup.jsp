<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布商品</title>

<link rel="stylesheet" href="waresup.css">
<script type="text/javascript">
<%
String result=(String)session.getAttribute("fabu_result");
if(result!=null){%>
	alert("<%=result%>");
	<%session.setAttribute("fabu_result", null);
}%>
</script>
</head>
<body >
<c:if test="${empty sessionScope.user}">
<%response.sendRedirect("admin_login.jsp"); %>
</c:if>
<c:if test="${not empty sessionScope.user}">
<div class="allbody">
 <a class="us_a" href="<%=request.getContextPath()%>/servlet_yhspxx">商品预览</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_spxx">已上传商品</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_jl">查看申请记录</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_lsjl">查看历史记录</a>
    <a class="us_a" href="admin_change.jsp">修改密码</a>
    <a class="us_a" href="admin_waresup.jsp">上传商品</a>
    <a class="us_a" href="servlet_tcdl">退出登录</a>
    <hr />
</div>
<h1>商家你好：</h1>
<h1>用户名:1234</h1>   
	<div class="bodydelu">
    <div class="box">
        <div class="left"></div>
        <div class="right">
            <h4>发布商品</h4>
            <form action="servlet_tjsp">
             <input class="acc" type="hidden" name="uname" value="1234">
            	<input class="acc" type="text" name="waresname" placeholder="商品名称(必填)"><br/>
				<input class="acc" type="text" name="waresprice" placeholder="商品价格(元)（必填）"><br/>
				<input class="acc" type="hidden" name="waresnumber" value=1><br/>
				<a class="acc" href="FileUpload.jsp">商品图片上传</a><br/>
	 			<input class="acc" type="text" name="waresclass" placeholder=" 商品类别"><br/>
				<input class="acc" type="text" name="matketing" placeholder=" 商品信息"><br/>
                <input class="submit" type="submit" name="submit" value="发布">
            </form>
        </div>
    </div>
</div>
</c:if>
</body>
</html>