<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="WriteAnnouncePostController.do" onsubmit="return false" id = "writeannounceform" method="post">
<input style="width: 70%; height: 100px;" type = "text" name = "title" placeholder="제목" required="required"><br>
<textarea style="width: 70%; height: 500px;" name = "content" placeholder="내용" required="required"></textarea><br>
<button type = "button" style="background-color: #00ba00; color: white; border-radius: 5px; width: 100px; height: 50px;" onclick="writeannounce()">등록</button>
</form>

<script>
	function writeannounce() {
		let result = confirm("글을 등록하시겠습니까?");
		if(result) {
			let form = document.getElementById("writeannounceform");
			form.submit();
		}
	}
</script>