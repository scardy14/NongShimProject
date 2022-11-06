<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="background-color: #00ac00; height: 27px;" align="right" >
	
<c:choose>
<c:when test="${sessionScope.mvo==null}">
	<a href="LoginControllerMove.do"><span style="color: white;">로그인</span></a> &nbsp;&nbsp;
	<a href="RegisterControllerMove.do"><span style="color: white;">회원가입</span></a>&nbsp;&nbsp;
	<a href=""><span style="color: white;">고객센터</span></a>&nbsp;&nbsp;
</c:when> 
<c:otherwise>
<span style="color: white;">이름:${sessionScope.mvo.name}</span>&nbsp;&nbsp;
<span style="color: white;">아이디:${sessionScope.mvo.id}</span>&nbsp;&nbsp;
<a href="LogoutController.do"><span style="color: white;">로그아웃</span></a>&nbsp;&nbsp;
<a href=""><span style="color: white;">고객센터</span></a>&nbsp;&nbsp;
</c:otherwise>
</c:choose>

</div>
<table class="table">
	<tr>
		<td rowspan="2"><a href="WelcomePageMove.do" ><img src="images/NongShim.PNG" style="width: 60px; height: 80px;"></a></td>
		<td colspan="4">
			<form action="" id="searchform">
				<input type = "text" style="width: 750px; height: 45px;" id = "searchword">
				<button type = "button" onclick="search()" style="border: none; width: 45px;"><img src="images/search.png" style="width: 45px; height: 40px; display: inline;"></button>
			</form>
		</td>
<c:choose>	
		<c:when test="${sessionScope.mvo==null}">
		<td rowspan="2"><img src="images/MyNongShim.PNG" style="width: 60px; height: 80px;"></td>
		</c:when>
		<c:otherwise>
		<td rowspan="2"><a href="MyPageUpdateMemberController.do"><img src="images/MyNongShim.PNG" style="width: 60px; height: 80px;"></a></td>
		</c:otherwise>
</c:choose>			
		
		<td rowspan="2"><img src="images/ShoppingCart.PNG" style="width: 60px; height: 80px;"></td>
	</tr>
	<tr>
		<td><a href="FindAnnouncePostListController.do">공지사항</a></td><td><a href="FindPostListByValueController.do">공구게시판</a></td><td><a href="FindFreePostListController.do">자유게시판</a></td><td><a href="">포인트복권</a></td>
	</tr>
</table>
<br>
<script>
	function search() {
		let searchword = document.getElementById("searchword").value; //inputbox안의 값을 불러옴
		let searchform = document.getElementById("searchform");		  //inputbox를 감싸고 있는 폼 객체를 불러옴
		if(searchword=="") {	//input박스 안의 값이 없다면 발동
			alert("검색어를 입력하세요");	//검색어 입력하라고 알림
		} else {	//inputbox안에 값이 있다면
			searchform.submit();	//inputbox를 감싸고있는 폼을 제출시킴 =>action에 저장한 링크로 이동함과 동시에 inputbox안의 값을 전송함
		}
	}
</script>

<%--
공통사항
a href에 자신이 맏은 영역의 컨트롤러와 페이지 집어넣기
그냥 비어있는데에 자기가 맏은 부분 알아서 집어넣기

 --%>