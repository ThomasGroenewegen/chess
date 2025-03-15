package com.example.chess.controller;

import com.example.chess.domain.Column;
import com.example.chess.domain.Game;
import com.example.chess.domain.Row;
import com.example.chess.domain.Square;
import com.example.chess.service.ChessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chess")
@Slf4j
@RequiredArgsConstructor
public class ChessController {

    private final ChessService chessService;

    @GetMapping("/init-game")
    public Game getSquareList() {
        return chessService.getGame();
    }

}
