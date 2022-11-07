<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<div class="container pt-3">
<form method="post" action="WritePostController.do">
	<input type = "text" name = "category" required="required" placeholder="카테고리"  list="taglist" style="width: 95px; height: 29px;">
   			 <select id="taglist">
       			<option value="곡물"></option>
       			<option value="야채"></option>
       			<option value="과일"></option>       
       			<option value="기타"></option>       
        	 </select>
         <input type="number" name="minCustomer" placeholder="최소인원수" required="required">
         <input type="number" name="maxCustomer" placeholder="최대인원수" required="required">
         <input type="number" name="productPoint" placeholder="포인트" required="required">
         <input type="text" name="duration" placeholder="판매기간" required="required"><br><br>
         <input style="width: 700px; height: 40px;" name="title" placeholder="제목을 입력해주세요" required="required" ><br><br>
         <input style="width: 700px; height: 400px;" name="content" placeholder="내용을 입력해주세요" required="required" ><br><br>

	<div class="text-center">
		<button type="submit" class="btn btn-success">등록</button>
		<button type="submit" class="btn btn-success">목록</button>	
	</div>
	</form>
	
</div>
</body>
</html>