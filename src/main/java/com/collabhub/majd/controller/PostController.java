package com.collabhub.majd.controller;

import com.collabhub.majd.Dto.PostDto;
import com.collabhub.majd.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/boards/{boardId}/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@PathVariable Long boardId, @RequestBody PostDto postDto) {
        return ResponseEntity.ok(postService.createPost(boardId, postDto));
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getPostsByBoardId(@PathVariable Long boardId) {
        return ResponseEntity.ok(postService.getPostsByBoardId(boardId));
    }
}