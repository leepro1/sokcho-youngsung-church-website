<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../include/header.jsp" %>

<div class="container p-4">
    <c:choose>
        <c:when test="${empty userInfo}">
            <h2>비밀번호 찾기</h2>
        </c:when>
        <c:otherwise>
            <h2>비밀번호 변경하기</h2>
        </c:otherwise>
    </c:choose>

    <form action="${root}/members/changePwd" method="post">
        <c:choose>
            <c:when test="${empty userInfo}">
                <div class="form-group">
                    <label for="email">email:</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Email 입력">
                </div>
                <div class="form-group">
                    <label for="name">email:</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="이름 입력">
                </div>
            </c:when>
        </c:choose>
        <div class="form-group">
            <label for="pw">비밀번호:</label>
            <input type="password" class="form-control" id="pw" name="password" placeholder="새로운 비밀번호 입력">
        </div>
        <button type="submit" class="btn btn-primary">로그인</button>
        <a class="btn btn-secondary" href="${root}/members/changePwd">비밀번호 찾기</a>
        <a class="btn btn-secondary" href="${root}/members/join">회원가입</a>
        <a class="btn btn-secondary" href="${root}/">메인 페이지</a>
    </form>
</div>
</body>
</html>