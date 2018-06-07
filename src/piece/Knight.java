package piece;

import chessFrame.Frame;

import java.awt.*;

public class Knight implements Piece {
    @Override
    public void movePiece(Frame frame) {
        int i = frame.board.srcInfo.i;
        int j = frame.board.srcInfo.j;
        knightMove(frame, i - 2, j - 1);
        knightMove(frame, i - 1, j - 2);
        knightMove(frame, i + 1, j - 2);
        knightMove(frame, i + 2, j - 1);
        knightMove(frame, i - 2, j + 1);
        knightMove(frame, i - 1, j + 2);
        knightMove(frame, i + 1, j + 2);
        knightMove(frame, i + 2, j + 1);
    }

    private void knightMove(Frame frame, int a, int b) {
        try {
            if(frame.board.boardInfo[a][b].pieceColor != null) {
                if (frame.game.ifAlly(frame.board.boardInfo[a][b].pieceColor, frame.board.thisTurn))
                    return;
                frame.board.iPanel[a][b].setBackground(new Color(255, 152, 142));
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {
        }
    }
}

