package com.godofwarportfolio.godofwarportfolio.web;

import com.godofwarportfolio.godofwarportfolio.config.auth.LoginUser;
import com.godofwarportfolio.godofwarportfolio.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.h2.engine.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/character")
    public String character(){
        return "character";
    }
}