<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	alert("상품구매에 실패하였습니다. 포인트가 부족합니다.");
	location.href="ProductDetailController.do?postno=${post_No}"
</script>