package kr.co.green.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.green.interceptor.LoginAuthInterceptor;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class WebConfig implements WebMvcConfigurer{
	
	private final LoginAuthInterceptor loginAuthInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginAuthInterceptor)
			    .addPathPatterns("/**")
			    .excludePathPatterns("/css/**",
			    					 "/js/**",
			    					 "/img/**",
			    					 "/member/signup/form",
			    					 "/member/signup",
			    					 "/member/signin/form",
			    					 "/member/signin");
	}
}
