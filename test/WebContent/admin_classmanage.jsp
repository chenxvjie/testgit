<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.vo.Classes"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>类别管理</title>

<link rel="stylesheet" href="page.css">
<script type="text/javascript">
<%
String result=(String)session.getAttribute("class_result");
if(result!=null){%>
	alert("<%=result%>");
	<%
	session.setAttribute("class_result", null);
}%>
	
</script>
</head>
<body class="allbody">


	<a class="us_a" href="<%=request.getContextPath()%>/servlet_yhspxx">商品预览</a>
	<a class="us_a" href="<%=request.getContextPath()%>/servlet_spxx">商品记录</a>
	<a class="us_a" href="<%=request.getContextPath()%>/servlet_jl">申请记录</a>
	<a class="us_a" href="<%=request.getContextPath()%>/servlet_admin_cus">用户信息</a>
	<a class="us_a" href="admin_change.jsp">修改密码</a>
	<a class="us_a" href="servlet_fl">上传商品</a>
	<a class="us_a" href="<%=request.getContextPath()%>/servlet_classmanage?opp=chaxun">类别管理</a>
	<a class="us_a" href="servlet_tcdl">退出登录</a>
	<hr />
	</div>
	<table border="1">
		<tr>
			<td>主类名</td>
			<td>副类1</td>
			<td>副类2</td>
			<td>副类3</td>
			<td>副类4</td>
			<td>副类5</td>
			<td>编辑</td>
			<td>删除</td>

		</tr>
		<%
			List<Classes> asd = new ArrayList<Classes>();
			if (session.getAttribute("classes") != null) {
				asd = (List<Classes>) session.getAttribute("classes");
				Classes cs = null;
				Iterator it = asd.iterator();
				while (it.hasNext()) {
					cs = new Classes();
					cs = (Classes) it.next();
					String otherclasses = cs.getOtherclass();
					String[] otherclasse = otherclasses.split(";");
		%>
		<tr>
		<form action="servlet_classmanage?opp=bianji" method="post">
			<td><input type="text" name="mainclass"
				value="<%=cs.getMainclass()%>" readonly></td>
			<%
				if (otherclasse.length >= 1&&!otherclasse[0].equals("")) {
			%>
			<td><input type="text" name="otherclasse1"
				value="<%=otherclasse[0]%>"></td>
			<%
				} else {
			%>
			<td><input type="text" name="otherclasse1" placeholder="副类1"></td>
			<%
				}
			%>
			<%
				if (otherclasse.length >= 2) {
			%>
			<td><input type="text" name="otherclasse2"
				value="<%=otherclasse[1]%>"></td>
			<%
				} else {
			%>
			<td><input type="text" name="otherclasse2" placeholder="副类2"></td>
			<%
				}
			%>
			<%
				if (otherclasse.length >= 3) {
			%>
			<td><input type="text" name="otherclasse3"
				value="<%=otherclasse[2]%>"></td>
			<%
				} else {
			%>
			<td><input type="text" name="otherclasse3" placeholder="副类3"></td>
			<%
				}
			%>
			<%
				if (otherclasse.length >= 4) {
			%>
			<td><input type="text" name="otherclasse4"
				value="<%=otherclasse[3]%>"></td>
			<%
				} else {
			%>
			<td><input type="text" name="otherclasse4" placeholder="副类4"></td>
			<%
				}
			%>
			<%
				if (otherclasse.length >= 5) {
			%>
			<td><input type="text" name="otherclasse5"
				value="<%=otherclasse[4]%>"></td>
			<%
				} else {
			%>
			<td><input type="text" name="otherclasse5" placeholder="副类5"></td>
			<%
				}
			%>
			<td><input type="submit" name="submit" value="保存 "></td>
			</form>
			<td><form action="servlet_classmanage?opp=shanchu" method="post">
					<input type="hidden" name="mainclass" value=<%=cs.getMainclass()%>>
					<input type="submit" name="submit" value="删除 ">
				</form></td>
		</tr>
		<%
			}
			}
		%>
		<tr>
			<form action="servlet_classmanage?opp=charu" method="post">
			<td><input type="text" name="mainclass"
				placeholder="主类"></td>
			<td><input type="text" name="otherclasse1"
				placeholder="副类1"></td>
				<td><input type="text" name="otherclasse2"
				placeholder="副类2"></td>
				<td><input type="text" name="otherclasse3"
				placeholder="副类3"></td>
				<td><input type="text" name="otherclasse4"
				placeholder="副类4"></td>
				<td><input type="text" name="otherclasse5"
				placeholder="副类5"></td>
			
			<td><input type="submit" name="submit" value="插入 "></td>
			</form>
		</tr>
	</table>

</body>
</html>