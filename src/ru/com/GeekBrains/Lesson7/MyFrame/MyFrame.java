package ru.com.GeekBrains.Lesson7.MyFrame;

import javax.swing.*;
import java.awt.event.*;

class SimpleWindow extends JFrame {
    private JLabel lblSurname;
    private JLabel lblName;
    private JLabel lblMidname;
    private JLabel lblSurnameText;
    private JLabel lblNameText;
    private JLabel lblMidnameText;
    private JButton btnFillName;
    private JButton btnExit;

    public SimpleWindow(String title) {
        super(title);
        int width = 350, height = 250;
        setBounds(400, 300, width, height);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        lblSurname = new JLabel();
        lblSurname.setText("Фамилия: ");
        lblSurname.setBounds(10, 10, width / 2 - 20, 50);
        add(lblSurname);

        lblName = new JLabel();
        lblName.setText("Имя: ");
        lblName.setBounds(10, 50, width / 2 - 20, 50);
        add(lblName);

        lblMidname = new JLabel();
        lblMidname.setText("Отчество: ");
        lblMidname.setBounds(10, 90, width / 2 - 20, 50);
        add(lblMidname);

        lblSurnameText = new JLabel();
        lblSurnameText.setText("... ");
        lblSurnameText.setBounds(lblSurname.getWidth() + 20, 10, width / 2 - 10, 50);
        add(lblSurnameText);

        lblNameText = new JLabel();
        lblNameText.setText("... ");
        lblNameText.setBounds(lblName.getWidth() + 20   , 50, width / 2 - 10, 50);
        add(lblNameText);

        lblMidnameText = new JLabel();
        lblMidnameText.setText("... ");
        lblMidnameText.setBounds(lblMidname.getWidth() + 20, 90, width / 2 - 10, 50);
        add(lblMidnameText);

        btnFillName = new JButton();
        btnFillName.setText("Заполнить ФИО");
        btnFillName.setBounds(10, height - 80, 150, 30);
        btnFillName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int width = 350, height = 250;
                JDialog innerDialog = new JDialog();
                innerDialog.setModal(true);
                innerDialog.setTitle("Модальное окно");
                innerDialog.setBounds(500, 400, width, height);
                innerDialog.setResizable(false);
                innerDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                innerDialog.setLayout(null);

                JTextField txtSurname = new JTextField();
                txtSurname.setBounds(10, 10, width - 35, 25);
                txtSurname.setText("");
                innerDialog.add(txtSurname);

                JTextField txtName = new JTextField();
                txtName.setBounds(10, txtSurname.getHeight() + 25, width - 35, 25);
                txtName.setText("");
                innerDialog.add(txtName);

                JTextField txtMidname = new JTextField();
                txtMidname.setBounds(10, txtSurname.getHeight() + txtName.getHeight() + 40, width - 35, 25);
                txtMidname.setText("");
                innerDialog.add(txtMidname);

                JButton btnOk = new JButton();
                btnOk.setText("Заполнить ФИО");
                btnOk.setBounds(width / 2 - 85, height - 80, 150, 30);
                btnOk.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (txtSurname.getText().equalsIgnoreCase("") || txtName.getText().equalsIgnoreCase("") || txtMidname.getText().equalsIgnoreCase("")) {
                            innerDialog.setIconImage(innerDialog.getToolkit().getImage("E:\\GeekBrains\\src\\ru\\com\\GeekBrains\\Lesson7\\MyFrame\\attention.png"));
                            innerDialog.setTitle("Заполните все поля!");
                        } else {
                            lblSurnameText.setText(txtSurname.getText());
                            lblNameText.setText(txtName.getText());
                            lblMidnameText.setText(txtMidname.getText());
                            innerDialog.setVisible(false);
                        }

                    }
                });
                innerDialog.add(btnOk);

                innerDialog.setVisible(true);
            }
        });
        add(btnFillName);

        btnExit = new JButton("Выход");
        btnExit.setBounds(btnFillName.getWidth() + 25, height - 80, 150, 30);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(btnExit);

        setVisible(true);
    }
}

public class MyFrame {
    public static void main(String[] args) {
        new SimpleWindow("Главное окно");
    }
}
