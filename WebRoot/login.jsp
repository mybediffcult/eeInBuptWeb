<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<script src="js/index.js" type="text/javascript" charset="UTF-8"></script>
<link href="css/login.css" type="text/css" rel="stylesheet" />
</head>
<body>
<%String indexParam = request.getParameter("indexParam");
request.setAttribute("indexParam", indexParam);
 %>
	<div class="tops">
		<div class="logo"></div>
		<div class="logosize">儿童医师培训平台</div>
	<div class="login_D">
		<section id="banner">
			<div class="login_DL">
				<div class="login_DC">
					<form action="login" method="post" name="f1">
						<h1 class="h2">登录</h1>
						<table class="logintable">
							<tr>
								<td>用户名：&nbsp;<input type="text" name="uid" class="TXT"
									placeholder="请输入用户名" onkeyup="value=value.replace(/[\W]/g,'') "
									onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" /></td>
							</tr>
							<tr>
								<td>密码：&nbsp;<input type="password" name="upass" class="TXT"
									placeholder="请输入密码" /></td>
							</tr>
							<tr>
							     <td>
							     <input type="hidden" name="indexParam" value="${indexParam}"/>
							     </td>
							</tr>
							<tr>
								<td><input name="sub" type="submit" value="登录" id="sub"
									class="submit" onClick="return kongK()" /></td>
							</tr>
							<tr>
								<td><br /></td>
								<td></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</section>
	</div>
	<div class="botom">@版权所有：eeinbuptweb 联系方式：123456789@163.com</div>
	<c:if test="${param.logmsg==0}">
		<script>
			alert("请先登录！");
		</script>
	</c:if>
		<c:if test="${! empty param.indexParam}">
		<script>
			alert("请先登录！");
		</script>
	</c:if>
</body>
</html>