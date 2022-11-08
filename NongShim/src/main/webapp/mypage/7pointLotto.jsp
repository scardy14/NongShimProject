<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포인트 복권</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container pt-3">
<header>
		<nav id="sidebarMenu"
			class="collapse d-lg-block sidebar collapse bg-white">
			<div class="position-sticky float:left">
				<div class="list-group list-group-flush mx-3 mt-4">
					<a href="MyPageUpdateMemberControllerMove.do"
						class="list-group-item list-group-item-action py-2 ripple"
						aria-current="true"> <i
						class="fas fa-tachometer-alt fa-fw me-3"></i><span>내 정보</span>
					</a> <a href="MyPagecustomerController.do" class="list-group-item list-group-item-action py-2 ripple">
						<i class="fas fa-chart-area fa-fw me-3"></i><span>구매</span></a> 	
					<c:choose>
						<c:when test="${sessionScope.mvo.sellerInfo eq '일반'}">
					<a href="MyPageSellerCheckMoveController.do" class="list-group-item list-group-item-action py-2 ripple">
						<i class="fas fa-chart-area fa-fw me-3"></i><span>판매인증</span>				
					</a>
					</c:when>
					<c:otherwise>
						 <a href="MyPageSellerTotalController.do"
						class="list-group-item list-group-item-action py-2 ripple"><i
						class="fas fa-lock fa-fw me-3"></i><span>판매</span></a>
					</c:otherwise>
					</c:choose>
					<a href="MyPageFavoriteListController.do" class="list-group-item list-group-item-action py-2 ripple active">
						<i class="fas fa-chart-area fa-fw me-3"></i><span>찜목록</span></a>
				</div>
			</div>
		</nav>
	</header>
	<div class="container pt-4">
<div>
	<form action="#">
		<button>
			포인트 복권 응모하기
		</button>
	</form>
</div>
</div>
</div>
</body>
</html>