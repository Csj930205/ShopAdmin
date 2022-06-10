<%@page import="shop.com.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<script>
	window.onload=function(){
		const MemberInsert=document.forms.MemInsert;
		MemberInsert.id.addEventListener("input",async(e)=>{ // ID 중복체크
			if(e.target.value.length>4){
				const res=await fetch("./id_check.do?id="+e.target.value);
				const json=await res.json();
				if(json.id_check){
					checkId.innerText="사용가능한 아이디입니다."
					checkId.style.color="green";
				}else{
					checkId.innerText="이미 사용중인 아이디입니다."
					checkId.style.color="red";
				}
			}else{
				checkId.innerText="5글자 이상 입력하세요."
				checkId.style.color="red";
			}
		});
		MemberInsert.email.addEventListener("input", async(e)=>{ // Email 중복체크
			const res=await fetch("./email_check.do?email="+e.target.value);
			const json=await res.json();
			if(json.email_check){
				checkEmail.innerText="사용가능한 이메일입니다";
				checkEmail.style.color="green";
			}else{
				checkEmail.innerText="이미 사용중인 이메일입니다.";
				checkEmail.style.color="red";
			}
		});
		MemberInsert.phone.addEventListener("input",async(e)=>{ // Phone 중복체크
			const res=await fetch("./phone_check.do?phone="+e.target.value);
			const json=await res.json();
			if(json.phone_check){
				checkPhone.innerText="사용가능한 번호입니다."
				checkPhone.style.color="green"
			}else{
				checkPhone.innerText="이미 사용중인 번호입니다."
				checkPhone.style.color="red"				
			}
		});
		const PwC=MemberInsert.pw.addEventListener("input",async(e)=>{ // Pw 길이 및 중복체크
				const res=await fetch("./pw_check.do?pw="+e.target.value);
				const json=await res.json();
			if(e.target.value.length>4){
				checkPw.innerText="사용가능한 비밀번호 입니다."
				checkPw.style.color="green"					
			}else{
				checkPw.innerText="4자리 이상 입력하세요."
				checkPw.style.color="red"				
			}
		});
		MemberInsert.check_pw.addEventListener("input",(e)=>{ // Pw 일치 여부
			if(e.target.value==MemberInsert.pw.value){
				console.log(MemberInsert.pw.value)
				checkPwCheck.innerText="비밀번호가 일치합니다."
				checkPwCheck.style.color="green"
			}else{
				checkPwCheck.innerText="비밀번호가 일치하지 않습니다."
				checkPwCheck.style.color="red"
			}
		});
	}
</script>
<body>
	<%@ include file="/main_nav.jsp" %>
	<h1 class="text-center">회원가입</h1>
	<br>
	<div class="d-flex justify-content-center align-items-center" style="height:clac(100vh -200px)">
		<form action="./signup.do" method="post" name="MemInsert" style="width: 400px">
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<span class="input-group-text" id="basic-addon3">아이디</span>
  					<input type="text" class="form-control" name="id">
				</div>
			</div>
			<p id="checkId">아이디 중복체크</p>
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<span class="input-group-text" id="basic-addon3">이메일</span>
  					<input type="text" class="form-control" name="email">
				</div>
			</div>		
			<p id="checkEmail">이메일 중복체크</p>
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<span class="input-group-text" id="basic-addon3">폰번호</span>
  					<input type="text" class="form-control" name="phone">
				</div>
			</div>		
			<p id="checkPhone">폰번호 중복체크</p>			
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<span class="input-group-text" id="basic-addon3">패스워드</span>
  					<input type="text" class="form-control" name="pw">
				</div>
			</div>		
			<p id="checkPw">길이 4이상 입력</p>
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<span class="input-group-text" id="basic-addon3">패스워드체크</span>
  					<input type="text" class="form-control" name="check_pw">
				</div>
			</div>		
			<p id="checkPwCheck">같은 비밀번호 입력</p>
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<span class="input-group-text" id="basic-addon3">이름</span>
  					<input type="text" class="form-control" name="name">
				</div>
			</div>		
			<br>
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<label class="input-group-text" for="inputGroupSelect01">주소</label>
  					<select class="form-select" id="inputGroupSelect01" name="address">
						    <option selected>선택</option>
						    <option value="서울">서울</option>
						    <option value="부산">부산</option>
						    <option value="대구">대구</option>
  					</select>
				</div>
			</div>
			<br>
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<span class="input-group-text" id="basic-addon3">주소상세</span>
  					<input type="text" class="form-control" name="address_detail">
				</div>
			</div>
			<br>	
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<label class="input-group-text" for="inputGroupSelect01">등급</label>
  					<select class="form-select" id="inputGroupSelect01" name="grade">
							<option value="0" disabled>총관리자(0)</option>
							<option value="1" disabled>관리자(1)</option>
							<option value="2">판매자(2)</option>
							<option value="3" selected="selected">소비자(3)</option>
							<option value="4" disabled>탈퇴(4)</option>
  					</select>
				</div>
			</div>
			<br>
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<span class="input-group-text" id="basic-addon3">생일</span>
  					<input type="date" class="form-control" name="birth" pattern="yyyy-mm-dd">
				</div>
			</div>	
			<div class="col-10">
				<button type="reset" class="btn btn-outline-warning">리셋</button>
				<button type="submit" class="btn btn-outline-primary">가입</button>					
			</div>	
		</form>
	</div>
</body>
</html>