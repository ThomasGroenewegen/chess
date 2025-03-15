package com.example.chess.domain;

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
