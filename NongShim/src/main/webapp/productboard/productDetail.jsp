<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<form action="UpdatePostFormController.do" method="post" id="update">
	<input type="hidden" name="no" value="${vo.postNo}"> <input
		type="hidden" name="title" value="${vo.title}"> <input
		type="hidden" name="content" value="${vo.content}">
</form>
<form action="DeletePostController.do" method="post" id="delete1">
	<input type="hidden" name="no" value="${vo.postNo }">
</form>

<h3>${vo.title}</h3>

<div style="text-align: right;">
	<form>

		<input type="hidden" id="postno12" value="${vo.postNo}"> <input
			type="hidden" id="id12" value="${sessionScope.mvo.id}">
		
		<button type="button" onclick="startAjax12()">좋아요♥</button>
		<span id="likeCount">${requestScope.cocount}</span>

	</form>
</div>

<script>
function startAjax12() {
	//alert("눌렷는가");
 	let postno=document.getElementById("postno12");
	let id=document.getElementById("id12");
	let countSpan=document.getElementById("likeCount");
	let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			
			if(xhr.readyState==4&&xhr.status==200){
				//alert(xhr.responseText);
				/*
				if(xhr.responseText=="pushok"){
					countSpan.innerHTML="${requestScope.likeTotal}";
					
				}else{
					countSpan.innerHTML="${requestScope.likeTotal}";
				}
				
			
			*/
				countSpan.innerHTML=xhr.responseText;
			}
		}//function
		xhr.open("get","LikeController.do?postno123="+postno.value+"&id123="+id.value);
		xhr.send();

}//startAjax12
</script>

<br>
<table class="table table-bordered">
	<tr>
		<td style="width: 15%; background-color: #00ba00; color: white;">작성자</td>
		<td>${vo.nickName}</td>
		<td style="background-color: #00ba00; color: white;">판매가격</td>
		<td>${vo.productPoint}</td>
	</tr>

	<tr>
		<td style="background-color: #00ba00; color: white;">등록일</td>
		<td>${vo.date}</td>
		<td style="background-color: #00ba00; color: white;">판매기간</td>
		<td>${vo.duration}</td>
	</tr>
	<tr>
		<td style="background-color: #00ba00; color: white;">카테고리</td>
		<td>${vo.category}</td>
		<td style="background-color: #00ba00; color: white;">조회수</td>
		<td>${vo.hits}</td>
	</tr>
	<tr>
		<td style="background-color: #00ba00; color: white;">최소공구인원</td>
		<td>${vo.minCustomer}</td>
		<td style="background-color: #00ba00; color: white;">주문가능인원</td>
		<td>${vo.maxCustomer}</td>
	</tr>
</table>

${vo.content}

<br>
<br>
<c:choose>
	<c:when test="${sessionScope.mvo !=null}">
		<button
			style="background-color: #color: white;; border-radius: 10px; width: 500px; height: 50px; border: none;"
			onclick="buyproduct(true)">구매하기</button>
		<br>
	</c:when>
	<c:otherwise>
		<button
			style="background-color: #00ba00; border-radius: 10px; width: 500px; height: 50px; border: none;"
			onclick="buyproduct(false)">구매하기</button>
		<br>
	</c:otherwise>
</c:choose>
<br>
<c:choose>
	<c:when test="${sessionScope.mvo.nickName==vo.nickName}">
		<td>
			<div style="text-align: right;">
				<button onclick="location.href='FindPostListByValueController.do'"
					style="background-color: #00ba00; color: white; border: none; width: 60px; height: 30px; ">목록</button>
				<button onclick="location.href='WritePostFormController.do'"
					style="background-color: #00ba00; color: white; border: none; width: 60px; height: 30px;">글쓰기</button>
				<button type="button"
					style="background-color: #00ba00; color: white; border: none; width: 60px; height: 30px;"
					onclick="update()">수정</button>
				<button type="button"
					style="background-color: #00ba00; color: white; border: none; width: 60px; height: 30px;"
					onclick="delete1()">삭제</button>
			</div>
		</td>
	</c:when>
	<c:otherwise>
		<button onclick="location.href='FindPostListByValueController.do'"
			style="background-color: #00ba00; color: white; border: none; width: 60px; height: 30px;">목록</button>
	</c:otherwise>
</c:choose>

<hr>


<input type="text" style="width: 100%; height: 50px;" id="comment"
	required="required" placeholder="댓글입력">
<br>
<br>


