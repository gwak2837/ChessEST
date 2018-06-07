package piece;

import chessFrame.Frame;

public interface Piece{
    //frame.board.srcInfo.i; 클릭된 i위치
    //frame.board.srcInfo.j; 클릭된 j위치
    //frame.board.boardInfo[i][j] != null; 존재하는 체스판
    //frame.board.boardInfo[i][j].pieceColor != null; 2vs2에서 이동가능한 체스판
    void movePiece(Frame frame);
}

