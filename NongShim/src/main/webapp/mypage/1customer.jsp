<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container pt-3">
<table class="table">
<c:forEach items="${requestScope.list}" var="list" varStatus="order"> <%-- items 내 목록 --%>
 	 <tr>
 	 	<td rowspan="6">${order.count}</td>
        <td><a href="">[${list.buyProductVO.status}:상태] 게시글명 게시글로 제목 찾아오는 메서드 postDetailFind 에서 제목만 가져오는 메서드 ${list.buyProductVO}</a></td>
      </tr>
      <tr>
      	<td>구매 수량: {}</td>
      </tr>
      <tr>
      	<td>배송지:{}</td>
      </tr>
      <tr>
      	<td>수령인:{}</td>
      </tr>
      <tr>
      	<td>연락처:{}</td>
      </tr>
      </c:forEach>
</table>

</div>
</body>
</html>