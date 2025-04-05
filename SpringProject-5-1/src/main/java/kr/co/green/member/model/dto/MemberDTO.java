
package kr.co.green.member.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberDTO {
	private int no;
	
	private String id;
	private String name;
	
	@Size(min = 6, max = 48, message = "6자 이상 48자 이하입니다.")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!~`<>,./?;:'\"\\[\\]{}\\\\()|_-])\\S*$")
	private String password;
	
	private String confirmPassword;
	private String status;
	private String createAt;
	private String updateAt;
	private String deleteAt;
}
