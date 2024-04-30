<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../include/header.jsp" %>

<div class="container mt-3">
    <h2>회원 목록</h2>
    <table class='table table-hover'>
        <thead>
        <tr>
            <th>이름</th>
            <th>이메일</th>
            <th>가입일</th>
            <th>권한</th>
            <th>관리자 권한 부여</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="member" items="${members}">
            <tr>
                <td>${member.name}</td>
                <td>${member.email}</td>
                <td>${member.createAt}</td>
                <td>${member.role}</td>
                <c:choose>
                    <c:when test="${member.role eq 'ADMIN'}">
                        <td><a class="btn btn-secondary"
                                           href="${root}/members/auth/${member.id}?role=${member.role}">관리자 권한 회수</a>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td><a class="btn btn-primary"
                                           href="${root}/members/auth/${member.id}?role=${member.role}">관리자 권한 부여</a>
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
