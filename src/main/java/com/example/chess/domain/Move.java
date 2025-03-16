package com.example.chess.domain;

import com.example.chess.domain.board.Square;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Move {

    Square initialSquare;
    Square finalSquare;

}
