<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="../taglibs.jsp" %>
<script type="text/javascript">
	$(function() {
		$("#query").click(function() {
			$("[name='pageNum']").val(1);
			$("form:first").submit();
		});
	});
	function showMsg(msg,uuid){
		//top.document.getElementById("context-msg").style.display = "block";
		top.$('context-msg').style.display = "block";
		top.$('context-msg-text').innerHTML=msg;
		top.$('hid-action').value="actionName";
		top.lock.show();
	}
	
	function gRole(empId){
		var selects = '';
		var result = '';
		$("tr input:checked").each(function(){
			selects = selects+$(this).val()+",";
		});
		
		if(selects!=''){
			$.ajax({
				url:"${path}/ajax_emp_grantRoles?emp.empId="+empId,
				data:{
					"roleIds":selects
				},
				dataType:"text",
				async:false,
				success:function(responseText){
					result = responseText;
				},
				error:function(){
				alert("XmlHttpRequest Error!");
			}
			});
		}
		return result
	}
	
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">角色管理</span>
		</div>
	</div>
	<div class="content-text">
		<form action="${page }/role_list" method="post"> 
			<!--"square-o-top"end-->
			<div class="square-order">
				<table width="100%" border="1" cellpadding="0" cellspacing="0">
					<tr align="center"
						style="background:url(${path}/images/table_bg.gif) repeat-x;">
						<td width="20%">选择</td>
						<td width="40%" height="30">角色名称</td>
						<td width="40%">角色编码</td>
					</tr>
					<s:iterator value="#roles" var="role">
						<tr align="center" bgcolor="#FFFFFF">
						<td height="30"><input type="checkbox" <s:if test="#role.select=='yes'" >checked</s:if> value="<s:property value='#role.roleId'/>"></td>
						<td height="30"><s:property value="#role.name"/></td>
						<td><s:property value="#role.code"/></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</form>
	</div>
	<div class="content-bbg"></div>
</div>
