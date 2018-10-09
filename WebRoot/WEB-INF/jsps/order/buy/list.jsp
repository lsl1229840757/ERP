<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../taglibs.jsp" %>
<script type="text/javascript">
	$(function() {
		$("#query").click(function() {
			$("form:first").submit();
		});
	});
</script>
<style>
li{
	list-style: none;
	float: left;
	margin-right: 2px;
	padding: 2px;
	border: 2px solid #01E401;
	width: 80px;
	text-align: center;
	font-size: 13px;
}
	
	

</style>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">进货订单管理</span>
		</div>
	</div>
	<div class="content-text">
		<form action="${path }/orderModel_list" method="post"> 
			<input type="hidden" name="query.orderType" value="<s:property value = 'query.orderType'/>">
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td>下单人:</td>
						<td><s:textfield size="14" name="query.creatorName"></s:textfield></td>
						<td>总量:</td>
						<td><s:textfield size="14" name="query.minTotalNum"></s:textfield></td>
						<td>到 </td>
						<td>&nbsp;&nbsp;<s:textfield size="14" name="query.maxTotalNum"></s:textfield></td>
						<td colspan="2"></td>
						<td><a id="query"> 
							<img src="${path}/images/can_b_01.gif" border="0" /> </a>
						</td>
					</tr>
					<tr>
						<td>下单时间:</td>
						<td>
							<input name="query.minCreateTime" type="text" size="14" onfocus="c.showMoreDay=false;c.show(this);" readonly="true"/>
						</td>
						<td>到</td>
						<td>
							<input name="query.maxCreateTime" type="text" size="14" onfocus="c.showMoreDay=false;c.show(this);" readonly="true"/>
						</td>
						<td>总额:</td>
						<td><s:textfield size="14" name="query.minTotalPrice"></s:textfield></td>
						<td>到</td>
						<td>&nbsp;&nbsp;<s:textfield size="14" name="query.maxTotalPrice"></s:textfield></td>
						<td>
							<a href="./buyInput.jsp">
								<img src="${path}/images/can_b_02.gif" border="0" /> 
							</a>
						</td>
					</tr>
				</table>
			</div>
			<!--"square-o-top"end-->
			<div class="square-order">
				<ul>
					<li style="background: #01E401"><a style="text-decoration: none" href='#'>未审核</a></li>	
					<li><a style="text-decoration: none" href='#'>审核通过</a></li>	
					<li><a style="text-decoration: none" href='#'>审核未通过</a></li>	
				</ul>
				
				<table width="100%" border="1" cellpadding="0" cellspacing="0">
					<tr align="center"
						style="background:url(${path}/images/table_bg.gif) repeat-x;">
						<td width="25%" height="30">订单号</td>
						<td width="9%">供应商</td>
						<td width="10%">制单人</td>
						<td width="20%">制单时间</td>
						<td width="10%">订单商品总量</td>
						<td width="12%">订单总金额</td>
						<td width="5%">详情</td>
						<td width="9%">订单状态</td>
					</tr>
					
					<s:iterator value="#page.list" var="order">
						<tr align="center" bgcolor="#FFFFFF">
							<td width="13%" height="30"><s:property value="#order.orderNum"/></td>
							<td><s:property value="#order.supplier.name"/></td>
							<td><s:property value="#order.creatorEmp.name"/></td>
							<td><s:property value="#order.createTime"/></td>
							<td><s:property value="#order.totalNum"/></td>
							<td align="right"><s:property value="#order.totalPrice"/>元</td>
							<td>
								<a href="inDetailList.jsp" class="xiu">详情</a>
							</td>
							<td>未审核</td>
						</tr>
					</s:iterator>
					<%@include file="../../tools/paging.jsp" %>
				</table>
			</div>
		</form>
	</div>
</div>
