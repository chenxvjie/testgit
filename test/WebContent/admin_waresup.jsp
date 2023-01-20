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
<meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>发布商品</title>

<link rel="stylesheet" href="waresup.css">
<script type="text/javascript">
<%
String result=(String)session.getAttribute("fabu_result");
String user=(String)session.getAttribute("user");
if(result!=null){%>
	alert("<%=result%>");
	<%session.setAttribute("fabu_result", null);
}%>

//定义了城市的二维数组，里面的顺序跟省份的顺序是相同的。通过selectedIndex获得省份的下标值来得到相应的城市数组
function getCity(value,tt){
    //获得省份下拉框的对象
    var sltProvince=document.form1.province;
    //获得城市下拉框的对象
    var sltCity=document.form1.city;  
    var sz=value.split(";");
    //清空下拉框，仅留提示选项
    sltCity.length=1;
    //将城市数组中的值填充到城市下拉框中
    for(var i=0;i<sz.length;i++){
		 //Option(选项描述，选项值) 等价于 <option value="选项值" >选项描述</option>;
        sltCity[i+1]=new Option(sz[i],sz[i]);
    }
}
</script>
</head>
<body class="allbody">
<c:if test="${empty sessionScope.user}">
<%response.sendRedirect("admin_login.jsp"); %>
</c:if>
<c:if test="${not empty sessionScope.user}">
<script type="text/javascript" src="ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="ueditor/ueditor.all.js"></script> 
<div >
 <a class="us_a" href="<%=request.getContextPath()%>/servlet_yhspxx">商品预览</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_spxx">商品记录</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_jl">申请记录</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_admin_cus">用户信息</a>
    <a class="us_a" href="admin_change.jsp">修改密码</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_fl">上传商品</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_classmanage?opp=chaxun">类别管理</a> 
    <a class="us_a" href="servlet_tcdl">退出登录</a>
    <hr />
</div>   
	<div class="bodydelu">
    <div class="box">
        <div class="left"></div>
        <div class="right">
            <h4>发布商品</h4>
            <form action="servlet_tjsp" name="form1">
             <input class="acc" type="hidden" name="uname" value=<%=user %>>
            	<input class="acc" type="text" name="waresname" placeholder="商品名称(必填)"><br/>
				<input class="acc" type="text" name="waresprice" placeholder="商品价格(元)（必填）"><br/>
				<input class="acc" type="text" name="waresnumber" placeholder="商品库存"><br/>
				<a class="acc" href="FileUpload.jsp">商品图片上传</a><br/>
				<a class="acc" >商品类别</a> <br/>
				<a class="acc">
		<select class="add" name="province" onchange="getCity(this.value,this.options[this.selectedIndex].text)">
 			<option value="0">请选择主类</option>	
 			<%
 			List<Classes> asd =new ArrayList<>();
			asd=(List<Classes>)session.getAttribute("fl");
			Iterator it =asd.iterator();
			Classes qwe;
			for(int i=0;i<asd.size();i++){
				qwe=new Classes();
				qwe=(Classes)it.next();
				%>
					<option value=<%=qwe.getOtherclass()%>><%=qwe.getMainclass() %></option>
					
				<%			
			}
 			%>						
 		</select>	
 		<input id="asd" type="hidden" value=<%=asd %>>
 		<select name="city">
 			<option value="0">请选择副类</option>
 		</select>
			</a><br/>
				<label>
				<textarea  name="editor" id="editor" style="height:300px" ></textarea><br/>
				</label>
                <input class="submit" type="submit" name="submit" value="发布">
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" charset="utf-8">
UE.getEditor('editor');
</script>
</c:if>
</body>
</html>
<script>
function change()
{
   var x = document.getElementById("first");
   var y = document.getElementById("second");
   y.options.length = 0; // 清除second下拉框的所有内容
   var i;
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