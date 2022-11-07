<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	alert("상품을 구매하였습니다");
	location.href="ProductDetailController.do?postno=${post_No}"
</script>