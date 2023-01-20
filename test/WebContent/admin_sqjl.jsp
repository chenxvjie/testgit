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
<link rel="stylesheet" type="text/css" href="./css/index.css">
<link rel="stylesheet" href="page.css">
<script type="text/javascript">
<%
String result=(String)session.getAttribute("order_result");
List<Wares> mypage_list= (List<Wares>)session.getAttribute("ware_list");
String[] page_index=new String[mypage_list.size()];
for(int hi=0;hi<mypage_list.size();hi++){
	int hj=hi+1;
	page_index[hi]="page-"+hj;
}
if(result!=null){%>
	alert("<%=result%>");
	<%session.setAttribute("order_result", null);
	response.sendRedirect("servlet_jl");
}%>
var page_index = ["page-1", "page-2", "page-3","page-4","page-5","page-6","page-7","page-8","page-9","page-10","page-11","page-12","page-13","page-14","page-15","page-16","page-17","page-18","page-19","page-20"];
//输入pagename，打开指定的div，隐藏其他的div
function page_option(pagename){
	var tar_index = page_index.indexOf(pagename);
	page_index.slice(tar_index, 1);
	for (var j = 0; j < page_index.length ; j++){
		var close_div = document.getElementsByClassName(page_index[j]);
		for (var i = 0; i<close_div.length;i++) {
			   close_div[i].style.display="none";
		};
	}
	
	var opendiv = document.getElementsByClassName(pagename);
	for (var i = 0; i<opendiv.length;i++) {
		   opendiv[i].style.display="block";
	};
}

//点击 返回第一页按钮 执行的操作
function first_click(){
	page_option("page-1");
	document.getElementById('currentPage').value=1;
}

//点击 跳到最后一页按钮 执行的操作
function last_click(){
	var total_page = document.getElementById('totalPage').value;
	page_option(page_index[parseInt(total_page)-1]);
	document.getElementById('currentPage').value=total_page;
}

//点击 上一页按钮 执行的操作
function prev_click(){
	var cur_page = document.getElementById('currentPage').value;
	if (cur_page > 1){
		document.getElementById('currentPage').value=parseInt(cur_page)-1;
		var pagename = page_index[parseInt(cur_page)-2];
		page_option(pagename);
	}
}

//点击 下一页按钮 执行的操作
function next_click(){
	var cur_page = document.getElementById('currentPage').value;
	var total_page = document.getElementById('totalPage').value;
	if (cur_page < total_page){
		document.getElementById('currentPage').value=parseInt(cur_page) + 1;
		var pagename = page_index[parseInt(cur_page)];
		page_option(pagename);
	}
}

//手动改变当前页码时执行的操作
function choose_page(){
	var t=parseInt(document.getElementById('totalPage').value)+1;
	
	var cur_page = document.getElementById('currentPage').value;
	if(!(0<parseInt(cur_page)&&parseInt(cur_page)<t)){
		alert("超出范围");
	}
	else {
		var pagename = page_index[parseInt(cur_page)-1];
		page_option(pagename);
		
	}
}

//鼠标事件，经过每一条资讯时改变标题的颜色
function light(obj){
	obj.firstElementChild.style.color="#FF9900";
}

function normal(obj){
	obj.firstElementChild.style.color="#000000";
}


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
    <a class="us_a" href="servlet_fl">上传商品</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_classmanage?opp=chaxun">类别管理</a>
    <a class="us_a" href="servlet_tcdl">退出登录</a>
    <hr />
    <c:if test="${not empty sessionScope.ware_list}">
    <%--Wares w=(Wares)session.getAttribute("ware");
	int id=w.getWaresid(); --%>
    <%
	List<Wares> ware_list= (List<Wares>)session.getAttribute("ware_list");
	%>
<div >
		<%
		int flag=0;
		for(int i=0;i<ware_list.size();i++){
			String qq=page_index[i];
				%>
				<div class="<%=qq%>">
				<%
					Wares w=ware_list.get(i);
    				int id=w.getWaresid();
    				if(true){
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
		
		int null_flag=0;
		null_flag=null_flag+asd_nochoose.size()+asd_choose.size();
		if(null_flag==0){
			%>
			<h1 style="text-align: center;">暂无申请记录</h1>
		<%}else{%>
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
		<%}
		
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
	</div>
	<%}%>
		<%} %>
	</div>
	<!-- 分页按钮 -->
	<div class="page-icon">
		<button class="" onclick="first_click()" >第一页</button>
		<button class="beforePage" onclick="prev_click()" ><img src="./img/3.png"/></button>
		<button>第<input id="currentPage" onchange="choose_page()" type="text" value="1"/>页</button>
		<button>/&nbsp;&nbsp;&nbsp;共<input id="totalPage" type="button" value="<%=mypage_list.size() %>" readonly="readonly">页</button>
		<button class="nextPage" onclick="next_click()"><img src="./img/2.png"/></button>
		<button class="" onclick="last_click()">最后一页</button>			
	</div>
</c:if>
<c:if test="${empty sessionScope.ware_list}">
<h1 style="text-align:center;">暂无出售商品</h1>
</c:if>
</c:if>
</c:if>
<script type = "text/javascript">
        window.onload = function()
        {
        	first_click();
        }
    </script>
</body>

</html>