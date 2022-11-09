<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<form action="UpdateFreePostController.do" onsubmit="return false" id = "updatefreeform" method="post">

<input type = "hidden" name = "post_No" value = "${freepostvo.post_No}">

<textarea style="width: 70%; height: 40px;"  name = "title" placeholder="제목" required="required">${freepostvo.title}</textarea><br>
<textarea style="width: 70%; height: 300px;"  name = "content" placeholder="내용" required="required">${freepostvo.content}</textarea><br>
</form>

	<button type ="button" onclick="updatefree()"  style="background-color: #00ba00; color: white; border: none; width: 5%;  height: 30px; border-radius: 5px;">등록</button>
	<button type="button" onclick="location.href='FindFreePostListController.do'" style="background-color: #00ba00; color: white; border: none; width: 5%;  height: 30px; border-radius: 5px;">목록</button><br><br>
<script>
	function updatefree() {
		let result = confirm("게시물을 수정하시겠습니까?");
		if(result) {
			let form = document.getElementById("updatefreeform");
			form.submit();
		}
	}
</script>
