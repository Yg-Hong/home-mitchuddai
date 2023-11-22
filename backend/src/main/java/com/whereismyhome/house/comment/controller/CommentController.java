package com.whereismyhome.house.comment.controller;

import com.whereismyhome.house.comment.VO.CommentVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @PostMapping("/{aptCode}")
    public void addComment(@PathVariable Long aptCode) {

    }

    @GetMapping("/{aptCode}")
    public List<CommentVO> getCommentList(@PathVariable Long aptCode) {
        return null;
    }
}
