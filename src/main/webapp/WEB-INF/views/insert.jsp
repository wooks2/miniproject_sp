<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="memberDTO" value="${memberDTO}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>
</head>
<body>
<form action="insertAction" method="get">
<table>
<caption>게시물쓰기</caption>
<tr>
	<th>분류</th>
	<td>
		<select name="cf">
		<c:forEach var="cf" items='${cfList}'>
			<option value="${cf.articleCFNo}">${cf.cf_name}</option>
		</c:forEach>
		</select>
	</td>
</tr>
<tr>
	<th>제목</th>
	<td><input type="text" name="title" /></td>
</tr>
<tr>
	<th>이름</th>
	<td><input type="hidden" name="member_no" value="${memberDTO.memberNo}"/>${memberDTO.id}</td>
</tr>
<tr>
	<th>내용</th>
	<td><textarea name="content" rows="5" cols="40"/></textarea></td>
</tr>
<tr>
	<th>읽기권한</th>
	<td>
		<select name="grade">
		<c:forEach var="grade" items='${gradeList}'>
			<option value="${grade.gradeNo}">${grade.grade}</option>
		</c:forEach>
		</select>
	</td>
</tr>
<tr>
	<td><input type="submit" value="완료"/></td>
	<td><input type="button" value="취소" onclick="goBack()"/></td>
</tr>
</table>
</form>
</body>
</html>