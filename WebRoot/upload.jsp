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
	
	
	<!-- ��ͷ���ַ���Ƶ�ͼ����ڵ�ͷ�������ȥ����signup.jsp�� -->
  <script type="text/javascript">
	function img(smileface)
	{
		window.opener.document.regform.img.value=smileface;
		window.close();
	}
  </script>

  </head>
  
  <body>
<font size=5 color=#FF0000> <b>�ļ��ϴ�----ʹ��jspsmartupload���</b> </font>
<br>
<c:if test="${img==null}">
<form action="servlet/ImgUploadServlet" method="post" enctype="multipart/form-data">
	<p>�ļ����ƣ� <input type="file" name="file1" size="20" maxlength="80"></p>
	
	<p><input type="submit" value="�ϴ�"> <input type="reset" value="����"></p>

</form>
</c:if>
<c:if test="${img!=null}">
	�����Ƭ�Ѿ��ɹ��ϴ���<br><br>���ѡ�񲢸���ͼƬ·��->: <a href=Javascript:img('.${img }');><b><font color=#FF0000>���ϴ�����Ƭ</font></b><br><br><img src='<%=basePath%>${img }' border='0'></a>
</c:if>
</body>
</html>
