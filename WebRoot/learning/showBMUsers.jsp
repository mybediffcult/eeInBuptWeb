<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <title>审核中心</title>
	<%@ include file="/houtai/includes.jsp"%>
<link href="../css/index.css" type="text/css" rel="stylesheet" />
<link href="../css/login.css" type="text/css" rel="stylesheet" />
<div class="u-1">
<div class="u-l"><h3>审核中心</h3></div>
<div class="u-r"><h5>当前位置 <span class="black">> 审核中心</span></h5></div>
</div>
<div class="u-2"></div>
<div >
<div class="u-l-l">
<a href="passShenHe?uid=${bMUser.uid}"><div class="submit">通过 审核</div></a>
</div>
<c:if test="${!empty err} }">${err}</c:if>
<br>
 </div>
 <p></p>
<div>
 <div class="u-left"></div>
  <div class="u-midd grey">
    <div><h2>账号:${bMUser.uid}</h2></div>
    <div><h2>姓名:${bMUser.uname }</h2></div>
    <div><h2>年龄:${bMUser.uage}</h2></div>
    <div><h2>性别:${bMUser.usex }</h2></div>
    <div><h2>身份证号:${bMUser.uIdCard}</h2></div>
    <div><h2>手机号码:${bMUser.uPhone}</h2></div>
    <div><h2>单位地址:${bMUser.uUnit}</h2></div>
    <div><h2>单位电话:${bMUser.uUnitPhone}</h2></div>
    <div><h2>邮箱:${bMUser.uMail}</h2></div>
    <div><h2>微信:${bMUser.uMicroMsg}</h2></div>
    <c:if test="${bMUser.ubmShenHe == '0'}">
    <div><h2>审核状态:未通过审核</h2></div>
    </c:if>
    <c:if test="${bMUser.ubmShenHe == '1'}">
    <div><h2>审核状态:已通过审核</h2></div>
    </c:if>
 </div>
<div class="u-right grey">
<div>
<!-- <div><img alt="" src=".${bMUser.uIdentification }" width="50" height="50"></div> -->
<!-- <h3>头像</h3> -->
<table border="0" width="100%" cellspacing="0" cellpadding="0" id="table5">
										<tr>
											<td>
											<p align="center" style="margin-bottom: -4px">
											<font color="#39867B">
											<a target="_blank" href=".${bMUser.uIdentification }">
											<img border="0" src=".${bMUser.uIdentification }" width="124" height="97" alt="点击查看实际大小相片"></a></font></p>
											</td>
										</tr>
										</table>
									</td>
									<td>点击图片查看实际大小</td>
</div>
</div>
</div> 
