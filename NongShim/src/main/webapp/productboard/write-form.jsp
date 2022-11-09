<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<div class="container pt-3">
<form method="post" action="WritePostController.do">
   		 <select name = "category" style="width: 95px; height: 29px;">
   		 	<option value="기타">기타</option>
       		<option value="곡물">곡물</option>
       		<option value="야채">야채</option>
       		<option value="과일">과일</option>       
         </select>
         <input type="number" name="minCustomer" placeholder="최소인원수" required="required">
         <input type="number" name="maxCustomer" placeholder="최대인원수" required="required">
         <input type="number" name="productPoint" placeholder="포인트" required="required">
         <input type="date" name="duration" placeholder="판매기간" required="required"><br><br>
         <input style="width: 700px; height: 40px;" name="title" placeholder="제목을 입력해주세요" required="required" ><br><br>
         <input style="width: 700px; height: 400px;" name="content" placeholder="내용을 입력해주세요" required="required" ><br><br>

	<div class="text-center">
	
		<button type="submit"  style="background-color: #00ba00; border-radius: 10px; width: 60px; height: 30px; border: none;">
            <span style="color: white;">등록</span></button>
		<button type="button"  style="background-color: #00ba00; border-radius: 10px; width: 60px; height: 30px; border: none;">
            <span style="color: white;"  onclick="location.href='FindPostListByValueController.do'">목록</span></button>

	</div>
	</form>
	
</div>
</body>
</html>