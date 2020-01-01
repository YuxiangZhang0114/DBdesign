package com.upc.yuxiang.gui;

import com.sun.codemodel.internal.fmt.JTextFile;
import com.upc.yuxiang.controller.LoginContrller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class Login extends JFrame {
    public String userName = "";
    private String userPwd = "";
    public Login(){

        setBounds(500,300,450,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("用户登录");
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

        final JTextField textField_name = new JTextField();
        textField_name.setBounds(120,100,160,30);

        final JPasswordField passwordField_pwd = new JPasswordField();
        passwordField_pwd.setBounds(120,140,160,30);

        //用户名密码监听器
        textField_name.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                userName = textField_name.getText();
            }
        });
        passwordField_pwd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                userPwd = passwordField_pwd.getPassword().toString();
            }
        });

        c.add(textField_name);
        c.add(passwordField_pwd);





        btn_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*
                TODO 登录跳转
                 */
                userName = textField_name.getText();
                userPwd = passwordField_pwd.getText();
                try {
                    if (LoginContrller.checkLogin(userName,userPwd)){
                        //JOptionPane.showMessageDialog(null,"登陆成功");
                        new ManageGui(userName);
                    }else{
                        JOptionPane.showMessageDialog(null,"登陆失败");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            }
        });

        btn_cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });



        setVisible(true);




    }

    public static void main(String[] args) {
        new Login();
    }
}
