package com.example.chess.domain;

import com.example.chess.domain.piece.Piece;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Square {

    private Row row;
    private Column column;
}