<input type="hidden" value="${postno}" id="postno">
<button type="button"
	style="background-color: #00ba00; border-radius: 10px; height: 40px; border: none;"
	onclick="moon()">문의글작성</button>
<button type="button"
	style="background-color: #00ba00; border-radius: 10px; height: 40px; border: none;"
	onclick="hoo()">후기글작성</button>

<div style="text-align: right;">
	<c:choose>
		<c:when test="${commentMode=='hoo' }">
			<input type="checkbox" name="checkbox" value="all"
				onclick="commentMode(${vo.postNo },'all')" >전체
			<input type="checkbox" name="checkbox" value="hoo"
				onclick="commentMode(${vo.postNo },'hoo')" checked>후기
			<input type="checkbox" name="checkbox" value="moon"
				onclick="commentMode(${vo.postNo },'moon')">문의
		</c:when>
		<c:when test="${commentMode=='moon' }">
			<input type="checkbox" name="checkbox" value="all"
				onclick="commentMode(${vo.postNo },'all')" >전체
			<input type="checkbox" name="checkbox" value="hoo"
				onclick="commentMode(${vo.postNo },'hoo')" >후기
			<input type="checkbox" name="checkbox" value="moon"
				onclick="commentMode(${vo.postNo },'moon')" checked>문의
		</c:when>
		<c:otherwise>
			<input type="checkbox" name="checkbox" value="all"
				onclick="commentMode(${vo.postNo },'all')" checked>전체
			<input type="checkbox" name="checkbox" value="hoo"
				onclick="commentMode(${vo.postNo },'hoo')">후기
			<input type="checkbox" name="checkbox" value="moon"
				onclick="commentMode(${vo.postNo },'moon')">문의
	</c:otherwise>
	</c:choose>
</div>

<br>
<br>


<table class="table   boardlist">
	<thead>
		<tr style="background-color: #00ba00">
			<th>번호</th>
			<th>내용</th>
			<th>카테고리</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${commentlist}" var="commentlist">
			<tr>
				<td>${commentlist.postno}</td>
				<td>${commentlist.content}</td>
				<td>${commentlist.category}</td>
				<td>${commentlist.id}</td>
				<c:choose>
					<c:when test="${commentlist.id==sessionScope.mvo.id }">
						<td>${commentlist.writtenDate}<button>수정하기</button><button>삭제하기</button></td>
					</c:when>
					<c:otherwise>
						<td>${commentlist.writtenDate}</td>
					</c:otherwise>
				</c:choose>				
			</tr>
		</c:forEach>
	</tbody>
</table>



<form id="buyform" action="BuyProductController.do">
	<input type="hidden" name="id" value="${sessionScope.mvo.id }">
	<input type="hidden" name="post_No" value="${vo.postNo }">
</form>





<br>
<br>

<script>
	function moon() {
		let comment = document.getElementById("comment").value;
		if(comment.length==0){
			alert("댓글을 입력해주세요");
			return;	
		}
		let postno = document.getElementById("postno").value;
		location.href = "MoonCommentController.do?comment=" + comment
				+ "&postno=" + postno;
	}

	function hoo() {
		let comment = document.getElementById("comment").value;
		if(comment.length==0){
			alert("댓글을 입력해주세요");
			return;
		}
		let postno = document.getElementById("postno").value;
		location.href = "HooCommentController.do?comment=" + comment
		+ "&postno=" + postno;;
	}
	function update() {
		let id = document.getElementById("update");
		let result = confirm("게시물을 수정하시겠습니까?");
		if(result) {
			id.submit();
		}
	}
	function delete1() {   
		let id = document.getElementById("delete1");
		let result = confirm("게시물을 삭제하시겠습니까?");
		if(result) {
			id.submit();
		}
	}
	function buyproduct(result) {
		if(!result) {
			alert("로그인 후 이용해주세요");
		} else {
			let result = confirm("상품을 구매하시겠습니까?");
			let buyform = document.getElementById("buyform");
			buyform.submit();
		}
	}
	function commentMode(postno, mode) {
	/* 	let checkboxes = document.getElementsByName("checkbox");
		let loop = checkboxes.length;
		let checkbox = null;
		for(let i = 0; i<loop;i++) {
			if(checkboxes[i].checked) {
				checkbox = checkboxes[i].value;
			}
		} */
		location.href = "ProductDetailController.do?postno="+postno+"&checkbox="+mode;
	}
</script>



<%-- 제품명은 글 제목에 쓸 거로 감안해서 추가적인 제품명은 안보여주는게 나을수도--%>