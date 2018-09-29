package ru.com.GeekBrains.Lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {

    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;

    int[][] field;
    int fieldSizeX;
    int fieldSizeY;
    int winLenght;

    int cellHeight;
    int cellWidth;

    boolean isInitialized = false;

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

    void update(MouseEvent e) {
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;
        System.out.println(cellY + " " + cellX);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    void startNewGame(int mode, int filedSizeX, int filedSizeY, int winLen) {
        System.out.println(mode + " " + filedSizeX + " " + winLen);

        this.fieldSizeX = filedSizeX;
        this.fieldSizeY = filedSizeY;
        this.winLenght = winLen;
        field = new int[filedSizeY][filedSizeX];
        isInitialized = true;
        repaint();
    }

    void render(Graphics g) {
        if(!isInitialized) return;

        int panelWidth = getWidth();
        int panelHeight = getHeight();


        cellWidth = panelWidth/fieldSizeY;
        cellHeight = panelHeight/fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x,0,x, panelHeight);
        }

    }

}
