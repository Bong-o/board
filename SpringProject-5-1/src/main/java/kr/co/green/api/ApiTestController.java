package kr.co.green.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller + @ResponseBody
@RestController
@RequestMapping("/api/test")
public class ApiTestController {
	
	@GetMapping("/{text}")
	public String getApi(@PathVariable("text") String inputText) {
		System.out.println(inputText);
		String check = "admin";
		
		if(check.equals(inputText)) {
			return "일치함";
		} else {
			return "일치하지 않음";
		}
			
	}
}
