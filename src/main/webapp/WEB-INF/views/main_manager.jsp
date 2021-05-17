<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16"
	href="/xciweb01/img/favicon-16.png">
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
html, body {
	width: 100%; height: 100%;
}
nav{background-color:#90EE90;}
nav ul{position:relative;margin:0px; padding:0px;}
ul li{display:inline;}

</style>

</head>
<body>
	<div style="width: 100%; height: 10vh; display: block; boarder:none;">
		<nav id="navigation">
			<ul>
				<li><a href="memberManager" target="board_main_manager">회원관리</a></li>
				<li><a href="articleManager" target="board_main_manager">게시글관리</a></li>
				<li><a href="articleCFManager" target="board_main_manager">게시판관리</a></li>
			</ul>
		</nav>
	</div>
	<div style="width: 100%; height: 100%; border: none;">
		<iframe name="board_main_manager" id="board_main_manager" title="회원관리"
			src="memberManager?gradeSelect=0" scrolling="no" 
			style="display: block; width: 100%; height: 100%;"></iframe>
	</div>
</body>

</html>