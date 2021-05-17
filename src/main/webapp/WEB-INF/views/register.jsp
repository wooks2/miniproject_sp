<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
h1{
	font-size:25px;
	padding-bottom:20px
}
label{
	flex: 1;
	text-align: left;
}
</style>
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
<script type="text/javascript">
var checked_id = false;
var checked_pw = false;

$(function(){
	$('#pw').keyup(function() {
		$('#chkNotice').html('');
	});
	
	$('#pw_chk').keyup(function() {
		if($('#pw').val() != $('#pw_chk').val()) {
			$('#chkNotice').html('비밀번호가 일치하지 않습니다<br/><br/>');
			$('#chkNotice').attr('color', '#f82a2aa3');
		} else {
			$('#chkNotice').html('비밀번호가 일치합니다<br/><br/>');
			$('#chkNotice').attr('color', '#199894b3');
			checked_pw = true;
		}
	});
	
	
	$('#btn_checkID').click(function() {
		$.ajax({
			type:"POST",
			url:"register/checkID",
			data:{
				"id" : $('#txt_checkID').val()
			},
			dataType:"text",
			success:function(data) {
				console.log(data);
			},
			error:function() {
				alert("ajax error");
			}
		});
	});
});

</script>

<body>
<form action="registerAction" method="post">
<div class="member_register">
	<div class="heading1"><h1>회원가입</h1></div>
	<div class="formData">
		<label>아이디</label><input type="text" id="txt_checkID" name="id"/>
		<button type="button" id="btn_checkID" name="btn_checkID">중복확인</button><br/>

		<label>비밀번호</label><input type="password" name="pw" id="pw" required="required"/><br/>
		<label>비밀번호확인</label><input type="password" name="pw_chk" id="pw_chk" required="required"/><br/>
		<font id="chkNotice" size="2"></font><br/>

		<label>이름</label><input type="text" name="name" required="required"/><br/>

		<label>이메일</label><input type="text" name="email" required="required"/><br/>

		<label>성별</label><br/><input type="radio" name="gender" value="남자"/>남자
								<input type="radio" name="gender" value="여자"/>여자<br/>
	

		<button type="button" id="btn_register">확인</button>
		<button type="button" id="btn_cancel">취소</button>
	</div>
</div>
</form>
</body>
</html>