package com.sparta.week01.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Post extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    public Post(PostDto postDto) {
        this.writer = postDto.getWriter();
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
    }

    public void update(PostDto postDto) {
        this.writer = postDto.getWriter();
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
    }
}
