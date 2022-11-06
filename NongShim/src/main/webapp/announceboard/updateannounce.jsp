<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="UpdateAnnouncePostController.do" onsubmit="return false" id = "updateannounceform" method="post">
<input type = "hidden" name = "post_No" value = ${announcePostVO.post_No }>
<textarea style="width: 70%; height: 40px;"  name = "title" placeholder="제목" required="required">${announcePostVO.title }</textarea><br>
<textarea style="width: 70%; height: 300px;"  name = "content" placeholder="내용" required="required">${announcePostVO.content }</textarea><br>
</form>
<button type = "button" onclick="updateannounce()">수정하기</button>

<script>
	function updateannounce() {
		let result = confirm("수정하시겠습니까?");
		if(result) {
			let form = document.getElementById("updateannounceform");
			form.submit();
		}
	}
</script>