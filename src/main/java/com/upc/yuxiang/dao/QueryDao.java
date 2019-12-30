package com.upc.yuxiang.dao;

import com.upc.yuxiang.config.SqlServerHelper;

public class QueryDao {
    public static String getQuerycommodities(){
        String str = "select Cid,Cname from managesysem.commodities";
        return str;
    }
    public static String getQuerycommodities(String Cname){
        String str = "select Cid,Cname from managesysem.commodities where Cname = " + Cname;
        return str;
    }

    public static String getQueryAdmins(){
        String str = "select Cid,Cname from managesystem.Person";
        return str;
    }

    public static String getQueryWarehouses(){
        String str = "select Cid,Cname from managesystem.Warehouses";
        return str;
    }
    public static String getQueryWarehouses(String Wname){
        String str = "select Cid,Cname from managesystem.Warehouses where Wname = " +Wname;
        return str;
    }


}
