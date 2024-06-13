package com.example.jwt.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor  // memberRepository 가져오기
public class MemberService {

    private final MemberRepository memberRepository;
    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    public Member join(String username, String password, String email) {
        Member member = Member.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();

        memberRepository.save(member);

        return member;
    }
}
