<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container pt-3">





<table class="table table-bordered table-hover boardlist">	
 	<thead>
		<tr style="background-color: #d0fd7d">
			<th>제목</th>
			<br>
			<th>내용</th>
			<th>조회수</th>
			<th style="width: 45%">작성자</th>
			<th>댓글</th>
			<th>등록날짜</th>
			<th>카테고리</th>
			<th>상품이름</th>
			<th>포인트(가격)</th>
			<th>마감날짜</th>
			<th>최소인원</th>
			<th>최대인원</th>
		</tr>
	</thead>
	<tbody>
		
			<tr>
				<td>${vo.title}</td>
				<td>${vo.content}</td>
				<td>${vo.hits}</td>
				<td>${vo.nickName}</td>
				<td>${vo.comments}</td>
				<td>${vo.date}</td>
				<td>${vo.category}</td>
				<td>${vo.productName}</td>
				<td>${vo.productPoint}</td>
				<td>${vo.duration}</td>
				<td>${vo.minCustomer}</td>
				<td>${vo.maxCustomer}</td>
				
			</tr>
		
	</tbody> 
</table>

<form>

<input type = "text" >
<button>댓글등록!</button>

</form>


</div>
</body>
</html>