<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<pre>


</pre>
<form action="">
	<input type = "text" name = "id" required="required" placeholder="아이디" style="height: 40px;"><br><br>
	<input type = "password" name = "password" required="required" placeholder="비밀번호" style="height: 40px"><br><hr>
	<button type = "submit" style="width: 190px;  background-color: #00ac00; color: white;">로그인</button> <br><br>
	<a href = ""><button type = "button" style="width: 190px;  background-color: whie; color: #00ac00"> 회원가입</button></a><br>
	<a href ="">아이디찾기</a>  <a href="">비밀번호찾기</a>
</form>
<pre>




</pre>
<%--
action에다가
이동할 주소 집어넣기,
로그인후에는 redirect로 이동
회원가입 href에 회원가입창으로 이동하는 컨트롤러 넣기
 --%>

