package com.example.chess.controller;

import com.example.chess.domain.*;
import com.example.chess.service.ChessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chess")
@Slf4j
@RequiredArgsConstructor
public class ChessController {

    private final ChessService chessService;

    @GetMapping("/board")
    public Game getSquareList() {
        return chessService.getGame();
    }

    @PostMapping("/move")
    public String move(@RequestBody Move move) {

        log.info("Move " + move);

        return chessService.executeMove(move);
    }

}
