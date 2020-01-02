package com.upc.yuxiang.gui;

import com.upc.yuxiang.config.SqlServerHelper;
import com.upc.yuxiang.dao.QueryDao;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InUI extends JFrame {
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
    InUI(Point location ,Dimension size,String username){
        setLocation(location);
        setSize(size);

        String userid = getUserId(username);


        setVisible(true);
    }
}
