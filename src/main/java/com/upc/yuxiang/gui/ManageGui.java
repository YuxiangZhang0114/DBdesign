package com.upc.yuxiang.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ManageGui extends JFrame {

    ManageGui(final String username){
        setBounds(450,300,800,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("商店进销存管理系统");
        Container c = getContentPane();
        c.setLayout(null);

        //按钮

        JButton btn_queryCommodities = new JButton("查询商品");
        btn_queryCommodities.setBounds(30,20,100,30);
        c.add(btn_queryCommodities);

        JButton btn_queryWarehouse = new JButton("查询仓库");
        btn_queryWarehouse.setBounds(150,20,100,30);
        c.add(btn_queryWarehouse);


        JButton btn_queryDomains = new JButton("商品种类");
        btn_queryDomains.setBounds(270,20,100,30);
        c.add(btn_queryDomains);

        JButton btn_queryrecord = new JButton("查询记录");
        btn_queryrecord.setBounds(390,20,100,30);
        c.add(btn_queryrecord);

        //end 按钮
        //listeners
        btn_queryCommodities.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new CommoditiesList(getLocation(),getSize(),username);
                    setVisible(false);
//                    dispose();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btn_queryWarehouse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new WarehouseList(getLocation(),getSize(),username);
                    setVisible(false);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });


        btn_queryDomains.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new DomainsList(getLocation(),getSize(),username);
                    setVisible(false);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        btn_queryrecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new OperationsList(getLocation(),getSize(),username);
                    setVisible(false);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //end liseners
        setVisible(true);

    }
    public static void main(String[] args) {
        new ManageGui("admin");
    }
}
