<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../taglibs.jsp" %>
<script type="text/javascript">
	//修改供应商
	$(function() {
		$("#supplierSelect").change(function(){
			var pro = $("#productType");
			pro.empty();
			//二级联动发送ajax
			$.ajax({
				url:"${path}/ajax_product_changeSupplier",
				data:{
					"query.supplierId" : $("#supplierSelect").val()
				},
				type:"post",
				dataType:"json",
				async: false,
				success:function(jsonArr){
					for(i = 0;i<jsonArr.length;i++){
					pro.append("<option value='"+jsonArr[i].productTypeId+"'>"+jsonArr[i].name+"</option>")
					}
				},
				error:function(jsonArr){
					alert("XmlRequest Error!");
					alert(Object.keys(jsonArr));
					alert(jsonArr.status);
					console.log(jsonArr.responseText);
				}
			});
			$(this).attr("disabled","diabled");
		});
		
		$("#productType").change(function(){
			var pro = $("#product");
			pro.empty();
			//二级联动发送ajax
			$.ajax({
				url:"${path}/ajax_productType_getProduct",
				data:{
					"query.productTypeId" : $("#productType").val()
				},
				type:"post",
				dataType:"json",
				async: false,
				success:function(jsonArr){
					for(i = 0;i<jsonArr.length;i++){
					pro.append("<option value='"+jsonArr[i].productTypeId+"'>"+jsonArr[i].name+"</option>")
					}
				},
				error:function(){
					alert("XmlRequest Error!");
				}
			});
			$(this).attr("disabled","diabled");	
		});
	});
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">订单管理</span>
		</div>
	</div>
	<div class="content-text">
		<form action="buyList.jsp" method="post">
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td width="68px" height="30">供应商：</td>
						<td width="648px">
							<s:select id="supplierSelect" list="#suppliers" cssClass="kuan" cssStyle="width:300px;" listKey="supplierId" listValue="name"></s:select>
						</td>
						<td height="30">
							<a id="add"><img src="${path}/images/can_b_02.gif" border="0" /> </a>
						</td>
					</tr>
				</table>
			</div>
			<!--"square-o-top"end-->
			<div class="square-order">
				<table id="order" width="100%" border="1" cellpadding="0" cellspacing="0">
					<tr align="center"
						style="background:url(${path}/images/table_bg.gif) repeat-x;">
						<td width="25%" height="30">商品类别</td>
						<td width="25%">商品名称</td>
						<td width="10%">采购数量</td>
						<td width="15%">单价</td>
						<td width="15%">合计</td>
						<td width="10%">操作</td>
					</tr>
					<tr align="center" bgcolor="#FFFFFF">
						<td height="30">
							<select id="productType" class="goodsType" style="width:200px">
							</select>
						</td>
						<td>
							<select id="product" class="goods" style="width:200px">
							</select>
						</td>
						<td><input name="nums" class="num order_num" style="width:67px;border:1px solid black;text-align:right;padding:2px" type="text" value="1"/></td>
						<td><input name="prices" class="prices order_num" style="width:93px;border:1px solid black;text-align:right;padding:2px" type="text" value="100"/> 元</td>
						<td class="total" align="right">100.00&nbsp;元</td>
						<td>
							<a class="deleteBtn delete xiu" value="4"><img src="${path}/images/icon_04.gif" /> 删除</a>
						</td>
					</tr>
					<tr id="finalTr" align="center"
						style="background:url(${path}/images/table_bg.gif) repeat-x;">
						<td height="30" colspan="4" align="right">总&nbsp;计:&nbsp;</td>
						<td class="all" width="16%" align="right">100.00&nbsp;元</td>
						<td>&nbsp;</td>
					</tr>
				</table>
				<div class="order-botton">
				<div style="margin:1px auto auto 1px;">
					<table width="100%"  border="0" cellpadding="0" cellspacing="0">
					  <tr>
					    <td>
					    	<a href="javascript:void(0)" id="submitOrder"><img src="${path}/images/order_tuo.gif" border="0" /></a>
					    </td>
					    <td>&nbsp;</td>
					    <td><a href="#"><img src="${path}/images/order_tuo.gif" border="0" /></a></td>
					    <td>&nbsp;</td>
					    <td><a href="#"><img src="${path}/images/order_tuo.gif" border="0" /></a></td>
					  </tr>
					</table>
				</div>
			</div>
			</div>
		</form>
	</div>
	
	<div class="content-bbg"></div>
</div>
