<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="selected" value='${selectedGrade}'/>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16"
	href="/xciweb01/img/favicon-16.png">
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function changeGrade() {
		document.frmGrade.submit();
	}
	
	function checkAllMember() {
		if(frmMember.allMemberNo.checked) {
			for(i=0; i < frmMember.length; i++) {
				frmMember.memberNo[i].checked = true;
			}
		} else {
			for(i=0; i < frmMember.length; i++) {
				frmMember.memberNo[i].checked = false;
			}
		}
	}
	function deleteCheckedMember() {
		var target = document.getElementById("gradeId");
		var selected = target.options[target.selectedIndex].value;
		document.frmMember.action = "memberDeleteManager?gradeSelect=".concat(selected);
		document.frmMember.submit();
	}
</script>
</head>
<body>
	<form name="frmGrade" method="get" action="memberManager">
	<select id="gradeId" name="gradeSelect" onchange="changeGrade()">
		<option value="0">전체보기</option>
		<c:forEach var="grade" items='${gradeList}'>
			<option <c:if test="${selected eq grade.gradeNo}">selected</c:if> value="${grade.gradeNo}">${grade.grade}</option>
		</c:forEach>
	</select>
	</form>
	<form name="frmMember" method="get" >
	<table border="1">
		<caption>회원 리스트</caption>
		<tr>
			<th><input type="checkbox" name="allMemberNo" onclick="checkAllMember()"/></th>
			<th>번호</th>
			<th>이름</th>
			<th>성별</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>등급</th>
			<th>가입날짜</th>
			<th>이미지</th>
		</tr>

		<c:forEach var="memberDTO" items='${memberList}'>
		<tr>
			<td align=center><input type="checkbox" name="memberNo" value="${memberDTO.memberNo}" /></td>
			<td>${memberDTO.memberNo}</td>
			<td><a href="detail?no=${memberDTO.memberNo}">${memberDTO.name}</a></td>
			<td>${memberDTO.gender}</td>
			<td>${memberDTO.id}</td>
			<td>${memberDTO.pw}</td>
			<td>${memberDTO.email}</td>
			<td>${memberDTO.grade.grade}</td>
			<td>${memberDTO.joindate}</td>
			<td>${memberDTO.imgpath}</td>
		</tr>
	</c:forEach>
		<tr>
		<td><input type="button" value="추가" onclick="addMember()"/></td>
			<td><input type="button" value="삭제" onclick="deleteCheckedMember()"/></td>
		</tr>
</table>
</form>
</body>

</html>