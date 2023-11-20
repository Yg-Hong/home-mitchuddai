package com.whereismyhome.house.posts.controller;

import com.whereismyhome.house.posts.request.PostCreate;
import com.whereismyhome.house.posts.request.PostEdit;
import com.whereismyhome.house.posts.request.PostSearch;
import com.whereismyhome.house.posts.response.PostResponse;
import com.whereismyhome.house.posts.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    // 게시글 작성
    @PostMapping("")
    public Long post(@RequestBody @Valid PostCreate request) {
        return postService.write(request);
    }

    // 게시글 단건 조회
    @GetMapping("/{postId}")
    public PostResponse getSinglePost(@PathVariable Long postId) {
        return postService.getSinglePost(postId);
    }

    // 게시글 여러개 조회 - querydsl
    @GetMapping("")
    public Map<String, Object> getList(@RequestBody PostSearch postSearch) {
        Map<String, Object> map = new HashMap<>();
        map.put("PagInfo", postService.getTotalSize());
        map.put("Result", postService.getList(postSearch));
        return map;
    }

    // 게시글 수정
    @PatchMapping("/{postId}")
    public PostResponse edit(@PathVariable Long postId, @RequestBody @Valid PostEdit request) {
        return postService.edit(postId, request);
    }

    // 게시글 삭제
    @DeleteMapping("/{postId}")
    public void delete(@PathVariable Long postId) {
        postService.delete(postId);
    }
}