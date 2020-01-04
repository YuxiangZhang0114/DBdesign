package com.upc.yuxiang.dao;

import com.sun.org.apache.xerces.internal.util.EntityResolverWrapper;
import com.upc.yuxiang.config.SqlServerHelper;

import java.sql.Statement;

public class QueryDao {

    public static String getQuerycommodities(){
        String str = "select Cid,Cname from managesystem.commodities";
        return str;
    }
    public static String getQuerycommodities(String Cname){
        String str = "select Cid,Cname from managesystem.commodities where Cname = '%s' ";
        return String.format(str, Cname);
    }

    public static String getQueryAdmins(String userName){
        String str = "select Pid,Pname,pwd from managesystem.Persons where Pname = N'%s' ";
        return String.format(str, userName);
    }
    public static String getQueryDomains(){
        String str = "select Did, Dname from managesystem.Domains";
        return str;
    }
    public static String getQueryWarehouses(){
        String str = "select Wid,Wname from managesystem.Warehouses";
        return str;
    }
    public static String getQueryWarehouses(String Wname){
        String str = "select Wid,Wname from managesystem.Warehouses where Wname = '%s'" ;
        return String.format(str, Wname);
    }
    public static String getQueryCommoditiesWithDomain(){
        String str = "select x.Cid Cid, x.Cname Cname, y.Dname Dname, x.price price from managesystem.Commodities x, managesystem.Domains y where x.Did = y.Did ";
        return str;
    }

    public static String getQueryRecords(){
        String str = "select o.OType otype, o.Onum onum, p.Pname pname,w.Wname wname,c.cid cid,c.Cname cname,o.Date date,p.Pname pname,d.Dname dname " +
                " from managesystem.Operations o, managesystem.Commodities c,managesystem.Warehouses w, managesystem.Persons p, managesystem.Domains d " +
                " where o.Pid = p.Pid and o.Cid = c.Cid and c.Did =d.Did and o.Wid = w.Wid";
        return str;
    }

    public static String getQuertInventory(){
        String str = "select y.Cname Cname, z.Wname Wname, x.Cnum Cnum from  managesystem.Inventory x, managesystem.Commodities y,managesystem.Warehouses z where x.Cid = y.Cid and x.Wid = z.Wid";
        return str;
    }
    public static String getQuertAllInventory(){
        String str = "select x.Cid Cid, y.Cname Cname, Cnum from managesystem.Total_inv x,managesystem.Commodities y where x.Cid = y.Cid";
        return str;
    }

//    public static
    public static void main(String[] args) {
        System.out.println(getQueryAdmins("admin"));
    }
}
