package com.upc.yuxiang.controller;

import com.upc.yuxiang.config.SqlServerHelper;

import com.upc.yuxiang.dao.*;
public class LoginContrller {
    public static boolean login(String userName, String pwd){
        String sql = QueryDao.getQueryAdmins(userName);

        return true;
    }
}
