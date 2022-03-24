package com.sparta.week01.api.controller;

import com.sparta.week01.api.service.PostService;
import com.sparta.week01.domain.Post;
import com.sparta.week01.domain.PostDto;
import com.sparta.week01.repository.PostsRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;
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
        return posts;
    }

    @GetMapping("/api/posts/{id}")
    public Post view_post(@PathVariable("id") Long post_id) {
        Post post = postsRepository.findById(post_id).orElseThrow(
            () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );

        return post;
    }

    @PutMapping("/api/editpost/{id}")
    public Long update_post(@PathVariable("id") Long post_id, @RequestBody PostDto postDto) {
        postService.update(post_id, postDto);

        return post_id;
    }
}
