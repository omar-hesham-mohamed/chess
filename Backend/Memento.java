package ChessCore;

public class Memento {

    private ChessBoard board;
    private GameStatus gameStatus;
    private Player whoseTurn;

    private Move lastMove;
    private boolean canWhiteCastleKingSide;
    private boolean canWhiteCastleQueenSide;
    private boolean canBlackCastleKingSide;
    private boolean canBlackCastleQueenSide;

    public Memento(ChessBoard board, GameStatus gameStatus, Player whoseTurn, Move lastMove, boolean canWhiteCastleKingSide, boolean canWhiteCastleQueenSide, boolean canBlackCastleKingSide, boolean canBlackCastleQueenSide) {
        this.board = new ChessBoard(board);
        this.gameStatus = gameStatus;
        this.whoseTurn = whoseTurn;
        this.lastMove = lastMove;
        this.canWhiteCastleKingSide = canWhiteCastleKingSide;
        this.canWhiteCastleQueenSide = canWhiteCastleQueenSide;
        this.canBlackCastleKingSide = canBlackCastleKingSide;
        this.canBlackCastleQueenSide = canBlackCastleQueenSide;
    }

    public ChessBoard getBoard() {
        return board;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Player getWhoseTurn() {
        return whoseTurn;
    }

    public Move getLastMove() {
        return lastMove;
    }

    public boolean isCanWhiteCastleKingSide() {
        return canWhiteCastleKingSide;
    }

    public boolean isCanWhiteCastleQueenSide() {
        return canWhiteCastleQueenSide;
    }

    public boolean isCanBlackCastleKingSide() {
        return canBlackCastleKingSide;
    }

    public boolean isCanBlackCastleQueenSide() {
        return canBlackCastleQueenSide;
    }
}
