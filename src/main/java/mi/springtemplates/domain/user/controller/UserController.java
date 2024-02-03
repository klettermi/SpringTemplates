package mi.springtemplates.domain.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mi.springtemplates.domain.user.dto.UserRequestDto;
import mi.springtemplates.domain.user.service.UserService;
import mi.springtemplates.global.responseDto.ApiResponse;
import mi.springtemplates.global.security.jwt.JwtUtil;
import mi.springtemplates.global.utils.ResponseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j(topic = "User Controller")
public class UserController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/auth/signin")
    public ApiResponse<?> signUp(@Valid @RequestBody UserRequestDto userRequestDto){
        return ResponseUtils.ok(userService.signUp(userRequestDto));
    }
}
