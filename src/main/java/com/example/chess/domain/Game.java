package com.example.chess.domain;

import com.example.chess.domain.piece.Piece;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @JsonSerialize(keyUsing = SquareSerializer.class)
    Map<Square, Piece> board;
}
