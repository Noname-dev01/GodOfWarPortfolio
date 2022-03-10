package com.godofwarportfolio.godofwarportfolio.web.login;

import com.godofwarportfolio.godofwarportfolio.domain.member.Member;
import com.godofwarportfolio.godofwarportfolio.domain.member.MemberRepository;
import com.godofwarportfolio.godofwarportfolio.service.login.LoginService;
import com.godofwarportfolio.godofwarportfolio.web.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class LoginController {

    private final MemberRepository memberRepository;
    private final LoginService loginService;

    @GetMapping("/join")
    public String joinForm(@ModelAttribute("member")Member member) {return "join";}

    @PostMapping("/join")
    public String save(@Validated @ModelAttribute Member member, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "join";
        }
        memberRepository.save(member);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {return "login";}

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute LoginForm form, BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectURL,
                        HttpServletRequest request, Model model){

        if (bindingResult.hasErrors()){
            return "login";
        }

        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());

        if (loginMember == null){
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        model.addAttribute("member",loginMember);

        return "redirect:" + redirectURL;
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null){
            session.invalidate();
        }
        return "redirect:/";
    }
}
