<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="vo.Users" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Users users = (Users)session.getAttribute("ubaoming_users");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>报名页面</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css">
	<script language="Javascript">
	function openScript(url, width, height){
	window.open(url,"openScript",'width=' + width + ',height=' + height + ',resizable=1,scrollbars=yes,menubar=no,status=yes' );
}
    function openem()
{ 
openScript('upload.jsp',350,200); 
}

</script>
    <script type="text/javascript">
    function CheckForm()
{
	if (document.regform.username.value.length == 0) {
		alert("姓名没有填写.请重新输入！");
		return false;
	}
	if (document.regform.uage.value.length == 0) {
		alert("年龄没有填写.请重新输入！");
		return false;
	}
// 		if (document.addNEWS.T3.value.length == 0) {
// 		alert("出生年月没有填写.请重新输入！");
// 		document.addNEWS.T3.focus();
// 		return false;
// 	}
// 		if (document.addNEWS.T4.value.length == 0) {
// 		alert("民族没有填写.请重新输入！");
// 		document.addNEWS.T4.focus();
// 		return false;
// 	}
// 		if (document.addNEWS.T5.value.length == 0) {
// 		alert("籍贯没有填写.请重新输入！");
// 		document.addNEWS.T5.focus();
// 		return false;
// 	}
// 		if (document.addNEWS.T6.value.length == 0) {
// 		alert("文化程度没有填写.请重新输入！");
// 		document.addNEWS.T6.focus();
// 		return false;
// 	}
// 		if (document.addNEWS.T8.value.length == 0) {
// 		alert("政治面貌没有填写.请重新输入！");
// 		document.addNEWS.T8.focus();
// 		return false;
// 	}
		if (document.regform.idCard.value.length == 0) {
		alert("身份证号没有填写.请重新输入！");
		return false;
	}
// 		if (document.addNEWS.T11.value.length == 0) {
// 		alert("毕业学校地址及名称没有填写.请重新输入！");
// 		document.addNEWS.T11.focus();
// 		return false;
// 	}
		if (document.regform.unit.value.length == 0) {
		alert("单位地址没有填写.请重新输入！");
		return false;
	}
// 		if (document.addNEWS.T15.value.length == 0) {
// 		alert("邮政编码没有填写.请重新输入！");
// 		document.addNEWS.T15.focus();
// 		return false;
// 	}
		if (document.regform.phone.value.length == 0) {
		alert("手机号没有填写.请重新输入！");
		return false;
	}
	    if (document.regform.unitphone.value.length == 0) {
		alert("单位电话没有填写.请重新输入！");
		return false;
	}
	    if (document.regform.img.value.length == 0) {
		alert("还未上传证件照片");
		return false;
	}
// 		if (document.addNEWS.T17.value.length == 0) {
// 		alert("本人简历一何年何月至何年何月没有填写.请重新输入！");
// 		document.addNEWS.T17.focus();
// 		return false;
// 	}
// 		if (document.addNEWS.T18.value.length == 0) {
// 		alert("本人简历一在何地何学校单位学习工作没有填写.请重新输入！");
// 		document.addNEWS.T18.focus();
// 		return false;

// 	}
// 		if (document.addNEWS.T23.value.length == 0) {
// 		alert("家庭成员一姓名没有填写.请重新输入！");
// 		document.addNEWS.T23.focus();
// 		return false;
// 	}
// 		if (document.addNEWS.T24.value.length == 0) {
// 		alert("家庭成员一称呼没有填写.请重新输入！");
// 		document.addNEWS.T24.focus();
// 		return false;
// 	}
// 		if (document.addNEWS.T25.value.length == 0) {
// 		alert("家庭成员一工作单位没有填写.请重新输入！");
// 		document.addNEWS.T25.focus();
// 		return false;
// 	}
// 		if (document.addNEWS.T26.value.length == 0) {
// 		alert("家庭成员一联系电话没有填写.请重新输入！");
// 		document.addNEWS.T26.focus();
// 		return false;
// 	}
// 		if (document.addNEWS.T35.value.length == 0) {
// 		alert("志愿报考专业没有填写.请重新输入！（请慎重选择专业！！）");
// 		document.addNEWS.T35.focus();
// 		return false;
// 	}
 	return true;
}


function cls() {
	with (event.srcElement)
		//如果当前值为默认值，则清空
		if (value == defaultValue)
			value = "";
}

        function validateCode(){
	if(!validateName(document.regform.username.value)){
		alert("请输入中英文组成的名字！");
	}
}

    function validateName(str){
	var s = str;
	var reg = /(^[a-zA-Z\u4E00-\u9FA5]{2,20}$)/
	
	return reg.test(s);
}
 function isNum(){
     if(isNaN(document.regform.uage.value)){alert("输入的不是数字！"); return false;}
 }
