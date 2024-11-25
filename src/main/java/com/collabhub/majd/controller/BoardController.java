package com.collabhub.majd.controller;

import com.collabhub.majd.Dto.BoardDto;
import com.collabhub.majd.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/boards")
public class BoardController {

    private final BoardService service;

    public BoardController(BoardService service) {
        this.service = service;
    }

    @GetMapping
    public List<BoardDto> getAllBoards() {
        return service.getAllBoards();
    }

    @PostMapping
    public ResponseEntity<BoardDto> createBoard(@RequestBody BoardDto boardDto) {
        BoardDto createdBoard = service.createBoard(boardDto);
        return ResponseEntity.ok(createdBoard);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardDto> getBoardById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getBoardById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        service.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }
}