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
    <title>网络考试系统-查看错题</title>
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
                <li><a href="user?cmd=paperlist">试题列表</a></li>
                <li class="active"><a href="user/studPaper?cmd=studpaper">查看错题</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
					<c:when test="${user!=null}">
						<li><a><c:out  value="${sessionScope.user.sname}"/></a></li>
						<li>
		                    <a href="user?cmd=logout">注销</a>
		                </li>
					</c:when>
					<c:otherwise>
						<li><a href="login.jsp">登录</a></li>
					</c:otherwise>
				</c:choose>
                
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>

    <main class="container">
        <div class="panel panel-default">
			<div class="panel-heading text-center">
				<h3 class="panel-title">查看错题</h3>
			</div>
			<div class="panel-body">
				<div class="well">
					<table class="table">
						<thead>
							<tr>
								<th>试题名称</th>
								<th>错题数目</th>
								<th>得分</th>
								<th>做题时间</th>
								<th style="width: 90px;">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${papers}" var="item">
								<tr>
									<td>${item.pname}</td>
									<td>${item.errorcount}</td>
									<td>${item.rightcount*2}</td>
									<td class="times" data-time = ${item.spid}>${item.spid}</td>
									<td>
										<a href="user/studPaper?cmd=listpaper&uid=${item.sid}&spid=${item.spid}&pname=${item.pname}">查看详情</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
    </main>
    <script>
    // 获取basePath 
    var basePath = '<%=basePath%>'
    $(function(ev) {
        var len = $('.subject').length;
        $('.subject').each(function(index){
        var i = index
        var self = $(this)
        
        self.find('label').each(function(){
        	var label = $(this)
        	if(self.data('key')==label.data('value')){
        		label.parent().addClass('correct')
        	}
        	if(self.data('ekey')==label.data('value')){
        		label.parent().addClass('error')
        	}
        })
        })
    })
    
    function p(n){
		return n<10?'0'+n:n;
	}
    $(function(){
    	$('.times').each(function(){
    		var self = $(this);
    		var date = new Date(self.data('time'))
    		var y=date.getFullYear()
    		var mon=date.getMonth()+1
    		var d =date.getDate()
    		var h=date.getHours()
			var m=date.getMinutes()
			self.html(y+'年'+mon+'月'+d+'日'+p(h)+'时'+p(m)+'分');
    	})
    })
    </script>
</body>

</html>