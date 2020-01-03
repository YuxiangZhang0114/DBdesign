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

public class DomainsList extends JFrame {


    class Row{
        String did;
        String dname;

    }
    Vector<Row> data;

    Vector<Row> getData() throws SQLException {
        Vector<Row> v = new Vector<Row>();
        String sql = QueryDao.getQueryDomains();

        ResultSet rs = SqlServerHelper.st.executeQuery(sql);

        while(rs.next()){
            Row tmp = new Row();
            tmp.did = rs.getString("Did");
            tmp.dname = rs.getString("Dname");
            v.add(tmp);
        }



        return v;
    }
    public DomainsList(Point loaction, Dimension dim, final String username) throws SQLException {
        setLayout(null);
        setTitle("商店进销存管理系统");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        String[] columnNames =
                { "种类编号", "种类名" };
        Vector<Row> data = getData();
        String[][] dataArray = new String[data.size()][2];

        for(int i=0;i<data.size();i++){
            dataArray[i][0] = data.get(i).did;
            dataArray[i][1] = data.get(i).dname;
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
        btn_queryCommodities.setBounds(20,10,100,30);
        c.add(btn_queryCommodities);

        JButton btn_queryWarehouse = new JButton("查询仓库");
        btn_queryWarehouse.setBounds(140,10,100,30);
        c.add(btn_queryWarehouse);


        JButton btn_queryDomains = new JButton("商品种类");
        btn_queryDomains.setBounds(260,10,100,30);
        c.add(btn_queryDomains);

        JButton btn_queryrecord = new JButton("查询记录");
        btn_queryrecord.setBounds(380,10,100,30);
        c.add(btn_queryrecord);

//
//
//        JButton btn_querytDomain = new JButton("查询");
//        btn_querytDomain.setBounds(30,120,100,30);
//        c.add(btn_querytDomain);

        JButton btn_insertDomain = new JButton("插入");
        btn_insertDomain.setBounds(150,120,100,30);
        c.add(btn_insertDomain);

        JButton btn_deleteDomain = new JButton("删除");
        btn_deleteDomain.setBounds(270,120,100,30);
        c.add(btn_deleteDomain);

        JButton btn_sell = new JButton("销 售");
        btn_sell.setBounds(550,20,130,45);
        c.add(btn_sell);

        JButton btn_in = new JButton("入 库");
        btn_in.setBounds(550,70,130,45);
        c.add(btn_in);

        JButton btn_inventory = new JButton("库存情况");
        btn_inventory.setBounds(385,70,110,40);
        c.add(btn_inventory);

        JButton btn_logout = new JButton("切换登录");
        btn_logout.setBounds(690,100,100,30);
        c.add(btn_logout);



        //end 按钮
        c.add(jscrollpane);


//        label
        JLabel label_wid = new JLabel("领域名称");
        label_wid.setBounds(80,50,150,32);
        c.add(label_wid);


        JLabel label_username1 = new JLabel("当前用户：");
        label_username1.setBounds(690,20,90,35);
        c.add(label_username1);

        JLabel label_username2 = new JLabel(username);
        label_username2.setBounds(700,60,90,35);

        c.add(label_username2);

//        end label
        //textField

        final JTextField textField_dname = new JTextField();
        textField_dname.setBounds(30,80,150,38);
        c.add(textField_dname);

        //endTextfield

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
//        btn_querytDomain.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });

        btn_insertDomain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql = InsertDao.getInsertDomains(textField_dname.getText());
                try {
                    SqlServerHelper.st.execute(sql);
                    JOptionPane.showMessageDialog(null,"插入成功");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btn_deleteDomain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql = DeleteDao.deleteDomain(textField_dname.getText());
                System.out.println(sql);
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

        btn_in.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new InUI(new Point(getLocation().x-449,getLocation().y),new Dimension(450,getHeight()),username);

            }
        });

        btn_inventory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new InventoryGui(new Point(getX(),getY()-302),new Dimension(getWidth(),300),username);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });


        btn_logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login();
                setVisible(false);
            }
        });

        //end 监听器
        setVisible(true);
    }
    public static void main(String[] args) throws SQLException {
//        new CommoditiesList();
    }
}