function validateCard(){
   if(!isIdCardNo(document.regform.idCard.value)){
   		document.addNEWS.T9.value.focus();
   		return false;
   }
}
 function isIdCardNo(num)
  {
	if (isNaN(num)) {alert("输入的不是数字！"); return false;}
	var len = num.length, re;
	if (len == 15)
	  re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);
	else if (len == 18)
	  re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\d)$/);
	else {alert("输入的数字位数不对！"); return false;}
	var a = num.match(re);
	if (a != null)
	{
	  if (len==15)
	  {
		var D = new Date("19"+a[3]+"/"+a[4]+"/"+a[5]);
		var B = D.getYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5];
	  }
	  else
	  {
		var D = new Date(a[3]+"/"+a[4]+"/"+a[5]);
		var B = D.getFullYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5];
	  }
	  if (!B) {alert("输入的身份证号 "+ a[0] +" 里出生日期不对！"); return false;}
	}
	return true;
  }
  
  function validateEmail(){
  	if(!ismail(document.regform.mail.value)){
  		alert("电邮格式不正确！");
  	}
  }
  
   function ismail(mail)
  {
	return(new RegExp(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/).test(mail));
  }
  
  function validateTel(){
  	if(!PhoneCheck(document.regform.phone.value)){
  	    alert("电话号码格式不正确！");
  	}
  }
  
  function validaUnitPhone(){
  	if(!PhoneCheck(document.regform.unitphone.value)){
  	    alert("电话号码格式不正确！");
  	}
  }
  
 function PhoneCheck(s) {
	var str=s;
	var reg=/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/
	return reg.test(str);
}
    </script>
  </head>
  	
  <body>
  <div class="tops">
		<div class="logo"></div>
		<div class="logosize">儿童医师培训平台</div>
		<div class="bgct">
			<div class="bgtop">
				<%--<a class="bgtopsize"><font color='black'>OPEN AND CODE</font></a>--%>
			</div>
  <!-- 现在的报名前端 -->
  <div class="login_DL">
  <div id="reg">
					<form name="regform" action="SignUp" method="post" onSubmit="return CheckForm(this);" >
						<h2 class="h2">儿童医师培训在线报名</h2>
						<!-- 上传头像 start  2017/02/04 by Yu Yinming-->
		  			                       上传证件照片 :
									<td width="22%" rowspan="7">
									<table border="0" width="100%" cellspacing="0" cellpadding="0" id="table4">
										<tr>
											<td>
											<p align="center">
											<font color="#BFBFBF">
											<a href="JavaScript:openem()">
											<img border="0" src="images/Photo.gif" width="124" height="97">
											</a></font></p>
											</td>
										</tr>
										<tr>
											<td height="27">
											<p align="center" style="margin-bottom: -4px">
											<font color="#6C6C6C">
											<input type="text" name="img" value="${img }" size="20" style="border:1px solid #B6B6B6;font-style:normal; font-variant:normal; font-weight:normal; font-size:9pt; color:#FF0000;"></font></p>
											</td>
										</tr>
									</table>
									</td>
									<!-- 上传头像 end -->
							<tr>
								<td><span>用户名：</span><input class="TXT" type="text" name="username" id="input_style" onfocus="cls()" onchange="validateCode()" value="<%=users.getUname() %>" /></td>
							</tr>
							<tr>
								<td><span>年龄：</span><input class="TXT" type="text" name="uage" id="input_style" onfocus="cls()" onchange="validateCode()" value="<%=users.getUage()%>" /></td>
							</tr>
							<tr>
								<td><span>身份证号：</span><input class="TXT" type="text" name="idCard" id="input_style" onfocus="cls()" onchange="validateCard()" value="输入身份证号" /></td>
							</tr>
							<tr>
								<td><span>单位名：</span><input class="TXT" type="text" name="unit" id="input_style" onfocus="cls()"  value="输入单位名" /></td>
							</tr>
							<tr>
								<td><span>手机号：</span><input class="TXT" type="text" name="phone" id="input_style" onfocus="cls()" onchange="validateTel()" value="输入手机号" /></td>
							</tr>
							<tr>
								<td><span>单位电话：</span><input class="TXT" type="text" name="unitphone" id="input_style" onfocus="cls()" onchange="validaUnitPhone()" value="输入单位电话" /></td>
							</tr>
							<tr>
								<td><span>邮箱：</span><input class="TXT" type="text" name="mail" id="input_style" onfocus="cls()" onchange="validateEmail()" value="输入邮箱" /></td>
							</tr>
							<tr>
								<td><span>微信号：</span><input class="TXT" type="text" name="microMsg" id="input_style" onfocus="cls()"  value="输入微信号" /></td>
							</tr>
							<tr>
								<div>
							<%
							//flag true 男; flase 女
							  String sex = users.getUsex(); 
							  boolean flag = false;
							  if (sex.equals("男")){
							      flag = true;
							  }
							 %>
							 <%if (flag) {%>
								<td><input name="usex" type="radio" value="男" checked="男" />男<input
									name="usex" type="radio" value="女" />女</td>
									<%}else{ %>
									<td><input name="usex" type="radio" value="男"  />男<input
									name="usex" type="radio" value="女" checked="女"/>女</td>
									<%} %>
									</div>
							</tr>
							<br>
							<tr>
								<td><input type="submit" name="sub1" value="提交" id="sub1"
									class="submit"  />
									<input type="reset"
									name="re" class="submit" /></td>
							</tr>
							<tr>
								<td><br /></td>
								<td></td>
							</tr>
					</form>
					</div>
			</div>
		  			<!-- 
		  			头像
		  			姓名
		  			         单位
		  			     联系方式，手机单位电话，邮箱，微信号
		  			     身份证号
		  			     培训编号
		  			     培训内容（课程名）
		  			     考核情况，（是否结业）    
		  			 -->
		  	<div class="err">
		  		<%
				 	if (request.getAttribute("err") != null) {
				 %> 
				 <%=request.getAttribute("err")%> <%
				 	}
				 %> 
			 </div>
  	<div id="footer">
  		<span align="center"><p class="botom">Copyright &copy; 2017 eeinbuptweb Group </p></span>
  	</div>
  	</div>
  </body>
</html>
