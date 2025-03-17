package com.example.chess.service.move_validation;

import com.example.chess.domain.Game;
import com.example.chess.domain.Move;
import com.example.chess.domain.MoveValidationResult;
import org.springframework.stereotype.Service;

@Service
public class KingMoveValidator extends MoveValidator {

    @Override
    public MoveValidationResult validate(Move move, Game game) {
        if (!isValidKingMove(move) && !isValidDiagonalMove(move)) {
            return new MoveValidationResult(false, "Invalid move: King can only move in a straight or diagonal line");
        }

        return new MoveValidationResult(true, "No reason to deny this move, it looks legit");
    }

    boolean isValidKingMove(Move move) {
        int rowsMoved = getRowsMoved(move);
        int columnsMoved = getColumnsMoved(move);

        return (rowsMoved == 0 && columnsMoved == 1) ||
                (rowsMoved == 1 && columnsMoved == 0) ||
                (rowsMoved == 1 && columnsMoved == 1);
    }

}
