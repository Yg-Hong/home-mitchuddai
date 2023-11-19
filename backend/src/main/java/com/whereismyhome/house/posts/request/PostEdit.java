package com.whereismyhome.house.posts.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostEdit {

    private String title;

    private String content;

    @Builder
    public PostEdit(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
