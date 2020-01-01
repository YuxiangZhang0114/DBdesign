package com.upc.yuxiang.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageGui extends JFrame {

    ManageGui(String userName){
        setBounds(500,300,690,460);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("商店进销存管理系统");
        Container c = getContentPane();
        c.setLayout(null);
        JButton btn_queryCommoditie = new JButton("查询库存");
        btn_queryCommoditie.setBounds(50,50,100,30);

        c.add(btn_queryCommoditie);


        //listeners
        btn_queryCommoditie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CommoditiesList();
            }
        });

        setVisible(true);

    }
    public static void main(String[] args) {
        new ManageGui("admin");
    }
}
