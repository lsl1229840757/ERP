<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@include file="../taglibs.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#all").click(function() {
			$("[name=roles]:checkbox").attr("checked", $("#all").attr("checked") == "checked");
		});
		$("#reverse").click(function() {
			$("[name=roles]:checkbox").each(function() {
				$(this).attr("checked", !$(this).attr("checked"));
			});

		});

		$("#addEmpForm").find("[regr]").keyup(function() {
			var val = $(this).val();
			var regex = new RegExp($(this).attr("regr"));
			var name = $(this).attr("name");
			//这里只是判断是否成功,失败就隐藏
			if (val != null) {
				if (regex.test(val)) {
					//判断重复密码
					if (name == "repassword") {
						if (val == $("#password").val()) {
							$(this).next("span").show();
						} else {
							$(this).next("span").hide();
						}
					}else{
						$(this).next("span").show();
					} 
				} else {
					$(this).next("span").hide();
				}
			} else {
				$(this).next("span").hide();
			}

		});

		$("#addEmpForm").find("[reg]").keyup(function() {
			var val = $(this).val();
			var regex = new RegExp($(this).attr("reg"));
			//这里只是判断是否成功,失败就隐藏
			if (val != null && val != "") {
				if (regex.test(val)) {
					$(this).next("span").show();
				} else {
					$(this).next("span").hide();
				}
			} else {
				$(this).next("span").hide();
			}
		});
	});

	function submitForm() {
		if (validateForm()) {
		//这里不能直接使用表单提交,使用ajax提交表单
		var result = "";
		$("#addEmpForm").ajaxSubmit({
			async:false,
			dataType:"text",
			success:function(responseText){
				//后台添加成功就返回success
				result = responseText;
			}
		});
		return result;
		}
	}
	function validateForm() {
	    var flag = true;
		//获取regr的属性节点,要加[]
		$("#addEmpForm").find("[regr]").each(function() {
			//取值
			var val = $(this).val();
			var regex = new RegExp($(this).attr("regr"));
			var tip = $(this).attr("tip");
			var name = $(this).attr("name");
			if (regex.test(val)) {
				//校验输入密码和重复密码是否一致
				if (name == "repassword") {
					if (val != $("#password").val()) {
						$(this).css("background", "#FFAC8C");
						Dialog.alert("请确认两次密码是否一致!");
						flag = false;
						return false;
					}else{
						$(this).css("background", "white");
					}
				}
				
				if(name == "emp.username"){
					//发送ajax请求
					var result = validateUname($(this).val());
					if(result == "no"){
						$(this).css("background", "#FFAC8C");
						Dialog.alert("该用户已经存在!");
						flag = false;				
						return false;
					}else{
						$(this).css("background", "white");
					}
				}
				$(this).css("background", "white");
			} else {
				$(this).css("background", "#FFAC8C");
				Dialog.alert(tip);
				flag = false;
				return false;
			}
		});
		//再检验非必须项目
		$("#addEmpForm").find("[reg]").each(function() {
			var val = $(this).val();
			var tip = $(this).attr("tip");
			if (val != null && $.trim(val) != "") {
				var regex = new RegExp($(this).attr("reg"));
				if (regex.test(val)) {
					$(this).css("background", "white");
				} else {
					Dialog.alert(tip);
					$(this).css("background", "#FFAC8C");
					flag = false;
				return false;
				}
			}
		});
		return flag;
	}
	
	function validateUname(username){
		//发送ajax请求
		var result = "yes";
		$.ajax({
			url:"${path}/ajax_emp_validateUsername",
			data:{"emp.username" : username
			},
			//设置同步处理
			async:false,
			dataType:"text",
			success:function(responseText){
				result = responseText;			
			}
		});
		return result;		
	}
	
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">员工管理</span>
		</div>
	</div>
	<div class="content-text">
		<div class="square-order">
			<form id="addEmpForm" action="ajax_emp_add" method="post">
				<div style="border:1px solid #cecece;">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr bgcolor="#FFFFFF">
							<td>&nbsp;</td>
						</tr>
					</table>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr bgcolor="#FFFFFF">
							<td width="18%" height="30" align="center"><font color="red">*</font>用&nbsp;户&nbsp;名</td>
							<td width="32%">
								<!-- 这里的regr的r表示必填项目,\w表示匹配字母数字和下划线 --> <s:textfield type="text"
									size="25" name="emp.username" regr="^\w{6,8}$" tip="请输入6到8位用户名"></s:textfield>
								<span style="display:none;"><font color="green">√</font></span>
							</td>
							<td width="18%" align="center"><font color="red">*</font>真实姓名</td>
							<td width="32%"><s:textfield type="text" name="emp.name"
									size="25" regr="^[\u4e00-\u9fa5]{2,10}$" tip="请输入2到10位的真实姓名"></s:textfield>
								<span style="display:none;"><font color="green">√</font></span>
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td align="center"><font color="red">*</font>密&nbsp;&nbsp;&nbsp;&nbsp;码</td>
							<td><s:textfield id="password" type="password" size="25"
									name="emp.password" regr="^[\w!@#$%^&*()_]{6,8}$"
									tip="请输入6到8位密码"></s:textfield> <span style="display:none;"><font
									color="green">√</font></span></td>
							<td align="center"><font color="red">*</font>确认密码</td>
							<td><s:textfield name="repassword" type="password" size="25"
									regr="^[\w!@#$%^&*()_]{6,8}$" tip="请按格式输入确认密码"></s:textfield> <span
								style="display:none;"><font color="green">√</font></span></td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td height="30" align="center">电子邮箱</td>
							<td><s:textfield type="text" size="25" name="emp.email"
									reg="^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$"
									tip="请按邮箱格式输入"></s:textfield> <span style="display:none;"><font
									color="green">√</font></span>
							<td align="center">电话号码</td>
							<td><s:textfield type="text" name="emp.tel" size="25"
									reg="^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$"
									tip="请按手机号格式输入"></s:textfield> <span style="display:none;"><font
									color="green">√</font></span></td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td height="30" align="center"><font color='red'>*</font>性&nbsp;&nbsp;&nbsp;&nbsp;别</td>
							<td><s:select list="#{1:'男',2:'女' }" name="emp.gender"
									cssClass="kuan"></s:select></td>
							<td align="center">地&nbsp;&nbsp;&nbsp;&nbsp;址</td>
							<td><s:textfield type="text" name="emp.address" size="25"
									reg="^[\u4e00-\u9fa5]{2,50}$" tip="请输入50字以内的中文"></s:textfield>
								<span style="display:none;"><font color="green">√</font></span>
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td height="30" align="center">出生日期</td>
							<td><input type="text" size="25" name="emp.birthday"
								onfocus="c.showMoreDay=false;c.show(this);" readonly="true" /></td>
							<td align="center"><font color='red'>*</font>所属部门</td>
							<td><s:select list="#dList" cssClass="kuan" name="emp.depId"
									listKey="depId" listValue="name"></s:select></td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td colspan="4">&nbsp;</td>
						</tr>
					</table>
				</div>
				<div class="order-botton">
					<div style="margin:1px auto auto 1px;">
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td><a href="javascript:document.forms[0].submit()"><img
										src="${path}/images/order_tuo.gif" border="0" /></a></td>
								<td>&nbsp;</td>
								<td><a href="#"><img src="${path}/images/order_tuo.gif"
										border="0" /></a></td>
								<td>&nbsp;</td>
								<td><a href="#"><img src="${path}/images/order_tuo.gif"
										border="0" /></a></td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
		<!--"square-order"end-->
	</div>
	<!--"content-text"end-->
	<div class="content-bbg">
		<img src="${path}/images/content_bbg.jpg" />
	</div>
</div>
