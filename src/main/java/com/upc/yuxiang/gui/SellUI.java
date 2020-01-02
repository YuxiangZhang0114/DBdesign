package com.upc.yuxiang.gui;

import com.upc.yuxiang.config.SqlServerHelper;
import com.upc.yuxiang.dao.QueryDao;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SellUI extends JFrame {
    String getUserId(String pname){
        String sql = QueryDao.getQueryAdmins(pname);
        String str = "";
        try {
            ResultSet rs = SqlServerHelper.st.executeQuery(sql);
            str = rs.getString("Pid");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }

    SellUI(Point location, Dimension size, String username){
        setLocation(location);
        setSize(size);
        setLayout(null);

        Container c = getContentPane();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("销售界面");
        String userid = getUserId(username);

        //label
        JLabel label_cid = new JLabel("商品编号");
        label_cid.setBounds(20,20,80,25);
        c.add(label_cid);

        JLabel label_wid = new JLabel("仓库编号");
        label_wid.setBounds(150,20,80,25);
        c.add(label_wid);

        JLabel label_num = new JLabel("售出数量");
        label_num.setBounds(280,20,80,25);
        c.add(label_num);
        



        //end label


        setVisible(true);
    }


    public static void main(String[] args) {

    }
}
