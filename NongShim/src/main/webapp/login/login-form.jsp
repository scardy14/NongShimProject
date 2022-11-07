<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
<c:when test="${sessionScope.mvo==null}">
<form action="LoginController.do" method="post">
	<input type = "text" name = "id" required="required" placeholder="아이디" style="height: 40px;"><br><br>
	<input type = "password" name = "password" required="required" placeholder="비밀번호" style="height: 40px"><br><hr>
<button type = "submit" style="width: 190px;  background-color: #00ac00; color: white;">로그인</button> <br><br>
</form>
<form action="FindMemberByNameEmailControllerMove.do" method="post">
<button type = "submit" style="width: 190px;  background-color: #00ac00; color: white;">아이디 찾기</button>
</form>
<form action="findPasswordByIdAccountNoMove.do" method="post">
<button type = "submit" style="width: 190px;  background-color: #00ac00; color: white;">비밀번호 찾기</button> <br><br>
</form>
</c:when>

<c:otherwise>
	<c:import url="header.jsp"></c:import>
</c:otherwise>

</c:choose>