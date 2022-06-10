<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<%	
	Object login_obj=session.getAttribute("login");
	Object id=session.getAttribute("id");
	if(login_obj!=null && !((boolean) login_obj)){
		session.removeAttribute("login"); // 세션 객체 삭제
%>
		<script>alert("아이디와 패스워드를 확인하세요!");</script>
	<%}
	Object login_msg=session.getAttribute("login_msg");
	if(login_msg!=null){ // 맴버리스트 접근시 차단
		session.removeAttribute("login_msg");
	%>
		<script>alert("<%=login_msg%>")</script>
	<%}
	Object item_msg=session.getAttribute("item_msg");
	if(item_msg!=null){// 상품리스트 접근시 차단
		session.removeAttribute("item_msg");
	%>
	<script>alert("<%=item_msg%>")</script>
	<%}
	Object cate_msg=session.getAttribute("cate_msg");
	if(cate_msg!=null){
		session.removeAttribute("cate_msg");			
	%>
	<script>alert("<%=cate_msg%>")</script>
	<%}%>
<%@include file="/main_nav.jsp" %>
	<h1 class="text-center">로그인</h1>
	<br>
	<div class="d-flex justify-content-center align-items-center" style="height:clac(100vh -200px)">
		<form action="<%=request.getContextPath()%>/login/login.do" method="post" style="width: 400px;">
		  <div class="mb-3 row">
		    <label for="staticEmail" class="col-sm-3 col-form-label">아이디</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="staticEmail" value="<%=(id!=null)?id:""%>" name="id">
		    </div>
		  </div>
		  <div class="mb-3 row">
		    <label for="inputPassword" class="col-sm-3 col-form-label" >패스워드</label>
		    <div class="col-sm-10">
		      <input type="password" class="form-control" id="inputPassword" name="pw">
		    </div>
		  </div>
	  	  <div class="col-12">
			<a class="btn btn-danger" href="<%=request.getContextPath() %>/signup/signup.do" >회원가입</a>
		  	<button type="submit" class="btn btn-success">로그인</button>
		  </div>
		</form>
	</div>
</body>
</html>