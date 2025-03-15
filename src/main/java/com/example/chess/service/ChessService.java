package com.example.chess.service;

import com.example.chess.domain.Game;
import com.example.chess.domain.Move;
import com.example.chess.domain.exception.InitialSquareIsEmptyException;
import com.example.chess.domain.piece.Piece;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

    public Game executeMove(Move move) {
        Game game = getGame();

        validateMove(move);

        doMove(move);
        return game;
    }

    private void validateMove(Move move) {
        if (Objects.isNull(game.getBoard().get(move.getInitialSquare()))) {
            log.error("Invalid move: initial square is empty");
            throw new InitialSquareIsEmptyException(move.getInitialSquare());
        }
    }

    private void doMove(Move move) {
        Piece initialSquarePiece = game.getBoard().get(move.getInitialSquare());

        log.info("Moving {} {} from square {} to square {}", initialSquarePiece.getColour().getValue(), initialSquarePiece.getPieceType(), move.getInitialSquare(), move.getFinalSquare());
        game.getBoard().put(move.getInitialSquare(), null);
        game.getBoard().put(move.getFinalSquare(), initialSquarePiece);
    }
}
