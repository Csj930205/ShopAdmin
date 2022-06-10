<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop 관리자 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
	    <a class="navbar-brand" href="<%=request.getContextPath()%>">관리자 페이지</a>
    	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      		<span class="navbar-toggler-icon"></span>
    	</button>
			<div class="collapse navbar-collapse justify-content-between" id="navbarNavDropdown">	
				<ul class="navbar-nav">
<% Object login=session.getAttribute("login"); 
	if(login!=null && (boolean)login) {%>

					<li class="nav-item dropdown">
			    		<a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">회원관리</a>
				    		<ul class="dropdown-menu">
								<li class="nav-item">
									<a class="nav-link" href="<%=request.getContextPath()%>/member/list.do">회원리스트</a>
								</li>
							</ul>
					</li>
					<li class="nav-item dropdown">
		    			<a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">카테고리</a>
				    		<ul class="dropdown-menu">	
								<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/category/list.do">카테고리리스트</a></li>
							</ul>
					</li>
					  <li class="nav-item dropdown">
				    	<a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">상품관리</a>
				    	<ul class="dropdown-menu">
					      <li><a class="dropdown-item" href="<%=request.getContextPath()%>/item/list.do">상품리스트</a></li>
				    	</ul>
				  	</li>
<% }%>
				</ul>
<% if(login!=null && (boolean)login){%>
				<div>
					<span><%=session.getAttribute("id") %></span>
					(<span><%=session.getAttribute("name") %></span>)
					(<span><%=session.getAttribute("grade") %></span>)
					님 로그인
					&nbsp;/&nbsp;
    				<a class="" href="<%=request.getContextPath()%>/logout.do">로그아웃</a>
				</div>
<%}else{ %>
    			<div class="d-flax">
    				<a class="" href="<%=request.getContextPath()%>/login/login.do">로그인</a>
    				&nbsp;/&nbsp;
    				<a class="" href="<%=request.getContextPath()%>/signup/signup.do">회원가입</a>
    			</div>
			</div>
		</div>
<%} %>
	</nav>
</body>
</html>