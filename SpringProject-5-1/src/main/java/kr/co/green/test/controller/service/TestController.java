package kr.co.green.test.controller.service;

import java.util.List;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.green.test.dto.TestDTO;
import kr.co.green.test.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {
	private final TestService testService;
	
	public TestController(TestService testService) {
		this.testService = testService;
	}
			
	@GetMapping("/list") // 일단 list페이지 가져오고
	public String list(@RequestParam(value="currentPage", defaultValue="1") int currentPgae,
									 Model model) {
		int postCount = testService.getTotalCount(); //1 
		int pageLimit = 5;         //2
		int boardLimit = 10;
		
		Map<String, Object> result = testService.getAllPosts(postCount,        //3
													         pageLimit,
													         boardLimit,
													         currentPgae);
		// html 던지기 전에 확인부터
		
		List<TestDTO> postsResult = (List<TestDTO>) result.get("posts"); 
//																			
//		for(TestDTO item : postsResult) {
//			System.out.println(item.getTitle());
//		}
		
		model.addAttribute("posts", result.get("posts"));
		model.addAttribute("pi", result.get("pi"));
		
		
		return "test/list";
	}
	
	
	
//	private final TestPagination testPagination;
	
//	public TestController(TestService testService, TestPagination testPagination) {
//		this.testService = testService;
//		this.testPagination = testPagination;
	
//	@GetMapping("list")
//	public String list(@RequestParam(value="currentpage", defaultValue="1") int currentPage,
//					   Model model) {
//		
//		int postCount = testService.getTotalCount();
//		int pageLimit = 5;
//		int boardLimit = 10;
//		
//		Map<String, Object> result = testService.getAllPosts(testPagination,
//															 currentPage,
//															 postCount,
//															 pageLimit,
//															 boardLimit);
//		
//		TestPageDTO tpResult = (TestPageDTO) result.get("tp");
//		List<TestDTO> postResult = (List<TestDTO>) result.get("posts");
//		
//		model.addAttribute("posts", postResult);
//		model.addAttribute("tp", tpResult);
//		
//		System.out.println(postResult.getClass());
//		
//		return "/test/list";
//	}
	
//	@GetMapping("list")
//	public String list(Model model) {
//		List<TestDTO> testList = testService.findAll();
//		model.addAttribute("testList", testList);
//		
//		System.out.println(testList.get(0).getId());
//		System.out.println(testList.get(0).getTitle());
//		System.out.println(testList.get(0).getAuthor());
//		
//		return "test/list";
//	}
	
	// 

	
	
	
	
	
	
	
	

}
