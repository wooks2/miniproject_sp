<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="selected" value='${selectedCF}'/>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16"
	href="/xciweb01/img/favicon-16.png">
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function changeCF() {
		document.frmCF.submit();
	}
	function checkAllArticle() {
		if (frmArticle.allArticleNo.checked) {
			for (i = 0; i < frmArticle.length; i++) {
				frmArticle.articleNo[i].checked = true;
			}
		} else {
			for (i = 0; i < frmArticle.length; i++) {
				frmArticle.articleNo[i].checked = false;
			}
		}
	}
	function deleteCheckedArticle() {
		var target = document.getElementById("cfId");
		var selected = target.options[target.selectedIndex].value;
		document.frmArticle.action = "articleDeleteManager?cfSelect=".concat(selected);
		document.frmArticle.submit();
	}


</script>
</head>
<body>
	<form name="frmCF" method="get" action="articleManager">
	<select id="cfId" name="cfSelect" onchange="changeCF()">
		<c:forEach var="cf" items='${cfList}'>
			<option <c:if test="${selected eq cf.articleCFNo}">selected</c:if> value="${cf.articleCFNo}">${cf.cf_name}</option>
		</c:forEach>
	</select>
	</form>
	<form name="frmArticle" method="get">
	<table border="1">
		<caption>게시물 리스트</caption>
		<tr>
			<th><input type="checkbox" name="allArticleNo" onclick="checkAllArticle()"/></th>
			<th>번호</th>
			<th>게시판분류</th>
			<th>제목</th>
			<th>이름</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="articleList" items='${articleList}'>
		<tr>
			<td align=center><input type="checkbox" name="articleNo" value="${articleList.articleNo}" /></td>
			<td>${articleList.articleNo}</td>
			<td>${articleList.boardCF.cf_name}</td>
			<td><a href="detail?no=${articleList.articleNo}">${articleList.title}</a></td>
			<td>${articleList.writer}</td>
			<td>${articleList.regdate}</td>
			<td>${articleList.readcount}</td>
		</tr>
	</c:forEach>
		<tr>
			<td><input type="button" value="추가" onclick="addArticle()"/></td>
			<td><input type="button" value="삭제" onclick="deleteCheckedArticle()"/></td>
		</tr>
	</table>
	</form>
</body>

</html>