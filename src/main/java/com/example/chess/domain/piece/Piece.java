package com.example.chess.domain.piece;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Piece {

    private PieceType pieceType;
    private Colour colour;

}
