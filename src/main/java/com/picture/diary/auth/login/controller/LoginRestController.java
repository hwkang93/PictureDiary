package com.picture.diary.auth.login.controller;

import com.picture.diary.common.response.BasicResponse;
import com.picture.diary.common.response.SuccessResponse;
import com.picture.diary.auth.login.data.LoginRequestDto;
import com.picture.diary.auth.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

/**
    @see : https://ttl-blog.tistory.com/104
 */

@RequiredArgsConstructor
@RestController
public class LoginRestController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<BasicResponse> login(@Valid LoginRequestDto loginRequestDto) throws IOException {
        System.out.println("여기오냐!!!!!!!!!!!!!!!!!!!!!!!");
        loginService.login(loginRequestDto);

        SuccessResponse<String> response = new SuccessResponse<>();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<BasicResponse> logout(@RequestParam String userId) {

        return ResponseEntity.ok(new SuccessResponse<>());
    }
}
