package com.collabhub.majd.service;

import com.collabhub.majd.Dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(Long boardId, PostDto postDto);
    List<PostDto> getPostsByBoardId(Long boardId);
}
