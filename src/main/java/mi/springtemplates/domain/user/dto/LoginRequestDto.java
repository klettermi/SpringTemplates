package mi.springtemplates.domain.user.dto;

import lombok.Getter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Getter
public class LoginRequestDto {
    @Email(message = "이메일 양식이 아닙니다")
    @NotBlank(message = "Email 공백 불가")
    private String email;

    @NotBlank(message = "password 공백 불가")
    private String password;
}

