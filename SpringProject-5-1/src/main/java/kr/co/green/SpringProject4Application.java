package kr.co.green;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProject4Application {
	
	private static final Logger logger = LogManager.getLogger(SpringProject4Application.class);

	public static void main(String[] args) {
		
		logger.info("스프링 프로젝트가 시작중입니다.");
		SpringApplication.run(SpringProject4Application.class, args);
		logger.info("스프링 프로젝트가 성공적으로 시작되었습니다.");
	}

}
