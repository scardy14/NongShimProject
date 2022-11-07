<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
		<c:when test="${sessionScope.mvo.nickName==vo.nickName}">	 
				<td>
					<div style="text-align: right;">
					<button onclick="location.href='FindPostListByValueController.do'" style="background-color: #00ac00; color: white; width: 5%; height: 30px;">목록</button>
					<button onclick="location.href='WritePostFormController.do'" style="background-color: #00ac00; color: white; width: 8%; height: 30px;">글쓰기</button>
					<button type="button" style="background-color: #00ac00; color: white; width: 5%; height: 30px;" onclick="update()">수정</button>
					<button type="button" style="background-color: #00ac00; color: white; width: 5%; height: 30px;" onclick="delete1()">삭제</button>
					</div>
				</td>
		</c:when>
</c:choose>

	<form action="UpdatePostFormController.do" method="post" id="update">
		<%-- <input type="text" name = "no" value = "${postvo.no}">
		<input type="text" name = "title" value = "${postvo.title}">
		<input type="text" name = "content" value = "${postvo.content}"> --%>
	</form>
	<form action="DeletePostController.do" method="post" id="delete1">
		<input type = "hidden" name = "no" value = ${vo.postNo }>
	</form>

<h3>${vo.title}</h3>

<div style="text-align: right;">
<form action="LikeController.do?postno12=${vo.postNo}&id12=${sessionScope.mvo.id }">
<button>
좋아요
</button>
${requestScope.likeTotal}

</form>
</div>

<script>

function likemethod(){
	alert("좋아요를 누르셨습니다!")
	location.href="LikeController.do"
	//세션 mvo.id 로 아이디
	//
	
	
	
}



</script>

<br>
<table class="table table-bordered">
	<tr>
		<td style="width: 15%; background-color: #d0fd7d;">작성자</td>
		<td>${vo.nickName}</td>
		<td style="background-color: #d0fd7d;">판매가격</td>
		<td>${vo.productPoint}</td>
	</tr>

	<tr>
		<td style="background-color: #d0fd7d;">등록일</td>
		<td>${vo.date}</td>
		<td style="background-color: #d0fd7d;">판매기간</td>
		<td>${vo.duration}</td>
	</tr>
	<tr>
		<td style="background-color: #d0fd7d;">카테고리</td>
		<td>${vo.category}</td>
		<td style="background-color: #d0fd7d;">조회수</td>
		<td>${vo.hits}</td>
	</tr>
	<tr>
		<td style="background-color: #d0fd7d;">최소공구인원</td>
		<td>${vo.minCustomer}</td>
		<td style="background-color: #d0fd7d;">주문가능인원</td>
		<td>${vo.maxCustomer}</td>
	</tr>
</table>

${vo.content}
<hr>




댓글 쓰기
<input type="text" style="width: 90%; height: 50px;" id="comment" required="required">
<br>
<br>

<input type="hidden" value="${postno}" id="postno">
<button type="button" style="width: 10%; height: 50px;" onclick="moon()">문의글작성</button>



<button type="button" style="width: 10%; height: 50px;" onclick="hoo()">후기글작성</button>



<br>
<br>


<table class="table   boardlist">
	<thead>
		<tr style="background-color: #d0fd7d">
			<th>번호</th>
			<th>내용</th>
			<th>카테고리</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list1}" var="commentlist">
			<tr>
				<td>${commentlist.postno}</td>
				<td>${commentlist.content}</td>
				<td>${commentlist.category}</td>
				<td>${commentlist.id}</td>
				<td>${commentlist.writtenDate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>













<br>
<br>

<script>
	function moon() {

		let comment = document.getElementById("comment").value;
		if(comment.length==0){
			alert("입력된게 없습니다.")
			return;
			
		}
		let postno = document.getElementById("postno").value;
		location.href = "MoonCommentController.do?comment=" + comment
				+ "&postno=" + postno;
	}

	function hoo() {

		let comment = document.getElementById("comment").value;
		if(comment.length==0){
			alert("입력된게 없습니다.")
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
</script>



<%-- 제품명은 글 제목에 쓸 거로 감안해서 추가적인 제품명은 안보여주는게 나을수도--%>