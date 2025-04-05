package kr.co.green.member.validatior;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kr.co.green.member.model.dto.MemberDTO;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, MemberDTO> {
	
	@Override
	public void initialize(PasswordMatches constraintAnnotation) {}
	
	@Override
	public boolean isValid(MemberDTO memberDTO, ConstraintValidatorContext context) {
		if(memberDTO.getPassword() == null || memberDTO.getConfirmPassword() == null) {
			return false;
		}
		
		boolean isValid = memberDTO.getPassword().equals(memberDTO.getConfirmPassword());
		System.out.println(isValid);
		
		return isValid;
	}
}
