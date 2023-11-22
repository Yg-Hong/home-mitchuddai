package com.whereismyhome.house.comment.VO;

import lombok.Data;

import java.util.Date;

@Data
public class CommentVO {
    private String text;
    private String authorId;
    private String aptCode;
    private Date createdAt;
}
