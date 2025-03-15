package com.example.chess.controller;

import com.example.chess.domain.exception.InitialSquareIsEmptyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(InitialSquareIsEmptyException.class)
    public ResponseEntity<String> handle(InitialSquareIsEmptyException ex) {
        return ResponseEntity.badRequest().body("Invalid move: " + ex.getMessage());
    }
}
