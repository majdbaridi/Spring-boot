package com.collabhub.majd.service;



import com.collabhub.majd.Dto.BoardDto;

import java.util.List;

public interface BoardService {

    List<BoardDto> getAllBoards();

    BoardDto createBoard(BoardDto boardDto);

    BoardDto getBoardById(Long id);

    void deleteBoard(Long id);
}