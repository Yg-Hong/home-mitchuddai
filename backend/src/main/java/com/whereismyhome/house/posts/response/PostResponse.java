package com.whereismyhome.house.posts.response;


import com.whereismyhome.house.posts.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String authorId;
    private final LocalDateTime createdAt;

    // 생성자 오버로딩
    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.authorId = post.getAuthorId();
        this.createdAt = post.getCreatedAt();
    }

    @Builder
    public PostResponse(Long id, String title, String content, String authorId, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.createdAt = createdAt;
    }
}
