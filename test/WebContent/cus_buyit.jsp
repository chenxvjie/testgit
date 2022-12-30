<%@page import="com.vo.Buyer"%>
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
	<a class="us_a" href="servlet_yhspxxcus">商城首页</a>
	<a class="us_a" href="admin_login.jsp">商家页面</a>
	<a class="us_a" href="cus_record.jsp">个人中心</a>
    <hr />
<% 
	String wid= request.getParameter("wid");
	String shopid = request.getParameter("shopid");
	String wnumber = request.getParameter("wnumber");
%>
<c:if test="${empty sessionScope.cus}">
<div class="bodydelu">
    <div class="box">
        <div class="left"></div>
        <div class="right">
            <h4>填写个人信息</h4>
            <form action="servlet_scjlcus">              
		            <input class="acc" type="hidden" name="waresid" value=<%=wid %>>
					<input  class="acc" type="hidden" name="shopid" value=<%=shopid %>>
					<input class="acc" type="text" name="buyerid"  placeholder="客户名"><br/>
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
<c:if test="${not empty sessionScope.cus}">
<%
Buyer buyer = (Buyer)session.getAttribute("cus");
%>
<div class="bodydelu">
    <div class="box">
        <div class="left"></div>
        <div class="right">
            <h4>填写个人信息</h4>
            <form action="servlet_scjlcus">              
		            <input class="acc" type="hidden" name="waresid" value=<%=wid %>>
					<input  class="acc" type="hidden" name="shopid" value=<%=shopid %>>
					<input class="acc" type="hidden" name="buyerid"  value=<%=buyer.getBuyerid() %>><br/>
					<input class="acc" type="text" name="waresnumber" placeholder="购买数量">
					<input class="acc" type="hidden" name="wnumber" value=<%=wnumber %>>
					<input class="acc" type="hidden" name="buyeraddress" value=<%=buyer.getBuyeraddress() %>><br/>
					<input class="acc" type="hidden" name="buyerphone" value=<%=buyer.getBuyerphone() %>><br/>
                	<input class="submit" type="submit" name="submit" value="确认">
            </form>
        </div>
    </div>
</div>
</c:if>


</body>
</html>