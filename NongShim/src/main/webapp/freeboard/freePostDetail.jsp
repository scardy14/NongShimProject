<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class = "table table-bordered">
	<tr>
		<td style="width: 15%; background-color: #d0fd7d;">제목</td><td colspan="4">${FreePostVO.nickname }</td>
	</tr>
	<tr>
		<td style="width: 15%; background-color: #d0fd7d;">작성자</td><td style="width: 35%;">${FreePostVO.title }</td><td style="width: 15%; background-color: #d0fd7d;">게시글번호</td><td>${FreePostVO.post_No}</td>
	</tr>
	<tr>
		<td style="background-color: #d0fd7d;">등록일자</td><td>${FreePostVO.register_Date }</td><td style="background-color: #d0fd7d;">조회수</td><td>${FreePostVO.hits }</td>
	</tr>
	<tr>
		<td colspan="5"><pre>${FreePostVO.content }</pre></td>
	</tr>
</table>

<div style="text-align: right;">
<button type = "button" onclick = "toList()" style="background-color: #d0fd7d;border-radius: 10px; width: 80px; height: 40px; border: none;">목록으로</button>
<c:choose>
<c:when test="${sessionScope.mvo.id== FreePostVO.id}">
<button type = "button" onclick = "updatepost()" style="background-color: #d0fd7d;border-radius: 10px; width: 80px; height: 40px; border: none;">수정하기</button>
<button type = "button" onclick = "deletepost()" style="background-color: #d0fd7d;border-radius: 10px; width: 80px; height: 40px; border: none;">삭제하기</button>
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
		let result = confirm("게시물을 삭제하시겠습니까?");
		if(result) {
			deleteform.submit();
		}
	}
</script>