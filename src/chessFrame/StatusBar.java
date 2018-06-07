package chessFrame;

import javax.swing.*;
import java.awt.*;

public class StatusBar extends JPanel {
    private String status;
    private JLabel[] jLabel = new JLabel[3];

    StatusBar(String s) {
        //패널 생성 및 초기화
        super();
        setBackground(new Color(0xAA, 0xAA, 0xAA));
        setPreferredSize(null);
        setMinimumSize(null);
        setMaximumSize(null);
        setLayout(new BorderLayout());

        //라벨 추가
        status = s;
        jLabel[0] = new JLabel(status);
        jLabel[0].setFont(new Font("Arial",Font.BOLD,20));
        jLabel[0].setHorizontalAlignment(SwingConstants.CENTER);
        add(jLabel[0], BorderLayout.CENTER);

        jLabel[1] = new JLabel();
        jLabel[1].setFont(new Font("Arial",Font.PLAIN,20));
        add(jLabel[1], BorderLayout.WEST);

        jLabel[2] = new JLabel();
        jLabel[2].setFont(new Font("Arial",Font.PLAIN,20));
        add(jLabel[2], BorderLayout.EAST);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status, int i) {
        jLabel[i].setText(status);
    }
}
