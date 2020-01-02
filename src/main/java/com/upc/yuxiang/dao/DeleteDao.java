package com.upc.yuxiang.dao;

public class DeleteDao {

    /*
     * delate 操作
     *
     * */
    public static String deleteCommodity(String Cname) {
        String str = "delete from managesystem.commodities where Cname = N'%s'";

        return String.format(str, Cname);
    }
    public static String deleteCommodity(int Cid) {
        String str = "delete from managesystem.commodities where Cid = %d";
        return String.format(str, Cid);
    }
    public static String deleteWarehouse(String Wname){
        String str = "delete from managesystem.warehouses where Wname = N'%s'";
        return String.format(str, Wname);
    }

    public static String deleteWarehouse(int Wid){
        String str = "delete from managesystem.warehouses where Wid = %d";
        return String.format(str, Wid);
    }
    public static String deleteDomain(String dname){
        String str = "delete form managesystem.domains where dname = N'%s' ";
        return String.format(str,dname);
    }
;
    public static void main(String[] args) {
        System.out.println(deleteCommodity(1004));

    }
}
