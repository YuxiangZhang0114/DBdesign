package com.upc.yuxiang.dao;

import sun.plugin2.ipc.windows.WindowsNamedPipe;

public class Dao {
    public static String getInertCommodities(String cname, int domainId){
        String str  = "insert into managesystem.Commodities values(\'%s\', %d)";

        return String.format(str, cname,domainId);
    }
    public static String getInsertWarehouse(String Wname){
        String str = "insert into managesystem.Warehouses values(\'%s\')";
        return String.format(str, Wname);
    }
    public static String getInsertOutRecord(String OType, int Cid, int Onum,int Wid){
        String str = "insert into managesystem.Operations values ('out',%d,%d,SYSDATETIME(),%d,%d);";
        return String.format(str, OType, Cid, Onum, Wid);
    }
}
