<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#query").click(function() {
			//提交后将pageNum回置
			$("#pageNum").val(1);
			$("#DepQueryForm").submit();
		});
		$("#addDepButton").click(function() {
			var diag = new Dialog();
			diag.Width = 850;
			diag.Height = 400;
			diag.Title = "设定了高宽和标题的普通窗口";
			diag.URL = "test.html";
			diag.show();
		});

	});
	function showMsg(msg, uuid) {
		//top.document.getElementById("context-msg").style.display = "block";
		top.$('context-msg').style.display = "block";
		top.$('context-msg-text').innerHTML = msg;
		top.$('hid-action').value = "actionName";
		top.lock.show();
	}
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">部门管理</span>
		</div>
	</div>
	<div class="content-text">
		<form action="${path }/dep_list" method="post" id="DepQueryForm">
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td width="68" height="30">&nbsp;&nbsp;&nbsp;</td>
						<td width="123">&nbsp;</td>
						<td width="62">部门名称:</td>
						<td width="142"><s:textfield type="text" size="18"
								name="query.name"></s:textfield></td>
						<td width="60">电话:</td>
						<td width="149"><s:textfield type="text" size="18"
								name="query.tel"></s:textfield></td>
						<td width="70"><a id="query"> <img
								src="${path}/images/can_b_01.gif" border="0" />
						</a></td>
						<td width="70"><a id="addDepButton" href="javascript:void(0)"><img
								src="${path}/images/can_b_02.gif" border="0" /> </a></td>
					</tr>
				</table>
			</div>
			<!--"square-o-top"end-->
			<div class="square-order">
				<table width="100%" border="1" cellpadding="0" cellspacing="0">
					<tr align="center"
						style="background:url(${path}/images/table_bg.gif) repeat-x;">
						<td width="13%" height="30">编号</td>
						<td width="13%">部门名称</td>
						<td width="16%">电话</td>
						<td width="16%">操作</td>
					</tr>
					<s:iterator value="#page.list" var="dep">
						<tr align="center" bgcolor="#FFFFFF">
							<td width="13%" height="30"><s:property value="#dep.depId" /></td>
							<td><s:property value="#dep.name" /></td>
							<td><s:property value="#dep.tel" /></td>
							<td><img src="${path}/images/icon_3.gif" /> <span
								style="line-height:12px; text-align:center;"> <a
									href="input.jsp" class="xiu">修改</a>
							</span> <img src="${path}/images/icon_04.gif" /> <span
								style="line-height:12px; text-align:center;"> <a
									href="javascript:void(0)" class="xiu"
									onclick="showMsg('是否删除该项数据？当前部门删除后，所有部门内的员工将被删除，同时相关数据也将删除！',318)">删除</a>
							</span></td>
						</tr>
					</s:iterator>
				</table>
				<jsp:include page="../tools/paging.jsp"></jsp:include>
			</div>
		</form>
	</div>
	<div class="content-bbg"></div>
</div>
