<%@page import="com.vo.Classes"%>
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
<link rel="stylesheet" type="text/css" href="./css/index.css">
<link rel="stylesheet" href="page.css">

<script type="text/javascript">
<%
String result=(String)session.getAttribute("buyit_result");
if(result!=null){%>
	alert("<%=result%>");
	<%session.setAttribute("buyit_result", null);
}%>







var page_index = ["page-1", "page-2", "page-3","page-4","page-5","page-6","page-7","page-8"];




// 输入pagename，打开指定的div，隐藏其他的div
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

// 点击 返回第一页按钮 执行的操作
function first_click(){
	page_option("page-1");
	document.getElementById('currentPage').value=1;
}

// 点击 跳到最后一页按钮 执行的操作
function last_click(){
	var total_page = document.getElementById('totalPage').value;
	page_option(page_index[parseInt(total_page)-1]);
	document.getElementById('currentPage').value=total_page;
}

// 点击 上一页按钮 执行的操作
function prev_click(){
	var cur_page = document.getElementById('currentPage').value;
	if (cur_page > 1){
		document.getElementById('currentPage').value=parseInt(cur_page)-1;
		var pagename = page_index[parseInt(cur_page)-2];
		page_option(pagename);
	}
}

// 点击 下一页按钮 执行的操作
function next_click(){
	var cur_page = document.getElementById('currentPage').value;
	var total_page = document.getElementById('totalPage').value;
	if (cur_page < total_page){
		document.getElementById('currentPage').value=parseInt(cur_page) + 1;
		var pagename = page_index[parseInt(cur_page)];
		page_option(pagename);
	}
}

// 手动改变当前页码时执行的操作
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

// 鼠标事件，经过每一条资讯时改变标题的颜色
function light(obj){
	obj.firstElementChild.style.color="#FF9900";
}

function normal(obj){
	obj.firstElementChild.style.color="#000000";
}

function getCity(value,tt){
    //获得省份下拉框的对象
    var sltProvince=document.form1.province;
    //获得城市下拉框的对象
    var sltCity=document.form1.city;   
    var sz=value.split(";");
    //清空下拉框，仅留提示选项
    sltCity.length=1;
    //将城市数组中的值填充到城市下拉框中
    for(var i=0;i<sz.length-1;i++){
		 //Option(选项描述，选项值) 等价于 <option value="选项值" >选项描述</option>;
        sltCity[i+1]=new Option(sz[i],sz[i]);
    }
}
function change()
{
   var x = document.getElementById("first");
   var y = document.getElementById("second");
   y.options.length = 0; // 清除second下拉框的所有内容
   var i;
   alert("123");
   for(i=0;i<res.length;i++)
  {
	   if(x.selectedIndex == i)
	 {
	    var j;
	   y.options.add(new Option(res[i][1], "0",false, true));
		for( j=2;j<res[i].length;j++)   
	   {
			y.options.add(new Option(res[i][j], j-1));
			
	   }
	}
  
  }
}
</script>
</head>
<body class="allbody" >
    <a class="us_a" href="servlet_yhspxxcus">商城首页</a>
	<a class="us_a" href="admin_login.jsp">商家页面</a>
	<a class="us_a" href="cus_record.jsp">个人中心</a>
    <hr />
    <form action="cus_shop.jsp">
				<center>
				    <div class="search-box">
				        <input class="search-txt" type='text' id='inp' placeholder="请输入商品名称" name="inp" value=""/>
				        
				        <input class="search-btn"  id='btn' type="submit" value="&#xf002">
				    </div>
					<div>			
					</div>
				</center>
				</form>
	
