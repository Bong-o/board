package kr.co.green.member.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.green.member.controller.MemberController;
import kr.co.green.member.model.dto.MemberDTO;
import kr.co.green.member.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	private static final Logger logger = LogManager.getLogger(MemberServiceImpl.class);
	private final MemberMapper memberMapper;
	private PasswordEncoder passwordEncoder;
	
	public MemberServiceImpl(MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
		this.memberMapper = memberMapper;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public int signup(MemberDTO memberDTO) {
		// 1. 중복 검사
		int checkId = memberMapper.checkId(memberDTO.getId());
		
		if(checkId != 1) {
			// 2. 패스워드 암호화
			String encodePassword = passwordEncoder.encode(memberDTO.getPassword());
			memberDTO.setPassword(encodePassword);
			
			logger.info("회원가입 요청 : 아이디 = {}", memberDTO.getId());
			System.out.println("==============" + memberDTO.getId());

			// 3. insert
			return memberMapper.signup(memberDTO);
		} else {
			return 0;
		}
	}
	
	@Override
	public MemberDTO signin(MemberDTO memberDTO) {
		MemberDTO loginUser = memberMapper.signin(memberDTO);
		
		// 첫번째 매개변수에 사용자가 입력한 패스워드
		// 두번째 매개변수에 DB에서 가져온 (암호화된) 패스워드
		if(passwordEncoder.matches(memberDTO.getPassword(), loginUser.getPassword())) {
			return loginUser;
		}
		
		return null;
	}
	
	@Override
	public boolean checkId(String memberId) {
		int result = memberMapper.checkId(memberId);
		
		if(result == 1) {
			return true;
		}
		
		return false;
	}
	
}
