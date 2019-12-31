package com.upc.yuxiang.gui;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    public Login(){

        setBounds(100,100,450,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        JButton btn_login = new JButton("Login");
        JButton btn_cancel = new JButton("Cancel");

        btn_login.setBounds(300,100,80,30);
        btn_cancel.setBounds(300,140,80,30);
//        btn_cancel.setBounds(10,30,80,30);

        c.add(btn_login);
        c.add(btn_cancel);

        JLabel label_name = new JLabel("用户名：");
        JLabel label_pwd = new JLabel("密  码：");
        label_name.setBounds(30,100,80,30);
        label_pwd.setBounds(30,140,80,30);

        c.add(label_name);
        c.add(label_pwd);

        JTextField textField_name = new JTextField();
        textField_name.setBounds(120,100,160,30);

        JPasswordField passwordField_pwd = new JPasswordField();
        passwordField_pwd.setBounds(120,140,160,30);

        c.add(textField_name);
        c.add(passwordField_pwd);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Login();
    }
}
