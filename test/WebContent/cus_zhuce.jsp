<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
<script type="text/javascript">
<%
String result=(String)session.getAttribute("zhuce_result");
if(result!=null){%>
	alert("<%=result%>");
	<%session.setAttribute("zhuce_result", null);
}%>
</script>
<link rel="stylesheet" href="denglu.css">
</head>
<body class="allbody">
<a class="us_a" href="admin_login.jsp">返回</a>
    <div class="box">
        <div class="left"></div>
        <div class="right">
           
            <form action="servlet_cuszc">
                <input class="acc" type="text" placeholder="用户名" name="cusid">
                <input class="acc" type="password" placeholder="密码" name="cuspw">
                <input class="acc" type="text" placeholder="买家姓名" name="cusname">
                <input class="acc" type="text" placeholder="买家电话" name="cusphone">
                <input class="acc" type="text" placeholder="买家地址" name="cusaddress">
                <input class="submit" type="submit" value="注册">
            </form>
            
        </div>
    </div>
</body>
</html>