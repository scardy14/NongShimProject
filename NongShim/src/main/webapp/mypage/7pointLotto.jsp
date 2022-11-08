<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포인트 복권</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container pt-3">
<div align="left">
<h3> 오늘의 당첨금</h3>
</div>
	<table>
		<thead>
			<tr>
				<td>등수</td><td>당첨 금액</td>
			</tr>
		</thead>
		<tr>
			<td>1</td><td>${requestScope.num1}</td>
		</tr>
		<tr>
			<td>2</td><td>${requestScope.num2}</td>
		</tr>
		<tr>
			<td>3</td><td>${requestScope.num3}</td>
		</tr>
		<tr>
			<td>4</td><td>${requestScope.num4}</td>
		</tr>
		<tr>
			<td>5</td><td>${requestScope.num5}</td>
		</tr>
	</table>

<div>
	<form action="MyPageInsertLottoMoneyController.do">
		<button>
			경품 추첨
		</button>
		<input type="hidden" id="result" name="result" value=""/>
	</form>
</div>

    <script>
    	function  getPrize() {
            //랜덤값 생성 (1~100)
            const ranNum = Math.floor((Math.random() * 99) +1)
            
            let num1=${requestScope.num1};
            let num2=${requestScope.num2};
            let num3=${requestScope.num3};
            let num4=${requestScope.num4};
            let num5=${requestScope.num5};

            //경품 생성
            let gift = [num1, num2, num3, num4, num5,'꽝!']
            //확률 생성
            const pbt = [50,0,0,0,0,50]
            //리턴 경품 값
            let res = ''

            for (let i = 0; i < gift.length; i++) {

                if(pbt[i] >= ranNum){
                    res = gift[i]
                    return res
                }
                else if (pbt[pbt.length - 1] < ranNum) {
                    res = gift[gift.length - 1]
                    return res
                }
            }
            document.getElementById("result").value=res
        }
    </script>
</div> <!-- container pt -->
</body>
</html>