<%	
List<Wares> asd= new ArrayList<Wares>();
String tt1=request.getParameter("inp");
String province=request.getParameter("province");
String[] pro=null;
String zhu="";
String provine="";
if(province!=null){
	pro = province.split(";");
	provine=pro[pro.length-1];
	zhu =provine+";";
}
String city=request.getParameter("city");
String city1=zhu+city;
List<Wares> asdtt= new ArrayList<Wares>();
asdtt=(List<Wares>)session.getAttribute("yhspxxcus");
int ddt=0;
if(tt1==null){	
}
else {
	for(int i=0;i<asdtt.size();i++){
		Wares qwett=new Wares();
		qwett=asdtt.get(i);
		for(int j=0;j<=qwett.getWaresname().length()-tt1.length();j++){
			
			if(tt1.equals(qwett.getWaresname().substring(j,j+tt1.length()))&&!qwett.getWaresstate().equals("remove")){
				asd.add(qwett);
				ddt=1;
				break;
			}
		}
	}
	
}
if(ddt==0&&tt1==null){
	for(int i=0;i<asdtt.size();i++){
		Wares qwett=new Wares();
		qwett=asdtt.get(i);
		if(!qwett.getWaresstate().equals("remove")){
			asd.add(qwett);
		}
	}
	
}
if(ddt==0&&tt1!=null){
	for(int i=0;i<asdtt.size();i++){
		Wares qwett=new Wares();
		qwett=asdtt.get(i);
		if(!qwett.getWaresstate().equals("remove")){
			asd.add(qwett);
		}
	}
	%>
		<script type="text/javascript">
			alert("没有搜索到关键词，请重新搜索！");
		</script>
	<%
}
	int n=0;
	%> 
	<%
	List<Wares> abcd= new ArrayList<Wares>();
	int shu=0;
	if(zhu!=""){
		for(int i=0;i<asdtt.size();i++){
			Wares qwett=new Wares();
			qwett=asdtt.get(i);
			if(qwett.getWaresclass().equals(city1) ){
				abcd.add(qwett);
				shu=shu+1;
			}		
		}		
	}
	if(zhu!="" && shu==1){
		asd=abcd;
	}else if(zhu!="" && shu==0){
		%>
		<script type="text/javascript">
			alert("该类别商品已售完");
		</script>
		<%
	}
	%>
	<div class="page-left">
    <form action="cus_shop.jsp" name="form1" id="form1">
	<select class="add" name="province" id="select1" onchange="getCity(this.value,this.options[this.selectedIndex].text)">
 			<%
 			if(zhu!=""&& shu==1){%>
 				<option value=<%=provine %>><%=provine %></option>
 			<%}else{%>
 				<option value="0">请选择主类</option>
 			<%}
 			%>
 			<%
 			List<Classes> abc =new ArrayList<>();
			abc=(List<Classes>)session.getAttribute("fl");
			Iterator it =abc.iterator();
			Classes aqwe;
			for(int i=0;i<abc.size();i++){
				aqwe=new Classes();
				aqwe=(Classes)it.next();
				%>
					<option value=<%=aqwe.getOtherclass()+aqwe.getMainclass()%>><%=aqwe.getMainclass() %></option>
					
				<%			
			}
 			%>						
 		</select>	
 		<select name="city" id="select2" >
 		<%
 			if(zhu!=""&&shu==1){%>
 				<option value=<%=city %>><%=city %></option>
 			<%}else{%>
 				<option value="0">请选择副类</option>
 			<%}
 			%>
 		</select>
 	</form>
	</div>
    <div class="page-block">
    
		<%
			String[] page_index=new String[]{"page-1", "page-2", "page-3","page-4","page-5","page-6","page-7","page-8"};		
			int aa;
			aa=asd.size();
			int t;
			if(aa%3==0){
				t=aa/3;
			}
			else{
				t=(aa/3)+1;
			}
			int op=0;
			for(int i=0;i<t;i++){			
				String qq=page_index[i];
				%>			
				<div class="<%=qq%>">	
					<%
						if(i<t-1||(i==t-1&&aa%3==0)){
							for(int j=0;j<3;j++){
								Wares qwe=new Wares();
								qwe=asd.get(op);
								op++;
								%>
								<div class="article-hover" onclick="window.open('servlet_pergood_admin?wid=<%= qwe.getWaresid()%>','_self')">
									<div class="thumbnail" >
										<img src="upload1/<%= qwe.getWarespicture()%>" alt="">
									</div>
									
									<div class="info-content" onmouseover="light(this)" onmouseout="normal(this)">
										<div class="li-title">
											<%=qwe.getWaresname() %>
										</div>
										<div class="li-content">
											<%=qwe.getWaresprice() %>元 
										</div>
										<h4>点击查看详情</h4>
									</div>
								</div>
								<hr/>
								<%
							}
						}
						else if(i==t-1&&aa%3>0){
							for(int j=0;j<aa%3;j++){
								Wares qwe=new Wares();
								qwe=asd.get(op);
								op++;
								%>
								<div class="article-hover" onclick="window.open('servlet_pergood_admin?wid=<%= qwe.getWaresid()%>','_self')">
									<div class="thumbnail">
										<img src="upload1/<%= qwe.getWarespicture()%>" alt="">
									</div>
									
									<div class="info-content" onmouseover="light(this)" onmouseout="normal(this)">
										<div class="li-title">
											<%=qwe.getWaresname() %>
										</div>
										<div class="li-content">
											<%=qwe.getWaresprice() %>元
										</div>
										<h4>点击查看详情</h4>
									</div>
								</div>
								<hr/>
								<%
							}
						}
					%>
				</div>
				<%
			}
		%>
	</div>
	<!-- 分页按钮 -->
	<div class="page-icon">
		<button class="" onclick="first_click()" >第一页</button>
		<button class="beforePage" onclick="prev_click()" ><img src="./img/3.png"/></button>
		<button>第<input id="currentPage" onchange="choose_page()" type="text" value="1"/>页</button>
		<button>/&nbsp;&nbsp;&nbsp;共<input id="totalPage" type="button" value="<%=t %>" readonly="readonly">页</button>
		<button class="nextPage" onclick="next_click()"><img src="./img/2.png"/></button>
		<button class="" onclick="last_click()">最后一页</button>			
	</div>
    <script>
	    var oInp = document.getElementById('inp');
	    var oBtn = document.getElementById('btn');
	    var se1 = document.getElementById("select1");
	    var se2 = document.getElementById("select2");
	    var form1 = document.getElementById("form1");
	    se2.onchange = function () {
	    	form1.submit();
	    }
	    oBtn.onclick = function () {
	        Search();
	    }
	
	    document.onkeydown = function () {
	        if (event.keyCode == 13) {
	            Search();
	        }
	    }
	    function Search() {
	    	self.location='cus_shop.jsp';
	    }
	</script>
</body>
</html>