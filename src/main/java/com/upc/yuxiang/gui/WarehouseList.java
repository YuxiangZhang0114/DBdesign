package com.upc.yuxiang.gui;

import com.upc.yuxiang.config.SqlServerHelper;
import com.upc.yuxiang.dao.DeleteDao;
import com.upc.yuxiang.dao.InsertDao;
import com.upc.yuxiang.dao.QueryDao;

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

public class WarehouseList extends JFrame {


    class Row{
        String wid;
        String wname;

    }
    Vector<Row> data;

    Vector<Row> getData() throws SQLException {
        Vector<Row> v = new Vector<Row>();
        String sql = QueryDao.getQueryWarehouses();

        ResultSet rs = SqlServerHelper.st.executeQuery(sql);

        while(rs.next()){
            Row tmp = new Row();
            tmp.wid = rs.getString("Wid");
            tmp.wname = rs.getString("Wname");
            v.add(tmp);
        }



        return v;
    }
    public WarehouseList(Point loaction, Dimension dim, final String username) throws SQLException {
        setLayout(null);
        setTitle("商店进销存管理系统");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        String[] columnNames =
                { "仓库编号", "仓库名" };
        Vector<Row> data = getData();
        String[][] dataArray = new String[data.size()][2];

        for(int i=0;i<data.size();i++){
            dataArray[i][0] = data.get(i).wid;
            dataArray[i][1] = data.get(i).wname;
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

        //label

        JLabel label_wname = new JLabel("仓库名称");
        label_wname.setBounds(80,50,150,32);
        c.add(label_wname);

        //end label

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

//        JButton btn_querytWarehouse = new JButton("查询");
//        btn_querytWarehouse.setBounds(30,120,100,30);
//        c.add(btn_querytWarehouse);

        JButton btn_insertWarehouse = new JButton("插入");
        btn_insertWarehouse.setBounds(150,120,100,30);
        c.add(btn_insertWarehouse);

        JButton btn_deleteWarehouse = new JButton("删除");
        btn_deleteWarehouse.setBounds(270,120,100,30);
        c.add(btn_deleteWarehouse);

        JButton btn_sell = new JButton("销 售");
        btn_sell.setBounds(550,20,130,45);
        c.add(btn_sell);

        JButton btn_in = new JButton("入 库");
        btn_in.setBounds(550,70,130,45);
        c.add(btn_in);

        //end 按钮
        c.add(jscrollpane);

        //textField

        final JTextField textField_wname = new JTextField();

        textField_wname.setBounds(30,80,150,38);

        c.add(textField_wname);

        //end textField

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
//
//        btn_querytWarehouse.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });

        btn_insertWarehouse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql = InsertDao.getInsertWarehouse(textField_wname.getText());
                try {
                    System.out.println(sql);
                    SqlServerHelper.st.execute(sql);
                    JOptionPane.showMessageDialog(null,"插入成功");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btn_deleteWarehouse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql = DeleteDao.deleteWarehouse(textField_wname.getText());

                try {
                    SqlServerHelper.st.execute(sql);
                    JOptionPane.showMessageDialog(null,"删除成功");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btn_sell.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SellUI(new Point(getLocation().x+getWidth()+1,getLocation().y),new Dimension(400,getHeight()),username);

            }
        });

        //end 监听器
        setVisible(true);
    }
    public static void main(String[] args) throws SQLException {
//        new CommoditiesList();
    }
}