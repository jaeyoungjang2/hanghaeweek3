package com.sparta.week01.controller;

import com.sparta.week01.domain.Post;
import com.sparta.week01.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class PostController {

//    private final PostsRepository postsRepository;
//
//    @GetMapping("/api/posts/{id}")
//    public String view_post(@PathVariable("id") Long post_id, Model model) {
//        Post post = postsRepository.findById(post_id).orElseThrow(
//            () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
//        );
//        model.addAttribute("post", post);
//        return "postpage";
//    }
//
//    @GetMapping("/newpost")
//    public String new_post() {
//        return "newpost";
//    }
}
