package com.example.chess.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MoveRequest {

    private String initialSquare;
    private String finalSquare;
}
