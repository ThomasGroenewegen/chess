package com.example.chess.service;

import com.example.chess.domain.Column;
import com.example.chess.domain.Row;
import com.example.chess.domain.Square;
import com.example.chess.domain.piece.Knight;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BoardInitializerService {


    public List<Square> getSquareList() {
        List<Square> squares = initBoard();

        addPieceToSquare(squares, Row.ONE, Column.B);
        addPieceToSquare(squares, Row.TWO, Column.C);
        return squares;
    }

    private List<Square> initBoard() {
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

    private void addPieceToSquare(List<Square> squares, Row row, Column column) {
        Optional<Square> first = squares.stream()
                .filter(square -> square.getRow() == row && square.getColumn() == column)
                .findFirst();

        first.ifPresent(square -> square.setPiece(new Knight()));
    }
}
