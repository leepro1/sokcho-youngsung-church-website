<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

	<div class="container p-4">
		<h2 class='text-center'>MyPage</h2>
			<table class='table' border='1'>
				<tr>
					<td><label for="email" class="form-label" >이메일</label></td>
					<td><input type='email' id='email' value='${userInfo.email}' disabled="disabled"/></td>
				</tr>
				<tr>
					<td><label for="name" class="form-label">이름</label></td>
					<td><input type='text' id="name" value='${userInfo.name}' disabled="disabled"/></td>
				</tr>
				<tr>
					<td><label for="role" class="form-label">권한</label></td>
					<td><input type='text' id="role" value='${userInfo.role}' disabled="disabled"/></td>
				</tr>
			</table>
			<div class='text-center'>
					<a class='btn btn-primary' href='${root}/members/updatePass'>비밀번호 변경하기</a>
					<a class='btn btn-primary' href='${root}/members/delete/${userInfo.email}'>회원 탈퇴</a>
					<a class='btn btn-primary' href='${root}/'>메인페이지</a>
			</div>
		</form>
	</div>
	</div>
</body>
</html>