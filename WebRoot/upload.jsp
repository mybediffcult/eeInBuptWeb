<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
	<!-- 将头像地址复制到图像框内的头像变量中去，见signup.jsp中 -->
  <script type="text/javascript">
	function img(smileface)
	{
		window.opener.document.regform.img.value=smileface;
		window.close();
	}
  </script>

  </head>
  
  <body>
<font size=5 color=#FF0000> <b>文件上传----使用jspsmartupload组件</b> </font>
<br>
<c:if test="${img==null}">
<form action="servlet/ImgUploadServlet" method="post" enctype="multipart/form-data">
	<p>文件名称： <input type="file" name="file1" size="20" maxlength="80"></p>
	
	<p><input type="submit" value="上传"> <input type="reset" value="重置"></p>

</form>
</c:if>
<c:if test="${img!=null}">
	你的照片已经成功上传！<br><br>点击选择并复制图片路径->: <a href=Javascript:img('.${img }');><b><font color=#FF0000>我上传的照片</font></b><br><br><img src='<%=basePath%>${img }' border='0'></a>
</c:if>
</body>
</html>
