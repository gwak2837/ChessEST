package piece;

import chessFrame.Board;
import chessFrame.Frame;

import java.awt.*;

public class Bishop implements Piece {
    @Override
    public void movePiece(Frame frame) {
        int i = frame.board.srcInfo.i;
        int j = frame.board.srcInfo.j;
        try {
            while (frame.board.boardInfo[i + 1][j + 1] != null && frame.board.boardInfo[i + 1][j + 1].pieceColor != null) {
                if(frame.game.ifAlly(frame.board.boardInfo[i+1][j+1].pieceColor, frame.board.thisTurn))
                    break;
                frame.board.iPanel[i + 1][j + 1].setBackground(new Color(255, 152, 142));
                if (frame.game.ifEnemy(frame.board.boardInfo[i + 1][j + 1].pieceColor, frame.board.thisTurn))
                    break;
                i++;
                j++;
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {}

        i = frame.board.srcInfo.i;
        j = frame.board.srcInfo.j;
        try {
            while (frame.board.boardInfo[i + 1][j - 1] != null && frame.board.boardInfo[i + 1][j - 1].pieceColor != null) {
                if(frame.game.ifAlly(frame.board.boardInfo[i+1][j-1].pieceColor, frame.board.thisTurn))
                    break;
                frame.board.iPanel[i + 1][j - 1].setBackground(new Color(255, 152, 142));
                if (frame.game.ifEnemy(frame.board.boardInfo[i + 1][j - 1].pieceColor, frame.board.thisTurn))
                    break;
                i++;
                j--;
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {}

        i = frame.board.srcInfo.i;
        j = frame.board.srcInfo.j;
        try {
            while (frame.board.boardInfo[i - 1][j + 1] != null && frame.board.boardInfo[i - 1][j + 1].pieceColor != null) {
                if(frame.game.ifAlly(frame.board.boardInfo[i-1][j+1].pieceColor, frame.board.thisTurn))
                    break;
                frame.board.iPanel[i - 1][j + 1].setBackground(new Color(255, 152, 142));
                if (frame.game.ifEnemy(frame.board.boardInfo[i - 1][j + 1].pieceColor, frame.board.thisTurn))
                    break;
                i--;
                j++;
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {}

        i = frame.board.srcInfo.i;
        j = frame.board.srcInfo.j;
        try {
            while (frame.board.boardInfo[i - 1][j - 1] != null && frame.board.boardInfo[i - 1][j - 1].pieceColor != null) {
                if(frame.game.ifAlly(frame.board.boardInfo[i-1][j-1].pieceColor, frame.board.thisTurn))
                    break;
                frame.board.iPanel[i - 1][j - 1].setBackground(new Color(255, 152, 142));
                if (frame.game.ifEnemy(frame.board.boardInfo[i - 1][j - 1].pieceColor, frame.board.thisTurn))
                    break;
                i--;
                j--;
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {}
    }
}
