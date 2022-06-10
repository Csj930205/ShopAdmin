<%@page import="shop.com.vo.CategoryVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리리스트</title>
</head>
<%
	List<CategoryVo> cate_list=(ArrayList<CategoryVo>)request.getAttribute("cateList");
%>
<body>
	<%@include file="/main_nav.jsp" %>
	<h1 class="text-center">카테고리 리스트</h1>
	<br>
	<div class="col-12" >
	  <a href="./categoryInsert.do" class="btn btn-secondary">등록</a>
	</div>
	<hr>
 	 <div class="tab-pane fade show active" id="pills-list" role="tabpanel" aria-labelledby="pills-home-tab">
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th class="col-1">cate_num</th>
					<th class="col-1">name</th>
					<th class="col-1">sub</th>
					<th class="col-1">수정</th>
				</tr>
			</thead>
			<tbody>
			<%for(CategoryVo cate:cate_list) {%>
				<tr>
					<td><%=cate.getCate_num()%></td>
					<td><%=cate.getName() %></td>
					<td><%=cate.getSub() %></td>
					<td><a href="./categoryModify.do?cate_num=<%=cate.getCate_num()%>">수정</a></td>
				</tr>
			<%} %>
			</tbody>
		</table>
	</div>
</body>
</html>