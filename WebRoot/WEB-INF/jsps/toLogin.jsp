<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${path}/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<title>蓝源进销存(教学版)-系统登录页</title>
<script>
	$(function() {
		$("#login_ok").click(function() {
		//这里就只是使用后台加密
			$("form:first").submit();
		});
		if(top.location.href!=location.href){
			//这里相当于隐藏了self，指的是window对象,在没有iframe框架的时候top和self是一致的。
			//alert(top==self);
			top.location.href = location.href
		}
	});
	function MM_swapImage(srcObj,image_src){
		srcObj.src=image_src;
	}
	function change(img){
		img.src = img.src + "? random = " + Math.random();
	}
</script>
</head>
<body>
	<div class="container-login">
		<div class="login-pic">
			<div class="login-text">
				<form action="${path }/emp_login" method="post">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr align="center">
						
							<s:fielderror name="tip" cssStyle="height:2px;"></s:fielderror>
						</tr>
						<tr>
							<td>用户名：</td>
							<td colspan="2">
								<input name = "emp.username"  type="text" size="18" />
							</td>
						</tr>
						<tr>
							<td>密&nbsp;&nbsp;码：</td>
							<td colspan="2">
								<input id = "password" name = "emp.password"  type="password" size="18" />
							</td>
						</tr>
						<tr>
							<td>验证码：</td>
							<td >
								<input name = "rCode" id = "rCode" type="text" maxlength="4" size="4" />
							</td>
							<td><img onclick = "change(this)" src="${path}/ajax_emp_getImage"/>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td colspan="2">
								<a href="javascript:void(0)" id="login_ok">
									<img src="${path}/images/denglu_bg_03.gif" 
										 name="Image1" 	
										 height="22" border="0"  
										 onmouseover="MM_swapImage(this,'${path}/images/denglu_h_03.gif')" 
										 onmouseout="MM_swapImage(this,'${path}/images/denglu_bg_03.gif')" /></a>
								<a href="#">
									<img  src="${path}/images/giveup_bg_03.gif" 
										 name="Image2"
										 height="22" border="0"  
										 onmouseover="MM_swapImage(this,'${path}/images/giveup_h_03.gif')" 
										 onmouseout="MM_swapImage(this,'${path}/images/giveup_bg_03.gif')" /></a>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
