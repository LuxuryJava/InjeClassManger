package ac.injecs.java2.frame;

import ac.injecs.java2.Main;

import java.awt.*;
import javax.swing.*;

public class CheckClass_Day extends JPanel {
    private Main mainFrame;
    private checkWeekly checkW = new checkWeekly();
    public CheckClass_Day(Main main) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("강의실 예약 조회", SwingConstants.CENTER);
        title.setFont(new Font("나눔고딕", Font.BOLD, 30));
        add(title, BorderLayout.NORTH);
        add(checkW, BorderLayout.CENTER);
        setVisible(true);
    }

    public class checkWeekly extends JPanel {
        public checkWeekly() {
            setLayout(new GridLayout(1,7,0,0));
            ImageIcon[] image = {new ImageIcon("images/Weekly_sun.png"), new ImageIcon("images/Weekly_mon.png"),
                    new ImageIcon("images/Weekly_tue.png"), new ImageIcon("images/Weekly_wed.png"),
                    new ImageIcon("images/Weekly_thu.png"), new ImageIcon("images/Weekly_fri.png"),
                    new ImageIcon("images/Weekly_sat.png")};
            JButton[] btn = {new JButton(image[0]), new JButton(image[1]), new JButton(image[2]),
                    new JButton(image[3]), new JButton(image[4]), new JButton(image[5]), new JButton(image[6])};

            for(int i = 0; i < image.length; i++) {
                add(btn[i]);
                btn[i].setBorderPainted(false);
                btn[i].setFocusPainted(false);
                btn[i].setContentAreaFilled(false);
            }
        }
    }
}
