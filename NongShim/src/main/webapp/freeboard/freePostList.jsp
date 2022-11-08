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
		<c:forEach items="${list}" var="FreePostVO">
			<tr>
				<td>${FreePostVO.post_No}</td>
				<td><a href="FindFreePostDetailController.do?post_No=${FreePostVO.post_No}">${FreePostVO.nickname}</a></td>
				<td>${FreePostVO.title}</td>
				<td>${FreePostVO.register_Date}</td>
				<td>${FreePostVO.hits}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<c:choose>	
	<c:when test="${sessionScope.mvo!=null}">
		<div style="text-align: right;">
			<button type = "button" onclick="writefree()" style="background-color: #d0fd7d; color: 00ac00; border-radius: 10px; width: 80px; height: 40px; border: none;">글쓰기</button>
		</div>
	</c:when>
</c:choose>
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
<script> 
	function writefree() {
		location.href="WriteFreePostFormController.do";
	}
</script>