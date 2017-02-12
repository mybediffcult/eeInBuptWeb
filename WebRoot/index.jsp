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
		<div class="bgct">
			<div class="bgtop">
				<tr><td><a href=" login.jsp?indexParam=0 ">学籍系统</a></td>&nbsp;&nbsp;<td><a href="login.jsp?indexParam=1">在线学习</a></td>
				&nbsp;&nbsp;<td><a href="login.jsp?indexParam=10">班主任管理</a></td><tr>
			</div>
			<div class="bgtopbl">
				最新消息：
					<Marquee  direction="left" width="600px" scrollamount="10">${MessageList[0].mtitle}</Marquee>
			</div>
			<div class="bgtopkg"></div>
			<div class="bgctbt">
				<div class="bgctlt">
					<div class="bgctlttop">
						<div class="img_div_1"></div>
						<div class="img_div_2"></div>
						<div class="text_div_3">
							<c:if test="${empty MessageList}">
								<jsp:forward page="Index_Servlet"></jsp:forward>
							</c:if>
							<c:forEach items="${MessageList}" var="mes">
								<a href="index.jsp?logmsg=0" class="a_link">${mes.mtitle}</a>
								<br />
							</c:forEach>
						</div>
					</div>
					<div class="bgctltct"></div>
					<div class="bgctltbt">
						<div>
							<h2 style="margin-top: 20px;" class="white">医师培训资料</h2>
								<c:forEach items="${bookList}" var="bkl">
								${bkl.bname}
								<img alt="" src="../${bkl.bimage}" width="50px"
											height="50px">
								</c:forEach>							
						</div>
					</div>
				</div>
				<div class="bgctltlt"></div>
				<div class="bgcltltlt">
					<div class="bgcltltlttop">
						<c:if test="${param.msg==10 }">
							<script>
								alert("登陆失败")
							</script>
						</c:if>
						<c:if test="${param.msg==11 }">
							<script>
								alert("注册失败")
							</script>
						</c:if>
						<div>
							<div id="Main">
								<a href="login.jsp" class="dl">登录</a>
							</div>
						</div>
						<div id="Main">
							<a href="reg.jsp" class="zc">注册</a>
						</div>
					</div>
					<div class="bgcltltltct">最受欢迎的讲师</div>
					<div class="bgcltltltbt">
						<br>
						<c:if test="${empty lectorList}">
							<div class="index_teacher">
								讲<br /> 师<br /> 暂<br /> 空<br /> ！
							</div>
						</c:if>
						<c:if test="${!empty lectorList}">
							<c:forEach items="${lectorList}" var="lec">
								<div class="index_teacher">
									<div class="touxiang_div">
										<img alt="" src="./${lec.user.uimage}" width="120px"
											height="100px">
									</div>
									<div class="textintro_div">
										${lec.user.uname}<br />${lec.lcourse} <br />
										${lec.user.utext}
									</div>
								</div>
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="bg"></div>
	<div class="botom">@版权所有：eeinbuptweb 联系方式：123456789@163.com</div>
	<c:if test="${param.logmsg==0}">
		<script>
			alert("请先登录！");
		</script>
	</c:if>
</body>
</html>