package com.upc.yuxiang.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ManageGui extends JFrame {

    ManageGui(final String username){
        setBounds(440,320,800,600);
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

        JButton btn_sell = new JButton("销 售");
        btn_sell.setBounds(550,20,130,45);
        c.add(btn_sell);

        JButton btn_in = new JButton("入 库");
        btn_in.setBounds(550,70,130,45);
        c.add(btn_in);

        JButton btn_inventory = new JButton("库存情况");
        btn_inventory.setBounds(385,70,110,40);
        c.add(btn_inventory);




        //label

        JLabel label_username1 = new JLabel("当前用户：");
        label_username1.setBounds(690,20,90,35);
        c.add(label_username1);

        JLabel label_username2 = new JLabel(username);
        label_username2.setBounds(700,60,90,35);

        c.add(label_username2);
        //end label



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

        btn_sell.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SellUI(new Point(getLocation().x+getWidth()+1,getLocation().y),new Dimension(450,getHeight()),username);

            }
        });

        btn_in.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });



        btn_inventory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new InventoryGui(new Point(getX(),getY()-302),new Dimension(getWidth(),300),username);
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
