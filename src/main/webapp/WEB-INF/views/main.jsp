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
</style>

</head>
<body>
	<div style="width:100%; height:100%; border:none;">
		<div id="sidebar" style="width:30%; height:100%; float:left;">
			<aside id="categories" class="widget">
				<ul>
					<li><a href="list?cf=0" target="board_main">전체 글 보기</a></li>
					<c:forEach var="cf" items='${cfList}'>
						<li><a href="list?cf=${cf.articleCFNo}" target="board_main" >${cf.cf_name}</a></li>
					</c:forEach>
				</ul>
			</aside>
		</div>
		<div id="content" style="width:69%; height:100%; float:left">
			<iframe name="board_main" id="board_main" title="게시글 메인" src="list?cf=0" scrolling="no"
				style="display:block; width:100%; height:100%;"></iframe>
		</div>
	</div>
</body>

</html>