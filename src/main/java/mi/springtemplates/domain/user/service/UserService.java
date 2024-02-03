package mi.springtemplates.domain.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mi.springtemplates.domain.user.dto.UserRequestDto;
import mi.springtemplates.domain.user.entity.User;
import mi.springtemplates.domain.user.exception.UserDuplicationException;
import mi.springtemplates.domain.user.repository.UserRepository;
import mi.springtemplates.global.enums.SuccessCode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static mi.springtemplates.global.enums.ErrorCode.DUPLICATE_EMAIL;
import static mi.springtemplates.global.enums.ErrorCode.DUPLICATE_NICKNAME;
import static mi.springtemplates.global.enums.SuccessCode.USER_SIGNUP_SUCCESS;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "User Service")
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SuccessCode signUp(UserRequestDto userRequestDto) {
        log.info("회원가입");
        String email = userRequestDto.getEmail();
        String nickname = userRequestDto.getNickname();
        String password = passwordEncoder.encode(userRequestDto.getPassword());
        Boolean marketingAgree = userRequestDto.getOptionCheck();

        if (checkEmail(email)) {
            throw new UserDuplicationException(DUPLICATE_EMAIL);
        } else if (checkNickname(nickname)) {
            throw new UserDuplicationException(DUPLICATE_NICKNAME);
        }

        // 사용자 등록
        User user = User.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .marketingAgree(marketingAgree)
                .social(false)
                .build();
        userRepository.save(user);

        return USER_SIGNUP_SUCCESS;
    }

    public Boolean checkEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public Boolean checkNickname(String nickname) {
        return userRepository.existsByNickname(nickname);
    }
}
