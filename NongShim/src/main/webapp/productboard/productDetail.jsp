<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>${vo.title}</h3>
<table class="table table-bordered">
	<tr>
		<td style="width: 15%; background-color: #d0fd7d;">작성자</td>
		<td colspan="4">${vo.nickName}</td>
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


<table class="table table-bordered table-hover boardlist">
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
</script>



<%-- 제품명은 글 제목에 쓸 거로 감안해서 추가적인 제품명은 안보여주는게 나을수도--%>