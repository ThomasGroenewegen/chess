package com.example.chess.domain;

import com.example.chess.domain.piece.Piece;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Square {

    private Row row;
    private Column column;
    private Piece piece;

    public Square(Row row, Column column) {
        this.row = row;
        this.column = column;
    }
}
