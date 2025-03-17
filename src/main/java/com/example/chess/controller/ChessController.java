package com.example.chess.controller;

import com.example.chess.controller.model.MoveRequest;
import com.example.chess.domain.*;
import com.example.chess.domain.board.Column;
import com.example.chess.domain.board.Row;
import com.example.chess.domain.board.Square;
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
    public String move(@RequestBody MoveRequest moveRequest) {

        log.info("MoveRequest " + moveRequest);

        Square initialSquare = mapStringToSquare(moveRequest.getInitialSquare());
        Square finalSquare = mapStringToSquare(moveRequest.getFinalSquare());

        Move move = new Move(initialSquare, finalSquare);

        return chessService.executeMove(move);
    }

    private Square mapStringToSquare(String squareString) {
        String column = squareString.substring(0, 1);
        String row = squareString.substring(1, 2);
        int rowInt = Integer.parseInt(row);

        return new Square(Row.fromIntValue(rowInt), Column.valueOf(column));
    }

}
