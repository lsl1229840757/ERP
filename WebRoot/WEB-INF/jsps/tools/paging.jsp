<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "../taglibs.jsp" %>	
<script type="text/javascript">
	$(function() {
		//获得总页数
		var cPageNum = parseInt($("#cPageNum").val());
		var totalPage = parseInt($("#totalPage").val());
		if (cPageNum >= 1 && cPageNum <= totalPage) {
			if (cPageNum == totalPage) {
				$("#next").hide();
				$("#pre").show();
				$("#fir").show();
				$("#last").hide();
				if (cPageNum == 1) {
					$("#next").hide();
					$("#pre").hide();
					$("#fir").hide();
					$("#last").hide();
				}
			} else if (cPageNum < totalPage) {
				$("#next").show();
				$("#pre").show();
				$("#fir").show();
				$("#last").show();
				if (cPageNum == 1) {
					$("#next").show();
					$("#pre").hide();
					$("#fir").hide();
					$("#last").show();
				}
			}
		}

		$("#next").click(function() {
			$("#pageNum").val(cPageNum + 1);
			$("form:first").submit();
		});
		$("#pre").click(function() {
			$("#pageNum").val(cPageNum - 1);
			$("form:first").submit();
		});
		$("#fir").click(function() {
			$("#pageNum").val(1);
			$("form:first").submit();
		});
		$("#last").click(function() {
			$("#pageNum").val(totalPage);
			$("form:first").submit();
		});
		
		$("#jump").click(function(){
			var selectPageNum = $("#selectPageNum").val();
			var regex = /^\d{1,}$/;
			if(regex.test(selectPageNum)){
				selectPageNum = parseInt(selectPageNum);
				if((selectPageNum >= 1) && (selectPageNum <= totalPage)){
					$("#pageNum").val(selectPageNum);
					$("form:first").submit();
				}else{
					Dialog.alert("请输入1到"+totalPage+"的数字!");
				}
			}else{
				Dialog.alert("请输入1到"+totalPage+"的数字!");
			}
		});
	});
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="40%">&nbsp;</td>
		<td>共<s:property value="#page.totalCount" />条记录
		<td><a id="fir" class="sye">首&nbsp;&nbsp;页</a></td>
		<td><a id="pre" class="sye">上一页</a></td>
		<td><a id="next" class="sye">下一页</a></td>
		<td><a id="last" class="sye">末&nbsp;&nbsp;页</a></td>
		<td><input type="text" id="selectPageNum" size="1" value='<s:property value="#page.pageNum" />'></td>		
		<td><input type="button" id="jump" value="跳转"></td>
		<td>当前第<span style="color:red;"><s:property
					value="#page.pageNum" /></span>/<s:property value="#page.totalPage"/>页
		</td>
	</tr>
		<!-- 添加隐藏域，记录当前页数 --> 
		<input type="hidden" id="cPageNum" name="cPageNum" value='<s:property value="#page.pageNum"/>'>
		<input type="hidden" id="totalPage" name="totalPage" value='<s:property value="#page.totalPage"/>'>
		<input type="hidden" id="pageNum" name="query.pageNum" value="<s:property value="#page.pageNum"/>">
</table>