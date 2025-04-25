package ChessCore;

import ChessCore.Pieces.*;

public final class ClassicBoardInitializer implements BoardInitializer {
    private static final BoardInitializer instance = new ClassicBoardInitializer();

    private ClassicBoardInitializer() {
    }

    public static BoardInitializer getInstance() {
        return instance;
    }

    @Override
    public Piece[][] initialize() {
        Piece[][] initialState = {
            {PieceFactory.createChessPiece("Rook",Player.WHITE), PieceFactory.createChessPiece("Knight",Player.WHITE), PieceFactory.createChessPiece("Bishop",Player.WHITE), PieceFactory.createChessPiece("Queen",Player.WHITE), PieceFactory.createChessPiece("King",Player.WHITE), PieceFactory.createChessPiece("Bishop",Player.WHITE), PieceFactory.createChessPiece("Knight",Player.WHITE),PieceFactory.createChessPiece("Rook",Player.WHITE)},
            {PieceFactory.createChessPiece("Pawn",Player.WHITE), PieceFactory.createChessPiece("Pawn",Player.WHITE), PieceFactory.createChessPiece("Pawn",Player.WHITE), PieceFactory.createChessPiece("Pawn",Player.WHITE), PieceFactory.createChessPiece("Pawn",Player.WHITE), PieceFactory.createChessPiece("Pawn",Player.WHITE), PieceFactory.createChessPiece("Pawn",Player.WHITE), PieceFactory.createChessPiece("Pawn",Player.WHITE)},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {PieceFactory.createChessPiece("Pawn",Player.BLACK), PieceFactory.createChessPiece("Pawn",Player.BLACK), PieceFactory.createChessPiece("Pawn",Player.BLACK), PieceFactory.createChessPiece("Pawn",Player.BLACK), PieceFactory.createChessPiece("Pawn",Player.BLACK), PieceFactory.createChessPiece("Pawn",Player.BLACK), PieceFactory.createChessPiece("Pawn",Player.BLACK), PieceFactory.createChessPiece("Pawn",Player.BLACK)},
            {PieceFactory.createChessPiece("Rook",Player.BLACK), PieceFactory.createChessPiece("Knight",Player.BLACK), PieceFactory.createChessPiece("Bishop",Player.BLACK), PieceFactory.createChessPiece("Queen",Player.BLACK), PieceFactory.createChessPiece("King",Player.BLACK), PieceFactory.createChessPiece("Bishop",Player.BLACK), PieceFactory.createChessPiece("Knight",Player.BLACK),PieceFactory.createChessPiece("Rook",Player.BLACK)},
        };
        return initialState;
    }
}
