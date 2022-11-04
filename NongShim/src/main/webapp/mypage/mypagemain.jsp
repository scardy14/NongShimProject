<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container pt-3">
<table class="table table-bordered">
    <thead >
      <tr style="background-color: #d0fd7d">
        <th rowspan="2" colspan="1" style="width: 20%">마이농심</th>
        <th style="width: 40%">확인중</th>
        <th style="width: 40%">발송완료</th>
      </tr>
    </thead>
    <tbody>
    <tr>
    <td></td>
    <td>확인중 value</td>
    <td>발송완료 value</td>
      <tr>
        <th>구매</th>
        <td colspan="2" rowspan="3"></td>
      </tr>
      <tr>
        <th>판매</th>
      </tr>
      <tr>
         <th>내정보</th>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>