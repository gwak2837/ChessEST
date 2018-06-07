package piece;


import chessFrame.Frame;

public class Queen implements Piece {
    @Override
    public void movePiece(Frame frame) {
        new Rook().movePiece(frame);
        new Bishop().movePiece(frame);
    }
}