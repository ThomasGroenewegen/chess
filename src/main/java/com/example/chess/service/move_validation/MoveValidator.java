package com.example.chess.service.move_validation;

import com.example.chess.domain.Game;
import com.example.chess.domain.Move;
import com.example.chess.domain.MoveValidationResult;
import com.example.chess.domain.board.Square;

public abstract class MoveValidator {

    abstract MoveValidationResult validate(Move move, Game game);

    boolean isValidStraightMove(Move move) {
        int rowsMoved = getRowsMoved(move);
        int columnsMoved = getColumnsMoved(move);

        return !(rowsMoved > 0 && columnsMoved > 0);
    }

    boolean isValidDiagonalMove(Move move) {
        int rowsMoved = getRowsMoved(move);
        int columnsMoved = getColumnsMoved(move);

        return rowsMoved == columnsMoved;
    }

    int getRowsMoved(Move move) {
        Square start = move.getInitialSquare();
        Square end = move.getFinalSquare();

        return Math.abs(start.getRow().getValue() - end.getRow().getValue());
    }

    int getColumnsMoved(Move move) {
        Square start = move.getInitialSquare();
        Square end = move.getFinalSquare();

        return Math.abs(start.getColumn().getValue() - end.getColumn().getValue());
    }
}
