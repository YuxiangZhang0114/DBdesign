package com.upc.yuxiang.gui;

import com.upc.yuxiang.config.SqlServerHelper;
import com.upc.yuxiang.dao.QueryDao;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class InventoryGui extends JFrame {


    class Row1 {
        String cname;
        String wname;
        String num;

    }
    class Row2{
        String cname;
        String num;
    }

    Vector<Row1> getData1() throws SQLException {
        Vector<Row1> v = new Vector<Row1>();
        String sql = QueryDao.getQuertInventory();

        ResultSet rs = SqlServerHelper.st.executeQuery(sql);

        while(rs.next()){
            Row1 tmp = new Row1();
            tmp.cname = rs.getString("Cname");
            tmp.wname = rs.getString("Wname");
            tmp.num = rs.getString("Cnum");
            v.add(tmp);
        }

        return v;
    }

    Vector<Row2> getData2() throws SQLException {
        Vector<Row2> v = new Vector<Row2>();
        String sql = QueryDao.getQuertAllInventory();

        ResultSet rs = SqlServerHelper.st.executeQuery(sql);

        while(rs.next()){
            Row2 tmp = new Row2();
            tmp.cname = rs.getString("Cname");
            tmp.num = rs.getString("Cnum");
            v.add(tmp);
        }

        return v;
    }

    public InventoryGui(Point loaction, Dimension dim, final String username) throws SQLException {
        setLayout(null);
        setTitle("查询库存");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        String[] columnNames =
                {"商品名称","所处仓库","储存数量" };
        Vector<Row1> data = getData1();
        String[][] dataArray = new String[data.size()][3];

        for(int i=0;i<data.size();i++){
            dataArray[i][0] = data.get(i).cname;
            dataArray[i][1] = data.get(i).wname;
            dataArray[i][2] = data.get(i).num;
        }


        setLocation(loaction);
        setSize(dim);
//        setBounds(450,300,800,600);
        JTable table_inventort = new JTable(dataArray,columnNames);
//        FitTableColumns(table_commodities);
        JScrollPane jscrollpane = new JScrollPane(table_inventort);

        jscrollpane.setViewportView(table_inventort);

        jscrollpane.setBounds(160,15,300,260);

        table_inventort.setGridColor(Color.gray);
        table_inventort.setRowHeight(26);
        Container c = getContentPane();
        c.add(jscrollpane);




        //table 2

        String[] columnNames2 =
                {"商品名称","储存总量" };
        Vector<Row2> data2 = getData2();
        String[][] dataArray2 = new String[data2.size()][2];

        for(int i=0;i<data2.size();i++){
            dataArray2[i][0] = data2.get(i).cname;

            dataArray2[i][1] = data2.get(i).num;
        }

        JTable table_total_inv = new JTable(dataArray2,columnNames2);
        JScrollPane jscrollpane2 = new JScrollPane(table_total_inv);

        jscrollpane2.setViewportView(table_total_inv);

        jscrollpane2.setBounds(480,15,300,260);

        table_total_inv.setGridColor(Color.gray);
        table_total_inv.setRowHeight(26);

        c.add(jscrollpane2);

        JButton btn_refresh = new JButton("刷新");
        btn_refresh.setBounds(20,50,100,40);
        c.add(btn_refresh);

        btn_refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new InventoryGui(getLocation(),getSize(),username);
                    setVisible(false);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });



        setVisible(true);
    }
    public static void main(String[] args) throws SQLException {
//        new CommoditiesList();
    }
}