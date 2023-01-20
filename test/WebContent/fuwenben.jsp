<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="ueditor/ueditor.all.js"></script> 
<form action="fuwenben">
<label>
<textarea name="editor" id="editor" style="height:360px;width:70%"></textarea>
</label>
<script type="text/javascript" charset="utf-8">
UEDITOR_CONFIG.UEDITOR_HOME_URL = './ueditor/';
UE.getEditor('editor');
</script>
<input class="submit" type="submit" name="submit" value="提交">
</form>
<%String x="<p>123</p>"; %>
<%=x %>
</body>
</html>