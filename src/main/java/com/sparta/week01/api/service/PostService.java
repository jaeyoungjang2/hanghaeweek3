package com.sparta.week01.api.service;

import com.sparta.week01.domain.Post;
import com.sparta.week01.domain.PostDto;
import com.sparta.week01.repository.PostsRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostsRepository postsRepository;
    @Transactional // db에 반영할거임 라고 말하는 것
    public Long update(Long id, PostDto postDto) {
        Post post = postsRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        post.update(postDto);
        return post.getId();
    }
}
