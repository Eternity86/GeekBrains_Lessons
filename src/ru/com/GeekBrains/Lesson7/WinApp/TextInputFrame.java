package ru.com.GeekBrains.Lesson7.WinApp;

import javax.swing.*;
import java.awt.event.*;

class TextInputFrame implements ActionListener, KeyListener {
    private JFrame frame;
    JLabel enter;
    JTextField tf;
    JButton btYes, btNo;
    private String name;

    TextInputFrame(String msg) {
        int width = 300, height = 150;
        frame = new JFrame(" Окно для ввода текста (имени)...");
        frame.setBounds(400, 300, width, height);
        frame.setLayout(null);
        enter = new JLabel(msg, JLabel.LEFT);
        enter.setBounds(10, 10, width - 30, height / 6);
        tf = new JTextField(frame.getWidth() - 20);
        tf.setBounds(10, enter.getHeight() + 5, enter.getWidth() - 5, height / 6);
        tf.addKeyListener(this);
        btYes = new JButton("Подтверждаю");
        btYes.setBounds(10, height / 2 + 10, (width - 30) / 2, height / 6);
        //btYes.setEnabled(false);
        btYes.setFocusPainted(false);
        btNo = new JButton("Завершить");
        btNo.setBounds((width - 30) / 2 + 18, height / 2 + 10, (width - 50) / 2, height / 6);
        btNo.setFocusPainted(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(enter);
        frame.add(tf);
        frame.add(btYes);
        frame.add(btNo);
        frame.setResizable(false);
        btYes.addActionListener(this);
        btNo.addActionListener(this);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String btName = ae.getActionCommand();
        if (btName.equalsIgnoreCase(btYes.getText())) {
            name = tf.getText();
            frame.setVisible(false);
            IntInputFrame.show("Сколько Вам лет? Укажите возраст (лет): ", name);
        } else {
            System.exit(0);
        }

    }

    static void show(String txt) {
        new TextInputFrame(txt);
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        try {
            Integer.parseInt(tf.getText());
            btYes.setEnabled(true);
        } catch (Exception e) {
            btYes.setEnabled(false);
        }
    }
    @Override
    public void keyPressed(KeyEvent ke) {}
    @Override
    public void keyTyped(KeyEvent ke) {}
}

