<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action = "FindPostListBySearchController.do" >
<h3 style="display: inline;">공구게시판</h3> &nbsp;&nbsp;<input type = "text" style="width: 700px; height: 45px;" id = "inputbox" name ="inputbox" value = "${inputvalue }">
<button type = "submit">검색</button><br>
</form>


<form action = "FindPostListByValueController.do" id = "checkboxform">
	<c:forEach items="${checkboxlist }" var="checkbox" varStatus="checkboxno">
		<c:choose>
			<c:when test="${checkbox==checkedbox }">
				<input type='checkbox' name='checkbox' value='${checkbox }' onclick='checkOnlyOne(this); sendinfo()' checked/> ${checkbox }
			</c:when>
			<c:otherwise>
				<input type='checkbox' name='checkbox' value='${checkbox }' onclick='checkOnlyOne(this); sendinfo()'/> ${checkbox }
			</c:otherwise>
		</c:choose>
	</c:forEach>
</form>
<br>




<table class="table table-bordered table-hover boardlist">
	<thead>
		<tr style="background-color: #00ba00">
			<th style="color: white;">번호</th>
			<th style="color: white;">카테고리</th>
			<th style="color: white;">상태</th>
			<th style="color: white; width: 40%;">제목</th>
			<th style="color: white;">작성자</th>
			<th style="color: white;">작성일</th>
			<th style="color: white;">조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="ProductPostVO">
			<tr>
				<td>${ProductPostVO.postNo}</td>
				<td>${ProductPostVO.category}</td>
				<td>${ProductPostVO.status}</td>
				<td><a href="ProductDetailController.do?postno=${ProductPostVO.postNo}">${ProductPostVO.title}</a></td>
				<td>${ProductPostVO.nickName}</td>
				<td>${ProductPostVO.date}</td>
				<td>${ProductPostVO.hits}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<c:choose>
	<c:when test="${sessionScope.mvo.sellerInfo == '판매자'}">
		<div style="text-align: right;">
			<button onclick="location.href='WritePostFormController.do'" style="background-color: #00ba00; color: white; width: 8%; height: 30px; border: none; border-radius: 5px;"><span style="color: white;">글쓰기</span></button><br><br>
		</div>
	</c:when>
</c:choose>

<!--
      pagination 
-->
<c:choose>
	<c:when test="${mode =='value' }">
		<ul class="pagination justify-content-center" style="margin:20px 0">	
			<c:if test="${pagination.previousPageGroup}">
				<li class="page-item"><a class="page-link" onclick="sendpageandinfo(${pagination.startPageOfPageGroup-1})">Previous</a></li>
			</c:if>
			<c:forEach begin="${pagination.startPageOfPageGroup}" end="${pagination.endPageOfPageGroup}" var="page">
			<c:choose>
				<c:when test="${pagination.nowPage==page}">
					<li class="page-item active"><a class="page-link" onclick="sendpageandinfo(${page})">${page}</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" onclick="sendpageandinfo(${page})">${page}</a></li>
				</c:otherwise>
			</c:choose>	
			</c:forEach>
			<c:if test="${pagination.nextPageGroup}">
		  		<li class="page-item"><a class="page-link" onclick="sendpageandinfo(${pagination.endPageOfPageGroup+1})">Next</a></li>     
		  	</c:if>	
		</ul>
	</c:when>
	<c:otherwise>
		<ul class="pagination justify-content-center" style="margin:20px 0">	
			<c:if test="${pagination.previousPageGroup}">
				<li class="page-item"><a class="page-link" onclick="sendpageandsearch(${pagination.startPageOfPageGroup-1})">Previous</a></li>
			</c:if>
			<c:forEach begin="${pagination.startPageOfPageGroup}" end="${pagination.endPageOfPageGroup}" var="page">
			<c:choose>
				<c:when test="${pagination.nowPage==page}">
					<li class="page-item active"><a class="page-link" onclick="sendpageandsearch(${page})">${page}</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" onclick="sendpageandsearch(${page})">${page}</a></li>
				</c:otherwise>
			</c:choose>	
			</c:forEach>
			<c:if test="${pagination.nextPageGroup}">
		  		<li class="page-item"><a class="page-link" onclick="sendpageandsearch(${pagination.endPageOfPageGroup+1})">Next</a></li>     
		  	</c:if>	
		</ul>	
	</c:otherwise>
</c:choose>

<hr>

<script>
	function checkOnlyOne(element) {
		  const checkboxes = document.getElementsByName("checkbox");
		  checkboxes.forEach((cb) => {
		    cb.checked = false;
		  })
		  element.checked = true;
		}
	function sendinfo() {
		let checkboxform = document.getElementById("checkboxform");
		checkboxform.submit();
	}
	function sendpageandinfo(element) {
		let checkboxes = document.getElementsByName("checkbox");
		let loop = checkboxes.length;
		let checkbox = null;
		for(let i = 0; i<loop;i++) {
			if(checkboxes[i].checked) {
				checkbox = checkboxes[i].value;
			}
		}
		location.href="FindPostListByValueController.do?pageNo="+element+"&checkbox="+checkbox;
	}
	function sendpageandsearch(element) {
		let inputbox = document.getElementById("inputbox").value;
		location.href="FindPostListBySearchController.do?pageNo="+element+"&inputbox="+inputbox;		
	}
	
</script>