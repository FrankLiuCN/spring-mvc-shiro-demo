<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>shiro-demo</title>
		<link   rel="icon" href="http://img.wenyifan.net/images/favicon.ico" type="image/x-icon" />
		<meta charset="utf-8" />
    	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />	
		<link href="<%=basePath%>/libs/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
		<script  src="<%=basePath%>/libs/jquery-3.1.1.min.js"></script>
		<script  src="<%=basePath%>/libs/bootstrap-3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="common/head.jsp" %>
	主页
</body>
</html>