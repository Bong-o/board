//package kr.co.green.filter;
//
//import java.io.IOException;
//
//import org.springframework.stereotype.Component;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@Component
//// HttpFilter (Class)    vs     Filter (interface)
//public class LoginAuthFilter extends HttpFilter {
//
//	@Override
//	public void doFilter(HttpServletRequest request, 
//						 HttpServletResponse response,
//						 FilterChain chain) throws IOException, ServletException {
////		HttpServletRequest     vs     ServletRequest
////		  HTTP 전용(웹 요청)			모든 프로토콜에대한 요청
//		
//		HttpSession session = request.getSession();
//		Object memberNo = session.getAttribute("memberNo");
//	
//		String path = request.getServletPath();
//		
//		if(memberNo == null && !isExcludePath(path)) {
//			response.sendRedirect("/member/signin/form");
//			return;
//		}
//		 
//		chain.doFilter(request, response);
//	}
//		
//	private boolean isExcludePath(String path) {
////		path : /member/signup/form
//		
//		return path.startsWith("/css/") ||
//			   path.startsWith("/is/") ||
//			   path.startsWith("/img") ||
//			   path.equals("/member/signup/form") ||
//			   path.equals("member/signup") ||
//			   path.equals("/member/signin/form") ||
//			   path.equals("/member/signin");
//	}
//	
//	
//	
//}








