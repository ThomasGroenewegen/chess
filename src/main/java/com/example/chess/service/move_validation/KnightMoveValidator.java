package com.example.chess.service.move_validation;

import com.example.chess.domain.Game;
import com.example.chess.domain.Move;
import com.example.chess.domain.MoveValidationResult;
import org.springframework.stereotype.Service;

@Service
public class KnightMoveValidator extends MoveValidator {

    @Override
    public MoveValidationResult validate(Move move, Game game) {
        if (!isValidKnightMove(move)) {
            return new MoveValidationResult(false, "Invalid move: Knight can only move 1/2 rows/columns");
        }

        return new MoveValidationResult(true, "No reason to deny this move, it looks legit");
    }

    private boolean isValidKnightMove(Move move) {
        int rowsMoved = getRowsMoved(move);
        int columnsMoved = getColumnsMoved(move);

        return (rowsMoved == 1 && columnsMoved == 2) || (rowsMoved == 2 && columnsMoved == 1);
    }

}
