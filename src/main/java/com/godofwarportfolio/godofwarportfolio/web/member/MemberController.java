package com.godofwarportfolio.godofwarportfolio.web.member;

import com.godofwarportfolio.godofwarportfolio.domain.member.Member;
import com.godofwarportfolio.godofwarportfolio.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/join")
    public String joinForm(@ModelAttribute("member") Member member){return "join";}

    @PostMapping("/join")
    public String save(@Validated @ModelAttribute Member member, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "join";
        }
        memberRepository.save(member);
        return "redirect:/";
    }
}
