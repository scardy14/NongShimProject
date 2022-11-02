<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id = "registerform" action="">
	<input type = "text" name = "id" required="required" placeholder="아이디" style="height: 40px;"><br>
	<input type = "password" name = "password" required="required" placeholder="비밀번호" style="height: 40px;" id="password"><br>
	<input type = "password" name = "passwordcheck" required="required" placeholder="비밀번호확인" style="height: 40px;" id = "passwordcheck"><br>
	<input type = "text" name = "name" required="required" placeholder="이름" style="height: 40px;"><br>
	<input type = "text" name = "nickname" required="required" placeholder="닉네임" style="height: 40px;"><br>
	<input type = "text" name = "email" required="required" placeholder="이메일" style="height: 40px;"><br>
	<input type = "text" name = "tel" required="required" placeholder="전화번호" style="height: 40px;"><br>
	<input type="checkbox" value="약관동의"><br>
	<button type = "button" style="width: 190px;   background-color: #00ac00; color: white;" onclick = "register()">회원가입</button>
</form>

<script>
	function register() {
		let password = document.getElementById("password").value;
		let passwordcheck = document.getElementById("passwordcheck").value;
		let registerform = document.getElementById("registerform");
		if(password !=passwordcheck) {
			alert("비밀번호가 일치하지 않습니다");
		} else {
			registerform.submit;
		}
	}
	
</script>