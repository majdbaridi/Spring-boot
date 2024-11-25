package com.collabhub.majd.mapper;


import com.collabhub.majd.Dto.PostDto;
import com.collabhub.majd.entity.Post;

public class PostMapper {

    public static PostDto mapToPostDto(Post post) {
        return new PostDto(
                post.getId(),
                post.getContent(),
                post.getCreator(),
                post.getBoard().getId(),
                post.getCreatedAt()
        );
    }

    public static Post mapToPost(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setContent(postDto.getContent());
        post.setCreator(postDto.getCreator());
        post.setCreatedAt(postDto.getCreatedAt());
        return post;
    }
}