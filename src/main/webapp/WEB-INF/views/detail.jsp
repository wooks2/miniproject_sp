<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="articleDTO" value='${articleDTO}'/>
<c:set var="memberDTO" value='${memberDTO}'/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<caption>게시글 상세보기</caption>
	<tr>
		<th>글번호</th>
		<td>${articleDTO.articleNo}</td>
	</tr>
	<tr>
		<th>카테고리</th>
		<td>${articleDTO.boardCF.cf_name}
	</tr>
	<tr>
		<th>제목</th>
		<td>${articleDTO.title}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${articleDTO.writer}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${articleDTO.content}</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${articleDTO.regdate}</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${articleDTO.readcount}</td>
	</tr>
</table><br/>
<a href="update?no=${articleDTO.articleNo}">수정</a>
<a href="delete?no=${articleDTO.articleNo}">삭제</a>
<a href="list">리스트</a>
</body>
</html>