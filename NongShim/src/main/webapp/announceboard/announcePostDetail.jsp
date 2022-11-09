<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class = "table table-bordered">
	<tr>
		<td style="width: 15%; background-color: #00ba00; color: white;">제목</td><td colspan="4">${AnnouncePostVO.title }</td>
	</tr>
	<tr>
		<td style="width: 15%; background-color: #00ba00; color: white;">작성자</td><td style="width: 35%;">${AnnouncePostVO.nickname }</td><td style="width: 15%; background-color: #00ba00; color: white;">게시글번호</td><td>${AnnouncePostVO.post_No }</td>
	</tr>
	<tr>
		<td style="background-color: #00ba00; color: white;">등록일자</td><td>${AnnouncePostVO.register_Date }</td><td style="background-color: #00ba00; color: white;">조회수</td><td>${AnnouncePostVO.hits }</td>
	</tr>
	<tr>
		<td colspan="5"><pre>${AnnouncePostVO.content }</pre></td>
	</tr>
</table>

<div style="text-align: right;">
<button type = "button" onclick = "toList()" style="background-color: #00ba00;border-radius: 5px; width: 80px; height: 40px; border: none;"><span style="color: white;">목록</span></button>
<c:choose>
<c:when test="${sessionScope.mvo.id== AnnouncePostVO.id}">
<button type = "button" onclick = "updatepost()" style="background-color: #00ba00;border-radius: 5px; width: 80px; height: 40px; border: none;"><span style="color: white;">수정</span></button>
<button type = "button" onclick = "deletepost()" style="background-color: #00ba00;border-radius: 5px; width: 80px; height: 40px; border: none;"><span style="color: white;">삭제</span></button>
</c:when>
</c:choose>
</div>
<form action = "UpdateAnnouncePostControllerMove.do" id = "updateform">
	<input type = "hidden" name = "post_No" value = ${AnnouncePostVO.post_No }>
</form>
<form action="DeleteAnnouncePostController.do" method="post" id = "deleteform">
	<input type = "hidden" name = "post_No" value = ${AnnouncePostVO.post_No }>
</form>
<script>
	function toList() {
		location.href="FindAnnouncePostListController.do";
	}
	function updatepost() {
		let udpateform = document.getElementById("updateform");
		udpateform.submit();
	}
	function deletepost() {
		let deleteform = document.getElementById("deleteform");
		deleteform.submit();
	}
</script>