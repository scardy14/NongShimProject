<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>공지사항</h3><br>
<br>
<table class="table table-bordered table-hover boardlist">
	<thead>
		<tr style="background-color: #00ba00">
			<th style="color: white;">번호</th>
			<th style="width: 45%; color: white;">제목</th>
			<th style="color: white;" >작성자</th>
			<th style="color: white;">작성일</th>
			<th style="color: white;">조회수</th>
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

<c:choose>
	<c:when test="${sessionScope.mvo.adminiInfo=='운영자'}">
		<div style="text-align: right;">
			<button type = "button" onclick="writeannounce()" style="background-color: #00ba00; border-radius: 10px; width: 80px; height: 40px; border: none;"><span style="color: white;">글쓰기</span></button>
		</div>
	</c:when>
</c:choose>
<ul class="pagination justify-content-center" style="margin:20px 0">	
			<c:if test="${pagination.previousPageGroup}">
				<li class="page-item"><a class="page-link" onclick="sendpageandsearch(${pagination.startPageOfPageGroup-1})">Previous</a></li>
			</c:if>
			<c:forEach begin="${pagination.startPageOfPageGroup}" end="${pagination.endPageOfPageGroup}" var="page">
			<c:choose>
				<c:when test="${pagination.nowPage==page}">
					<li class="page-item active"><a class="page-link" onclick="sendpageandsearch(${page})">${page}</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" onclick="sendpageandsearch(${page})">${page}</a></li>
				</c:otherwise>
			</c:choose>	
			</c:forEach>
			<c:if test="${pagination.nextPageGroup}">
		  		<li class="page-item"><a class="page-link" onclick="sendpageandsearch(${pagination.endPageOfPageGroup+1})">Next</a></li>     
		  	</c:if>	
		</ul>	
<script>
	function writeannounce() {
		location.href="WriteAnnouncePostControllerMove.do";
	}
	function sendpageandsearch(element) {
		location.href="FindAnnouncePostListController.do?pageNo="+element;		
	}
</script>