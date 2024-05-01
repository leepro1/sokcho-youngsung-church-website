<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>속초영성교회</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-light navbar-light">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link active" href="${root}/">로고</a>
				</li>
				<c:choose>
					<c:when test='${empty userInfo }'>
						<li class="nav-item">
							<a class="nav-link" href="${root}/members/login">로그인</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="${root}/members/join">회원가입</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="nav-item">
							<a class="nav-link" href="${root}/members/mypage">MyPage</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="${root}/members/logout">로그아웃</a>
						</li>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test='${userInfo.role eq ("ADMIN")}'>
						<li class="nav-item">
							<a class="nav-link" href="${root}/members/admin/list">회원관리</a>
						</li>
					</c:when>
				</c:choose>
			</ul>
		</div>
	</nav>