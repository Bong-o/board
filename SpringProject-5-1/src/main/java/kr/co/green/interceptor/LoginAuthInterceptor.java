package kr.co.green.interceptor;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginAuthInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response,
							 Object handler) throws IOException {
		HttpSession session = request.getSession();
		Object memberNo = session.getAttribute("memberNo");
		
//		if(memberNo == null) {
//			response.sendRedirect("/member/signin/form");
//			return false;
//		}
		
		return true;
	}
}
