<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../taglibs.jsp" %>
<script type="text/javascript">
	
	
	function syntronizeTrTotal(trObj){
		var price = parseInt(trObj.find(".prices").val());	
		var num = parseInt(trObj.find(".num").val());
		var trPrice = trObj.find(".total");
		trPrice.html(num*price+"&nbsp元");
		trPrice.attr("trPrice",num*price);
	}
	
	function syntronizeAllTotal(trObj){
		var table = trObj.parent();
		var totalPrice = 0;
		table.find(".total").each(function(){
			var trPrice = parseInt($(this).attr("trPrice"));
			totalPrice += trPrice;
		});
		table.find(".all").html(totalPrice+"&nbsp元");
	}
		//加载商品类别
		function loadPtType(trObj){
				//二级联动发送ajax
			var pro = trObj.find(".goodsType");	
			pro.empty();
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
			});
			loadPt(trObj);
		}
		// 加载商品
		function loadPt(trObj){
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
					loadPtDetail(trObj);
				},
			});
		}
		//加载商品的详细信息
		function loadPtDetail(trObj){
			var theSelect = trObj.find(".goods"); 
			var tableObj = trObj.parent();
			var nowProductId = theSelect.val();
			//注意这里tableObj在find之后 也会把自己找到
			var count = 0; 
			tableObj.find(".goods").each(function(){
				if(nowProductId==$(this).val()){
					count++;
				}
			});
			if(count==2){
				Dialog.alert("该商品已经存在！");
				theSelect.find("[value="+nowProductId+"]").remove();
			}else{
			//正常情况
			//发送ajax请求价格
			$.ajax({
				url:"${path}/ajax_product_getProduct",
				data:{
					"query.productId" : nowProductId
				},
				type:"post",
				dataType:"json",
				async: false,
				success:function(jsonObj){
					trObj.find(".prices").val(jsonObj.inPrice);
					syntronizeTrTotal(trObj);
					syntronizeAllTotal(trObj);
				},
			});		
			}
		}

	function submitOrder(){
		//这里不能直接使用表单提交,使用ajax提交表单
		var result = "";
		$("form:first").ajaxSubmit({
			async:false,
			dataType:"text",
			success:function(responseText){
				//后台添加成功就返回success
				result = responseText;
			},
			error:function(responseText){
				console.log(responseText);
			}
		});
		return result;
	}


	//修改供应商
	$(function() {
		//删除事件注册,这里第一行是无法删除的
		$(".deleteBtn").click(function(){
			var trObj = $(this).parent().parent();
			if(trObj.attr("id") != "defaultTr"){
				var prev = trObj.prev();
				trObj.remove();
				syntronizeAllTotal(prev);
			}else{
				Dialog.alert("第一行无法删除!");			
			}
		});
	
		$(".num").keyup(function(){
			var trObj = $(this).parent().parent();		
			syntronizeTrTotal(trObj);
			syntronizeAllTotal(trObj);
		});
		$(".prices").keyup(function(){
			var trObj = $(this).parent().parent();		
			syntronizeTrTotal(trObj);
			syntronizeAllTotal(trObj);
		});
		//添加add点击事件
		$("#add").click(function(){
			var tr = $("#defaultTr").clone(true);//带事件的克隆
			tr.removeAttr("id"); //删除新建的tr的id属性
			tr.find(".goods").empty();
			tr.find(".prices").attr("value","");
		
			//loadPtType(tr);
			
			$("#finalTr").before(tr);
			loadPtType(tr); // BUG 这里只能放在最后，此时tr才会有父元素
		});
	
		$("#supplierSelect").change(function(){
			//加载商品Type
			loadPtType($("#defaultTr"));
			$(this).attr("disabled","diabled"); //disabled的数据后台是无法接受的
			$("#supplierIdHiden").val($(this).val());
		});
		
		$(".goods").change(function(){
			loadPtDetail($(this).parent().parent());
		});
		$(".goodsType").change(function(){
			var trObj = $(this).parent().parent();
			loadPt(trObj);		
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
		<form action="${path}/ajax_orderModel_submitOrder" method="post">
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td width="68px" height="30">供应商：</td>
						<td width="648px">
							<s:select id="supplierSelect" headerKey="" headerValue="请选择" list="#suppliers" cssClass="kuan" cssStyle="width:300px;" listKey="supplierId" listValue="name"></s:select>
							<input id="supplierIdHiden" type="hidden" name="order.supplierId"/><!--  <--后台接受的supplierId--> -->
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
							<select name="productType" id="productType" class="goodsType" style="width:200px">
							</select>
						</td>
						<td>
							<select name="productId" id="product" class="goods" style="width:200px">
							</select>
						</td>
						<td><input name="detailNum" class="num order_num" style="width:67px;border:1px solid black;text-align:right;padding:2px" type="text" value="1"/></td>
						<td><input name="detailPrice" class="prices order_num" style="width:93px;border:1px solid black;text-align:right;padding:2px" type="text" value="100"/> 元</td>
						<td class="total" trPrice="100" align="right">100.00&nbsp;元</td>
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
		</form>
	</div>
	
	<div class="content-bbg"></div>
</div>
