package com.upc.yuxiang.gui;

import javax.swing.*;

public class ManageGui extends JFrame {

    ManageGui(String userName){
        setBounds(500,300,600,400);


    }
    public static void main(String[] args) {
        new ManageGui("admin");
    }
}
