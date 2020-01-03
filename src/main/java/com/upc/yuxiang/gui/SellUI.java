package com.upc.yuxiang.gui;

import com.upc.yuxiang.config.SqlServerHelper;
import com.upc.yuxiang.dao.QueryDao;

import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SellUI extends JFrame {
    class Row{
        String cid;
        String wid;
        String onum;
        String pid;
    }
    Vector<Row> data;

    void getData(String cid, String wid, String onum, String pid) throws SQLException {
        Row t= new Row();
        t.cid=cid;
        t.wid=wid;
        t.onum = onum;
        t.pid = pid;
        data.add(t);
    }
    String getUserId(String pname){
        String sql = QueryDao.getQueryAdmins(pname);
        String str = "";
        try {
            System.out.println(sql);
            ResultSet rs = SqlServerHelper.st.executeQuery(sql);
            rs.next();
            str = rs.getString("Pid");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }

    void table(){




    }
    SellUI(Point location, Dimension size, String username){
        setLocation(location);
        setSize(size);
        setLayout(null);

        Container c = getContentPane();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("销售界面");
        String userid = getUserId(username);

        //label
        JLabel label_cid = new JLabel("商品编号");
        label_cid.setBounds(35,20,80,25);
        c.add(label_cid);

        JLabel label_wid = new JLabel("仓库编号");
        label_wid.setBounds(195,20,80,25);
        c.add(label_wid);

        JLabel label_num = new JLabel("售出数量");
        label_num.setBounds(355,20,80,25);
        c.add(label_num);


        //end label

        //textfield

        JTextField textField_cid = new JTextField();
        textField_cid.setBounds(20,50,90,30);
        c.add(textField_cid);

        JTextField textField_wid = new JTextField();
        textField_wid.setBounds(180,50,90,30);
        c.add(textField_wid);

        JTextField textField_num = new JTextField();
        textField_num.setBounds(340,50,90,30);
        c.add(textField_num);

        //end textfield

        //button
        JButton btn_add = new JButton("添加");
        btn_add.setBounds(50,100,100,30);
        c.add(btn_add);

        JButton btn_commmit = new JButton("提交");
        btn_commmit.setBounds(280,100,100,30);
        c.add(btn_commmit);


        //TABLE

//        String[][] dataArray = new String[data.size()][5];
//
//        for(int i=0;i<data.size();i++){
//            dataArray[i][0] = data.get(i).cid;
//            dataArray[i][1] = data.get(i).wid;
//            dataArray[i][2] = data.get(i).onum;
//            dataArray[i][3] = data.get(i).pid;
//
//        }
//        String[] columnNames = {"商品编号","仓库编号","操作数量","操作人编号"};
////        setBounds(450,300,800,600);
//        JTable table_selled = new JTable(dataArray,columnNames);
////        FitTableColumns(table_selled);
//        JScrollPane jscrollpane = new JScrollPane(table_selled);
//
//        jscrollpane.setViewportView(table_selled);
//
//        jscrollpane.setBounds(30,150,3600,400);
//
//        table_selled.setGridColor(Color.gray);
//        table_selled.setRowHeight(26);
//        c.add(table_selled);
        //END TABLE


        setVisible(true);
    }


    public static void main(String[] args) {

    }
}
