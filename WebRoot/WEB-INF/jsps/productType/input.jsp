<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp" %>
<script type="text/javascript">
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
			<span class="page_title">商品类别管理</span>
		</div>
	</div>
	<div class="content-text">
		<div class="square-order">
			<form action="ajax_productType_add" method="post">
  			<div style="border:1px solid #cecece;">
				<table width="100%"  border="0" cellpadding="0" cellspacing="0">
				  <tr bgcolor="#FFFFFF">
				    <td>&nbsp;</td>
				  </tr>
				</table>
				<table width="100%"  border="0" cellpadding="0" cellspacing="0">
				    <tr  bgcolor="#FFFFFF">
				      <td width="18%" height="30" align="center">供应商</td>
				      <td width="82%" colspan="3">
							<s:select list="#list" name = "productType.supplier.supplierId" cssClass="kuan" listKey="supplierId" listValue="name" headerKey="" headerValue="----请-选-择----"></s:select>
				      </td>
				    </tr>
				    <tr  bgcolor="#FFFFFF">
				      <td colspan="4">&nbsp;</td>
				    </tr>
				    <tr  bgcolor="#FFFFFF">
				      <td width="18%" height="30" align="center">商品类别名称</td>
				      <td width="82%" colspan="3">
				      <s:textfield name="productType.name"></s:textfield>
				      </td>
				    </tr>
				    <tr>
				      <td><s:fielderror></s:fielderror>
				      </td>
					这里有点Bug，好像zdialog不支持请求转发。页面没有实现刷新，但是还是完成了
					validate
				    </tr>
				    <tr  bgcolor="#FFFFFF">
				      <td colspan="4">&nbsp;</td>
				    </tr>
				    <tr>
				    </tr>
				</table>
			</div>
			</form>
		</div>
	</div>
</div>
