<%@ page language="java" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8" />
	<title>login</title>
	<link   rel="icon" href="http://img.wenyifan.net/images/favicon.ico" type="image/x-icon" />
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
	<link href="<%=basePath%>/libs/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet" />
	<link href="<%=basePath%>/css/login.css" rel="stylesheet" />
	<script src="<%=basePath%>/libs/jquery-3.1.1.min.js"></script>
	<script src="<%=basePath%>/libs/bootstrap-3.3.0/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		var basePath="<%=basePath%>";
		$(function() {
			$("#txtSubmit").click(function() {
				login();
			});
		});
	
		function login() {
			$.post(basePath + "/login", {
				userName : $("#txtUserName").val(),
				password : $("#txtPassword").val()
			}, function(result) {
				if (result.status == "200") {
					window.location.href = result.back_url;
				} else {
					alert(result.message);
				}
			});
		}
	</script>
</head>
<body>
	<div class="panel panel-primary login-box">
		<div class="panel-heading">登录</div>
		<div class="panel-body">
			<div class="form-group">
				<label for="txtUserName">登录名：</label> <input type="text"
					class="form-control" id="txtUserName" placeholder="请输入登录名">
			</div>
			<div class="form-group">
				<label for="txtPassword">密码：</label> <input type="password"
					class="form-control" id="txtPassword" placeholder="请输入密码">
			</div>
			<div class="checkbox">
				<label> <input type="checkbox"> 记住我
				</label>
			</div>
			<button type="submit" class="btn btn-primary" id="txtSubmit">登录</button>
			<div id="loginResult"></div>
		</div>
	</div>
</body>
</html>