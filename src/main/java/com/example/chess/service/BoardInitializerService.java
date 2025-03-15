package com.example.chess.service;

import com.example.chess.domain.Column;
import com.example.chess.domain.Game;
import com.example.chess.domain.Row;
import com.example.chess.domain.Square;
import com.example.chess.domain.piece.Colour;
import com.example.chess.domain.piece.Piece;
import com.example.chess.domain.piece.PieceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Slf4j
@Service
public class BoardInitializerService {

    public Game initChessGame() {
        log.info("Initialising new chess game");
        List<Square> squares = getSquareList();
        LinkedHashMap<Square,Piece> board = new LinkedHashMap<>();

        for (Square square : squares) {
            board.put(square, getPieceForSquare(square));
        }

        return new Game(board);
    }

    private List<Square> getSquareList() {
        return Arrays.stream(Row.values())
                .map(this::getColumnListForRow)
                .flatMap(List::stream)
                .toList();
    }

    private List<Square> getColumnListForRow(Row row) {
        return Arrays.stream(Column.values())
                .map(columnValue -> new Square(row, columnValue))
                .toList();
    }

    private Piece getPieceForSquare(Square square) {
        if (Row.ONE.equals(square.getRow())) {
            return getRowOneOrEightPiece(square.getColumn(), Colour.WHITE);
        } else if (Row.EIGHT.equals(square.getRow())) {
            return getRowOneOrEightPiece(square.getColumn(), Colour.BLACK);
        } else if (square.getRow().equals(Row.TWO)) {
            return new Piece(PieceType.PAWN, Colour.WHITE);
        } else if (square.getRow().equals(Row.SEVEN)) {
            return new Piece(PieceType.PAWN, Colour.BLACK);
        } else {
            return null;
        }
    }

    private Piece getRowOneOrEightPiece(Column column, Colour colour) {
        return switch (column) {
            case A, H -> new Piece(PieceType.ROOK, colour);
            case B, G -> new Piece(PieceType.KNIGHT, colour);
            case C, F -> new Piece(PieceType.BISHOP, colour);
            case D -> new Piece(PieceType.QUEEN, colour);
            case E -> new Piece(PieceType.KING, colour);
        };
    }
}
