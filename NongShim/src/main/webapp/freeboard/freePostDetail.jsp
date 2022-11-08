<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-bordered ">
   <tr>
      <td style="width: 15%; background-color: #d0fd7d;">제목</td>
      <td colspan="4">${FreePostVO.title}</td>
   </tr>
   <tr>   
      <td style="width: 15%; background-color: #d0fd7d;">작성자</td>
      <td style="width: 35%;">${FreePostVO.nickname }</td>
      <td style="width: 15%; background-color: #d0fd7d;">게시글번호</td>
      <td>${FreePostVO.post_No}</td>
   </tr>
   <tr>
      <td style="backgroutitlend-color: #d0fd7d;">등록일자</td>
      <td>${FreePostVO.register_Date }</td>
      <td style="background-color: #d0fd7d;">조회수</td>
      <td>${FreePostVO.hits }</td>
   </tr>
   <tr>
      <td colspan="5"><pre>${FreePostVO.content }</pre></td>
   </tr>
</table>

<div style="text-align: right;">
   <button type="button" onclick="toList()"
      style="background-color: #00ba00; border-radius: 10px; width: 80px; height: 40px; border: none;">
      <span style="color: white;">목록</span>
   </button>
   <c:choose>

      <c:when test="${sessionScope.mvo.id== FreePostVO.id}">
         <button type="button" onclick="updatepost()"
            style="background-color: #00ba00; border-radius: 10px; width: 80px; height: 40px; border: none;">
            <span style="color: white;">수정</span>
         </button>
         <button type="button" onclick="deletepost()"
            style="background-color: #00ba00; border-radius: 10px; width: 80px; height: 40px; border: none;">
            <span style="color: white;">삭제</span>
         </button>
      </c:when>
   </c:choose>
</div>
<form action="UpdateFreePostFormControllerMove.do" id="udpateform">
   <input type="hidden" name="post_No" value=${FreePostVO.post_No }>
</form>
<form action="DeleteFreePostController.do" method="post" id="deleteform">
   <input type="hidden" name="post_No" value=${FreePostVO.post_No }>
</form>

<%--댓글부분 --%>
<input type="text" style="width: 100%; height: 50px;" id="comment"
   required="required" placeholder="댓글입력">
<br>
<br>
<input type="hidden" value="${FreePostVO.post_No}" id="postno">
<button type="button"
   style="background-color: #00ba00; border-radius: 10px; height: 40px; border: none;"
   onclick="MoveToFreeCommentController()">
   <span style="color: white;">댓글등록</span>
</button>

<br>
<br>

<table class="table   boardlist">
   <thead>
      <tr style="background-color: #00ba00">
         <th style="width: 80px; color: white;">번호</th>
         <th style="color: white;">내용</th>
         <th style="width: 100px; color: white;">작성자</th>
         <th style="width: 150px; color: white;">작성일</th>
         <th style="width: 80px;"></th>
         <th style="width: 80px;"></th>
      </tr>
   </thead>
   <tbody>
      <c:forEach items="${commentlist}" var="commentlist"
         varStatus="commentno">
         <tr>
            <td>${commentlist.postno}</td>
            <td>${commentlist.content}</td>
            <td>${commentlist.nickName}</td>
            <td>${commentlist.writtenDate}</td>

         </tr>
      </c:forEach>
   </tbody>
</table>



<%--댓글 끝 --%>


<script>
   function MoveToFreeCommentController() {
      let comment = document.getElementById("comment").value;
      let postno = document.getElementById("postno").value;
      location.href = "FreeCommentController.do?comment=" + comment
            + "&postno=" + postno;

   }
   function toList() {
      location.href = "FindFreePostListController.do";
   }
   function updatepost() {
      let udpateform = document.getElementById("udpateform");
      udpateform.submit();
   }
   function deletepost() {
      let deleteform = document.getElementById("deleteform");
      let result = confirm("게시물을 삭제하시겠습니까?");
      if (result) {
         deleteform.submit();
      }
   }
</script>


