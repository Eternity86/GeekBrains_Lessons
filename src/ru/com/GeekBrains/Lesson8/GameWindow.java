package ru.com.GeekBrains.Lesson8;

import ru.com.GeekBrains.Lesson8.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    // 1 данные основного окна
    private static final int WIN_HEIGHT = 560;
    private static final int WIN_WIDTH = 510;
    private static final int WIN_POS_X = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - WIN_WIDTH / 2;
    private static final int WIN_POS_Y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - WIN_HEIGHT / 2;

    private static Map gameField;
    private static StartNewGameWindow startNewGameWindow;

    public GameWindow() {
        setTitle("Крестики-Нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WIN_POS_X, WIN_POS_Y, WIN_WIDTH, WIN_HEIGHT);
        setResizable(false);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

        JButton btnNewGame = new JButton("Начать новую игру");
        JButton btnExit = new JButton("Выход");

        startNewGameWindow = new StartNewGameWindow(this);

        bottomPanel.add(btnNewGame);
        bottomPanel.add(btnExit);

        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGameWindow.setVisible(true);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        gameField = new Map();
        add(gameField, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
    }


    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLen) {
        gameField.startNewGame(mode, fieldSizeX, fieldSizeY, winLen);
    }
}