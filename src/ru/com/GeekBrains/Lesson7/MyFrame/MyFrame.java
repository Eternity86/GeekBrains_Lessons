package ru.com.GeekBrains.Lesson7.WinApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MyFrame extends JFrame {
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JButton btn;
    private MyHandler hnd;

    public MyFrame(String title) {
        super(title);
        setBounds(250, 250, 350, 250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        lbl1 = new JLabel("Фамилия: ");
        lbl1.setBounds(10, 10, 230, 50);
        add(lbl1);
        lbl2 = new JLabel("Имя: ");
        lbl2.setBounds(10, 50, 230, 50);
        add(lbl2);
        lbl3 = new JLabel("Отчество: ");
        lbl3.setBounds(10, 90, 230, 50);
        add(lbl3);
        btn = new JButton("Закрыть окно");
        btn.setBounds(50, 170, 120, 30);
        hnd = new MyHandler();
        btn.addActionListener(hnd);
        add(btn);
        //lbl3.setText("Изменили текст");
        setVisible(true);
    }
}

class MyHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog inFrame = new JDialog();
        inFrame.setModal(true);
        inFrame.setTitle("Модальное окно");
        inFrame.setBounds(300, 300, 350, 250);
        inFrame.setResizable(false);
        inFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        inFrame.setLayout(null);
        JTextField txtField = new JTextField();
        inFrame.add(txtField);
        inFrame.setVisible(true);
        System.out.println("Button pressed...");
    }
}

class SimpleWindow {
    public static void main(String[] args) {
        new MyFrame("Обычное окно");
    }
}
