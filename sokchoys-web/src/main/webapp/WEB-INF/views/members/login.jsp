<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<div class="container p-4">
    <h2>로그인</h2>
    <form action="${root}/members/login" method="post">
        <c:if test="${!empty msg }">
            <div class="form-group">
                <h3 class='text-center text-danger'>${msg}</h3>
            </div>
        </c:if>

        <div class="form-group">
            <label for="email">email:</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Email 입력" value="${cookie.saveEmail.value}">
        </div>
        <div class="form-group">
            <label for="pw">비밀번호:</label>
            <input type="password" class="form-control" id="pw" name="password" placeholder="비밀번호 입력" >
        </div>
        <div class="form-group form-check">
            <label class="form-check-label">
                <c:choose>
                    <c:when test="${empty cookie.saveEmail}">
                        <input class="form-check-input" type="checkbox" name="remember"> 아이디 기억하기
                    </c:when>
                    <c:otherwise>
                        <input class="form-check-input" type="checkbox" name="remember" checked="checked"> 아이디 기억하기
                    </c:otherwise>
                </c:choose>
            </label>
        </div>

        <button type="submit" class="btn btn-primary">로그인</button>
        <a class="btn btn-secondary" href="${root}/members/join" >회원가입</a>
        <a class="btn btn-secondary" href="${root}/">메인 페이지</a>
    </form>
</div>
</body>
</html>