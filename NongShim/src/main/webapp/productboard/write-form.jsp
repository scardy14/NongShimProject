<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container pt-3">
<form method="post" action="WritePostController.do">

			<input type = "text" name = "tag" required="required" placeholder="카테고리"  list="taglist" style="width: 95px; height: 29px;">
     			 <datalist id="taglist">
          			<option value="곡물"></option>
           			<option value="야채"></option>
           			<option value="과일"></option>       
           			<option value="기타"></option>       
         </datalist>
         <input type="number" name="minCustomer" placeholder="최소인원수" required="required">
         <input type="number" name="maxCustomer" placeholder="최대인원수" required="required">
         <input type="number" name="productPoint" placeholder="포인트" required="required">
         <input type="text" name="duration" placeholder="판매기간" required="required"><br><br>
         <input style="width: 700px; height: 100px;" name="title" placeholder="제목을 입력해주세요" required="required" ><br>
         <input style="width: 700px; height: 700px;" name="content" placeholder="내용을 입력해주세요" required="required" ><br>

	<div	class="text-center">
		<button type="submit" class="btn btn-success">등록</button>
		<button type="submit" class="btn btn-success">목록</button>	
	</div>
	</form>
	
</div>
</body>
</html>