package com.upc.yuxiang.gui;

import com.upc.yuxiang.config.SqlServerHelper;
import com.upc.yuxiang.dao.DeleteDao;
import com.upc.yuxiang.dao.InsertDao;
import com.upc.yuxiang.dao.QueryDao;

import javax.swing.*;
import javax.swing.plaf.SliderUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class CommoditiesList extends JFrame {


    class Row{
        String cid;
        String cname;
        String dname;

    }
    Vector<Row> data;

    Vector<Row> getData() throws SQLException {
        Vector<Row> v = new Vector<Row>();
        String sql = QueryDao.getQueryCommoditiesWithDomain();

        ResultSet rs = SqlServerHelper.st.executeQuery(sql);

        while(rs.next()){
            Row tmp = new Row();
            tmp.cid = rs.getString("cid");
            tmp.cname = rs.getString("cname");
            tmp.dname =rs.getString("dname");
            v.add(tmp);
        }



        return v;
    }
    public CommoditiesList(Point loaction, Dimension dim, final String username) throws SQLException {
        setLayout(null);
        setTitle("商店进销存管理系统");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        String[] columnNames =
                { "商品编号", "商品名称", "商品类别" };
        final Vector<Row> data = getData();
        final String[][] dataArray = new String[data.size()][3];

        for(int i=0;i<data.size();i++){
            dataArray[i][0] = data.get(i).cid;
            dataArray[i][1] = data.get(i).cname;
            dataArray[i][2] = data.get(i).dname;
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


        JButton btn_querytCommodity = new JButton("查询");
        btn_querytCommodity.setBounds(30,120,100,30);
        c.add(btn_querytCommodity);

        JButton btn_insertCommodity = new JButton("插入");
        btn_insertCommodity.setBounds(150,120,100,30);
        c.add(btn_insertCommodity);

        JButton btn_deleteCommodity = new JButton("删除");
        btn_deleteCommodity.setBounds(270,120,100,30);
        c.add(btn_deleteCommodity);

        //end 按钮
        c.add(jscrollpane);


        //label
        JLabel label_cname = new JLabel("商品名称");
        JLabel label_domain = new JLabel("领域编号");

        label_cname.setBounds(80,50,150,32);
        label_domain.setBounds(250,50,150,32);

        c.add(label_cname);
        c.add(label_domain);
        //end label


        //Textfield


        final JTextField textField_cname = new JTextField();
        final JTextField textField_domain = new JTextField();

        textField_cname.setBounds(30,80,150,38);
        textField_domain.setBounds(200,80,150,38);



        c.add(textField_cname);
        c.add(textField_domain);


        //


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

        btn_querytCommodity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        btn_insertCommodity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql = InsertDao.getInertCommodities(textField_cname.getText(),Integer.parseInt(textField_domain.getText()));
                try {
                    System.out.println(sql);
                    SqlServerHelper.st.execute(sql);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btn_deleteCommodity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql = DeleteDao.deleteCommodity(textField_cname.getText());
                try {
                    SqlServerHelper.st.execute(sql);
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