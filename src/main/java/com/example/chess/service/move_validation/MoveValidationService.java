package com.example.chess.service.move_validation;

import com.example.chess.domain.Game;
import com.example.chess.domain.Move;
import com.example.chess.domain.MoveValidationResult;
import com.example.chess.domain.piece.Piece;
import com.example.chess.domain.piece.PieceType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class MoveValidationService {

    private final BishopMoveValidator bishopMoveValidator;
    private final KingMoveValidator kingMoveValidator;
    private final KnightMoveValidator knightMoveValidator;
    private final PawnMoveValidator pawnMoveValidator;
    private final QueenMoveValidator queenMoveValidator;
    private final RookMoveValidator rookMoveValidator;

    public MoveValidationResult validateMove(Move move, Game game) {
        MoveValidationResult genericMoveValidationResult = validateGenericMoveConstraints(move, game);

        if (!genericMoveValidationResult.isValidMove()) {
            return genericMoveValidationResult;
        }


        return validateMoveForPiece(move, game);
    }

    private MoveValidationResult validateGenericMoveConstraints(Move move, Game game) {
        Piece pieceToMove = game.getBoard().get(move.getInitialSquare());
        Piece pieceOnEndSquare = game.getBoard().get(move.getFinalSquare());
        if (Objects.isNull(pieceToMove)) {
            log.error("Invalid move: initial square is empty");
            return new MoveValidationResult(false, "Invalid move: initial square is empty");
        } else if (move.getInitialSquare().equals(move.getFinalSquare())) {
            return new MoveValidationResult(false, "Invalid move: initial square and final square are the same");
        } else if (isMoveToSameColourPiece(pieceToMove, pieceOnEndSquare)) {
            return new MoveValidationResult(false, "Invalid move: cannot move to square because a piece of the same colour is there");
        } else {
            return new MoveValidationResult(true, "looks valid");
        }
    }

    private boolean isMoveToSameColourPiece(Piece pieceToMove, Piece pieceOnEndSquare) {
        if (pieceOnEndSquare == null) {
            return false;
        } else {
            return pieceToMove.getColour().equals(pieceOnEndSquare.getColour());
        }
    }

    private MoveValidationResult validateMoveForPiece(Move move, Game game) {
        Piece pieceToMove = game.getBoard().get(move.getInitialSquare());

        MoveValidator moveValidator = switch (pieceToMove.getPieceType()) {
            case PieceType.BISHOP -> bishopMoveValidator;
            case PieceType.KING -> kingMoveValidator;
            case PieceType.KNIGHT -> knightMoveValidator;
            case PieceType.PAWN -> pawnMoveValidator;
            case PieceType.QUEEN -> queenMoveValidator;
            case PieceType.ROOK -> rookMoveValidator;
        };

        return moveValidator.validate(move, game);
    }
}
