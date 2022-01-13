package com.godofwarportfolio.godofwarportfolio.web;

import com.godofwarportfolio.godofwarportfolio.domain.member.Member;
import com.godofwarportfolio.godofwarportfolio.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {
        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("test!");
        member.setName("테스터");
        member.setEmail("test@godofwar.com");
        member.setPhone("010-1234-1234");

        memberRepository.save(member);
    }


}
