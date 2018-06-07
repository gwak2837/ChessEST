package listener;

import chessFrame.Frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {

    private Frame frame;

    public MenuListener(Frame frame) {
        this.frame = frame;
    }

    public void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu startMenu = new JMenu("Start");
        JMenuItem newGame = new JMenuItem("New game");
        JMenuItem exit = new JMenuItem("Exit");

        startMenu.setMnemonic('S');
        newGame.setMnemonic('N');
        exit.setMnemonic('E');

        startMenu.add(newGame);
        startMenu.add(exit);
        newGame.addActionListener(this);
        exit.addActionListener(this);

        menuBar.add(startMenu);
        frame.setJMenuBar(menuBar);
    }

    //메뉴바 이벤트
    public void actionPerformed(ActionEvent e) {
        if ("New game".equals(e.getActionCommand())) {
            frame.newGame();
        } else if ("Exit".equals(e.getActionCommand())) {
            System.exit(0);
        }
    }
}