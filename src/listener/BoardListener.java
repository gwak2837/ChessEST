package listener;

import chessFrame.Frame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardListener implements MouseListener {
    public int i;
    public int j;
    public String pieceColor;
    public String pieceType;
    private Frame frame;

    public BoardListener(int i, int j, Frame frame) {
        this.i = i;
        this.j = j;
        this.frame = frame;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        if (!frame.board.end) {
            //첫번째 클릭(체스말 클릭)
            if (frame.board.click && frame.board.thisTurn.equals(this.pieceColor)) {
                frame.board.srcInfo = this;
                frame.game.findMovablePosition(frame.board.iPanel, true);
                frame.board.click = false;
            }
            //두번째 클릭(이동할 위치 클릭)
            else if (!frame.board.click && frame.board.iPanel[i][j].getBackground().equals(new Color(255, 152, 142))) {
                frame.game.findMovablePosition(frame.board.iPanel, false);
                frame.board.click = true;
                frame.game.move(frame.board, this);

                if (frame.rule.ifCheckmate(frame.board)) {
                    frame.statusBar.setStatus("Checkmate! " + frame.board.thisTurn + " player wins!", 0);
                    frame.board.end = true;
                } else if (frame.rule.ifStalemate(frame.board)) {
                    frame.statusBar.setStatus("Stalemate. Game ended in draw...", 0);
                    frame.board.end = true;
                } else if (frame.rule.ifCheck(frame.board))
                    frame.statusBar.setStatus("Check! " + frame.board.thisTurn + " player's turn", 0);
                else {
                    frame.board.thisTurn = frame.game.nextTurn(frame.board);
                    frame.statusBar.setStatus(frame.board.thisTurn + " player's turn", 0);
                }
                frame.statusBar.setStatus("  Number of White's piece : " + frame.game.getPlayer()[0].getNumberOfPiece(), 1);
                frame.statusBar.setStatus("Number of Black's piece : " + frame.game.getPlayer()[1].getNumberOfPiece() + "  ", 2);
            }
            //두번째 클릭(이동할 위치말고 다른 곳 클릭)
            else if (!frame.board.click) {
                frame.game.findMovablePosition(frame.board.iPanel, false);
                frame.board.click = true;
            }
        }
    }
}
