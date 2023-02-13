<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>  
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图片上传</title>
<link rel="stylesheet" href="style.css">

</head>

<!-- 头部的提示  -->
<body >
<!-- 一个横排框 按钮选择图像或视频 -->
<div id="main" class="upload_main">
    <form id="uploadForm" action="FileUpload" method="post" enctype="multipart/form-data">
        <div class="upload_box">
            <div class='upload_main'>
                <div class="upload_choose">
                    <!-- 按钮选择文件 -->
                    <input id="fileImage" onchange="choosefiles(this)" type="file" size="30" name="fileselect[]" multiple />
                </div>

                <div id="preview" class="upload_preview" overflow-y :scroll>
                    <!-- 预览区域 将它设置为滚动条方便显示多张图片  显示图片 每一张图存放在一个表格里面-->
                    <div class='imgtable'>
                        <table id="imgViewtb" class="show_imgtable">
                            <tbody id="imgViewtbody">
                            </tbody>
                        </table>
                    </div>
           
                </div>
            </div>
        </div>
        <input type="submit" name="sub1" value="上传"/><br/>
    </form>
</div>


<script src="http://libs.baidu.com/jquery/1.4.4/jquery.js"></script>
<script src="FileUpload.js"></script>
</body>
</html>
