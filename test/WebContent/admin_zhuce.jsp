<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript">
<%
String result=(String)session.getAttribute("zhuce_result");
if(result!=null){%>
	alert("<%=result%>");
	<%session.setAttribute("zhuce_result", null);
}%>
</script>
<link rel="stylesheet" href="zhuce.css">
</head>

<body class="allbody">
<a class="us_a" href="admin_login.jsp">返回</a>
    <div class="box">
        <div class="left"></div>
        <div class="right">
            <h4>注册</h4>
            <form action="servlet_sjzc">
                <input class="acc" type="text" placeholder="用户名" name="sellerid">
                <input class="acc" type="password" placeholder="密码" name="sellerpw">
                <input class="acc" type="text" placeholder="商家姓名" name="sellername">
                <input class="acc" type="password" placeholder="商家电话" "sellerphone">
                <input class="submit" type="submit" value="注册">
            </form>
            
        </div>
    </div>
</body>
</html>