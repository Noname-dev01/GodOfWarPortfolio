package com.godofwarportfolio.godofwarportfolio.web;

import com.godofwarportfolio.godofwarportfolio.config.auth.dto.SessionUser;
import com.godofwarportfolio.godofwarportfolio.domain.member.Member;
import com.godofwarportfolio.godofwarportfolio.domain.member.MemberRepository;
import com.godofwarportfolio.godofwarportfolio.web.session.SessionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;
    private final SessionManager sessionManager;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Member loginMember, Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }
}
