package listener;

import enumeration.BoardType;
import chessFrame.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static enumeration.BoardType.ONEONE;
import static enumeration.BoardType.TWOTWO;

public class NewGameDialog extends JDialog implements ActionListener {

    private BoardType boardType = ONEONE;

    public NewGameDialog(Frame owner) {
        super(owner, "New game", true);
        setLocationRelativeTo(owner);
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 25));
        setSize(300, 230);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton oneone = new JButton("1 vs 1");
        JButton twotwo = new JButton("2 vs 2");

        oneone.setSize(60,35);
        twotwo.setSize(60,35);
        oneone.setFont(new Font("맑은 고딕",Font.PLAIN,35));
        twotwo.setFont(new Font("맑은 고딕",Font.PLAIN,35));

        oneone.addActionListener(this);
        twotwo.addActionListener(this);

        add(oneone);
        add(twotwo);
        getRootPane().setDefaultButton(oneone);
        setVisible(true);
    }

    public BoardType getBoardType() {
        return boardType;
    }

    //New game Dialog 이벤트
    public void actionPerformed(ActionEvent e) {
        if(!"1 vs 1".equals(e.getActionCommand())) {
            boardType = TWOTWO;
        }
        setVisible(false);
        dispose();
    }
}
