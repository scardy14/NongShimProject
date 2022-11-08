<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="UpdateProductPostCommentController.do" method="post">
	<input type = "hidden" name = "comment_No" value = ${commentVO.comment_No }>
	<input type = "hidden" name = "post_No" value = ${commentVO.postno }>
	<textarea  name = "content" style="width: 500px; height: 200px;">${commentVO.content }</textarea><br>
	<button type = "submit" style="width: 80px; height: 40px; background-color: #00ba00; border: none; border-radius: 5px;"><span style="color: white;">수정하기</span></button>&nbsp;&nbsp;&nbsp;<button type ="button" onclick="returntodetail(${commentVO.postno })" style="width: 80px; height: 40px; background-color: #00ba00; border: none; border-radius: 5px;"><span style="color: white;">취소하기</span></button>
</form>
<script>
	function returntodetail(postno) {
		location.href="ProductDetailController.do?postno="+postno;
	}
</script>