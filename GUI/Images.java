package GUI;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Images {

    public static ImageIcon[] getAllImages() {
        ImageIcon black_bishop = new ImageIcon("C:\\Users\\acer\\Desktop\\Me\\Uni\\Term 5\\Programming 2\\ChessFinal\\ChessFinal\\build\\classes\\BlackBishop.png");
        ImageIcon black_king = new ImageIcon("C:\\Users\\acer\\Desktop\\Me\\Uni\\Term 5\\Programming 2\\ChessFinal\\ChessFinal\\build\\classes\\BlackKing.png");
        ImageIcon black_knight = new ImageIcon("C:\\Users\\acer\\Desktop\\Me\\Uni\\Term 5\\Programming 2\\ChessFinal\\ChessFinal\\build\\classes\\BlackKnight.png");
        ImageIcon black_pawn = new ImageIcon("C:\\Users\\acer\\Desktop\\Me\\Uni\\Term 5\\Programming 2\\ChessFinal\\ChessFinal\\build\\classes\\BlackPawn.png");
        ImageIcon black_queen = new ImageIcon("C:\\Users\\acer\\Desktop\\Me\\Uni\\Term 5\\Programming 2\\ChessFinal\\ChessFinal\\build\\classes\\BlackQueen.png");
        ImageIcon black_rook = new ImageIcon("C:\\Users\\acer\\Desktop\\Me\\Uni\\Term 5\\Programming 2\\ChessFinal\\ChessFinal\\build\\classes\\BlackRook.png");
        ImageIcon white_bishop = new ImageIcon("C:\\Users\\acer\\Desktop\\Me\\Uni\\Term 5\\Programming 2\\ChessFinal\\ChessFinal\\build\\classes\\WhiteBishop.png");
        ImageIcon white_king = new ImageIcon("C:\\Users\\acer\\Desktop\\Me\\Uni\\Term 5\\Programming 2\\ChessFinal\\ChessFinal\\build\\classes\\WhiteKing.png");
        ImageIcon white_knight = new ImageIcon("C:\\Users\\acer\\Desktop\\Me\\Uni\\Term 5\\Programming 2\\ChessFinal\\ChessFinal\\build\\classes\\WhiteKnight.png");
        ImageIcon white_pawn = new ImageIcon("C:\\Users\\acer\\Desktop\\Me\\Uni\\Term 5\\Programming 2\\ChessFinal\\ChessFinal\\build\\classes\\WhitePawn.png");
        ImageIcon white_queen = new ImageIcon("C:\\Users\\acer\\Desktop\\Me\\Uni\\Term 5\\Programming 2\\ChessFinal\\ChessFinal\\build\\classes\\WhiteQueen.png");
        ImageIcon white_rook = new ImageIcon("C:\\Users\\acer\\Desktop\\Me\\Uni\\Term 5\\Programming 2\\ChessFinal\\ChessFinal\\build\\classes\\WhiteRook.png");
        
        Image black_bishopimg = black_bishop.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        Image black_kingimg = black_king.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        Image black_knightimg = black_knight.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        Image black_pawnimg = black_pawn.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        Image black_queenimg = black_queen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        Image black_rookimg = black_rook.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        Image white_bishopimg = white_bishop.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        Image white_kingimg = white_king.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        Image white_knightimg = white_knight.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        Image white_pawnimg = white_pawn.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        Image white_queenimg = white_queen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        Image white_rookimg = white_rook.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);

        ImageIcon black_bishopimg_resize = new ImageIcon(black_bishopimg);
        ImageIcon black_kingimg_resize = new ImageIcon(black_kingimg);
        ImageIcon black_knightimg_resize = new ImageIcon(black_knightimg);
        ImageIcon black_pawnimg_resize = new ImageIcon(black_pawnimg);
        ImageIcon black_queenimg_resize = new ImageIcon(black_queenimg);
        ImageIcon black_rookimg_resize = new ImageIcon(black_rookimg);
        ImageIcon white_bishopimg_resize = new ImageIcon(white_bishopimg);
        ImageIcon white_kingimg_resize = new ImageIcon(white_kingimg);
        ImageIcon white_knightimg_resize = new ImageIcon(white_knightimg);
        ImageIcon white_pawnimg_resize = new ImageIcon(white_pawnimg);
        ImageIcon white_queenimg_resize = new ImageIcon(white_queenimg);
        ImageIcon white_rookimg_resize = new ImageIcon(white_rookimg);

        ImageIcon[] allImages = {
             white_rookimg_resize,
            white_knightimg_resize,
            white_bishopimg_resize,
            white_queenimg_resize,
            white_kingimg_resize,
            white_bishopimg_resize,
            white_knightimg_resize,
            white_rookimg_resize,
            white_pawnimg_resize,
                
            black_rookimg_resize,
            black_knightimg_resize,
            black_bishopimg_resize,
            black_queenimg_resize,
            black_kingimg_resize,
            black_bishopimg_resize,
            black_knightimg_resize,
            black_rookimg_resize,
            black_pawnimg_resize };

        return allImages;
    }

}
