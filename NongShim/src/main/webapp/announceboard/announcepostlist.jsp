<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-bordered table-hover boardlist">
	<thead>
		<tr style="background-color: #d0fd7d">
			<th>번호</th>
			<th style="width: 45%">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="AnnouncePostVO">
			<tr>
				<td>${AnnouncePostVO.post_No}</td>
				<td><a href="FindAnnouncePostDetailController.do?post_No=${AnnouncePostVO.post_No}">${AnnouncePostVO.title}</a></td>
				<td>${AnnouncePostVO.nickname}</td>
				<td>${AnnouncePostVO.register_Date}</td>
				<td>${AnnouncePostVO.hits}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<ul class="pagination justify-content-center" style="margin:20px 0">	
			<c:if test="${pagination.previousPageGroup}">
				<li class="page-item"><a class="page-link" onclick="sendpageandinfo(${pagination.endPageOfPageGroup-1})">Previous</a></li>
			</c:if>
			<c:forEach begin="${pagination.startPageOfPageGroup}" end="${pagination.endPageOfPageGroup}" var="page">
			<c:choose>
				<c:when test="${pagination.nowPage==page}">
					<li class="page-item active"><a class="page-link" onclick="sendpageandinfo(${page})">${page}</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" onclick="sendpageandinfo(${page})">${page}</a></li>
				</c:otherwise>
			</c:choose>	
			</c:forEach>
			<c:if test="${pagination.nextPageGroup}">
		  		<li class="page-item"><a class="page-link" onclick="sendpageandinfo(${pagination.endPageOfPageGroup+1})">Next</a></li>     
		  	</c:if>	
		</ul>