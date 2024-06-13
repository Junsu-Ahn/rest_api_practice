package com.example.jwt.domain.member;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor // memberService 가져오기
public class MemberController {
    private final MemberService memberService;
    @Data
    public static class LoginRequest {
        @NotBlank
        private String username;

        @NotBlank
        private String password;
    }

    @PostMapping("/login")
    public Member login(@Valid @RequestBody LoginRequest loginRequest)
    {
       return memberService.findByUsername(loginRequest.getUsername()).orElse(null);
    }
}
