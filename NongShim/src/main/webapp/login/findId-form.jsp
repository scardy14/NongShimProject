<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="FindMemberByNameEmailController.do" method="get">
	<input type = "text" name = "name" required="required" placeholder="이름" style="height: 40px;"><br>
	<input type = "text" name = "email" required="required" placeholder="이메일" style="height: 40px;"><br>
	<button type = "submit" style="width: 190px;   background-color: #00ac00; color: white;">아이디 찾기</button>
</form>