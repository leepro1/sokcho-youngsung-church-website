package com.sokchoys.member.interceptor;

import com.sokchoys.SokchoException;
import com.sokchoys.member.dto.MemberDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ConfirmInterceptor implements HandlerInterceptor { 

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberDto user = (MemberDto)session.getAttribute("userInfo");
		if(user == null  || !user.getRole().equals("USER")) {
			throw new SokchoException("관리자 전용 페이지 입니다. 접근 권한이 없습니다.");
		}
		return true;
	}
}

