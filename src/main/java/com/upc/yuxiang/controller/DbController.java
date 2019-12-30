package com.upc.yuxiang.controller;

import com.upc.yuxiang.config.SqlServerHelper;
import com.upc.yuxiang.dao.Dao;
import java.sql.SQLException;

public class DbController {
    /*
    * Insert 操作
    * TODO
    * */
    public static Boolean insertCommodity(String cname, int domainId) throws SQLException {
        SqlServerHelper.st.execute(Dao.getInertCommodities(cname, domainId));
        return true;
    }
    public static Boolean insertWarehouse(String Wname) throws SQLException {
        SqlServerHelper.st.execute(Dao.getInsertWarehouse(Wname));
        return true;
    }
    public static Boolean insertOutRecord(String OType, int Cid, int Onum,int Wid) throws SQLException {
        SqlServerHelper.st.execute(Dao.getInsertOutRecord(OType, Cid, Onum, Wid));
        return true;
    }
    public static Boolean insertinRecord(String OType, int Cid, int Onum,int Wid) throws SQLException {
        SqlServerHelper.st.execute(Dao.getInsertInRecord(OType, Cid, Onum, Wid));
        return true;
    }
    /*
    * delate 操作
    * TODO 删除商品
    *      删除仓库
    * */


    /*
    * Qurry 操作
    *
    * */

}
