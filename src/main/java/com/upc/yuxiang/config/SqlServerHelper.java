package com.upc.yuxiang.config;


import java.sql.*;


import com.sun.tools.corba.se.idl.StringGen;
import com.upc.yuxiang.controller.DBController;
import com.upc.yuxiang.dao.*;

public class SqlServerHelper {
    static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎

    static String serverUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=testdb;";
//    "jdbc:sqlserver://localhost:1433/myDatabase?currentSchema=mySchema"
    static String user = "sa";
    static String pass = "<Abc123456>";
    public static Connection conn;


    static {
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(serverUrl,user,pass);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Statement st;

    static {
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public SqlServerHelper() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {
//        String sql = "insert into managesystem.Commodities values(\'" + "啤酒" + "\', "+"1"+")";
//        String sql = QueryDao.getQuerycommodities();
//        System.out.println(sql);
//        ResultSet rs = st.executeQuery(sql);
//        while(rs.next()){
//            System.out.println(rs.getString("Cname"));
//
//        }
//        DBController.insertCommodity("冰红茶",1);
    }
}
