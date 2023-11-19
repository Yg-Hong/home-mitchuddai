package com.whereismyhome.house.posts.request;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostCreate {

    private String title;

    private String content;

    private String authorId;

    @Builder
    public PostCreate(String title, String content, String authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }

}
