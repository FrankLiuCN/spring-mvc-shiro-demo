<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">spring-mvc-shiro-demo</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">首页</a></li>
				<li><a href="user/list">用户列表</a></li>
			</ul>

			<shiro:user>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><shiro:principal/></a></li>
					<li><a href="logout">注销</a></li>
				</ul>
			</shiro:user>
		</div>
	</div>
</nav>