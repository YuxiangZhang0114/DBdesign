package com.upc.yuxiang.controller;

import com.upc.yuxiang.config.SqlServerHelper;
import com.upc.yuxiang.dao.InsertDao;
import java.sql.SQLException;

public class DBController {
    /*
    * Insert 操作
    * TODO
    * */
    public static Boolean insertCommodity(String cname, int domainId) throws SQLException {
        SqlServerHelper.st.execute(InsertDao.getInertCommodities(cname, domainId));
        return true;
    }
    public static Boolean insertWarehouse(String Wname) throws SQLException {
        SqlServerHelper.st.execute(InsertDao.getInsertWarehouse(Wname));
        return true;
    }
    public static Boolean insertOutRecord(String OType, int Cid, int Onum,int Wid) throws SQLException {
        SqlServerHelper.st.execute(InsertDao.getInsertOutRecord(OType, Cid, Onum, Wid));
        return true;
    }
    public static Boolean insertinRecord(String OType, int Cid, int Onum,int Wid) throws SQLException {
        SqlServerHelper.st.execute(InsertDao.getInsertInRecord(OType, Cid, Onum, Wid));
        return true;
    }



    /*
    * Query 操作
    *
    * */




}
