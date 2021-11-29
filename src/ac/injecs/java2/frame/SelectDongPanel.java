package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectDongPanel extends JPanel {
    private Main mainFrame;
    public JLabel title = new JLabel("강의실 예약");

    public SelectDongPanel(Main main) {
        this.mainFrame = main;
        setLayout(null);

        title.setFont(InjeFont.XLfont);
        title.setBounds(450, 20, 200, 30);

        RoundedButton aButton = new RoundedButton("A동");
        aButton.setBounds(200, 200, 150, 150);
        aButton.setFont(InjeFont.XLfont);

        RoundedButton bButton = new RoundedButton("B동");
        bButton.setBounds(450, 200, 150, 150);
        bButton.setFont(InjeFont.XLfont);

        RoundedButton cButton = new RoundedButton("C동");
        cButton.setBounds(700, 200, 150, 150);
        cButton.setFont(InjeFont.XLfont);

        add(cButton);
        add(bButton);
        add(aButton);
        add(title);


        aButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nowMode = mainFrame.getMode();
                if (nowMode.indexOf("예약") != -1) {
                    mainFrame.setCenterPanel(mainFrame.reservation);
                    return;
                }
                mainFrame.setCenterPanel(mainFrame.class_openCloseA);
            }
        });

        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nowMode = mainFrame.getMode();
                if (nowMode.indexOf("예약") != -1) {
                    mainFrame.setCenterPanel(mainFrame.reservation);
                    return;
                }
                mainFrame.setCenterPanel(mainFrame.class_openCloseA);
            }
        });

        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nowMode = mainFrame.getMode();
                if (nowMode.indexOf("예약") != -1) {
                    mainFrame.setCenterPanel(mainFrame.reservation);
                    return;
                }
                mainFrame.setCenterPanel(mainFrame.class_openCloseA);
            }
        });

        setVisible(true);
    }
}