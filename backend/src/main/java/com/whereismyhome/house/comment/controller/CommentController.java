package com.whereismyhome.house.comment.controller;

import com.whereismyhome.house.comment.VO.CommentVO;
import com.whereismyhome.house.comment.dto.CommentDto;
import com.whereismyhome.house.comment.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{aptCode}")
    public void addComment(@PathVariable Long aptCode, @RequestBody CommentDto commentDto) {
        commentService.addComment(aptCode, commentDto);
    }

    @GetMapping("/{aptCode}")
    public List<CommentVO> getCommentList(@PathVariable Long aptCode) {
        return commentService.getCommentListByAptCode(aptCode);
    }
}
