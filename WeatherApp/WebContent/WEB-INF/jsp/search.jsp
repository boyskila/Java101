<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#outPopUp {
	position: absolute;
	width: 300px;
	height: 200px;
	z-index: 15;
	top: 50%;
	left: 50%;
	margin: -100px 0 0 -150px;
}
</style>
</head>
<body>
	<div id="outPopUp">
		<img src="${url}" width="100" height="100" />
		<center>${message}</center>
	</div>

</body>
</html>