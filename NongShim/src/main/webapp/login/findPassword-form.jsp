<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<form action="findPasswordByIdAccountNo.do" method="get">
	<input type = "text" name = "id" required="required" placeholder="아이디" style="height: 40px;"><br>
	<input type = "text" name = "accountNo" required="required" placeholder="계좌번호" style="height: 40px;"><br>
	<button type = "submit" style="width: 190px;   background-color: #00ac00; color: white;">비밀번호 찾기</button>
</form>