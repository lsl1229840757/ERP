<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp" %>
<script type="text/javascript">
	$(function() {
		$("#addProduct").click(function(){
			var diag = new Dialog();
			diag.Width = 850;
			diag.Height = 450;
			diag.Title = "商品添加";
			diag.URL = path+"/product_input";
			diag.OKEvent = function(){
			//调用子页面的bom对象
				var bom = diag.innerFrame.contentWindow;
				//提交表单,加验证			
				if(bom.submitForm()=="success"){
					//提交表单成功!
					diag.close();
					window.location.href = "${path}/product_list";
				}
			};
			diag.show();
		});
	
	
		$("#query").click(function() {
			$("form:first").submit();
		});
	});
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">商品管理</span>
		</div>
	</div>
	<div class="content-text">
		<form action="${path }/product_list" method="post"> 
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td>供应商:</td>
						<td>
							<s:select list="#list" cssStyle="width:113px" name="query.supplierId" headerKey="" headerValue="----请-选-择----" listKey="supplierId" listValue="name"></s:select>
						</td>
						<td height="30">商&nbsp;品&nbsp;名</td>
						<td><s:textfield size="14" name = "query.name"></s:textfield></td>
						<td>生产厂家</td>
						<td><s:textfield size="14" name = "query.producer"></s:textfield></td>
						<td>单&nbsp;&nbsp;&nbsp;&nbsp;位</td>
						<td><s:textfield size="14" name = "query.unit"></s:textfield></td>
						<td width="70"><a href="javascript:void(0);"><img src="${path}/images/can_b_02.gif" border="0"  id = "addProduct"/> </a></td>
					</tr>
					<tr>
						<td height="30">进货价格</td>
						<td><s:textfield size="14" name = "query.minInPrice"></s:textfield></td>
						<td>到</td>
						<td><s:textfield size="14" name = "query.maxInPrice"></s:textfield></td>
						<td height="30">销售价格</td>
						<td><s:textfield size="14" name = "query.minOutPrice"></s:textfield></td>
						<td>到</td>
						<td><s:textfield size="14" name = "query.maxOutPrice"></s:textfield></td>
						<td><a id="query"> <img src="${path}/images/can_b_01.gif" border="0" /> </a></td>
					</tr>
				</table>
			</div>
			<!--"square-o-top"end-->
			<div class="square-order">
				<table width="100%" border="1" cellpadding="0" cellspacing="0">
					<tr align="center"
						style="background:url(${path}/images/table_bg.gif) repeat-x;">
						<td width="12%" height="30">供应商</td>
						<td width="12%">商品名</td>
						<td width="12%">生产厂家</td>
						<td width="12%">产地</td>
						<td width="12%">进货价格</td>
						<td width="12%">销售价格</td>
						<td width="12%">单位</td>
						<td width="16%">操作</td>
					</tr>
						<s:iterator value="#page.list" var="p">
							<tr align="center" bgcolor="#FFFFFF">
								<td width="13%" height="30"><s:property value="#p.productType.supplier.name"/></td>
								<td><s:property value="#p.name"/></td>
								<td><s:property value="#p.producer"/></td>
								<td><s:property value="#p.origin"/></td>
								<td align="right"><s:property value="#p.inPrice"/>&nbsp;元&nbsp;</td>
								<td align="right"><s:property value="#p.outPrice"/>&nbsp;元&nbsp;</td>
								<td><s:property value="#p.unit"/></td>
								<td>
									<img src="${path}/images/icon_3.gif"/> 
									<span style="line-height:12px; text-align:center;"> 
										<a href="./input.jsp" class="xiu">修改</a> 
									</span> 
									<img src="${path}/images/icon_04.gif" /> 
									<span style="line-height:12px; text-align:center;"> 
										<a href="javascript:void(0)" class="xiu" onclick="showMsg('是否删除该项数据？',318)">删除</a>
									</span>
								</td>
							</tr>
						</s:iterator>
				</table>
				<jsp:include page="../tools/paging.jsp"></jsp:include>
			</div>
		</form>
	</div>
	<div class="content-bbg"></div>
</div>
