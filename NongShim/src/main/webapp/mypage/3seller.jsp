<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<body>
	<header>
		<nav id="sidebarMenu"
			class="collapse d-lg-block sidebar collapse bg-white">
			<div class="position-sticky float:left">
				<div class="list-group list-group-flush mx-3 mt-4">
					<a href="MyPageUpdateMemberControllerMove.do"
						class="list-group-item list-group-item-action py-2 ripple"
						aria-current="true"> <i class="fas fa-tachometer-alt fa-fw me-3"></i><span>내 정보</span></a> 
					<a href="MyPagecustomerController.do"
						class="list-group-item list-group-item-action py-2 ripple">
						<i class="fas fa-chart-area fa-fw me-3"></i><span>구매</span></a>
					<c:choose>
						<c:when test="${sessionScope.mvo.sellerInfo eq '일반'}">
					<a href="MyPageSellerCheckMoveController.do" class="list-group-item list-group-item-action py-2 ripple">
						<i class="fas fa-chart-area fa-fw me-3"></i><span>판매인증</span>				
					</a>
					</c:when>
					<c:otherwise>
					<a href="MyPageSellerTotalController.do"
						class="list-group-item list-group-item-action py-2 ripple active"><i
						class="fas fa-lock fa-fw me-3"></i><span>판매</span></a>
					</c:otherwise>
					</c:choose>
										<a href="MyPageFavoriteListController.do" class="list-group-item list-group-item-action py-2 ripple">
						<i class="fas fa-chart-area fa-fw me-3"></i><span>찜목록</span></a>
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
							<tr style="background-color: #00ba00; color: white;" align="center">
								<td><button style="background-color: #00ba00; border: none;" onclick="sellinglist()"><span style="color: white;">판매 중</span></button></td><td><button style="background-color: #00ba00; border: none;" onclick="soldlist()"><span style="color: white;">판매완료</span></button></td>
							</tr>
							<tr align="center">
								<td>${requestScope.selling}</td><td>${requestScope.sell}</td>
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
													<span>${seller.rnum}</span>
												</div>
											</th>
											<td>
												<div class="event-wrap">
													<h4>
														<a href="ProductDetailController.do?postno=${seller.postNo}">[${seller.status}] ${seller.title}</a>
													</h4>
													<div class="meta">
														<div class="organizers">
															<span>최소/최대 인원수: ${seller.minCustomer}/${seller.maxCustomer}</span>
														</div>
														<div class="time">
															<span>판매종료 기간: ${seller.duration}</span>
														</div>
														<div class="progress position-relative">
															<div class="progress-bar" role="progressbar"
																style="width: ${seller.productPoint}%" aria-valuenow="${seller.productPoint}" aria-valuemin="0"
																aria-valuemax="100" align="center"></div>
															<small
																class="justify-content-center d-flex position-absolute w-100"></small>
														</div>
													</div>
												</div>
											</td>
											<td>
												<%-- <div class="primary-btn">
													<a class="btn btn-primary" href="MyPageMyCustomerListController.do?postNo=${seller.postNo}">구매자 목록</a>
												</div> --%>
												<form action="MyPageMyCustomerListController.do">
													<button>구매자 목록</button>
													<input type="hidden" name="status" value="${seller.status}">
													<input type="hidden" name="postNo" value="${seller.postNo}">
												</form>
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
		<c:choose>
			<c:when test="${mode=='판매중' }">
				<ul class="pagination justify-content-center" style="margin:20px 0">	
					<c:if test="${pagination.previousPageGroup}">
						<li class="page-item"><a class="page-link" onclick="sellingproduct(${pagination.startPageOfPageGroup-1},'판매중')">Previous</a></li>
					</c:if>
					<c:forEach begin="${pagination.startPageOfPageGroup}" end="${pagination.endPageOfPageGroup}" var="page">
					<c:choose>
						<c:when test="${pagination.nowPage==page}">
							<li class="page-item active"><a class="page-link" onclick="sellingproduct(${page},'판매중')">${page}</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link" onclick="sellingproduct(${page},'판매중')">${page}</a></li>
						</c:otherwise>
					</c:choose>	
					</c:forEach>
					<c:if test="${pagination.nextPageGroup}">
				  		<li class="page-item"><a class="page-link" onclick="sellingproduct(${pagination.endPageOfPageGroup+1},'판매중')">Next</a></li>     
				  	</c:if>	
				</ul>
			</c:when>
			<c:otherwise>
				<ul class="pagination justify-content-center" style="margin:20px 0">	
					<c:if test="${pagination.previousPageGroup}">
						<li class="page-item"><a class="page-link" onclick="soldproduct(${pagination.startPageOfPageGroup-1},'판매완료')">Previous</a></li>
					</c:if>
					<c:forEach begin="${pagination.startPageOfPageGroup}" end="${pagination.endPageOfPageGroup}" var="page">
					<c:choose>
						<c:when test="${pagination.nowPage==page}">
							<li class="page-item active"><a class="page-link" onclick="soldproduct(${page},'판매완료')">${page}</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link" onclick="soldproduct(${page},'판매완료')">${page}</a></li>
						</c:otherwise>
					</c:choose>	
					</c:forEach>
					<c:if test="${pagination.nextPageGroup}">
				  		<li class="page-item"><a class="page-link" onclick="soldproduct(${pagination.endPageOfPageGroup+1},'판매완료')">Next</a></li>     
				  	</c:if>	
				</ul>
			</c:otherwise>
		</c:choose>
</body>
<script>
	function sellinglist() {
		location.href="MyPageSellerTotalController.do?mode=판매중";
	}
	function soldlist() {
		location.href="MyPageSellerTotalController.do?mode=판매완료";
	}
	function sellingproduct(pageNo,mode) {
		location.href="MyPageSellerTotalController.do?pageNo="+pageNo+"&mode="+mode;		
	}
	function soldproduct(pageNo,mode) {
		location.href="MyPageSellerTotalController.do?pageNo="+pageNo+"&mode="+mode;
	}
</script>