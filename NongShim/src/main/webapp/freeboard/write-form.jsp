<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<div class="container pt-3">
<form method="post" action="WriteFreePostController.do">

         <input style="width: 700px; height: 40px;" name="title" placeholder="제목을 입력해주세요" required="required" ><br><br>
         <input style="width: 700px; height: 400px;" name="content" placeholder="내용을 입력해주세요" required="required" ><br><br>

	<div class="text-center">
		<button type="submit" style="background-color: #00ba00; color: white; border: none; width: 5%; height: 30px;">등록</button>
		<button type="button" onclick="location.href='FindFreePostListController.do'" style="background-color: #00ba00; color: white; border: none; width: 5%;  height: 30px;">목록</button>
	</div>
	</form>
	
</div>
</body>
</html>