<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16" href="/xciweb01/img/favicon-16.png">
<meta charset="UTF-8">
<title>Login</title>
<style>
	.links {
	  background-color: gray;
	  text-align: center;
	}
	
	.links a {
	  margin-left: 10px;
	  margin-right: 10px;
	}
</style>

<script type="text/javascript">
	function login() {
		var loginForm = document.loginForm;
		var id = loginForm.id.value;
		var pw = loginForm.pw.value;
		
		loginForm.manager.value = "true";
		if (!id || !id) {
			alert("아이디와 비밀번호를 모두 입력해주세요.")
		} else {
			loginForm.submit();
		}
	}
</script>
</head>
<body>
<form name="loginForm" action="loginAction" method="post">
	<table border="1" style="margin-left:auto; margin-right:auto">
		<caption>로그인</caption>
		<tr>
			<td>아이디</td>
			<td colspan="2"><input type="text" name="id"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td colspan="2"><input type="password" name="pw" required="required"/></td>
		</tr>
		<tr>
			<td><input type="hidden" name="manager" value="false"/><input type="submit" value="로그인"/></td>
			<td><input type="reset" value="다시입력"/></td>
			<td>
				<input type="button" onclick="login()" value="관리자로그인"/>
			</td>
		</tr>
	</table>
</form>
	<div class="links">
		<a href="register">아직 회원이 아니신가요?</a>
	</div>
</body>
</html>