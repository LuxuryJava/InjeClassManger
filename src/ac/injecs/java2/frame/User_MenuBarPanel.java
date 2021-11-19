package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.constant.FrameConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class User_MenuBarPanel extends JPanel {
    private Main mainFrame;
    private int menuBarWidth = FrameConstant.MENUWIDTH.getValue();

    public User_MenuBarPanel(Main main) {
        this.mainFrame = main;
        setLayout(null);
        setBounds(0, 0, menuBarWidth, FrameConstant.HEIGHT.getValue());
        setBackground(Color.GRAY);

        // add
        MenuBarTopLabel menuBarTopLabel = new MenuBarTopLabel();
        MenuBarButtons menuBarButtons = new MenuBarButtons();
        MenuBarUser menuBarUser = new MenuBarUser();

        menuBarTopLabel.setBounds(0, 0, menuBarWidth, 100);
        menuBarButtons.setBounds(0, 100, menuBarWidth, 400);
        menuBarUser.setBounds(0, 500, menuBarWidth, 60);

        add(menuBarTopLabel);

        add(menuBarButtons);

        add(menuBarUser);

        setVisible(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("메뉴바 : " + e.getX() + ", " + e.getY());
            }
        });
    }

    public class MenuBarTopLabel extends JPanel {
        public MenuBarTopLabel() {
            setLayout(null);
            JLabel notice = new JLabel("인제 클래스 매니저");
            JLabel name;
            String userName = mainFrame.session.user.getName();
            if(mainFrame.session.isLogin)
                name = new JLabel("어서오세요. " + userName +"님");
            else
                name = new JLabel("어서오세요.");

            notice.setBounds(20, 20, 200, 30);
            name.setBounds(20, 60, 200, 30);

            add(notice);
            add(name);

            setVisible(true);
        }
    }

    public class MenuBarButtons extends JPanel {
        public MenuBarButtons() {
            setLayout(new GridLayout(5, 1, 40, 10));

            JButton dashboardButton = new JButton("대시보드");
            JButton classReservationButton = new JButton("강의실 예약");
            JButton classCheckButton = new JButton("강의실 조회");
            JButton classStateButton = new JButton("강의실 개방");
            JButton lectureButton = new JButton("특강");

            add(dashboardButton);
            add(classReservationButton);
            add(classCheckButton);
            add(classStateButton);
            add(lectureButton);

            dashboardButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.dashBoardPanel);
                    mainFrame.setMode("대시보드");
                }
            });
            classReservationButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.selectDongPanel);
                    mainFrame.selectDongPanel.title.setText("강의실 예약");

                    mainFrame.setMode("예약");
                }
            });
            classCheckButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.checkClass_day);
                    mainFrame.setMode("조희");
                }
            });
            classStateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.selectDongPanel);
                    mainFrame.selectDongPanel.title.setText("강의실 개방");
                    mainFrame.setMode("개방");
                }
            });
            lectureButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.lecture_list);
                    mainFrame.setMode("특강");
                }
            });

            setVisible(true);
        }
    }

    public class MenuBarUser extends JPanel {
        public MenuBarUser() {
            setLayout(new FlowLayout());

//            JButton accountButton = new JButton("계정");
            JButton signButton = new JButton("회원가입");
            JButton loginButton = new JButton("로그인");
            JButton accountButton = new JButton("계정");

//            add(accountButton);
            add(loginButton);
            add(signButton);
            add(accountButton);

            signButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.signPanel);
                }
            });
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.loginPanel);
                }
            });

            setVisible(true);
        }
    }

}
