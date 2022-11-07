<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<header>
		<nav id="sidebarMenu"
			class="collapse d-lg-block sidebar collapse bg-white">
			<div class="position-sticky float:left">
				<div class="list-group list-group-flush mx-3 mt-4">
					<a href="MyPageUpdateMemberControllerMove.do"
						class="list-group-item list-group-item-action py-2 ripple"
						aria-current="true"> <i
						class="fas fa-tachometer-alt fa-fw me-3"></i><span>내 정보</span>
					</a> <a href="MyPagecustomerController.do"
						class="list-group-item list-group-item-action py-2 ripple active">
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
								<td><button type = "button" style="border: none; background-color: #00ac00;" onclick="beforsend()"><span style="color: white;">발송전</span></button></td><td><button type = "button" style="border: none; background-color: #00ac00;" onclick="aftersend()"><span style="color: white;">발송완료</span></button></td>
							</tr>
							<tr align="center">
								<td>${requestScope.beforesend}</td><td>${requestScope.aftersend}</td>
							</tr>
						</thead>
					</table>
					<br><br>
						<h2>내 구매 목록</h2>
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
									<c:forEach items="${requestScope.list}" var="product" varStatus="order">
										<tr class="inner-box">
											<th scope="row" class="text-center">
												<div class="event-date">
													<span>${order.count}</span>
												</div>
											</th>
											<td>
												<div class="event-wrap">
													<h4>
														<a href="ProductDetailController.do?postno=${product.postNo}">[${product.status}] ${product.title}</a>
													</h4>
													<div class="meta">
														<div class="organizers">
															<span>구매 수량:${product.amount}</span>
														</div>
														<div>
															<span>배송지:${sessionScope.mvo.address}</span>
														</div>
														<div>
															<span>수령인:${sessionScope.mvo.name}</span>
														</div>
														<div>
															<span>전화번호:${sessionScope.mvo.tel}</span>
														</div>
													</div>
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
<form action = "MyPagecustomerController.do" id = "beforesendform">
	<input type = "hidden" name = "mode" value = "발송전">
</form>
<form action = "MyPagecustomerController.do" id = "aftersendform">
	<input type = "hidden" name = "mode" value = "발송완료">
</form>
	
<script>
	function beforsend() {
		let beforesendform = document.getElementById("beforesendform");
		beforesendform.submit();
	}
	function aftersend() {
		let aftersendform = document.getElementById("aftersendform");
		aftersendform.submit();
	}
</script>
