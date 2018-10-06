<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../taglibs.jsp" %>
<script type="text/javascript">
	$(function() {
		var pro = $("#pro");
		$("#supplierSelect").change(function(){
			pro.empty();
			pro.append("<option value=''>----请-选-择----</option>")
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
				error:function(){
					alert("XmlRequest Error!");
				}
			});
		});
	});
	
	function submitForm(){
		//成功标志
		var result = "";
		$("form:first").ajaxSubmit({
			async: false,
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
			<span class="page_title">商品管理</span>
		</div>
	</div>
	<div class="content-text">
		<div class="square-order">
			<form action="${path }/ajax_product_add" method="post">
  			<div style="border:1px solid #cecece;">
				<table width="100%"  border="0" cellpadding="0" cellspacing="0">
				  <tr bgcolor="#FFFFFF">
				    <td>&nbsp;</td>
				  </tr>
				</table>
				<table width="100%"  border="0" cellpadding="0" cellspacing="0">
				    <tr  bgcolor="#FFFFFF">
				      <td width="18%" height="30" align="center">供&nbsp;应&nbsp;商</td>
				      <td width="32%">
				      		<s:select name="product.productType.supplier.supplierId" id = "supplierSelect" list="#list" cssStyle="width:190px" headerKey="" headerValue="----请-选-择----" listKey="supplierId" listValue="name"></s:select>
				      </td>
				      <td width="18%"align="center">商品类别</td>
				      <td width="32%">
							 <select name="product.productType.productTypeId" style="width:190px" id="pro">
								<option value="-1">----请-选-择----</option>
							</select>
					  </td>
				    </tr>
				    <tr bgcolor="#FFFFFF">
					  <td colspan="4">&nbsp;</td>
					</tr>
				    <tr  bgcolor="#FFFFFF">
				      <td align="center">商品名称</td>
				      <td>
						<s:textfield size="25" name="product.name"></s:textfield>
				      </td>
				      <td  align="center">产&nbsp;&nbsp;&nbsp;&nbsp;地</td>
				      <td >
				      	<s:textfield size="25" name="product.origin"></s:textfield>
				      </td>
				    </tr>
				     <tr bgcolor="#FFFFFF">
					  <td colspan="4">&nbsp;</td>
					</tr>
				    <tr  bgcolor="#FFFFFF">
				      <td height="30" align="center">生产厂家</td>
				      <td>
				      	<s:textfield size="25" name="product.producer"></s:textfield>
				      <td align="center">单&nbsp;&nbsp;&nbsp;&nbsp;位</td>
				      <td>
				      	<s:textfield size="25" name="product.unit"></s:textfield>
					  </td>
				     </tr>
				    <tr bgcolor="#FFFFFF">
					  <td colspan="4">&nbsp;</td>
					</tr>
				    <tr  bgcolor="#FFFFFF">
				      <td height="30" align="center">进货单价</td>
				      <td>
				      	<s:textfield size="25" name="product.inPrice"></s:textfield>
					  </td>
				      <td align="center">销售单价</td>
				      <td>
				      	<s:textfield size="25" name="product.outPrice"></s:textfield>
					  </td>
				    </tr>
				    <tr bgcolor="#FFFFFF">
					  <td colspan="4">&nbsp;</td>
				     <tr bgcolor="#FFFFFF">
					  <td colspan="4">&nbsp;</td>
					</tr>
				</table>
			</div>
			</form>
		</div><!--"square-order"end-->
	</div><!--"content-text"end-->
	<div class="content-bbg"><img src="${path}/images/content_bbg.jpg" /></div>
</div>
