<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../taglibs.jsp" %>
<div class="content-right">
	<div class="content-text">
			<div class="square-order">
				<table width="100%" border="1" cellpadding="0" cellspacing="0">
					<tr align="center"
						style="background:url(${path}/images/table_bg.gif) repeat-x;">
						<td>审核人</td>
						<td>操作时间</td>
						<td>备注</td>
					</tr>
					<s:iterator value="#logList" var="log">
						<tr align="center" bgcolor="#FFFFFF">
							<td width="13%" height="30"><s:property value="#log.checker.name"/></td>
							<td><s:date name="#log.optTime" format="yyyy-dd-MM"/></td>
							<td><s:property value="#log.note"/></td>
						</tr>
					</s:iterator>
				</table>
			</div>
	</div>
</div>
