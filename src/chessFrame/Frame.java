package chessFrame;

import game.Rule;
import listener.MenuListener;
import listener.NewGameDialog;
import game.Game;
import main.Chess;

import javax.swing.*;
import java.awt.*;

import static enumeration.BoardType.ONEONE;

public class Frame extends JFrame {

    public Board board;
    public StatusBar statusBar;
    public Game game;
    public Rule rule = new Rule();

    public Frame() {
        //프레임 생성
        super(Chess.getTitle());

        //메뉴바 생성
        MenuListener menuListener = new MenuListener(this);
        menuListener.createMenu();

        //프레임 배경 설정
        JLabel jLabel = new JLabel(new ImageIcon("image/MainDisplay.jpeg"));
        statusBar = new StatusBar("Click Start Button");
        setLayout(new BorderLayout());
        add(statusBar, BorderLayout.SOUTH);
        add(jLabel);

        //프레임 속성 설정
        setSize(1260, 790);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //N인용의 새로운 체스게임 생성 후 시작
    public void newGame() {
        NewGameDialog ngd = new NewGameDialog(this);
        getContentPane().removeAll();

        if (ngd.getBoardType() == ONEONE)
            setSize(800, 840);
        else
            setSize(1000, 1040);

        board = new Board(this, ngd.getBoardType());
        add(board, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
        revalidate();
        repaint();

        game = new Game(ngd.getBoardType(), this);
        game.begin();
    }
}