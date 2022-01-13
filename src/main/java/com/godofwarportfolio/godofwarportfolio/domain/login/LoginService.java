package com.godofwarportfolio.godofwarportfolio.domain.login;

import com.godofwarportfolio.godofwarportfolio.domain.member.Member;
import com.godofwarportfolio.godofwarportfolio.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private  final MemberRepository memberRepository;

    public Member login(String loginId, String password){
        return memberRepository.findByLoginId(loginId)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);
    }

}
