<%@page import="shop.com.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<% 
	MemberVo memVo=(MemberVo)request.getAttribute("memVo");
%>
<body>
	<%@ include file="/main_nav.jsp" %>
	<h1 class="text-center">회원정보 수정</h1>
	<div class="btn-group" >
	  <a href="./list.do" class="btn btn-secondary">리스트</a>
	</div>
	<hr>
	<div class="d-flex justify-content-center align-items-center" style="height:clac(100vh -200px)">
		<form action="./memberUpdate.do" method="post">
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<span class="input-group-text" id="basic-addon3">아이디</span>
  					<input type="text" class="form-control" name="id" value="<%=memVo.getId()%>" disabled>
				</div>
			</div>
			<br>	
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<span class="input-group-text" id="basic-addon3">이메일</span>
  					<input type="text" class="form-control" name="email" value="<%=memVo.getEmail()%>">
				</div>
			</div>	
			<p id="checkEmail">이메일 중복체크</p>
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<span class="input-group-text" id="basic-addon3">폰번호</span>
  					<input type="text" class="form-control" name="phone" value="<%=memVo.getPhone()%>">
				</div>
			</div>	
			<p id="checkPhone">폰번호 중복체크</p>
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<span class="input-group-text" id="basic-addon3">패스워드</span>
  					<input type="text" class="form-control" name="pw" value="<%=memVo.getPw()%>">
				</div>
			</div>	
			<p id="checkPw">길이가 4이상</p>					
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<span class="input-group-text" id="basic-addon3">패스워드체크</span>
  					<input type="text" class="form-control" name="pwC" value="<%=memVo.getPw()%>">
				</div>
			</div>	
			<p id="checkPwCheck">같은 비밀번호 입력</p>				
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<span class="input-group-text" id="basic-addon3">이름</span>
  					<input type="text" class="form-control" name="name" value="<%=memVo.getName()%>">
				</div>
			</div>	
			<br>
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<label class="input-group-text" for="inputGroupSelect01">주소</label>
  					<select class="form-select" id="inputGroupSelect01" name="address" value="<%=memVo.getAddress()%>">
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
  					<input type="text" class="form-control" name="address_detail" value="<%=memVo.getAddress_detail()%>">
				</div>
			</div>	
			<br>
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<label class="input-group-text" for="inputGroupSelect01">등급</label>
  					<select class="form-select" id="inputGroupSelect01" name="grade" value="<%=memVo.getGrade()%>">
						<option value="0" <%if(memVo.getGrade()==0){out.append("selected");}%> >총관리자(0)</option>
						<option value="1" <%if(memVo.getGrade()==1){out.append("selected");}%>>관리자(1)</option>
						<option value="2" <%if(memVo.getGrade()==2){out.append("selected");}%>>판매자(2)</option>
						<option value="3" <%if(memVo.getGrade()==3){out.append("selected");}%>>소비자(3)</option>
						<option value="4" <%if(memVo.getGrade()==4){out.append("selected");}%>>탈퇴(4)</option>
  					</select>
				</div>
			</div>			
			<br>
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<span class="input-group-text" id="basic-addon3">가입일</span>
  					<input type="date" class="form-control" name="signup_time" value="<%=memVo.getSignup_time()%>" disabled>
				</div>
			</div>	
			<br>
			<div class="col-sm-12">
				<div class="input-group mb-1">
  					<span class="input-group-text" id="basic-addon3">생일</span>
  					<input type="date" class="form-control" name="birth" value="<%=memVo.getBirth()%>">
				</div>
			</div>	
			<p class="d-grid gap-2 d-md-flex justify-content-md-end">
				<button type="reset" class="btn btn-outline-warning">리셋</button>
				<a class="btn btn-outline-danger" href="./memberDelete.do?id=<%=memVo.getId()%>" >삭제</a>
				<button type="submit" class="btn btn-outline-primary">수정</button>					
			</p>				
		</form>
	</div>
	<br>
</body>
</html>