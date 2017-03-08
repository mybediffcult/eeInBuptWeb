<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/houtai/includes.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>儿童医师培训</title>
<script src="js/index.js" type="text/javascript" charset="UTF-8"></script>
<link href="css/login.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="tops">
		<div class="logo"></div>
		<div class="logosize">儿童医师培训平台</div>
	<div class="login_D">
		<section id="inner">
			<div class="login_DL">
				<div class="login_DC">
					<form action="zhuce" method="post" name="f2">
						<h2 class="h2">注册</h2>
						<table class="logintable">
							<tr>
								<td><span>用户名：</span><input name="uid" type="text" class="TXT"
									onkeyup="value=value.replace(/[\W]/g,'') " placeholder="请输入用书名"
									onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" /></td>
							</tr>
							<tr>
								<td><span>密码：</span><input name="upass" type="password" class="TXT"
									placeholder="请输入密码" /></td>
							</tr>
							<tr>
								<td><span>确认密码：</span><input name="upass1" type="password" class="TXT"
									placeholder="确认密码" /></td>
							</tr>
							<tr>
								<td><span>姓名：</span><input name="uname" type="text" class="TXT"
									placeholder="输入姓名" /></td>
							</tr>
							<%--<tr>--%>
								<%--<td><input name="uage" type="text" class="TXT"--%>
									<%--onkeyup="value=value.replace(/[^\d]/g,'') " placeholder="输入年龄"--%>
									<%--onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" /></td>--%>
							<%--</tr>--%>
							<tr>
								<td><input name="usex" type="radio" value="男" checked="男" />男<input
									name="usex" type="radio" value="女" />女</td>
							</tr>
							<tr>
								<td><input type="submit" name="sub1" value="注册" id="sub1"
									class="submit" onClick="return saveIt()" /><input type="reset"
									name="re" class="submit" /></td>
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
	<c:if test="${param.msg==1 }">
	    <script>alert("注册失败！请重新尝试")</script>
	</c:if>
</body>
</html>