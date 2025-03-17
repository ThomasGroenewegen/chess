package com.example.chess.domain.board;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Row {
    ONE (1),
    TWO (2),
    THREE (3),
    FOUR (4),
    FIVE (5),
    SIX (6),
    SEVEN (7),
    EIGHT (8);

    private int value;

    Row(int value) {
        this.value = value;
    }

    public static Row fromIntValue(int value) {
        return Arrays.stream(Row.values())
                .filter(row -> row.value == value)
                .findFirst()
                .orElse(null);
    }
}
