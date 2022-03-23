package com.sparta.week01.api.controller;

import com.sparta.week01.domain.Post;
import com.sparta.week01.domain.PostDto;
import com.sparta.week01.repository.PostsRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostsRepository postsRepository;

    // front에서 받은 정보를 database에 저장
    @PostMapping("/api/newpost")
    public Post savePost(@RequestBody PostDto postDto) {
        Post post = new Post(postDto);
        return postsRepository.save(post);
    }

    // 전체 게시글 조회
    @GetMapping("/api/posts")
    public List<Post> showPosts() {
        List<Post> posts = postsRepository.findAllByOrderByCreatedAtDesc();
        System.out.println(posts);
        for (Post post : posts) {
            System.out.println(post.getCreatedAt());
        }
        return posts;
    }
}
