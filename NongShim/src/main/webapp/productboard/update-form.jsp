  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="UpdatePostController">
		<table class="table">
			<tr>
				<td>
				<input type="text" name="category" value="${productpostvo.category}" required="required" placeholder="카테고리"  list="taglist" style="width: 95px; height: 29px;">
						<datalist id="taglist">
       			<option value="곡물"></option>
       			<option value="야채"></option>
       			<option value="과일"></option>       
       			<option value="기타"></option>       
        	 </datalist>
			<input type="text" name="mincustomer" value="${productpostvo.mincustomer}">
			<input type="text" name="maxcustomer" value="${productpostvo.maxcustomer}">
			<input type="text" name="productpoint" value="${productpostvo.productpoint}">
			<input type="text" name="duration" value="${productpostvo.duration}"><br><br>
			<input style="width: 700px; height: 40px;" type="text" name="title" value="${productpostvo.title}" required="required"><br><br>
			<input style="width: 700px; height: 400px;" type="text" name="content" value="${productpostvo.content}"><br>
			<input type="hidden" name="no" value="${productpostvo.postNo}">
				</td>
			</tr>
		
		</table>
		<span style="text-align: center;">
				<button onclick="location.href='FindPostListByValueController.do'" style="background-color: #00ac00; color: white; width: 5%; height: 30px;">목록</button>
				<button type="submit" class="btn btn-success">취소</button>
		</span>
		<div class="text-center">
			<button type="submit" class="btn btn-success">취소</button>
		</div>
</form>

