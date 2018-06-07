package game;

import chessFrame.Board;

public class Rule {

    public boolean ifCheck(Board board) {

        return false;
    }

    public boolean ifCheckmate(Board board) {

        return false;
    }

    public boolean ifStalemate(Board board) {

        return false;
    }

    public boolean ifPromote(Board board) {

        return true;
    }


}
