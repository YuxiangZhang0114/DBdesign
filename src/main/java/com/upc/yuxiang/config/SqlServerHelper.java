package com.upc.yuxiang.config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
        String sql = "insert into managesystem.Commodities values(\'" + "啤酒" + "\', "+"1"+")";
        System.out.println(sql);
        System.out.println(st.execute(sql));
//        SqlServerHelper.st.executeUpdate(sql)

    }
}
