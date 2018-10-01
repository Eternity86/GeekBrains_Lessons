package ru.com.GeekBrains.Lesson8;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartNewGameWindow extends JDialog {

    private final GameWindow gameWindow;
    private static final int WIN_HEIGHT = 230;
    private static final int WIN_WIDTH = 350;
    private static final int MIN_WIN_LEN = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_WIN_LEN = 10;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String STR_WIN_LEN = "Победная серия: ";
    private static final String STR_FILED_SIZE = "Размер поля: ";

    private JRadioButton jrbHumVsAi = new JRadioButton("Игрок против ИИ", true);
    private JRadioButton jrbHumVsHum = new JRadioButton("Игрок против Игрока");
    private ButtonGroup gameMode = new ButtonGroup();

    private JSlider slFieldSize;
    private JSlider slWinLenght;


    public StartNewGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setModal(true);
        setTitle("Настройки новой игры!");
        setSize(WIN_WIDTH, WIN_HEIGHT);

        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) (gameWindowBounds.getCenterX() - WIN_WIDTH / 2);
        int posY = (int) (gameWindowBounds.getCenterY() - WIN_HEIGHT / 2);

        setLocation(posX, posY);
        setLayout(new GridLayout(10,1));

        addGameControlsMode();
        addGameControlsFieldWinLen();

        JButton btnStartGame = new JButton("Начать игру!");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartGame();
            }
        });
        add(btnStartGame);

    }

    private void btnStartGame() {
        int gameMode;
        if(jrbHumVsAi.isSelected()) {
            gameMode = Map.MODE_H_V_A;
        } else {
            gameMode = Map.MODE_H_V_H;
        }

        int fieldSize = slFieldSize.getValue();
        int winLen = slWinLenght.getValue();
        gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLen);
        setVisible(false);
    }

    private void addGameControlsMode() {
        add(new JLabel("Выбрать игровой режим"));
        gameMode.add(jrbHumVsAi);
        gameMode.add(jrbHumVsHum);
        add(jrbHumVsAi);
        add(jrbHumVsHum);
    }

    private void addGameControlsFieldWinLen() {
        add(new JLabel("Выбрать размер поля"));
        final JLabel lblFieldSize = new JLabel(STR_FILED_SIZE + MIN_FIELD_SIZE);
        add(lblFieldSize);

        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_WIN_LEN);
        slFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentFieldSize = slFieldSize.getValue();
                lblFieldSize.setText(STR_FILED_SIZE + currentFieldSize);
                slWinLenght.setMaximum(currentFieldSize);
            }
        });
        add(slFieldSize);

        add(new JLabel("Длина победной серии: "));
        final JLabel lblWinLen = new JLabel(STR_WIN_LEN + MIN_WIN_LEN);
        add(lblWinLen);

        slWinLenght = new JSlider(MIN_WIN_LEN, slFieldSize.getValue(), MIN_WIN_LEN);
        slWinLenght.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblWinLen.setText(STR_WIN_LEN + slWinLenght.getValue());
            }
        });
        add(slWinLenght);
    }
}
