package com.upc.yuxiang.gui;

import com.sun.org.apache.bcel.internal.generic.DSTORE;
import com.upc.yuxiang.config.SqlServerHelper;
import com.upc.yuxiang.dao.InsertDao;
import com.upc.yuxiang.dao.QueryDao;

import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

public class SellUI extends JFrame {
    class Row{
        String cid;
        String wid;
        String onum;
        String pid;
    }
    Vector<Row> data = new Vector<Row>();

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
    SellUI(Point location, Dimension size, final String username){
        setLocation(location);
        setSize(size);
        setLayout(null);

        Container c = getContentPane();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("销售界面");
        final String userid = getUserId(username);

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

        final JTextField textField_cid = new JTextField();
        textField_cid.setBounds(20,50,90,30);
        c.add(textField_cid);

        final JTextField textField_wid = new JTextField();
        textField_wid.setBounds(180,50,90,30);
        c.add(textField_wid);

        final JTextField textField_num = new JTextField();
        textField_num.setBounds(340,50,90,30);
        c.add(textField_num);

        //end textfield

        //button
        JButton btn_add = new JButton("添加");
        btn_add.setBounds(220,100,100,30);
        c.add(btn_add);

        JButton btn_commmit = new JButton("提交");
        btn_commmit.setBounds(330,100,100,30);
        c.add(btn_commmit);


        //TABLE

        String[][] dataArray = new String[1][4];

        for(int i=0;i<data.size();i++){
            dataArray[i][0] = data.get(i).cid;
            dataArray[i][1] = data.get(i).wid;
            dataArray[i][2] = data.get(i).onum;
            dataArray[i][3] = data.get(i).pid;


        }
        String[] columnNames = {"商品编号","仓库编号","操作数量","操作人编号"};
//        setBounds(450,300,800,600);
        final JTable table_selled = new JTable(dataArray,columnNames);
//        FitTableColumns(table_selled);
        JScrollPane jscrollpane = new JScrollPane(table_selled);

        jscrollpane.setViewportView(table_selled);

        jscrollpane.setBounds(30,150,360,400);

        table_selled.setGridColor(Color.gray);
        table_selled.setRowHeight(26);
        c.add(jscrollpane);


        //end table

        btn_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Row t = new Row();
                t.cid = textField_cid.getText();
                t.onum = textField_num.getText();
                t.pid = userid;
                t.wid = textField_wid.getText();
                data.add(t);
                textField_cid.setText("");
                textField_num.setText("");
                textField_wid.setText("");

                String[][] dataArray = new String[data.size()][4];

                for(int i=0;i<data.size();i++){
                    dataArray[i][0] = data.get(i).cid;
                    dataArray[i][1] = data.get(i).wid;
                    dataArray[i][2] = data.get(i).onum;
                    dataArray[i][3] = data.get(i).pid;


                }
                String[] columnNames = {"商品编号","仓库编号","操作数量","操作人编号"};
//        setBounds(450,300,800,600);
                final JTable table_selled = new JTable(dataArray,columnNames);
//        FitTableColumns(table_selled);
                JScrollPane jscrollpane = new JScrollPane(table_selled);

                jscrollpane.setViewportView(table_selled);

                jscrollpane.setBounds(30,150,360,400);

                table_selled.setGridColor(Color.gray);
                table_selled.setRowHeight(26);
                Container c =getContentPane();
                c.add(jscrollpane);

            }
        });
        btn_commmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(int i =0;i<data.size();i++){
                    //tring OType, String Cid, String Onum,String Wid
                    String sql = InsertDao.getInsertOutRecord( data.get(i).cid, data.get(i).onum,data.get(i).pid,data.get(i).wid);
                    System.out.println(sql);
                    boolean t =true;
                    try {
                        SqlServerHelper.st.execute(sql);
                        t = false;
                    } catch (SQLException ex) {
                        ex.printStackTrace();

                    }

                    if(t){
                        return;
                    }
                    new InUI(getLocation(),getSize(),username);

                    setVisible(false);



                }
            }
        });


        setVisible(true);
    }

    public static void main(String[] args) {

    }
}
