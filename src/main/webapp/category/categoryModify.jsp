<%@page import="shop.com.vo.CategoryVo"%>
<%@page import="shop.com.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 수정</title>
</head>
<% 
	CategoryVo cate=(CategoryVo)request.getAttribute("cateVo");
%>
<body>
	<%@ include file="/main_nav.jsp" %>
	<h1 class="text-center">카테고리 수정</h1>
	<div class="btn-group" >
	  <a href="./list.do" class="btn btn-secondary">리스트</a>
	</div>
	<hr>
	<div class="d-flex justify-content-center align-items-center" style="height:clac(100vh -200px)">
		<form action="./categoryUpdate.do" method="post">
			<p class="input-group">
				<label class="input-group-text">cate_num</label>
				<input name="cate_num" type="number" class="form-control" value="<%=cate.getCate_num() %>" readonly>
			</p>
			<p class="input-group">
				<label class="input-group-text">name</label>
				<input name="name" type="text" class="form-control" value="<%=cate.getName()%>">
			</p>
			<p class="input-group">
 					<label class="input-group-text">sub</label>
 					<input name="sub" type="number" class="form-control" value="<%=cate.getSub()%>" readonly>
			</p>
			<p class="d-grid gap-2 d-md-flex justify-content-md-end">
				<a class="btn btn-outline-danger" href="./categoryDelete.do?cate_num=<%=cate.getCate_num() %>" >삭제</a>
					<button class="btn btn-outline-warning " type="reset">리셋</button>
					<button class="btn btn-outline-primary " type="submit">수정</button>
			</p>
		</form>
	</div>
</body>
</html>