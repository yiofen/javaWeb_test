<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>

<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<title>网络考试系统-考生界面</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/paper.css">
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/bootstrap.js"></script>
</head>

<body>
	<nav class="navbar navbar-default" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<span class="navbar-brand">网络考试系统</span>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="user?cmd=paperlist">试题列表</a></li>
				<li><a href="user/studPaper?cmd=studpaper">查看错题</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${user!=null}">
						<li>
							<a>
								<c:out value="${sessionScope.user.sname}" />
							</a>
						</li>
						<li><a href="user?cmd=logout">注销</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="login.jsp">登录</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>

	<main class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h3 class="panel-title">查看试题</h3>
			</div>
			<div class="panel-body">
				<div class="well">
					<table class="table">
						<thead>
							<tr>
								<th>试题名称</th>
								<th>题目数量</th>
								<th style="width: 90px;">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${papers}" var="item">
								<tr>
									<td>${item.pname}</td>
									<td>${item.ecount}</td>
									<td>
										<a href="user?cmd=paper&pname=${item.pname}">开始答题</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>

</body>

</html>