<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>审核中</title>
<script src="js/index.js" type="text/javascript" charset="UTF-8"></script>
<link href="css/login.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="tops">
		<div class="logo"></div>
		<div class="logosize">儿童医师培训平台</div>
		<div class="bgct">
		<br>
	  <br>
	   <br>
	    <br>
	     <br>
	      <br>
			<div class="bgtop">
				<h1>报名正在审核中，请耐心等待.................</h1>
			</div>
		</div>
	</div>
	<%
	 String err = (String)request.getAttribute("err");
	 if (err !=null && !err.equals(" ")){
     %>
     <%=err %>
	 <% 
	 }
	 %>
	 <br>
	  <br>
	   <br>
	    <br>
	     <br>
	      <br>
	      <br>
	  <br>
	   <br>
	    <br>
	     <br>
	      <br>
	      <br>
	  <br>
	   <br>
	    <br>
	     <br>
	      <br>
	      <br>
	  <br>
	   <br>
	    <br>
	     <br>
	      <br>
	      <br>
	   <br>
	    <br>
	     <br>
	      <br>
	      <br>
	   <br>
	    <br>
	     <br>
	      <br>
	      <br>
	      	   <br>
	
	 
	 	<div id="footer">
  		<span align="center"><p class="botom">Copyright &copy; 2017 eeinbuptweb Group </p></span>
  	</div>
</body>
</html>