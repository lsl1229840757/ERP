<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../taglibs.jsp" %>
<head>
	<script type="text/javascript">
		function getText(){
			var area = $("#auditText");
			return area.val();
		}
	
	</script>
</head>

<div>
	<textarea rows="8" cols="50" id="auditText"></textarea>
</div>
