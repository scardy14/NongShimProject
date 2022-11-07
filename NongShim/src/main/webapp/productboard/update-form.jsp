  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="UpdatePostController.do">
	<table class="table">
		<tr>
			<td>
				<select name="category" style="width: 95px; height: 29px;">
	       			<option value="곡물">곡물</option>
	       			<option value="야채">야채</option>
	       			<option value="과일">과일</option>       
	       			<option value="기타">기타</option>       
        	 	</select>
				<input type="text" name="minCustomer" value="${productpostvo.minCustomer}" required="required" placeholder="최소인원수">
				<input type="text" name="maxCustomer" value="${productpostvo.maxCustomer}" required="required" placeholder="최대인원수">
				<input type="text" name="productPoint" value="${productpostvo.productPoint}" required="required" placeholder="포인트">
				<input type="date" name="duration" value="${productpostvo.duration}" required="required" placeholder="최소인원수"><br><br>
				<input style="width: 700px; height: 40px;" type="text" name="title" value="${productpostvo.title}" required="required" placeholder="제목을 입력해주세요"><br><br>
				<input style="width: 700px; height: 400px;" type="text" name="content" value="${productpostvo.content}" required="required" placeholder="내용을 입력해주세요"><br>
				<input type="hidden" name="no" value="${productpostvo.postNo}">
			</td>
			</tr>
		
		</table>
		<div style="text-align: center;">
				<button type="submit" style="background-color: #00ac00; color: white; width: 5%; height: 30px;">등록</button>
				<button type="button" onclick="location.href='FindPostListByValueController.do'" style="background-color: #00ac00; color: white; width: 5%; height: 30px;">목록</button>
		</div>
</form>

