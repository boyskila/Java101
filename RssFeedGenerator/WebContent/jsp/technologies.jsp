<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Technologies</title>
</head>
<body>
	<ul class="pagination">
		<li><a href="${pageContext.request.contextPath}/news">news</a></li>
		<li><a href="${pageContext.request.contextPath}/sport">sport</a></li>
		<li class="active"><a
			href=" ${pageContext.request.contextPath}/technologies">technologies</a></li>
	</ul>
	<h1>ТЕХНОЛОГИИ</h1>
	<br />
	<div>${tech}</div>
	<ul class="pagination">
		<li><a href="${pageContext.request.contextPath}/news">news</a></li>
		<li><a href="${pageContext.request.contextPath}/sport">sport</a></li>
		<li class="active"><a
			href=" ${pageContext.request.contextPath}/technologies">technologies</a></li>
	</ul>
</body>
</html>