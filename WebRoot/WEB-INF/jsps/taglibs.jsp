<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- 定义绝对路径的变量 -->
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- EL可以直接引入jstl的变量 -->
<link href="${path }/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	//定义js可以访问的全局变量
	var path = "${path }";
</script>
<script type="text/javascript" src="${path }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path }/js/jquery.form.js"></script>
<!-- 引入calendar的js -->
<script type="text/javascript" src="${path }/js/Calendar.js"></script>
<script type="text/javascript" src="${path }/js/zdialog/zDialog.js"></script>
<script type="text/javascript" src="${path }/js/zdialog/zDrag.js"></script>
</head>
<body>
</body>
</html>
