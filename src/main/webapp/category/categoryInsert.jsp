<%@page import="shop.com.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 등록</title>
</head>
<body>
	<%@ include file="/main_nav.jsp" %>
	<h1 class="text-center">카테고리 등록</h1>
	<div class="btn-group" ><a href="./list.do" class="btn btn-secondary">리스트</a></div>
	<hr>
	<div class="d-flex justify-content-center align-items-center" style="height:clac(100vh -200px)">
		<form action="./categoryInsert.do" method="post" style="width: 400px">
			<p class="input-group">
				<label class="input-group-text">name</label>
				<input name="name" type="text" class="form-control" value="">
			</p>
			<p class="input-group">
				<label class="input-group-text">sub</label>
				<input name="sub" type="number" class="form-control" value="0" readonly>
			</p>
			<p class="d-grid gap-2 d-md-flex justify-content-md-end">
				<button class="btn btn-outline-warning " type="reset">리셋</button>
				<button class="btn btn-outline-primary " type="submit">등록</button>
			</p>
		</form>
	</div>
</body>
</html>