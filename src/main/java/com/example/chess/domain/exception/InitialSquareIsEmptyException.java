package com.example.chess.domain.exception;

import com.example.chess.domain.Square;

public class InitialSquareIsEmptyException extends RuntimeException {

    public InitialSquareIsEmptyException(Square initialSquare) {
        super("Initial square " + initialSquare + " is empty");
    }
}
