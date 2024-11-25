package com.collabhub.majd.service.impl;

import com.collabhub.majd.Dto.BoardDto;
import com.collabhub.majd.entity.Board;
import com.collabhub.majd.mapper.BoardMapper;
import com.collabhub.majd.repository.BoardRepository;
import com.collabhub.majd.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;

    public BoardServiceImpl(BoardRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BoardDto> getAllBoards() {
        return repository.findAll().stream()
                .map(BoardMapper::mapToBoardDto)
                .collect(Collectors.toList());
    }

    @Override
    public BoardDto createBoard(BoardDto boardDto) {
        Board board = BoardMapper.mapToBoard(boardDto);
        Board savedBoard = repository.save(board);
        return BoardMapper.mapToBoardDto(savedBoard);
    }

    @Override
    public BoardDto getBoardById(Long id) {
        Board board = repository.findById(id).orElseThrow(() -> new RuntimeException("Board not found"));
        return BoardMapper.mapToBoardDto(board);
    }

    @Override
    public void deleteBoard(Long id) {
        repository.deleteById(id);
    }
}
