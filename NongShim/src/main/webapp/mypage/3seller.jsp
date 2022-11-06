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
					<a href="MyPageUpdateMemberController.do"
						class="list-group-item list-group-item-action py-2 ripple"
						aria-current="true"> <i
						class="fas fa-tachometer-alt fa-fw me-3"></i><span>내 정보</span>
					</a> <a href="MyPagecustomerController.do"
						class="list-group-item list-group-item-action py-2 ripple">
						<i class="fas fa-chart-area fa-fw me-3"></i><span>구매</span>
					</a> <a href="MyPageSellerTotalController.do"
						class="list-group-item list-group-item-action py-2 ripple active"><i
						class="fas fa-lock fa-fw me-3"></i><span>판매</span></a>
				</div>
			</div>
		</nav>
	</header>
	<div class="container pt-4">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title text-left">
					<div class="title-text">
					<table class="headertable">
						<thead>
							<tr style="background-color: #00ac00; color: white;" align="center">
								<td>판매 중</td><td>판매종료</td>
							</tr>
							<tr align="center">
								<td>판매중value</td><td>판매종료value</td>
							</tr>
						</thead>
					</table>
					<br><br>
						<h2>내 판매 목록</h2>
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
							<table class="table">
								<thead>
									<!-- 표 head -->
									<tr>
										<th class="text-center" scope="col">번호</th>
										<th scope="col">상세</th>
										<th class="text-center" scope="col"></th>
									</tr>
								</thead>
								<%-- items 내 목록 --%>
								<tbody class="text-left">
									<c:forEach items="${requestScope.sellerList}" var="seller" varStatus="order">
										<tr class="inner-box">
											<th scope="row" class="text-center">
												<div class="event-date">
													<span>${order.count}</span>
												</div>
											</th>
											<td>
												<div class="event-wrap">
													<h4>
														<a href="#">[${seller.status}] ${seller.title}</a>
													</h4>
													<div class="meta">
														<div class="organizers">
															<span>판매수량:${seller.amount}</span>
														</div>
														<div class="categories">
															<span>참여자 수:</span>
														</div>
														<div class="time">
															<span>판매종료 기간:${seller.duration}</span>
														</div>
														<div class="progress position-relative">
															<div class="progress-bar" role="progressbar"
																style="width: 60%" aria-valuenow="60" aria-valuemin="0"
																aria-valuemax="100" align="center"></div>
															<small
																class="justify-content-center d-flex position-absolute w-100">${seller.maxCustomer}/${product.minCustomer}</small>
														</div>
														<div>
															<span>최대인원:${seller.maxCustomer}</span>
														</div>
														<div>
															<span>최소인원:${seller.minCustomer}</span>
														</div>
													</div>
												</div>
											</td>
											<td>
												<div class="primary-btn">
													<a class="btn btn-primary" href="#">구매자 목록</a>
												</div>
											</td>
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