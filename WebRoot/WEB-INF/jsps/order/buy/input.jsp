<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../taglibs.jsp" %>
<script type="text/javascript">
	//修改供应商
	$(function() {
		//添加add点击事件
		$("#add").click(function(){
			var tr = $("#defaultTr").clone(true);//带事件的克隆
			tr.find(".goods").empty();
			$("#finalTr").before(tr);
		});
	
		$("#supplierSelect").change(function(){
			var pro = $("#defaultTr").find(".goodsType"); //此处存在bug
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
				}
			});
			$(this).attr("disabled","diabled");
		});
		
		$(".goods").change(function(){
			var tableObj = $(this).parent().parent().parent();
			var nowProductId = $(this).val();
			//注意这里tableObj在find之后 也会把自己找到
			var count = 0; 
			tableObj.find(".goods").each(function(){
				if(nowProductId==$(this).val()){
					count++;
				}
			});
			if(count==2){
				Dialog.alert("该商品已经存在！");
				$(this).find("[value="+nowProductId+"]").remove();
			}
		});
		$(".goodsType").change(function(){
			var trObj = $(this).parent().parent();
			var pro = trObj.find(".goods");
			pro.empty();
			//二级联动发送ajax
			$.ajax({
				url:"${path}/ajax_productType_getProduct",
				data:{
					"query.productTypeId" :trObj.find(".goodsType").val()
				},
				type:"post",
				dataType:"json",
				async: false,
				success:function(jsonArr){
					for(i = 0;i<jsonArr.length;i++){
						//防止生成数据的时候出现相同的商品
						var isExit = false;
						trObj.parent().find(".goods").each(function(){//多次dom操作可以改进
							var productId = $(this).val();
							if(jsonArr[i].productId+"" == productId){
								isExit = true;
								return;
							}					
						});
						if(!isExit){
							pro.append("<option value='"+jsonArr[i].productId+"'>"+jsonArr[i].name+"</option>");
						}
					}
				},
				error:function(){
					alert("XmlRequest Error!");
				}
			});
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
							<s:select id="supplierSelect" headerKey="" headerValue="请选择" list="#suppliers" cssClass="kuan" cssStyle="width:300px;" listKey="supplierId" listValue="name"></s:select>
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
					<tr id="defaultTr" align="center" bgcolor="#FFFFFF">
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
