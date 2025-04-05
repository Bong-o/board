package kr.co.green.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.green.test.dto.PageInfoDTO;
import kr.co.green.test.dto.TestDTO;

@Mapper
public interface TestMapper {
	
	int getTotalCount();

	List<TestDTO> getAllPosts(PageInfoDTO pi);  // param이 안들어가면 xml에서 ex) pi.offset 안됨

//	List<TestDTO> getAllPosts(@Param("tp") TestPageDTO tp);
//	
//	List<TestDTO> findAll();

}
