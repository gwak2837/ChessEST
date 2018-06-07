package piece;


import chessFrame.Frame;

import java.awt.*;

public class King implements Piece {
    @Override
    public void movePiece(Frame frame) {
        int i = frame.board.srcInfo.i;
        int j = frame.board.srcInfo.j;

        //킹 주위 색칠
        for (int a = -1; a < 2; a++) {
            for (int b = -1; b < 2; b++) {
                try {
                    if(frame.board.boardInfo[i + a][j + b].pieceColor != null) {
                        if (frame.game.ifAlly(frame.board.boardInfo[i + a][j + b].pieceColor, frame.board.thisTurn))
                            throw new MoveException();
                        frame.board.iPanel[i + a][j + b].setBackground(new Color(255, 152, 142));
                    }
                } catch (ArrayIndexOutOfBoundsException | MoveException ignore) {}
            }
        }

        //갈 수 없는 곳 색칠 해제





    }
    private class MoveException extends RuntimeException{}
}