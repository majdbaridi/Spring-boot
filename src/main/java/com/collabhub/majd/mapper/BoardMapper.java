package com.collabhub.majd.mapper;


import com.collabhub.majd.Dto.BoardDto;
import com.collabhub.majd.entity.Board;

public class BoardMapper {

    public static BoardDto mapToBoardDto(Board board) {
        BoardDto boardDto = new BoardDto();
        boardDto.setId(board.getId());
        boardDto.setTitle(board.getTitle());
        boardDto.setDescription(board.getDescription());
        boardDto.setCreator(board.getCreator());
        boardDto.setCreatedAt(board.getCreatedAt());
        return boardDto;
    }

    public static Board mapToBoard(BoardDto boardDto) {
        Board board = new Board();
        board.setId(boardDto.getId());
        board.setTitle(boardDto.getTitle());
        board.setDescription(boardDto.getDescription());
        board.setCreator(boardDto.getCreator());
        board.setCreatedAt(boardDto.getCreatedAt());
        return board;
    }
}

