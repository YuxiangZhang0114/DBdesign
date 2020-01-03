package com.upc.yuxiang.gui;

import com.upc.yuxiang.config.SqlServerHelper;
import com.upc.yuxiang.dao.DeleteDao;
import com.upc.yuxiang.dao.InsertDao;
import com.upc.yuxiang.dao.QueryDao;
import javafx.scene.chart.Axis;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Vector;

public class InventoryGui extends JFrame {


    class Row{
        String cname;
        String wname;
        String num;

    }
    Vector<Row> data;

    Vector<Row> getData() throws SQLException {
        Vector<Row> v = new Vector<Row>();
        String sql = QueryDao.getQuertInventory();

        ResultSet rs = SqlServerHelper.st.executeQuery(sql);

        while(rs.next()){
            Row tmp = new Row();
            tmp.cname = rs.getString("Cname");
            tmp.wname = rs.getString("Wname");
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
        Vector<Row> data = getData();
        String[][] dataArray = new String[data.size()][3];

        for(int i=0;i<data.size();i++){
            dataArray[i][0] = data.get(i).cname;
            dataArray[i][1] = data.get(i).wname;
            dataArray[i][2] = data.get(i).num;
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
        c.add(jscrollpane);



        setVisible(true);
    }
    public static void main(String[] args) throws SQLException {
//        new CommoditiesList();
    }
}