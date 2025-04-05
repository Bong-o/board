package kr.co.green.test.service;

import java.util.Map;

public interface TestService {

//	List<TestDTO> findAll();
//	
//
//	Map<String, Object> getAllPosts(TestPagination testPagination, 
//									int currentPage, 
//									int postCount, 
//									int pageLimit,
//									int boardLimit);

	int getTotalCount();

	Map<String, Object> getAllPosts(int postCount, int pageLimit, int boardLimit, int currentPgae);
	
//	List<TestDTO> findAll(Map<String, Object> map);
	
}
	