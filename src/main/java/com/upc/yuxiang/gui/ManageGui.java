package com.upc.yuxiang.gui;

import javax.swing.*;
import java.awt.*;

public class ManageGui extends JFrame {

    ManageGui(String userName){
        setBounds(500,300,600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("商店进销存管理系统");
        Container c = getContentPane();
        c.setLayout(null);

    }
    public static void main(String[] args) {
        new ManageGui("admin");
    }
}
