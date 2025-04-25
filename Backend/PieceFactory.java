package ChessCore;
import ChessCore.Pieces.*;

class PieceFactory {
     public static Piece createChessPiece(String name, Player Color) {
        switch (name) {
            case "Pawn":
                if (Color == Color.WHITE) {
                    return new Pawn(Color.WHITE);
                } else if (Color == Color.BLACK) {
                    return new Pawn(Color.BLACK);
                }
            case "Rook":
                if (Color == Color.WHITE) {
                    return new Rook(Color.WHITE);
                } else if (Color == Color.BLACK) {
                    return new Rook(Color.BLACK);
                }
            case "Bishop":
                if (Color == Color.WHITE) {
                    return new Bishop(Color.WHITE);
                } else if (Color == Color.BLACK) {
                    return new Bishop(Color.BLACK);
                }
            case "King":
                if (Color == Color.WHITE) {
                    return new King(Color.WHITE);
                } else if (Color == Color.BLACK) {
                    return new King(Color.BLACK);
                }
            case "Queen":
                if (Color == Color.WHITE) {
                    return new Queen(Color.WHITE);
                } else if (Color == Color.BLACK) {
                    return new Queen(Color.BLACK);
                }
            case "Knight":
                if (Color == Color.WHITE) {
                    return new Knight(Color.WHITE);
                } else if (Color == Color.BLACK) {
                    return new Knight(Color.BLACK);
                }
            default:
                return null;
        }
    }
}
