<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer</title>
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
<body>
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
					<div align="left">
					<h3>
						내 찜 목록
					</h3>
					</div>
					</div>
			<!-- /.col end-->
		<!-- row end-->
		<!-- 출처: https://www.bootdey.com/snippets/view/Event-Schedule-list#css -->
		<div class="row">
			<div class="col-lg-12">
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade active show" id="home" role="tabpanel">
						<div class="table-responsive">
							<table class="table">
								<thead>
									<!-- 표 head -->
									<tr>
										<th class="text-center" scope="col">순번</th>
										<th scope="col">글제목</th>
										<th class="text-center" scope="col">작성자</th>
										<th>카테고리</th>
										<th>상태</th>
										<th>판매기간</th>
										<th>최소인원</th>
										<th>최대인원</th>
									</tr>
								</thead>
								<%-- items 내 목록 --%>
								<tbody class="text-left">
									<c:forEach items="${requestScope.list}" var="favorite" varStatus="order">
										<tr class="inner-box">
											<th scope="row" class="text-center">
												<div>
													<span>${order.count}</span>
												</div>
											</th>
											<td><a href="ProductDetailController.do?postno=${favorite.postNo}">${favorite.title}</a></td><td>${favorite.id}</td><td>${favorite.category}</td><td>${favorite.status}</td><td>${favorite.duration}</td><td>${favorite.minCustomer}</td><td>${favorite.maxCustomer}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- 테이블 종료 -->
						</div>
						<!-- /col end-->
					</div>
					<!-- /row end-->
				</div>
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
  .headertable {
    width: 100%;
  }
</style>
</body>
</html>