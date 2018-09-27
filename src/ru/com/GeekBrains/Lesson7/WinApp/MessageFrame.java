package ru.com.GeekBrains.Lesson7.WinApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MessageFrame implements ActionListener {
    private JFrame frame;
    JLabel il;
    JLabel message;
    JButton button;
    MessageFrame(String msg) {
        int width = 300, height = 180;
        ImageIcon img = new ImageIcon("E:/Books/Files/logo.png");
        frame = new JFrame(" Сообщение...");
        frame.setBounds(400, 300, width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        Image icon = frame.getToolkit().getImage("E:/Books/Files/pict.png");
        il = new JLabel(img);
        int w = img.getIconWidth();
        int h = img.getIconHeight();
        il.setBounds(10, 10, w, h);
        message = new JLabel("<html>" + msg.replace("\n", "<br>") + "</html>", JLabel.LEFT);
        message.setBounds(w + 20, 10, width - 30 - w, height / 2 - 10);
        frame.add(il);
        frame.add(message);
        button = new JButton("Прочитано!");
        button.setBounds(width / 4, 3 * height / 5, width / 2, height / 6);
        button.setFocusPainted(false);
        button.addActionListener(this);
        frame.add(button);
        frame.setResizable(false);
        frame.setIconImage(icon);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }
    static void show(String txt) {
        new MessageFrame(txt);
    }
}
