package com.upc.yuxiang.dao;


public class InsertDao {
    public static String getInertCommodities(String cname, int domainId){
        String str  = "insert into managesystem.Commodities values(N'%s', %d)";

        return String.format(str, cname,domainId);
    }
    public static String getInsertWarehouse(String Wname){
        String str = "insert into managesystem.Warehouses values(N'%s')";
        return String.format(str, Wname);
    }
    public static String getInsertOutRecord(String Cid, String Onum,String Pid,String Wid){
        String str = "insert into managesystem.Operations values (N'out',%s,%s,SYSDATETIME(),%s,%s);";
        return String.format(str, Cid, Onum,Pid, Wid);
    }
    public static String getInsertInRecord(String Cid, String Onum,String Pid,String Wid){
        String str = "insert into managesystem.Operations values (N'in',%s,%s,SYSDATETIME(),%s,%s);";
        return String.format(str, Cid, Onum,Pid, Wid);
    }
    public static String getInsertDomains(String Dname){
        String str = "insert into managesystem.Domains values(N'%s')";
        return String.format(str, Dname);
    }


}
