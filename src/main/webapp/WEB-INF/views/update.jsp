<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="articleDTO" value="${articleDTO}" />
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16"
	href="/xciweb01/img/favicon-16.png">
<meta charset="UTF-8">
<title>게시물 수정</title>
<script type="text/javascript">
	function changeCF(selected_obj) {
		var selected = selected_obj.selectedIndex;
		var text = document.getElementById("cfTextId");
		text.readonly = false;
		text.value = selected_obj.options[selected].text;
		text.readonly = true;
	}

	function changeGrade(selected_obj) {
		var selected = selected_obj.selectedIndex;
		var text = document.getElementById("gradeTextId");

		text.readonly = false;
		text.value = selected_obj.options[selected].text;
		text.readonly = true;
	}

	function goBack() {
		window.history.back();
	}
</script>
</head>
<body>

	<div>
		<div id="sidebar">
			<aside id="categories" class="widget">
				<ul>
					<li>전체 글 보기</li>
					<c:forEach var="cf" items='${cfList}'>
						<li>${cf.cf_name}
						<li>
					</c:forEach>
				</ul>
			</aside>
		</div>
		<div id="content">
			<aside id="content_all">
				<form action="updateAction" method="post">
					<table>
						<caption>게시물 수정</caption>
						<tr>
							<td>글번호</td>
							<td>${articleDTO.articleNo}<input type="hidden" name="no"
								value="${articleDTO.articleNo}">
							</td>
						</tr>
						<tr>
							<td>분류</td>
							<td><input type="text" id="cfTextId" name="txtCF"
								value="${articleDTO.boardCF.cf_name}" readonly /> 
							<select
								id="cfId" name="cfSelect" onchange="changeCF(this)">
									<c:forEach var="cf" items='${cfList}'>
										<option
											<c:if test="${cf.cf_name eq articleDTO.boardCF.cf_name}">selected</c:if>
											value="${cf.articleCFNo}">${cf.cf_name}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td>제목</td>
							<td><input type="text" name="title"
								value="${articleDTO.title}"></td>
						</tr>
						<tr>
							<td>작성자</td>
							<td><input type="text" name="writer"
								value="${articleDTO.writer}" readonly></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea name="content" rows="5" cols="40">${articleDTO.content}</textarea></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="password"
								required="required"> <span class="warn">* 처음 글
									작성시 비밀번호를 재 입력하세요.</span></td>
						</tr>
						<tr>
							<td>읽기권한</td>
							<td><input type="text" id="gradeTextId" name="txtGrade"
								value="${articleDTO.readgrade.grade}" readonly /> <select
								id="gradeId" name="gradeSelect" onchange="changeGrade(this)">
									<c:forEach var="grade" items='${gradeList}'>
										<option
											<c:if test="${grade.grade eq articleDTO.readgrade.grade}">selected</c:if>
											value="${grade.gradeNo}">${grade.grade}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td><input type="submit" value="확인"></td>
							<td><button type="button" rows="1" cols="3" class="navyBtn"
									value="취소" onClick="goBack()">취소</button></td>
						</tr>
					</table>
				</form>
			</aside>
		</div>
	</div>



</body>
</html>