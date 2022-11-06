  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="UpdatePostController">
		<table class="table">
			<tr>
				<td>
				<input type="text" name="category" value="${requestScope.category}" required="required" placeholder="카테고리"  list="taglist" style="width: 95px; height: 29px;">
						<datalist id="taglist">
       			<option value="곡물"></option>
       			<option value="야채"></option>
       			<option value="과일"></option>       
       			<option value="기타"></option>       
        	 </datalist>
			<input type="text" name="mincustomer" value="${requestScope.mincustomer}">
			<input type="text" name="maxcustomer" value="${requestScope.maxcustomer}">
			<input type="text" name="productpoint" value="${requestScope.productpoint}">
			<input type="text" name="duration" value="${requestScope.duration}">
			<input type="text" name="title" value="${requestScope.title}" required="required">
			<input type="text" name="content" value="${requestScope.content}">
			<input type="hidden" name="no" value="${requestScope.no}">
				</td>
			</tr>
		
		</table>
		<div class="text-center">
			<button type="submit" class="btn btn-success">확인</button>
			<button type="reset" class="btn btn-success">취소</button>
		</div>
</form>