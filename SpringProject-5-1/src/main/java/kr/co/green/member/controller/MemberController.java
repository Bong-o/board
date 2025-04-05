package kr.co.green.member.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import kr.co.green.member.model.dto.MemberDTO;
import kr.co.green.member.model.service.MemberServiceImpl;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private final MemberServiceImpl memberService;
	private static final Logger logger = LogManager.getLogger(MemberController.class);
//	private final PasswordEncoder passwordEncoder;
	
	public MemberController(MemberServiceImpl memberService) {
		this.memberService = memberService;
//		this.passwordEncoder = new BCryptPasswordEncoder();
//		this.passwordEncoder = passwordEncoder;
	} 
	
	@GetMapping("/signup/form")
	public String signupForm() {
		return "/member/sign_up";
	}
	
	//   /member/signup
	@PostMapping("/signup")
	public String signup(MemberDTO memberDTO) {
		
		memberService.signup(memberDTO);
		
		return "/member/sign_in";
	}
	
	@GetMapping("/signin/form")
	public String signinForm() {
		return "/member/sign_in";
	}
	
	@PostMapping("/signin")
	public String signin(MemberDTO memberDTO ,HttpSession session) {
		
		MemberDTO loginUser = memberService.signin(memberDTO);
		
		
		if(loginUser != null) {
			session.setAttribute("memberNo", loginUser.getNo());
			session.setAttribute("memberId", loginUser.getId());
			session.setAttribute("memberName", loginUser.getName());
		}
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/checkId/{id}")
	@ResponseBody // view로 안감 비동기 통신 주로 사용
	public ResponseEntity<?> checkId(@PathVariable("id") String memberId) {
		boolean isDuplication = memberService.checkId(memberId);
		
		if(isDuplication) {
			return new ResponseEntity("true", HttpStatus.GATEWAY_TIMEOUT);
		} else { // 중복이 없을 때
			return new ResponseEntity("false", HttpStatus.OK);
		}
	}
	
	
}
