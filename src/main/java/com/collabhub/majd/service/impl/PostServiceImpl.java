package com.collabhub.majd.service.impl;

import com.collabhub.majd.Dto.PostDto;
import com.collabhub.majd.entity.Board;
import com.collabhub.majd.entity.Post;
import com.collabhub.majd.functions.CollaborationPublisher;
import com.collabhub.majd.mapper.PostMapper;
import com.collabhub.majd.repository.BoardRepository;
import com.collabhub.majd.repository.PostRepository;
import com.collabhub.majd.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final CollaborationPublisher collaborationPublisher;
    private final PostRepository postRepository;
    private final BoardRepository boardRepository;



    @Override
    public PostDto createPost(Long boardId, PostDto postDto) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("Board not found"));
        Post post = PostMapper.mapToPost(postDto);
        post.setBoard(board);
        Post savedPost = postRepository.save(post);
        collaborationPublisher.sendUpdate("New post added to Board " + boardId);
        return PostMapper.mapToPostDto(savedPost);
    }

    @Override
    public List<PostDto> getPostsByBoardId(Long boardId) {
        return postRepository.findByBoardId(boardId).stream()
                .map(PostMapper::mapToPostDto)
                .collect(Collectors.toList());
    }
}