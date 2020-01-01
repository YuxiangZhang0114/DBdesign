package com.upc.yuxiang.config;


import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


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
//        String sql = QueryDao.getQuertCommoditiesWithDomain();
//        System.out.println(sql);
//        ResultSet rs = st.executeQuery(sql);
//        ResultSetMetaData rmd = rs.getMetaData();
//        HashMap<String, List<String> > data = new HashMap<String, List<String>>();
//        int count = rmd.getColumnCount();// 得到result有多少列
//
//        String[] columns = new String[count];
//
//        for (int i = 0; i < count; i++) {
//            columns[i] = rmd.getColumnName(i + 1);
//            List<String> t = new List<String>();
//            data.put(columns[i],new List<String>() )  ;
//        }
//        if(rs.next()) {
//
//            for (int i = 0; i < count; i++) {
//
//                data.get(columns[i]).add(rs.getObject(columns[i]));
//
//            }
//        }
//
//        Iterator<String> iterator=data.keySet().iterator();
//        while(iterator.hasNext()){
//            String key=iterator.next();
//            System.out.print(key+"\t");
//            for(Object ob : data.get(key))
//             System.out.print(ob.toString()+"\t");
//
//        }
//
//        DBController.insertCommodity("冰红茶",1);
    }
}
