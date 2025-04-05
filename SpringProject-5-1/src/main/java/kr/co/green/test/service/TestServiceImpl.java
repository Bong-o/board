package kr.co.green.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.co.green.test.dto.PageInfoDTO;
import kr.co.green.test.dto.TestDTO;
import kr.co.green.test.mapper.TestMapper;
import kr.co.green.test.util.TestPagination;

@Service
public class TestServiceImpl implements TestService {
	private final TestMapper testMapper;
	private final TestPagination pagination;
	
	public TestServiceImpl(TestMapper testMapper, TestPagination pagination) {
		this.testMapper = testMapper;
		this.pagination = pagination;
	}

	@Override
	public int getTotalCount() {
		return testMapper.getTotalCount();
	}
	
	@Override
	public Map<String, Object> getAllPosts(int postCount, int pageLimit, int boardLimit, int currentPgae) {
		// 페이징 처리
		PageInfoDTO pi = pagination.getPageInfo(postCount, currentPgae, pageLimit, boardLimit);

		// 전체 게시글 수
		List<TestDTO> posts = testMapper.getAllPosts(pi); // xml 결과가 여기에  
		
		Map<String, Object> result = new HashMap<>();    
		result.put("posts", posts);
		result.put("pi", pi);
		
		return result;
	}
//	@Override
//	public List<TestDTO> findAll() {
//		return testMapper.findAll();
//	}
//	
//	@Override
//	public Map<String, Object> getAllPosts(TestPagination testPagination, 
//										   int currentPage, 
//										   int postCount, 
//										   int pageLimit,
//										   int boardLimit) {
//		
//		TestPageDTO tp = testPagination.getPageInfo(postCount, 
//													currentPage, 
//													pageLimit, 
//													boardLimit);
//		
//		List<TestDTO> posts = testMapper.getAllPosts(tp);
//		
//		Map<String, Object> result = new HashMap<>();
//		result.put("tp", tp);
//	
//		return result;
//	}
	
	
	
}
