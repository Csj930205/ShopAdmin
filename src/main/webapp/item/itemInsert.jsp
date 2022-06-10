<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
</head>
<body>
	<%@include file="/main_nav.jsp" %>
	<h1 class="text-center">상품등록</h1>
	<div class="col-12" ><a href="./list.do" class="btn btn-secondary">리스트</a></div>
	<hr>
	<div class="d-flex justify-content-center align-items-center" style="height:clac(100vh -200px)">
		<form action="./itemInsert.do" method="post" style="width:500px">
			<p class="input-group">
				<label class="input-group-text">상품이름</label>
 				<input name="name" type="text" class="form-control" value="">
			</p>
	  		<p class="input-group">
				<label class="input-group-text">게시타이틀</label>
				<input name="title" type="text" class="form-control" value="">
			</p>
	  		<p class="input-group">
				<label  class="input-group-text">상품모델</label>
				<input name="model_num" type="text" class="form-control" value="">
			</p>
	  		<p class="input-group">
				<label class="input-group-text">게시자</label>
				<input name="member_id" type="text" class="form-control" value="admin" readonly>
			</p>
	  		<p class="input-group">
				<label class="input-group-text">상품가격</label>
				<input name="price" type="number" class="form-control" value="" >
			</p>
			<p class="input-group">
				<label class="input-group-text">카테고리</label>
				<select name="cate_num" class="form-control" >
					<option value="1">가전</option>
					<option value="2">컴퓨터</option>
				</select>
			</p>
	  		<p class="input-group">
				<label class="input-group-text">상품메인이미지</label>
				<input name="main_img" type="file" class="form-control" value="">
			</p>
	  		<p class="input-group">
				<label class="input-group-text">상품상세이미지</label>
				<input name="detail_img" type="file" class="form-control" value="">
			</p>
	  		<p class="input-group">
				<label class="input-group-text">상품판매시작일</label>
				<input name="sale_time" type="datetime-local" class="form-control" value="">
			</p>
	  		<p class="input-group">
				<label class="input-group-text">상품판매종료일</label>
				<input name="sale_end_time" type="datetime-local" class="form-control" value="">
			</p>
	  		<p class="input-group">
				<label class="input-group-text">상품색</label>
				<input name="color" type="color" class="form-control form-control-color" value="#563d7c" title="Choose your color">
				<label class="input-group-text">상태</label>
				<select name="state" class="form-control">
					<option value="0" selected>공개</option>
					<option value="1">비공개</option>
				</select>
				<label class="input-group-text">판매수</label>
				<input name="count" type="number" class="form-control" value="">
	  		</p>
	  		<p class="d-grid gap-2 d-md-flex justify-content-md-end">
				<button class="btn btn-outline-warning " type="reset">리셋</button>
				<button class="btn btn-outline-primary " type="submit">등록</button>
	  		</p>
		</form>
	</div>
</body>
</html>