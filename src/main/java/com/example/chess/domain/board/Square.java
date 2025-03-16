package com.example.chess.domain.board;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Square {

    private Row row;
    private Column column;

    @Override
    public String toString() {
        return column.name() + row.getValue();
    }
}
