<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myInfo</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<header>
	<nav id="sidebarMenu"
		class="collapse d-lg-block sidebar collapse bg-white">
		<div class="position-sticky float:left">
			<div class="list-group list-group-flush mx-3 mt-4">
				<a href="MyPageUpdateMemberController.do"
					class="list-group-item list-group-item-action py-2 ripple active">
					<i class="fas fa-chart-area fa-fw me-3"></i><span>내 정보</span></a> 
				<a href="MyPagecustomerController.do"
					class="list-group-item list-group-item-action py-2 ripple"><i
					class="fas fa-lock fa-fw me-3"></i><span>구매</span></a>
				<a href="MyPageSellerTotalController.do"
					class="list-group-item list-group-item-action py-2 ripple"
					aria-current="true"> <i
					class="fas fa-tachometer-alt fa-fw me-3"></i><span>판매</span>
				</a> 	
			</div>
		</div>
	</nav>
</header>
<div class="container pt-4"></div>
<div class="row">
	<div class="col-lg-12">
		<div class="section-title text-left">
			<div class="title-text">
			</div>
		</div>
	</div>
	<!-- /.col end-->
</div>
<!-- row end-->
<!-- 출처: https://www.bootdey.com/snippets/view/Event-Schedule-list#css -->
<div class="row">
	<div class="col-lg-12">
		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade active show" id="home" role="tabpanel">
				<div class="table-responsive">
					<form action="MyPageUpdateMemberController.do" method="post">
						<input type="hidden" name="id" value="${sessionScope.mvo.id}">
						<input type="password" name="password" required="required"
							placeholder="비밀번호" style="height: 40px;" id="password"><br>
						<input type="password" name="passwordcheck" required="required"
							placeholder="비밀번호확인" style="height: 40px;" id="passwordcheck"><br>
						<input type="text" name="name" required="required"
							placeholder="이름" style="height: 40px;"
							value="${sessionScope.mvo.name}"><br> <input
							type="text" name="address" required="required" placeholder="주소"
							style="height: 40px;" value="${sessionScope.mvo.address}"><br>
						<input type="text" name="nickname" required="required"
							placeholder="닉네임" style="height: 40px;"
							value="${sessionScope.mvo.nickName}"><br> <input
							type="text" name="email" required="required" placeholder="이메일"
							style="height: 40px;" value="${sessionScope.mvo.email}"><br>
						<input type="text" name="tel" id="memberTel" required="required"
							placeholder="전화번호" onkeyup="checkTel()" style="height: 40px;"
							value="${sessionScope.mvo.tel}"><br> <input
							type="text" name="accountNo" required="required"
							placeholder="계좌번호" style="height: 40px;"
							value="${sessionScope.mvo.accountNo}"><br> <input
							type="checkbox" value="약관동의"><br>
						<button type="submit"
							style="width: 190px; background-color: #00ac00; color: white;">회원정보
							수정</button>
					</form>

					<form action="deleteMemberController.do" method="post">
						<input type="hidden" name="id" value="${sessionScope.mvo.id}">
						<button type="submit"
							style="width: 190px; background-color: #00ac00; color: white;">회원
							탈퇴</button>
					</form>
					<!-- 테이블 종료 -->
				</div>
				<!-- /col end-->
			</div>
			<!-- /row end-->
		</div>
	</div>
</div>
<style>
/*출처: https://mdbootstrap.com/docs/standard/extended/sidebar/*/
.sidebar {
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
	padding: 58px 0 0;
	width: 150px;
	z-index: 600;
}

@media ( max-width : 991.98px) {
	.sidebar {
		width: 100%;
	}
}

.sidebar .active {
	border-radius: 5px;
	box-shadow: 0 2px 5px 0 rgb(0 0 0/ 16%), 0 2px 10px 0 rgb(0 0 0/ 12%);
}

.sidebar-sticky {
	position: relative;
	top: 0;
	height: calc(100vh - 48px);
	padding-top: 0.5rem;
	overflow-x: hidden;
	overflow-y: auto;
	/* Scrollable contents if viewport is shorter than content. */
}
</style>
</body>
</html>