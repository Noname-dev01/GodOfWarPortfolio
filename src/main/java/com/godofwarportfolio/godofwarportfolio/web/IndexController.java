package com.godofwarportfolio.godofwarportfolio.web;

import com.godofwarportfolio.godofwarportfolio.config.auth.LoginUser;
import com.godofwarportfolio.godofwarportfolio.config.auth.dto.SessionUser;
import com.godofwarportfolio.godofwarportfolio.domain.member.Member;
import com.godofwarportfolio.godofwarportfolio.service.posts.PostsService;
import com.godofwarportfolio.godofwarportfolio.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user,
                        @SessionAttribute(name=SessionConst.LOGIN_MEMBER,required = false)Member loginMember){
        if (loginMember == null){
            return "index";
        }
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        model.addAttribute("member",loginMember);
        return "index";
    }

    @GetMapping("/character")
    public String character(){
        return "character";
    }

    @GetMapping("/noticeBoard")
    public String noticeBoard(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "noticeBoard";
    }
    @GetMapping("/gameIntroduce")
    public String gameIntroduce(){
        return "gameIntroduce";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

    @GetMapping("/serviceTest")
    public String serviceTest() {
        return "service-test";
    }
}
