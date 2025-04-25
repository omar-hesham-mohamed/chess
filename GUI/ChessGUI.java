package GUI;

import ChessCore.*;
import ChessCore.Pieces.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class ChessGUI extends javax.swing.JFrame {

    private static ClassicChessGame chessGame = new ClassicChessGame();
    private static JButton[][] allButtons = new JButton[8][8];
    private static ImageIcon[] images = new ImageIcon[17];
    private static JButton prevButton = null;
    private static Square prevMoveSquare = null;

    public static void main(String args[]) {

        ChessGUI gui = new ChessGUI();

        JFrame frame = new JFrame("Chess Game");
        frame.setResizable(false);

        frame.setSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(8, 8));
        frame.add(panel);
        boolean isWhite = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton b = new JButton();
                panel.setFocusable(true);
                if (isWhite) {
                    b.setBackground(new Color(245, 245, 220));
                } else {
                    b.setBackground(new Color(196, 164, 132).darker());
                }
                SwingUtilities.invokeLater(() -> {
                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent event) {
                            JButton pressedButton = (JButton) event.getSource();
                            buttonPressed(pressedButton);
                        }
                    });
                });
                allButtons[i][j] = b;
                isWhite = !isWhite;
                panel.add(b);
            }
            isWhite = !isWhite;
        }

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        Action undo = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Undo");
                chessGame.undo();
                updateGUI();
                flipBoard();
            }
        };

        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("U"), "");
        panel.getActionMap().put("", undo);

        images = Images.getAllImages();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0) {
                    allButtons[i][j].setIcon(images[j]);
                } else {
                    allButtons[i][j].setIcon(images[8]);
                }
            }
        }
        for (int i = 6; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 7) {
                    allButtons[i][j].setIcon(images[j + 9]);
                } else {
                    allButtons[i][j].setIcon(images[17]);
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square = new Square(columnConverter(j), rowConverter(i));
                allButtons[i][j].putClientProperty("square", square);
            }
        }

        flipBoard();
    }

    public static void updateGUI() {
        boolean isWhite = true;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (isWhite) {
                    allButtons[x][y].setBackground(new Color(245, 245, 220));
                } else {
                    allButtons[x][y].setBackground(new Color(196, 164, 132).darker());
                }
                isWhite = !isWhite;
                allButtons[x][y].repaint();
            }
            isWhite = !isWhite;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = chessGame.getPieceAtSquare((Square) allButtons[i][j].getClientProperty("square"));

                if (piece != null) {
                    if (piece.getOwner().equals(Player.WHITE)) {
                        if (piece instanceof Rook) {
                            allButtons[i][j].setIcon(images[0]);
                        }
                        if (piece instanceof Knight) {
                            allButtons[i][j].setIcon(images[1]);
                        }
                        if (piece instanceof Bishop) {
                            allButtons[i][j].setIcon(images[2]);
                        }
                        if (piece instanceof Queen) {
                            allButtons[i][j].setIcon(images[3]);
                        }
                        if (piece instanceof King) {
                            allButtons[i][j].setIcon(images[4]);
                        }
                        if (piece instanceof Pawn) {
                            allButtons[i][j].setIcon(images[8]);
                        }
                    }

                    if (piece.getOwner().equals(Player.BLACK)) {
                        if (piece instanceof Rook) {
                            allButtons[i][j].setIcon(images[9]);
                        }
                        if (piece instanceof Knight) {
                            allButtons[i][j].setIcon(images[10]);
                        }
                        if (piece instanceof Bishop) {
                            allButtons[i][j].setIcon(images[11]);
                        }
                        if (piece instanceof Queen) {
                            allButtons[i][j].setIcon(images[12]);
                        }
                        if (piece instanceof King) {
                            allButtons[i][j].setIcon(images[13]);
                        }
                        if (piece instanceof Pawn) {
                            allButtons[i][j].setIcon(images[17]);
                        }
                    }
                } else {
                    allButtons[i][j].setIcon(null);
                }
            }
        }
    }

    public static BoardFile columnConverter(int i) {

        switch (i) {
            case 0:
                return BoardFile.A;
            case 1:
                return BoardFile.B;
            case 2:
                return BoardFile.C;
            case 3:
                return BoardFile.D;
            case 4:
                return BoardFile.E;
            case 5:
                return BoardFile.F;
            case 6:
                return BoardFile.G;
            case 7:
                return BoardFile.H;

        }
        return null;
    }

    public static BoardRank rowConverter(int i) {
        switch (i) {
            case 0:
                return BoardRank.FIRST;
            case 1:
                return BoardRank.SECOND;
            case 2:
                return BoardRank.THIRD;
            case 3:
                return BoardRank.FORTH;
            case 4:
                return BoardRank.FIFTH;
            case 5:
                return BoardRank.SIXTH;
            case 6:
                return BoardRank.SEVENTH;
            case 7:
                return BoardRank.EIGHTH;
        }
        return null;
    }

    public static boolean isHighlightedButton(JButton pressedButton) {
        return pressedButton.getBackground().equals(Color.BLUE);
    }

    public static boolean checkInList(Square square, List<Square> squareList) {
        for (Square sq : squareList) {
            if (sq.getFile() == square.getFile() && sq.getRank() == square.getRank()) {
                return true;
            }
        }
        return false;
    }

    public static void flipBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                Icon tempIcon = allButtons[i][j].getIcon();
                Square tempSquare = (Square) allButtons[i][j].getClientProperty("square");
                allButtons[i][j].setIcon(allButtons[8 - i - 1][j].getIcon());
                allButtons[i][j].putClientProperty("square", (Square) allButtons[8 - i - 1][j].getClientProperty("square"));
                allButtons[8 - i - 1][j].setIcon(tempIcon);
                allButtons[8 - i - 1][j].putClientProperty("square", tempSquare);
            }
        }
    }

    public static void buttonPressed(JButton pressedButton) {
        if (prevButton == null || !isHighlightedButton(pressedButton)) {
            boolean isWhite = true;
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    if (isWhite) {
                        allButtons[x][y].setBackground(new Color(245, 245, 220));
                    } else {
                        allButtons[x][y].setBackground(new Color(196, 164, 132).darker());
                    }
                    isWhite = !isWhite;
                    allButtons[x][y].repaint();
                }
                isWhite = !isWhite;
            }

            Square buttonSquare = (Square) pressedButton.getClientProperty("square");
            List<Square> validSquares = chessGame.getAllValidMovesFromSquare(buttonSquare);

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (checkInList((Square) allButtons[8 - i - 1][j].getClientProperty("square"), validSquares)) {
                        allButtons[8 - i - 1][j].setBackground(Color.BLUE);
                        allButtons[8 - i - 1][j].repaint();
                    }
                }
            }

            prevButton = pressedButton;
        } else {
            boolean isWhite = true;
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    if (isWhite) {
                        allButtons[x][y].setBackground(new Color(245, 245, 220));
                    } else {
                        allButtons[x][y].setBackground(new Color(196, 164, 132).darker());
                    }
                    isWhite = !isWhite;
                    allButtons[x][y].repaint();
                }
                isWhite = !isWhite;
            }

            Square prevSquare = (Square) prevButton.getClientProperty("square");
            Square nextSquare = (Square) pressedButton.getClientProperty("square");
            Move move = new Move(prevSquare, nextSquare);
            ChessBoard board = chessGame.getBoard();
            int moveType = chessGame.moveChecker(move, board);

            if (moveType == 0) {
                if (chessGame.makeMove(move)) {
                    pressedButton.setIcon(prevButton.getIcon());
                    prevButton.setIcon(null);
                } else {
                    JOptionPane.showMessageDialog(null,"Invalid Move!");
                }
            }//normal move

            if (moveType == 1) {
                if (chessGame.makeMove(move)) {
                    pressedButton.setIcon(prevButton.getIcon());
                    prevButton.setIcon(null);
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            Square checkSquare = (Square) allButtons[i][j].getClientProperty("square");
                            if (prevMoveSquare.getFile() == checkSquare.getFile() && prevMoveSquare.getRank() == checkSquare.getRank()) {
                                System.out.println("1");
                                System.out.println(checkSquare.getFile() + "," + checkSquare.getRank());
                                allButtons[8 - 1 - i][j].setIcon(null);
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Invalid Move!");
                }
            }//enpassent

            if (moveType == 2) {
                if (chessGame.makeMove(move)) {
                    pressedButton.setIcon(prevButton.getIcon());
                    prevButton.setIcon(null);

                    Square toSquare = move.getToSquare();
                    if (toSquare.getFile() == BoardFile.G && toSquare.getRank() == BoardRank.FIRST) {
                        // White king-side castle.
                        // Rook moves from H1 to F1
                        JButton rookButton = null;
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                Square checkSquare = (Square) allButtons[i][j].getClientProperty("square");
                                if (checkSquare.getFile() == BoardFile.H && checkSquare.getRank() == BoardRank.FIRST) {
                                    rookButton = allButtons[i][j];
                                }
                            }
                        }
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                Square checkSquare = (Square) allButtons[i][j].getClientProperty("square");
                                if (checkSquare.getFile() == BoardFile.F && checkSquare.getRank() == BoardRank.FIRST && rookButton != null) {
                                    allButtons[i][j].setIcon(rookButton.getIcon());
                                    rookButton.setIcon(null);
                                }
                            }
                        }
                    } else if (toSquare.getFile() == BoardFile.G && toSquare.getRank() == BoardRank.EIGHTH) {
                        // Black king-side castle.
                        // Rook moves from H8 to F8
                        JButton rookButton = null;
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                Square checkSquare = (Square) allButtons[i][j].getClientProperty("square");
                                if (checkSquare.getFile() == BoardFile.H && checkSquare.getRank() == BoardRank.EIGHTH) {
                                    rookButton = allButtons[i][j];
                                }
                            }
                        }
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                Square checkSquare = (Square) allButtons[i][j].getClientProperty("square");
                                if (checkSquare.getFile() == BoardFile.F && checkSquare.getRank() == BoardRank.EIGHTH && rookButton != null) {
                                    allButtons[i][j].setIcon(rookButton.getIcon());
                                    rookButton.setIcon(null);
                                }
                            }
                        }
                    } else if (toSquare.getFile() == BoardFile.C && toSquare.getRank() == BoardRank.FIRST) {
                        // White queen-side castle.
                        // Rook moves from A1 to D1
                        JButton rookButton = null;
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                Square checkSquare = (Square) allButtons[i][j].getClientProperty("square");
                                if (checkSquare.getFile() == BoardFile.A && checkSquare.getRank() == BoardRank.FIRST) {
                                    rookButton = allButtons[i][j];
                                }
                            }
                        }
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                Square checkSquare = (Square) allButtons[i][j].getClientProperty("square");
                                if (checkSquare.getFile() == BoardFile.D && checkSquare.getRank() == BoardRank.FIRST && rookButton != null) {
                                    allButtons[i][j].setIcon(rookButton.getIcon());
                                    rookButton.setIcon(null);
                                }
                            }
                        }
                    } else if (toSquare.getFile() == BoardFile.C && toSquare.getRank() == BoardRank.EIGHTH) {
                        // Black queen-side castle.
                        // Rook moves from A8 to D8
                        JButton rookButton = null;
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                Square checkSquare = (Square) allButtons[i][j].getClientProperty("square");
                                if (checkSquare.getFile() == BoardFile.A && checkSquare.getRank() == BoardRank.EIGHTH) {
                                    rookButton = allButtons[i][j];
                                }
                            }
                        }
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                Square checkSquare = (Square) allButtons[i][j].getClientProperty("square");
                                if (checkSquare.getFile() == BoardFile.D && checkSquare.getRank() == BoardRank.EIGHTH && rookButton != null) {
                                    allButtons[i][j].setIcon(rookButton.getIcon());
                                    rookButton.setIcon(null);
                                }
                            }
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null,"Invalid Move!");
                }
            }//castle

            if (moveType == 3) {
                String input = JOptionPane.showInputDialog("Promote to:\n1-Knight\n2-Bishop\n3-Rook\n4-Queen");
                int promoteChar = parseInt(input);

                switch (promoteChar) {
                    case 1:
                        chessGame.makeMove(new Move(prevSquare, nextSquare, PawnPromotion.Knight));
                        prevButton.setIcon(null);
                        if (chessGame.getWhoseTurn() == Player.BLACK) {
                            pressedButton.setIcon(images[1]);
                        } else {
                            pressedButton.setIcon(images[10]);
                        }
                        break;

                    case 2:
                        chessGame.makeMove(new Move(prevSquare, nextSquare, PawnPromotion.Bishop));
                        prevButton.setIcon(null);
                        if (chessGame.getWhoseTurn() == Player.BLACK) {
                            pressedButton.setIcon(images[2]);
                        } else {
                            pressedButton.setIcon(images[11]);
                        }
                        break;

                    case 3:
                        chessGame.makeMove(new Move(prevSquare, nextSquare, PawnPromotion.Rook));
                        prevButton.setIcon(null);
                        if (chessGame.getWhoseTurn() == Player.BLACK) {
                            pressedButton.setIcon(images[0]);
                        } else {
                            pressedButton.setIcon(images[9]);
                        }
                        break;

                    case 4:
                        chessGame.makeMove(new Move(prevSquare, nextSquare, PawnPromotion.Queen));
                        prevButton.setIcon(null);
                        if (chessGame.getWhoseTurn() == Player.BLACK) {
                            pressedButton.setIcon(images[3]);
                        } else {
                            pressedButton.setIcon(images[12]);
                        }
                        break;

                    default:
                        JOptionPane.showMessageDialog(null,"Invalid Move!");
                }
            }//promotion

            chessGame.addMemento();
            chessGame.setFirstUndo();
            
            flipBoard();
            prevMoveSquare = (Square) pressedButton.getClientProperty("square");
            prevButton = null;
        }

        ChessBoard board = chessGame.getBoard();
        if (Utilities.isInCheck(Player.WHITE, board)) {
            Square kingSquare = Utilities.getKingSquare(Player.WHITE, board);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Square checkKingSquare = (Square) allButtons[i][j].getClientProperty("square");
                    if (kingSquare.getFile() == checkKingSquare.getFile() && kingSquare.getRank() == checkKingSquare.getRank()) {
                        allButtons[i][j].setBackground(Color.RED);
                        allButtons[i][j].repaint();
                    }
                }
            }
        } else if (Utilities.isInCheck(Player.BLACK, board)) {
            Square kingSquare = Utilities.getKingSquare(Player.BLACK, board);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Square checkKingSquare = (Square) allButtons[i][j].getClientProperty("square");
                    if (kingSquare.getFile() == checkKingSquare.getFile() && kingSquare.getRank() == checkKingSquare.getRank()) {
                        allButtons[i][j].setBackground(Color.RED);
                        allButtons[i][j].repaint();
                    }
                }
            }
        }

        GameStatus status = chessGame.getGameStatus();
        if (status.equals(GameStatus.BLACK_WON)) {
            JOptionPane.showMessageDialog(null, "Checkmate for Black", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        if (status.equals(GameStatus.WHITE_WON)) {
            JOptionPane.showMessageDialog(null, "Checkmate for White", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        if (status.equals(GameStatus.STALEMATE)) {
            JOptionPane.showMessageDialog(null, "Stalemate", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        if (status.equals(GameStatus.INSUFFICIENT_MATERIAL)) {
            JOptionPane.showMessageDialog(null, "Insufficient Material", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
}
