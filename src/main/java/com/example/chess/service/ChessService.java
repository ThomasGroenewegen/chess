package com.example.chess.service;

import com.example.chess.domain.Game;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChessService {

    private final BoardInitializerService boardInitializerService;
    private static Game game;

    public Game getGame() {
        if (game == null) {
            game = boardInitializerService.initChessGame();
        }

        return game;
    }
}
