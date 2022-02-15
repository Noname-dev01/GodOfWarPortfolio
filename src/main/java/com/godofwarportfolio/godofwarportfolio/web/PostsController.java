package com.godofwarportfolio.godofwarportfolio.web;


import com.godofwarportfolio.godofwarportfolio.config.auth.LoginUser;
import com.godofwarportfolio.godofwarportfolio.config.auth.dto.SessionUser;
import com.godofwarportfolio.godofwarportfolio.domain.posts.PostsRepository;
import com.godofwarportfolio.godofwarportfolio.service.posts.PostsService;
import com.godofwarportfolio.godofwarportfolio.web.dto.PostsResponseDto;
import com.godofwarportfolio.godofwarportfolio.web.dto.PostsSaveRequestDto;
import com.godofwarportfolio.godofwarportfolio.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
