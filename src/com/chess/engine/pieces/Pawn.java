package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pawn extends Piece {

    private final static int[] CANDIDATE_MOVE_VECTORS = {7, 8, 9, 16};

    Pawn(int piecePosition, Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public Collection<Move> calculateLegalMoves(final Board board) {

        final List <Move> legalMoves = new ArrayList <> ();

        for(final int currentCandidateOffset : CANDIDATE_MOVE_VECTORS) {

            int candidateDestinationCoordinate = this.piecePosition + (this.getPieceAlliance().getDirection() * currentCandidateOffset);

            if(!BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                continue;
            }

            if(currentCandidateOffset == 8 && !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                //TODO auto generated stub

                legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));
            }
            else if(currentCandidateOffset == 16 && this.isFirstMove()
                    && (BoardUtils.SECOND_COLUMN[this.piecePosition] && this.getPieceAlliance().isBlack())
                    || (BoardUtils.SEVENTH_COLUMN[this.piecePosition] && this.getPieceAlliance().isWhite())) {

                final int behindCandidateDestinationCoordinate = this.piecePosition + (this.pieceAlliance.getDirection() * 8);

                if(!board.getTile(behindCandidateDestinationCoordinate).isTileOccupied()
                        && !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                    legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));
                }
            }
            else if(currentCandidateOffset == 7
                    && !(BoardUtils.EIGHTH_COLUMN[this.piecePosition] && this.getPieceAlliance().isWhite())
                    || (BoardUtils.FIRST_COLUMN[this.piecePosition] && this.getPieceAlliance().isBlack())) {

                if(board.getTile(candidateDestinationCoordinate).isTileOccupied()) {

                    final Piece pieceOnCandidate = board.getTile(candidateDestinationCoordinate).getPiece();

                    if(this.pieceAlliance != pieceOnCandidate.getPieceAlliance()) {
                        //TODO stub
                        legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));
                    }
                }

            }
            else if(currentCandidateOffset == 9
                    && !(BoardUtils.FIRST_COLUMN[this.piecePosition] && this.getPieceAlliance().isWhite())
                    || (BoardUtils.EIGHTH_COLUMN[this.piecePosition] && this.getPieceAlliance().isBlack())) {

                if(board.getTile(candidateDestinationCoordinate).isTileOccupied()) {

                    final Piece pieceOnCandidate = board.getTile(candidateDestinationCoordinate).getPiece();

                    if(this.pieceAlliance != pieceOnCandidate.getPieceAlliance()) {
                        //TODO stub
                        legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));
                    }
                }

            }

        }

        return ImmutableList.copyOf(legalMoves);
    }
}
