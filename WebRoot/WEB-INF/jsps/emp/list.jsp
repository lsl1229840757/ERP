<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../taglibs.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#query").click(function() {
			$("#pageNum").val(1);
			$("#EmpQueryForm").submit();
		});

		$("#addEmpButton").click(function() {
			var diag = new Dialog();
			diag.Width = 850;
			diag.Height = 450;
			diag.Title = "添加员工";
			diag.URL = path+"/emp_input";
			diag.OKEvent = function(){
			//调用子页面的bom对象
				var bom = diag.innerFrame.contentWindow;
				//提交表单,加验证			
				if(bom.submitForm()=="success"){
					//提交表单成功!
					diag.close();
					window.location.href = "${path}/emp_list";
				}
			};
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
	
	function update(userId){
		var diag = new Dialog();
			diag.Width = 850;
			diag.Height = 450;
			diag.Title = "修改员工";
			diag.URL = path+"/emp_update?emp.empId="+userId;
			diag.OKEvent = function(){
			alert("点击！");
			//调用子页面的bom对象
				var bom = diag.innerFrame.contentWindow;
				//提交表单,加验证			
				if(bom.submitForm()=="success"){
					//提交表单成功!
					diag.close();
					window.location.href = "${path}/emp_list";
				}
			};
			diag.show();
	}
	
	function grantRole(userId){
		var diag = new Dialog();
			diag.Width = 850;
			diag.Height = 450;
			diag.Title = "分配角色";
			diag.URL = path+"/emp_listpop?emp.empId="+userId;
			diag.OKEvent = function(){
				var bom = diag.innerFrame.contentWindow;
				if(bom.gRole(userId)=="yes"){
					diag.close();
					Dialog.alert("设置角色成功!");
					//提交表单成功!
					window.location.href = "${path}/emp_list";
				}else{
					Dialog.alert("无法将角色置空!");
				}				
			};
			diag.show();
	}
	
	function deleteEmp(empId){
		Dialog.confirm('警告：您确认要删除吗？',
		function(){
			//这里使用重定向来访问
			window.location = "${path}/emp_delete?emp.empId="+empId;
		});
	}
	
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">员工管理</span>
		</div>
	</div>
	<div class="content-text">
		<form action="${path }/emp_list" method="post" id="EmpQueryForm">
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td height="30">用&nbsp;户&nbsp;名</td>
						<td>
							<!-- 	<input type="text" size="14" /> --> <s:textfield
								name="query.username" type="text" size="14"></s:textfield>
						</td>
						<td>真实姓名</td>
						<td>
							<!-- <input type="text" size="14" /> --> <s:textfield
								name="query.name" type="text" size="14"></s:textfield>
						</td>
						<td>电&nbsp;&nbsp;&nbsp;&nbsp;话</td>
						<td>
							<!-- <input type="text" size="14" /> --> <s:textfield
								name="query.tel" type="text" size="14"></s:textfield>
						</td>
						<td>性&nbsp;&nbsp;&nbsp;&nbsp;别</td>
						<td>
							
							<!-- 这里将1换为字符串也可以，struts会自动完成转换 -->
							
							 <s:select name="query.gender" list="#{1:'男',2:'女' }"
								cssClass="kuan" headerKey="" headerValue="----请-选-择----"></s:select>
						</td>

						<td width="70"><a id="addEmpButton" href="javascript:void(0)"> <img
								src="${path}/images/can_b_02.gif" border="0" />
						</a></td>
					</tr>
					<tr>
						<td height="30">电子邮件</td>
						<td><input name="query.email" type="text" size="14" /></td>
						<td>出生日期</td>
						<td>
							<!-- <input type="text"  size="14" onfocus="c.showMoreDay=false;c.show(this);" readonly="true"/> -->
							<s:textfield name="query.startBirthday" type="text" size="14"
								onfocus="c.showMoreDay=false;c.show(this);" readonly="true"></s:textfield>
						</td>
						<td>出生日期</td>
						<td>
							<!-- <input type="text" size="14" onfocus="c.showMoreDay=false;c.show(this);" readonly="true"/> -->
							<s:textfield name="query.endBirthday" type="text" size="14"
								onfocus="c.showMoreDay=false;c.show(this);" readonly="true"></s:textfield>
						</td>
						<td>部门名称</td>
						<td>
							<!-- 
								<select class="kuan">
								<option value="-1">----请-选-择----</option>
								<option value="1">销售部</option>
								<option value="2">采购部</option>
							</select> --> <s:select name="query.depId" list="#dList"
								cssClass="kuan" listKey="depId" listValue="name" headerKey=""
								headerValue="----请-选-择----"></s:select>
						</td>
						<td><a id="query"> <img src="${path}/images/can_b_01.gif"
								border="0" />
						</a></td>
					</tr>
				</table>
			</div>
			<!--"square-o-top"end-->
			<div class="square-order">
				<table width="100%" border="1" cellpadding="0" cellspacing="0">
					<tr align="center"
						style="background:url(${path}/images/table_bg.gif) repeat-x;">
						<td width="10%" height="30">用户名</td>
						<td width="7%">真实姓名</td>
						<td width="5%">性别</td>
						<td width="12%">出生日期</td>
						<td width="10%">电话</td>
						<td width="12%">电子邮件</td>
						<td width="9%">所属部门</td>
						<td width="19%">操作</td>
					</tr>
					<s:iterator value="#page.list" var="emp">
						<tr align="center" bgcolor="#FFFFFF">
							<td width="13%" height="30"><s:property
									value="#emp.username" /></td>
							<td><s:property value="#emp.name" /></td>
							<td><s:property value="#emp.gender==1?'男':'女'" /></td>
							<td><s:date name="#emp.birthday" format="yyyy-dd-MM" /></td>
							<td><s:property value="#emp.tel" /></td>
							<td><s:property value="#emp.email" /></td>
							<td><s:property value="#emp.dep.name" /></td>
							
							<td><img src="${path}/images/icon_3.gif" /> <span
								style="line-height:12px; text-align:center;"> <a
									href="javascript:void(0);" onclick="grantRole(<s:property value="#emp.empId"/>)" class="xiu">分配角色</a>
							</span> 
							
							<img src="${path}/images/icon_3.gif" /> <span
								style="line-height:12px; text-align:center;"> <a
									href="javascript:void(0);" onclick="update(<s:property value="#emp.empId"/>)" class="xiu">修改</a>
							</span>
							
							<img src="${path}/images/icon_04.gif" /> <span
								style="line-height:12px; text-align:center;"> <a
									href="javascript:void(0)" class="xiu"
									onclick="deleteEmp(<s:property value='#emp.empId'/>)">删除</a>
							</span></td>
						</tr>
					</s:iterator>
				</table>
				<!-- 放入web-Inf下面之后就不能直接使用path定位绝对路径了 -->
				<jsp:include page="../tools/paging.jsp"></jsp:include>
			</div>
		</form>
	</div>
	<div class="content-bbg"></div>
</div>
<s:debug></s:debug>
