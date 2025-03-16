package com.example.chess.service.move_validation;

import com.example.chess.domain.Game;
import com.example.chess.domain.Move;
import com.example.chess.domain.MoveValidationResult;
import org.springframework.stereotype.Service;

@Service
public class BishopMoveValidator extends MoveValidator {

    @Override
    public MoveValidationResult validate(Move move, Game game) {
        if (!isValidDiagonalMove(move)) {
            return new MoveValidationResult(false, "Invalid move: Bishop can only move in a diagonal line");
        }

        return new MoveValidationResult(true, "No reason to deny this move, it looks legit");
    }

}
