<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form action="${pageContext.request.contextPath}/RegisterController.do" method="post" onsubmit="register(event)" onsubmit="checkRegisterForm(event)">
	<table class = "table-bordered table-borderless">
		<tr>
			<td style="width: 50%;"></td><td><input type = "text" name = "id" id="memberId" required="required" placeholder="아이디" onkeyup="checkId()" style="height: 40px;" ></td><td style="width: 50%; text-align: left;"><span id="checkResult"></span></td>
		</tr>
		<tr>
			<td></td><td><input type = "password" name = "password" required="required" placeholder="비밀번호" style="height: 40px;" id="password"></td><td></td>
		</tr>
		<tr>
			<td></td><td><input type = "password" name = "passwordcheck" required="required" placeholder="비밀번호확인" style="height: 40px;" id = "passwordcheck"></td><td></td>
		</tr>
		<tr>
			<td></td><td><input type = "text" name = "name" required="required" placeholder="이름" style="height: 40px;"></td><td></td>
		</tr>
		<tr>
			<td></td><td><input type = "text" name = "address" required="required" placeholder="주소" style="height: 40px;"></td><td></td>
		</tr>
		<tr>
			<td></td><td><input type = "text" name = "nickname" required="required" placeholder="닉네임" style="height: 40px;"></td><td></td>
		</tr>
		<tr>
			<td></td><td><input type = "text" name = "email" required="required" placeholder="이메일" style="height: 40px;"></td><td></td>
		</tr>
		<tr>
			<td></td><td><input type = "text" name = "tel" id="memberTel" required="required" placeholder="전화번호" onkeyup="checkTel()" style="height: 40px;"></td><td style="text-align: left;"><span id="checkResult2"></span></td>
		</tr>
		<tr>
			<td></td><td><input type = "text" name = "accountNo" required="required" placeholder="계좌번호" style="height: 40px;"></td><td></td>
		</tr>
		<tr>
			<td></td><td><button type = "submit" style="width: 190px;   background-color: #00ac00; color: white;">회원가입</button></td><td></td>
		</tr>
	</table>
</form>

<script type="text/javascript">
	let checkFlag=false;
function checkRegisterForm(event){
	if(checkFlag==false){
		alert("아이디 인증을 받으세요");
		event.preventDefault();
	}
}

	function register(event) {
		let password = document.getElementById("password").value;
		let passwordcheck = document.getElementById("passwordcheck").value;

		if(password !=passwordcheck) {
			alert("비밀번호가 일치하지 않습니다");
			event.preventDefault();
		}	
	}
	

	function checkId(){

		let memberId=document.getElementById("memberId").value; 
		let checkResultSpan=document.getElementById("checkResult");

		if(memberId.length<4){
			checkResultSpan.innerHTML="<font color=pink>아이디는 4글자 이상이여야 합니다.</font>";
		}else{
			let xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4&&xhr.status==200){
					if(xhr.responseText=="ok"){
						checkResultSpan.innerHTML="<font color=blue>사용가능한 아이디입니다.</font>";
						checkFlag=true;
					}else{
						checkResultSpan.innerHTML="<font color=red>아이디가 존재하여 사용이 불가합니다.</font>";
					}
				}//if
			}//function
			xhr.open("get","${pageContext.request.contextPath}/CheckIdController.do?id="+memberId);
			xhr.send();	
		}
	}
	
	
	
	function checkTel(){

		let memberTel=document.getElementById("memberTel").value; 
		let checkResultSpan=document.getElementById("checkResult2");
		
		if(memberTel.length<11){
			checkResultSpan.innerHTML="<font color=pink>전화번호는 열한자 이상이여야 합니다.</font>";
		}else{
			let xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4&&xhr.status==200){
					if(xhr.responseText=="ok"){
						checkResultSpan.innerHTML="<font color=blue>사용가능한 전화번호입니다.</font>";
						checkFlag=true;
					}else{
						checkResultSpan.innerHTML="<font color=red>전화번호를 다시 입력하세요</font>";
					}
				}//if
			}//function
			xhr.open("get","${pageContext.request.contextPath}/CheckTelController.do?tel="+memberTel);
			xhr.send();	
		}
	}
	
	
	
	function checkId(){

		let memberId=document.getElementById("memberId").value; 
		let checkResultSpan=document.getElementById("checkResult");
		
		if(memberId.length<4){
			checkResultSpan.innerHTML="<font color=pink>아이디는 4글자 이상이여야 합니다.</font>";
		}else{
			let xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4&&xhr.status==200){
					if(xhr.responseText=="ok"){
						checkResultSpan.innerHTML="<font color=blue>사용가능한 아이디입니다.</font>";
						checkFlag=true;
					}else{
						checkResultSpan.innerHTML="<font color=red>아이디가 존재하여 사용이 불가합니다.</font>";
					}
				}//if
			}//function
			xhr.open("get","${pageContext.request.contextPath}/CheckIdController.do?id="+memberId);
			xhr.send();	
		}
	}

</script>