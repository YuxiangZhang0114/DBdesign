package com.upc.yuxiang.gui;

import com.upc.yuxiang.config.SqlServerHelper;
import com.upc.yuxiang.dao.QueryDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class OperationsList extends JFrame {


    class Row{
        String onum;
        String otype;
        String cid;
        String cname;
        String dname;
        String wname;
        String date;
        String pname;
    }
    Vector<Row> data;

    Vector<Row> getData() throws SQLException {
        Vector<Row> v = new Vector<Row>();
        String sql = QueryDao.getQueryRecords();

        ResultSet rs = SqlServerHelper.st.executeQuery(sql);

        while(rs.next()){
            Row tmp = new Row();
            tmp.onum = rs.getString("onum");
            tmp.cid = rs.getString("cid");
            tmp.cname = rs.getString("cname");
            tmp.dname =rs.getString("dname");
            String otype = rs.getString("OType");
            if(otype.equals("in")){
                tmp.otype = "入库";
            }else if(otype.equals("out")){
                tmp.otype = "出库";
            }else if(otype.equals("selled")){
                tmp.otype = "售出";
            }else {
                tmp.otype = "其他";
            }
            tmp.dname = rs.getString("Dname");
            tmp.wname = rs.getString("Wname");
            tmp.pname = rs.getString("Pname");
            tmp.date = rs.getDate("Date").toString();//TODO
            v.add(tmp);
        }



        return v;
    }
    public OperationsList(Point loaction, Dimension dim, final String username) throws SQLException {
        setLayout(null);
        setTitle("商店进销存管理系统");

//        String otype;
//        String cid;
//        String cname;
//        String dname;
//        String wname;
//        String date;
//        String pname;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        String[] columnNames =
                { "操作类型","商品编号", "商品名","数量","仓库名","时间","操作人" };
        Vector<Row> data = getData();
        String[][] dataArray = new String[data.size()][7];

        for(int i=0;i<data.size();i++){
            dataArray[i][0] = data.get(i).otype;
            dataArray[i][1] = data.get(i).cid;
            dataArray[i][2] = data.get(i).cname;
            dataArray[i][3] = data.get(i).onum;
            dataArray[i][4] = data.get(i).wname;
            dataArray[i][5] = data.get(i).date;
            dataArray[i][6] = data.get(i).pname;
        }


        setLocation(loaction);
        setSize(dim);
//        setBounds(450,300,800,600);
        JTable table_commodities = new JTable(dataArray,columnNames);
//        FitTableColumns(table_commodities);
        JScrollPane jscrollpane = new JScrollPane(table_commodities);

        jscrollpane.setViewportView(table_commodities);

        jscrollpane.setBounds(40,150,720,400);

        table_commodities.setGridColor(Color.gray);
        table_commodities.setRowHeight(26);
        Container c = getContentPane();

        //按钮

        JButton btn_queryCommodities = new JButton("查询商品");
        btn_queryCommodities.setBounds(30,20,100,30);
        c.add(btn_queryCommodities);

        JButton btn_queryWarehouse = new JButton("查询仓库");
        btn_queryWarehouse.setBounds(150,20,100,30);
        c.add(btn_queryWarehouse);

        JButton btn_queryDomains = new JButton("商品种类");
        btn_queryDomains.setBounds(270,20,100,30);
        c.add(btn_queryDomains);

        JButton btn_queryrecord = new JButton("查询记录");
        btn_queryrecord.setBounds(390,20,100,30);
        c.add(btn_queryrecord);



        //end 按钮
        c.add(jscrollpane);


        //监听器

        btn_queryCommodities.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new CommoditiesList(getLocation(),getSize(),username);
                    setVisible(false);
//                    dispose();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btn_queryWarehouse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new WarehouseList(getLocation(),getSize(),username);
                    setVisible(false);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });


        btn_queryDomains.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new DomainsList(getLocation(),getSize(),username);
                    setVisible(false);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        btn_queryrecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new OperationsList(getLocation(),getSize(),username);
                    setVisible(false);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });



        //end 监听器
        setVisible(true);
    }
    public static void main(String[] args) throws SQLException {
//        new CommoditiesList();
    }
}