package com.example.chess.service;

import com.example.chess.domain.Game;
import com.example.chess.domain.Move;
import com.example.chess.domain.MoveValidationResult;
import com.example.chess.domain.piece.Piece;
import com.example.chess.service.move_validation.MoveValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChessService {

    private final BoardInitializerService boardInitializerService;
    private final MoveValidationService moveValidationService;
    private static Game game;

    public Game getGame() {
        if (game == null) {
            game = boardInitializerService.initChessGame();
        }

        return game;
    }

    public String executeMove(Move move) {
        Game game = getGame();

        MoveValidationResult moveValidationResult = moveValidationService.validateMove(move, game);

        if (moveValidationResult.isValidMove()) {
            doMove(move);
            return "Executed move";
        } else {
            return moveValidationResult.getReason();
        }
    }

    private void doMove(Move move) {
        Piece initialSquarePiece = game.getBoard().get(move.getInitialSquare());

        log.info("Moving {} {} from square {} to square {}", initialSquarePiece.getColour().getValue(), initialSquarePiece.getPieceType(), move.getInitialSquare(), move.getFinalSquare());
        game.getBoard().put(move.getInitialSquare(), null);
        game.getBoard().put(move.getFinalSquare(), initialSquarePiece);
    }
}
