<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="include/header.jsp" %>
<div class="container mt-3">
    <h2>에러 페이지</h2>
    <c:if test="${!empty msg }">
        <div class="form-group">
            <h3 class='text-center text-danger'>${msg}</h3>
        </div>
    </c:if>
</div>
</body>
</html>











