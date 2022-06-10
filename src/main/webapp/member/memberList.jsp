<%@page import="java.util.ArrayList"%>
<%@page import="shop.com.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트</title>
</head>
<%
	List<MemberVo> memList=(ArrayList<MemberVo>)request.getAttribute("mem_list");
%>
<body>
	<%@include file="/main_nav.jsp" %>
	<h1 class="text-center">회원리스트</h1>
	<br>
 	 <div class="tab-pane fade show active" id="pills-list" role="tabpanel" aria-labelledby="pills-home-tab">
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th class="col-1">id</th>
					<th class="col-1">pw</th>
					<th class="col-1">phone</th>
					<th class="col-1">email</th>
					<th class="col-1">name</th>
					<th class="col-2">address</th>
					<th class="col-1">address_detail</th>
					<th class="col-1">signup_time</th>
					<th class="col-1">birth</th>
					<th class="col-1">grade</th>
					<th class="col-1">수정</th>
				</tr>
			</thead>
			<tbody>
			<%for(MemberVo mem:memList) {%>
				<tr>
					<td><%=mem.getId()%></td>
					<td><%=mem.getPw() %></td>
					<td><%=mem.getPhone() %></td>
					<td><%=mem.getEmail() %></td>
					<td><%=mem.getName() %></td>
					<td><%=mem.getAddress() %></td>
					<td><%=mem.getAddress_detail() %></td>
					<td><%=mem.getSignup_time() %></td>
					<td><%=mem.getBirth() %></td>
					<td><%=mem.getGrade() %></td>
					<td><a href="./memberModify.do?id=<%=mem.getId()%>">수정</a></td>
				</tr>
			<%} %>
			</tbody>
		</table>
	</div>
</body>
</html>