<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sellerCheck</title>
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
				<a href="MyPageUpdateMemberControllerMove.do"
					class="list-group-item list-group-item-action py-2 ripple">
					<i class="fas fa-chart-area fa-fw me-3"></i><span>내 정보</span></a> 
				<a href="MyPagecustomerController.do"
					class="list-group-item list-group-item-action py-2 ripple"><i
					class="fas fa-lock fa-fw me-3"></i><span>구매</span></a>
					<c:choose>
						<c:when test="${sessionScope.mvo.sellerInfo eq '일반'}">
					<a href="MyPageSellerCheckMoveController.do" class="list-group-item list-group-item-action py-2 ripple active">
						<i class="fas fa-chart-area fa-fw me-3"></i><span>판매인증</span>				
					</a>
					</c:when>
					<c:otherwise>
					<a href="MyPageSellerTotalController.do"
					class="list-group-item list-group-item-action py-2 ripple"
					aria-current="true"> <i
					class="fas fa-tachometer-alt fa-fw me-3"></i><span>판매</span>
					</a> 	
					</c:otherwise>
					</c:choose>
										<a href="MyPageFavoriteListController.do" class="list-group-item list-group-item-action py-2 ripple">
						<i class="fas fa-chart-area fa-fw me-3"></i><span>찜목록</span></a>
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
					<form action="MyPageSellerCheckController.do" onsubmit="checkRegisterForm(event)">
						<input type="text" name="name" required="required" placeholder="이름" style="height: 40px;" value="${sessionScope.mvo.name}" readonly="readonly">
						<input type="text" name="sellerNumber" id="sellerNumber" required="required" placeholder="사업자등록번호" style="height: 40px;"
						 onkeyup="longCheck()" maxlength="10" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
						 <span id="checkResult"></span><br>
						<br><br>
						<button type="submit" style="width: 190px; background-color: #00ac00; color: white;">판매자 인증</button>
					</form>
					<!-- 테이블 종료 -->
				</div>
				<!-- /col end-->
			</div>
			<!-- /row end-->
		</div>
	</div>
</div>






















					<script type="text/javascript">

					let checkFlag=false;
					
					function checkRegisterForm(event){
						if(checkFlag==false){
							alert("판매자 인증을 다시 확인하세요");
							event.preventDefault();
						}
					}
					
						function longCheck(){
							let sellerNumber=document.getElementById("sellerNumber").value; 
							let checkResultSpan=document.getElementById("checkResult");
							
							if(sellerNumber.length<10){
								checkResultSpan.innerHTML="<font color=pink>사업자 등록번호를 10자로 등록하세요.</font>";
							}
								else{
								let xhr=new XMLHttpRequest();
								xhr.onreadystatechange=function(){
									if(xhr.readyState==4&&xhr.status==200){
										if(xhr.responseText=="ok"){
											checkResultSpan.innerHTML="<font color=blue>인증 가능한 사업자 등록번호입니다.</font>";
											checkFlag=true;
										}else{
											checkResultSpan.innerHTML="<font color=red>해당 번호의 사업자가 존재합니다.</font>";
										}//else
									}//if
								}//function
								xhr.open("get","${pageContext.request.contextPath}/MyPageSellerNumberCheckController.do?sellerNumber="+sellerNumber);
								xhr.send();	
							}
						}
					</script>
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