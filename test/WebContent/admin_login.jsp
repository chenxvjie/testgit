<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" href="denglu.css">
<script type="text/javascript">
<%
String result=(String)session.getAttribute("dl_result");
if(result!=null){%>
	alert("<%=result%>");
	<%session.setAttribute("dl_result", null);
}%>
</script>
</head>
<body class="allbody">
  <%
	String mess = (String)request.getAttribute("mess");         // 获取错误属性
	if(mess != null) {
	%>
	<script type="text/javascript" language="javascript">
	alert("<%=mess%>");                                            // 弹出错误信息
	window.location='admin_login.jsp' ;                            // 跳转到登录界面
	</script>
	<%
	}
	%>
    <div class="box">
        <div class="left"></div>
        <div class="right">
            <h4>登 录</h4>
            <form action="servlet_dl" method="post">
                <input class="acc" type="text" placeholder="用户名" name="uname" value="">
                <input class="acc" type="password" placeholder="密码" name="pwd" value="">
                <input class="submit" type="submit" name="submit" value="Login">
            </form>
        </div>
    </div>
</body>
</html>