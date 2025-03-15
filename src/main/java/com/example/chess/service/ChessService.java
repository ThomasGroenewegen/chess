package com.example.chess.service;

import com.example.chess.domain.Square;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChessService {


    private final BoardInitializerService boardInitializerService;

    public List<Square> getSquareList() {
        return boardInitializerService.getSquareList();
    }
}
