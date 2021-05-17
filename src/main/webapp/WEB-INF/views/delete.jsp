<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="no" value="${no}"/>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16" href="/xciweb01/img/favicon-16.png">
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goBack() {
		window.history.back();
}
</script>
</head>
<body>
<form action="deleteAction" method="post">
글번호 : ${no}<input type="hidden" name="no" value="${no}"/><br/>
비밀번호 : <input type="password" name="password" required="required"/>
<input type="submit" value="확인"/>
<input type="button" value="취소" onclick="goBack()"/>
</form>
</body>
</html>