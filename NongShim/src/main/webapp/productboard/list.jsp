<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-bordered table-hover boardlist">
	<thead>
		<tr style="background-color: #d0fd7d">
			<th>번호</th>
			<th>카테고리</th>
			<th>상태</th>
			<th style="width: 45%">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="ProductPostVO">
			<tr>
				<td>${ProductPostVO.postNo}</td>
				<td>${ProductPostVO.category}</td>
				<td>${ProductPostVO.status}</td>
				<td>${ProductPostVO.title}</td>
				<td>${ProductPostVO.nickName}</td>
				<td>${ProductPostVO.date}</td>
				<td>${ProductPostVO.hits}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<!--
      pagination 
-->
<ul class="pagination justify-content-center" style="margin:20px 0">	
	<c:if test="${pagination.previousPageGroup}">
	<li class="page-item"><a class="page-link" href="FindPostListController.do?pageNo=${pagination.startPageOfPageGroup-1}">Previous</a></li>
	</c:if>
	<c:forEach begin="${pagination.startPageOfPageGroup}" 
	end="${pagination.endPageOfPageGroup}" var="page">
	<c:choose>
		<c:when test="${pagination.nowPage==page}">
		<li class="page-item active"><a class="page-link" href="FindPostListController.do?pageNo=${page}">${page}</a></li>
		</c:when>
		<c:otherwise>
		<li class="page-item"><a class="page-link" href="FindPostListController.do?pageNo=${page}">${page}</a></li>
		</c:otherwise>
	</c:choose>	
	</c:forEach>
	<c:if test="${pagination.nextPageGroup}">
  	<li class="page-item"><a class="page-link" href="FindPostListController.do?pageNo=${pagination.endPageOfPageGroup+1}">Next</a></li>     
  	</c:if>	
</ul>