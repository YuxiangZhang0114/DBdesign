package com.upc.yuxiang.gui;

import sun.misc.JavaLangAccess;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JLabelDemo extends JFrame{
    public JLabelDemo(){
        setBounds(100,100,100,100);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        setVisible(true);
        JLabel l = new JLabel();
        Icon icon = new ImageIcon();
        URL url =JLabel.class.getResource("");
        l.setIcon(icon);

        c.add(l);


    }

    public static void main(String[] args) {
        new JLabelDemo();

    }
}
