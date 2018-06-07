package piece;

import chessFrame.Frame;

import java.awt.*;

public class Rook implements Piece {
    @Override
    public void movePiece(Frame frame) {
        int i = frame.board.srcInfo.i;
        int j = frame.board.srcInfo.j;
        try {
            while (frame.board.boardInfo[i][j + 1] != null && frame.board.boardInfo[i][j + 1].pieceColor != null) {
                if(frame.game.ifAlly(frame.board.boardInfo[i][j+1].pieceColor, frame.board.thisTurn))
                    break;
                frame.board.iPanel[i][j + 1].setBackground(new Color(255, 152, 142));
                if (frame.game.ifEnemy(frame.board.boardInfo[i][j + 1].pieceColor, frame.board.thisTurn))
                    break;
                j++;
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {}

        i = frame.board.srcInfo.i;
        j = frame.board.srcInfo.j;
        try {
            while (frame.board.boardInfo[i][j - 1] != null && frame.board.boardInfo[i][j - 1].pieceColor != null) {
                if(frame.game.ifAlly(frame.board.boardInfo[i][j-1].pieceColor, frame.board.thisTurn))
                    break;
                frame.board.iPanel[i][j - 1].setBackground(new Color(255, 152, 142));
                if (frame.game.ifEnemy(frame.board.boardInfo[i][j - 1].pieceColor, frame.board.thisTurn))
                    break;
                j--;
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {}

        i = frame.board.srcInfo.i;
        j = frame.board.srcInfo.j;
        try {
            while (frame.board.boardInfo[i + 1][j] != null && frame.board.boardInfo[i + 1][j].pieceColor != null) {
                if(frame.game.ifAlly(frame.board.boardInfo[i+1][j].pieceColor, frame.board.thisTurn))
                    break;
                frame.board.iPanel[i + 1][j].setBackground(new Color(255, 152, 142));
                if (frame.game.ifEnemy(frame.board.boardInfo[i + 1][j].pieceColor, frame.board.thisTurn))
                    break;
                i++;
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {}

        i = frame.board.srcInfo.i;
        j = frame.board.srcInfo.j;
        try {
            while (frame.board.boardInfo[i - 1][j] != null && frame.board.boardInfo[i - 1][j].pieceColor != null) {
                if(frame.game.ifAlly(frame.board.boardInfo[i-1][j].pieceColor, frame.board.thisTurn))
                    break;
                frame.board.iPanel[i - 1][j].setBackground(new Color(255, 152, 142));
                if (frame.game.ifEnemy(frame.board.boardInfo[i - 1][j].pieceColor, frame.board.thisTurn))
                    break;
                i--;
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {}
    }
}