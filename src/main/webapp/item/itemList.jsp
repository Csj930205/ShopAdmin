<%@page import="shop.com.vo.ItemVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shop.com.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품리스트</title>
</head>
<%
	List<ItemVo> itemList=(ArrayList<ItemVo>)request.getAttribute("itemList");
%>
<body>
	<%@include file="/main_nav.jsp" %>
	<h1 class="text-center">상품리스트</h1>
	<div class="col-12" >
	  <a href="./itemInsert.do" class="btn btn-secondary">등록</a>
	</div>
	<hr>
 	 <div class="tab-pane fade show active" id="pills-list" role="tabpanel" aria-labelledby="pills-home-tab">
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th class="col-1">item_num</th>
					<th class="col-1">name</th>
					<th class="col-2">title</th>
					<th class="col-1">count</th>
					<th class="col-1">price</th>
					<th class="col-1">color</th>
					<th class="col-1">model_num</th>
					<th class="col-1">member_id</th>
					<th class="col-1">state</th>
					<th class="col-1">cate_num</th>
					<th class="col-1">수정</th>
				</tr>
			</thead>
			<tbody>
				<tr>
				<%for(ItemVo item: itemList){ %>
					<td><%=item.getItem_num() %></td>
					<td><%=item.getName() %></td>
					<td><%=item.getTitle() %></td>
					<td><%=item.getCount() %></td>
					<td><%=item.getPrice() %></td>
					<td><%=item.getColor() %></td>
					<td><%=item.getModel_num() %></td>
					<td><%=item.getMember_id() %></td>
					<td><%=item.getState() %></td>
					<td><%=item.getCate_num() %></td>
					<td><a href="./itemModify.do?item_num=<%=item.getItem_num()%>">수정</a></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
</body>
</html>