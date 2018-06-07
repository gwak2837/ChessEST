package game;

import chessFrame.Board;
import kr.ac.cau.mecs.lenerd.chess.ImagePanel;
import enumeration.BoardType;
import chessFrame.Frame;
import listener.BoardListener;
import piece.*;

import java.awt.*;

import static enumeration.BoardType.ONEONE;
import static enumeration.BoardType.TWOTWO;

public class Game {
    private Player[] player = new Player[4];
    private Frame frame;

    public Game(Frame frame) {
        this(ONEONE, frame);
    }

    public Game(BoardType bt, Frame frame) {
        this.frame = frame;
        player[0] = new Player("White");
        player[1] = new Player("Black");

        if (bt == TWOTWO) {
            player[2] = new Player("Red");
            player[3] = new Player("Greed");
        }
    }

    public void begin() {
        String thisTurn = player[0].getColor();
        frame.board.thisTurn = thisTurn;
        frame.statusBar.setStatus(thisTurn + " player's turn", 0);
        frame.statusBar.setStatus("  Number of White's piece : " + player[0].getNumberOfPiece(), 1);
        frame.statusBar.setStatus("Number of Black's piece : " + player[1].getNumberOfPiece()+ "  ", 2 );
    }

    public void findMovablePosition(ImagePanel[][] iPanel, boolean flag) {
        //체스말의 이동가능 위치 계산 후 색칠
        if (flag) {
            switch (frame.board.srcInfo.pieceType) {
                case "bishop":
                    new Bishop().movePiece(frame);
                    break;
                case "rook":
                    new Rook().movePiece(frame);
                    break;
                case "knight":
                    new Knight().movePiece(frame);
                    break;
                case "king":
                    new King().movePiece(frame);
                    break;
                case "queen":
                    new Queen().movePiece(frame);
                    break;
                case "pawn":
                    new Pawn().movePiece(frame);
                    break;
                default:
                    System.out.println("등록되지 않은 체스말입니다.");
                    frame.statusBar.setStatus("등록되지 않은 체스말입니다.", 0);
            }
        }
        //모든 체스판의 색을 원래대로
        else {
            //1vs1 체스판
            for (int a = 0; a < Board.HEIGHT; a++) {
                for (int b = 0; b < Board.WIDTH; b++) {
                    iPanel[a][b].setBackground((a + b) % 2 == 0 ? new Color(244, 214, 179) : new Color(180, 134, 99));
                }
            }
            //2vs2 체스판
            if (Board.HEIGHT == 14) {
                for (int a = 0; a < Board.HEIGHT; a++) {
                    for (int b = 0; b < Board.WIDTH; b++) {
                        if (a < 3 && b < 3 || a < 3 && b > Board.WIDTH - 4 || a > Board.HEIGHT - 4 && b < 3 || a > Board.HEIGHT - 4 && b > Board.WIDTH - 4)
                            iPanel[a][b].setBackground(new Color(255, 247, 219));
                    }
                }
            }
        }
    }

    public String nextTurn(Board b) {
        String nextTurn = "";
        if (Board.WIDTH == 8) {
            switch (b.thisTurn) {
                case "White":
                    nextTurn = "Black";
                    break;
                case "Black":
                    nextTurn = "White";
                    break;
            }
        } else {
            switch (b.thisTurn) {
                case "White":
                    nextTurn = "Red";
                    break;
                case "Red":
                    nextTurn = "Black";
                    break;
                case "Black":
                    nextTurn = "Green";
                    break;
                default:
                    nextTurn = "White";
                    break;
            }
        }
        return nextTurn;
    }

    public boolean ifEnemy(String one, String two) {
        if (Board.WIDTH == 8) {
            switch (one) {
                case "Black":
                    return two.equals("White");
                case "White":
                    return two.equals("Black");
                default:
                    return false;
            }
        } else {
            switch (one) {
                case "Black":
                    return two.equals("Red") || two.equals("Green");
                case "White":
                    return two.equals("Red") || two.equals("Green");
                case "Red":
                    return two.equals("Black") || two.equals("White");
                case "Green":
                    return two.equals("Black") || two.equals("White");
                default:
                    return false;
            }
        }
    }

    public boolean ifAlly(String one, String two) {
        if (Board.WIDTH == 8) {
            switch (one) {
                case "Black":
                    return two.equals("Black");
                case "White":
                    return two.equals("White");
                default:
                    return false;
            }
        } else {
            switch (one) {
                case "Black":
                    return two.equals("Black") || two.equals("White");
                case "White":
                    return two.equals("Black") || two.equals("White");
                case "Red":
                    return two.equals("Red") || two.equals("Green");
                case "Green":
                    return two.equals("Red") || two.equals("Green");
                default:
                    return false;
            }
        }
    }

    //체스말이 목적지로 반드시 이동할 수 있어야 함
    public void move(Board board, BoardListener desInfo) {
        //목적지에 상대말이 있으면
        if (!desInfo.pieceType.equals("")) {
            switch (desInfo.pieceColor) {
                case "White":
                    player[0].setNumberOfPiece(player[0].getNumberOfPiece() - 1);
                    break;
                case "Black":
                    player[1].setNumberOfPiece(player[1].getNumberOfPiece() - 1);
                    break;
                case "Red":
                    player[2].setNumberOfPiece(player[2].getNumberOfPiece() - 1);
                    break;
                case "Green":
                    player[3].setNumberOfPiece(player[3].getNumberOfPiece() - 1);
                    break;
                default:
                    System.out.println("등록되지 않은 사용자입니다...");
            }
        }

        //목적지 정보 갱신
        board.iPanel[desInfo.i][desInfo.j].setImage(board.iPanel[board.srcInfo.i][board.srcInfo.j].getImage());
        desInfo.pieceColor = frame.board.srcInfo.pieceColor;
        desInfo.pieceType = frame.board.srcInfo.pieceType;

        //출발지 정보 삭제
        board.iPanel[board.srcInfo.i][board.srcInfo.j].setImage(null);
        board.srcInfo.pieceColor = "";
        board.srcInfo.pieceType = "";
        frame.revalidate();
        frame.repaint();
    }

    public Player[] getPlayer() {
        return player;
    }

    public void setPlayer(Player[] player) {
        this.player = player;
    }
}
