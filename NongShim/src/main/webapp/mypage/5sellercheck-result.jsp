<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	alert("판매자 인증이 완료되었습니다.");
	location.href = "<c:url value ='../LogoutController.do'/>";
</script>