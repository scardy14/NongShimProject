<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>${vo.title}</h3>
<table class = "table table-bordered">
	<tr>
		<td style="width: 15%; background-color: #d0fd7d;">작성자</td><td colspan="4">${vo.nickName}</td>
	</tr>
	
	<tr>
		<td style="background-color: #d0fd7d;">등록일</td><td>${vo.date}</td><td style="background-color: #d0fd7d;">판매기간</td><td>${vo.duration}</td>
	</tr>
	<tr>
		<td style="background-color: #d0fd7d;">카테고리</td><td>${vo.category}</td><td style="background-color: #d0fd7d;">조회수</td><td>${vo.hits}</td>
	</tr>
	<tr>
		<td style="background-color: #d0fd7d;">최소공구인원</td><td>${vo.minCustomer}</td><td style="background-color: #d0fd7d;">주문가능인원</td><td>${vo.maxCustomer}</td>
	</tr>
</table>
${vo.content}
<hr>
<form action="">
<input type = "text" style="width: 90%; height: 50px;"><button type ="submit" style="width: 10%; height: 50px;">댓글등록!</button>
</form>
<br>

${vo.comments}<br>
<br>


<br>
<br>		
				




<%-- 제품명은 글 제목에 쓸 거로 감안해서 추가적인 제품명은 안보여주는게 나을수도--%>