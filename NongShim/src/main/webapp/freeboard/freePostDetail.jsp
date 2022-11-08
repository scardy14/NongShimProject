<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class = "table table-bordered">
	<tr>
		<td style="width: 15%; background-color: #00ba00; color: white;">제목</td><td colspan="4">${FreePostVO.title }</td>
	</tr>
	<tr>
		<td style="width: 15%; background-color: #00ba00; color: white;">작성자</td><td style="width: 35%;">${FreePostVO.nickname }</td><td style="width: 15%; background-color: #00ba00; color: white;">게시글번호</td><td>${FreePostVO.post_No}</td>
	</tr>
	<tr>
		<td style="background-color: #00ba00; color: white;">등록일자</td><td>${FreePostVO.register_Date }</td><td style="background-color: #00ba00; color: white;">조회수</td><td>${FreePostVO.hits }</td>
	</tr>
	<tr>
		<td colspan="5"><pre>${FreePostVO.content }</pre></td>
	</tr>
</table>

<div style="text-align: right;">
<button type = "button" onclick = "toList()" style="background-color: #00ba00;border-radius: 10px; width: 80px; height: 40px; border: none;"><span style="color: white;">목록</span></button>
<c:choose>
<c:when test="${sessionScope.mvo.id== FreePostVO.id}">
<button type = "button" onclick = "updatepost()" style="background-color: #00ba00;border-radius: 10px; width: 80px; height: 40px; border: none;"><span style="color: white;">수정</span></button>
<button type = "button" onclick = "deletepost()" style="background-color: #00ba00;border-radius: 10px; width: 80px; height: 40px; border: none;"><span style="color: white;">삭제</span></button>
</c:when>
</c:choose>
</div>
<form action="UpdateFreePostFormController.do" id = "udpateform">
	<input type = "hidden" name = "post_No" value = ${FreePostVO.post_No }>
</form>
<form action="DeleteFreePostController.do" method="post" id = "deleteform">
	<input type = "hidden" name = "post_No" value = ${FreePostVO.post_No }>
</form>
<script>
	function toList() {
		location.href="FindFreePostListController.do";
	}
	function updatepost() {
		let udpateform = document.getElementById("udpateform");
		udpateform.submit();
	}
	function deletepost() {
		let deleteform = document.getElementById("deleteform");
		deleteform.submit();
	}
</script>