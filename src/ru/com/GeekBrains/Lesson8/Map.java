package ru.com.GeekBrains.Lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {

    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;
    private final char PLAYER_X = 'X', PLAYER_O = 'O', NOT_SIGN = '*';

    private char[][] gameField;

    private int fieldSizeX;
    private int fieldSizeY;
    private int winLenght;

    private int cellHeight;
    private int cellWidth;

    private boolean isInitialized = false;

    Map() {
        setBackground(Color.ORANGE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isInitialized) {
                    update(e);
                }
            }
        });
    }

    void startNewGame(int mode, int filedSizeX, int filedSizeY, int winLen) {
        System.out.println(mode + " " + filedSizeX + " " + winLen);

        this.fieldSizeX = filedSizeX;
        this.fieldSizeY = filedSizeY;
        this.winLenght = winLen;
        gameField = new char[filedSizeY][filedSizeX];
        isInitialized = true;
        repaint();
    }

    private void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        System.out.println((cellY + 1) + " " + (cellX + 1));
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if(!isInitialized) return;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSizeY;
        cellHeight = panelHeight / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {          // рисуем горизонтальные линии
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int i = 0; i < fieldSizeX; i++) {          // рисуем вертикальные линии
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (gameField[i][j] == (NOT_SIGN)) {
                    if (gameField[i][j] == (PLAYER_X)) {
                        g.setColor(Color.RED);
                        g.drawLine((i * cellWidth) + 10, (j * cellHeight) + 10, (i + 1) * cellWidth - 10, (j + 1) * cellHeight - 10);
                        g.drawLine((i + 1) * cellWidth - 10, (j * cellHeight) + 10, (i * cellWidth) + 10, (j + 1) * cellHeight - 10);
                    }
                    if (gameField[i][j] == (PLAYER_O)) {
                        g.setColor(Color.BLUE);
                        g.drawOval((i * cellWidth) + 10, (j * cellHeight) + 10, cellWidth - 20, cellHeight - 20);
                    }
                }
            }
        }


    }
}
