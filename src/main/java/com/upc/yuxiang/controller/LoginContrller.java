package com.upc.yuxiang.controller;

import com.upc.yuxiang.config.SqlServerHelper;

import com.upc.yuxiang.dao.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginContrller {
    public static boolean checkLogin(String userName, String pwd) throws SQLException {
        String sql = QueryDao.getQueryAdmins(userName);
        ResultSet rs = SqlServerHelper.st.executeQuery(sql);
        boolean ret = false;
        while(rs.next()){
            if(rs.getString("pwd").equals(pwd))
                ret = true;
        }
        return ret;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(checkLogin("admin","admin"));
    }
}
