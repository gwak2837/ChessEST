package chessFrame;

import enumeration.BoardType;
import kr.ac.cau.mecs.lenerd.chess.ImagePanel;
import listener.BoardListener;
import kr.ac.cau.mecs.lenerd.chess.ChessPieceSprite;
import kr.ac.cau.mecs.lenerd.chess.ChessPieceSprite.ChessPieceSpriteType;

import javax.swing.*;
import java.awt.*;

import static enumeration.BoardType.ONEONE;

public class Board extends JPanel {
    public static int WIDTH = 8;
    public static int HEIGHT = 8;

    //전체 체스판 정보
    public ImagePanel[][] iPanel;
    public BoardListener[][] boardInfo;

    //차례 정보
    public String thisTurn; //현재 차례인 플레이어 색
    public boolean click = true; //true : 체스말 클릭할 차례, false : 이동할 위치 클릭할 차례
    public boolean end = false;

    //첫번째 클릭된 체스판 정보
    public BoardListener srcInfo;

    public Board(Frame frame) {
        this(frame, ONEONE);
    }

    public Board(Frame frame, BoardType t) {
        //1vs1 보드 생성
        int gap = 2;
        iPanel = new ImagePanel[HEIGHT][WIDTH];
        boardInfo = new BoardListener[Board.HEIGHT][Board.WIDTH];
        if (t == ONEONE) {
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    BoardListener bl = new BoardListener(i, j, frame);
                    this.boardInfo[i][j] = bl;
                    iPanel[i][j] = new ImagePanel();
                    iPanel[i][j].setOpaque(true);
                    iPanel[i][j].setBackground((i + j) % 2 == 0 ? new Color(244, 214, 179) : new Color(180, 134, 99));
                    iPanel[i][j].addMouseListener(bl);
                    if (i == 0) {
                        switch (j) {
                            case 0:
                            case 7:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.BLACK_LOOK, bl, "Black", "rook");
                                break;
                            case 1:
                            case 6:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.BLACK_KNIGHT, bl, "Black", "knight");
                                break;
                            case 2:
                            case 5:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.BLACK_BISHOP, bl, "Black", "bishop");
                                break;
                            case 3:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.BLACK_QUEEN, bl, "Black", "queen");
                                break;
                            case 4:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.BLACK_KING, bl, "Black", "king");
                                break;
                            default:
                                System.out.println("Invalid Board. Width expected shorter than 9...");
                        }
                    }  else if (i == 1)
                        setPieceType(iPanel, i, j, ChessPieceSpriteType.BLACK_PAWN, bl, "Black", "pawn");
                    else if (i == 6)
                        setPieceType(iPanel, i, j, ChessPieceSpriteType.WHITE_PAWN, bl, "White", "pawn");
                    else if (i == 7) {
                        switch (j) {
                            case 0:
                            case 7:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.WHITE_LOOK, bl, "White", "rook");
                                break;
                            case 1:
                            case 6:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.WHITE_KNIGHT, bl, "White", "knight");
                                break;
                            case 2:
                            case 5:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.WHITE_BISHOP, bl, "White", "bishop");
                                break;
                            case 3:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.WHITE_QUEEN, bl, "White", "queen");
                                break;
                            case 4:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.WHITE_KING, bl, "White", "king");
                                break;
                            default:
                                System.out.println("Invalid Board. Width expected shorter than 9...");
                        }
                    }
                    else
                        setPieceType(iPanel, i, j, bl, "", "");
                    add(iPanel[i][j]);
                }
            }
            setLayout(new GridLayout(HEIGHT, WIDTH, gap, gap));
        }
        //2vs2 보드 생성
        else {
            WIDTH = 14;
            HEIGHT = 14;
            iPanel = new ImagePanel[HEIGHT][WIDTH];
            boardInfo = new BoardListener[Board.HEIGHT][Board.WIDTH];
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    BoardListener bl = new BoardListener(i, j, frame);
                    this.boardInfo[i][j] = bl;
                    iPanel[i][j] = new ImagePanel();
                    iPanel[i][j].setOpaque(true);
                    iPanel[i][j].addMouseListener(bl);
                    if (i == 0) {
                        switch (j) {
                            case 3:
                            case 10:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.BLACK_LOOK, bl, "Black", "rook");
                                break;
                            case 4:
                            case 9:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.BLACK_KNIGHT, bl, "Black", "knight");
                                break;
                            case 5:
                            case 8:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.BLACK_BISHOP, bl, "Black", "bishop");
                                break;
                            case 6:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.BLACK_KING, bl, "Black", "king");
                                break;
                            case 7:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.BLACK_QUEEN, bl, "Black", "queen");
                                break;
                        }
                    } else if (i == 1 && j > 2 && j < 11)
                        setPieceType(iPanel, i, j, ChessPieceSpriteType.BLACK_PAWN, bl, "Black", "pawn");
                    else if (j == 0 && i > 2 && i < HEIGHT - 3) {
                        switch (i) {
                            case 3:
                            case 10:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.RED_LOOK, bl, "Red", "rook");
                                break;
                            case 4:
                            case 9:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.RED_KNIGHT, bl, "Red", "knight");
                                break;
                            case 5:
                            case 8:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.RED_BISHOP, bl, "Red", "bishop");
                                break;
                            case 6:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.RED_KING, bl, "Red", "king");
                                break;
                            case 7:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.RED_QUEEN, bl, "Red", "queen");
                                break;
                        }
                    } else if (j == 1 && i > 2 && i < HEIGHT - 3) {
                        setPieceType(iPanel, i, j, ChessPieceSpriteType.RED_PAWN, bl, "Red", "pawn");
                    } else if (j == HEIGHT - 2 && i > 2 && i < HEIGHT - 3) {
                        setPieceType(iPanel, i, j, ChessPieceSpriteType.GREEN_PAWN, bl, "Green", "pawn");
                    } else if (j == HEIGHT - 1 && i > 2 && i < HEIGHT - 3) {
                        switch (i) {
                            case 3:
                            case 10:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.GREEN_LOOK, bl, "Green", "rook");
                                break;
                            case 4:
                            case 9:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.GREEN_KNIGHT, bl, "Green", "knight");
                                break;
                            case 5:
                            case 8:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.GREEN_BISHOP, bl, "Green", "bishop");
                                break;
                            case 6:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.GREEN_QUEEN, bl, "Green", "queen");
                                break;
                            case 7:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.GREEN_KING, bl, "Green", "king");
                                break;
                        }
                    } else if (i == HEIGHT - 2 && j > 2 && j < WIDTH - 3)
                        setPieceType(iPanel, i, j, ChessPieceSpriteType.WHITE_PAWN, bl, "White", "pawn");
                    else if (i == HEIGHT - 1) {
                        switch (j) {
                            case 3:
                            case 10:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.WHITE_LOOK, bl, "White", "rook");
                                break;
                            case 4:
                            case 9:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.WHITE_KNIGHT, bl, "White", "knight");
                                break;
                            case 5:
                            case 8:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.WHITE_BISHOP, bl, "White", "bishop");
                                break;
                            case 6:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.WHITE_QUEEN, bl, "White", "queen");
                                break;
                            case 7:
                                setPieceType(iPanel, i, j, ChessPieceSpriteType.WHITE_KING, bl, "White", "king");
                                break;
                        }
                    }
                    else
                        setPieceType(iPanel, i, j, bl, "", "");
                    if (i < 3 && j < 3 || i < 3 && j > WIDTH - 4 || i > HEIGHT - 4 && j < 3 || i > HEIGHT - 4 && j > WIDTH - 4) {
                        iPanel[i][j].setBackground(new Color(255, 247, 219));
                        setPieceType(iPanel, i, j, bl, null, null);
                    }
                    else
                        iPanel[i][j].setBackground((i + j) % 2 == 0 ? new Color(244, 214, 179) : new Color(180, 134, 99));
                    add(iPanel[i][j]);
                }
            }
            setLayout(new GridLayout(HEIGHT, WIDTH, gap, gap));
        }
    }

    private void setPieceType(ImagePanel[][] iPanel, int i, int j, ChessPieceSpriteType pieceType, BoardListener bl, String color, String type) {
        iPanel[i][j].setImage(ChessPieceSprite.getInstace().getChessPiece(pieceType));
        bl.pieceColor = color;
        bl.pieceType = type;
    }

    private void setPieceType(ImagePanel[][] iPanel, int i, int j, BoardListener bl, String color, String type) {
        iPanel[i][j].setImage(null);
        bl.pieceColor = color;
        bl.pieceType = type;
    }
}
