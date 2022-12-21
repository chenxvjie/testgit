<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
<link rel="stylesheet" href="denglu.css">
<script type="text/javascript">
<%
String result=(String)session.getAttribute("cus_dl_result");
if(result!=null){%>
	alert("<%=result%>");
	<%session.setAttribute("cus_dl_result", null);
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
	window.location='cus_login1.jsp' ;                            // 跳转到登录界面
	</script>
	<%
	}
	%>
    <div class="box">
        <div class="left"></div>
        <div class="right">
            <h4>登 录</h4>
            <form action="servlet_userdl" method="post">
                <input class="acc" type="text" placeholder="用户名" name="uname" value="">
                <input class="acc" type="password" placeholder="密码" name="pwd" value="">
                <input class="submit" type="submit" name="submit" value="Login">
            </form>
            <div class="fn">
                <a href="cus_zhuce.jsp">注册账号</a>
              	<a href="cus_shop.jsp">返回商城</a>
            </div>
        </div>
    </div>
</body>
</html>