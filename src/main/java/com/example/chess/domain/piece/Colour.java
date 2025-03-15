package com.example.chess.domain.piece;

import lombok.Getter;

@Getter
public enum Colour {
    WHITE ("White"),
    BLACK ("Black");

    private String value;

    Colour(String value) {
        this.value = value;
    }
}
