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
</head>
<body>
	<table border="1">
		<caption>게시물 리스트</caption>
		<tr>
			<th>번호</th>
			<th>게시판분류</th>
			<th>제목</th>
			<th>이름</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="dto" items='${list}'>
			<tr>
				<td>${dto.articleNo}</td>
				<td>${dto.boardCF.cf_name}
				<td><a href="detail?no=${dto.articleNo}">${dto.title}</a></td>
				<td>${dto.writer}</td>
				<td>${dto.regdate}</td>
				<td>${dto.readcount}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="insert">글쓰기</a>

</body>

</html>

