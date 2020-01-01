package com.upc.yuxiang.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CommoditiesList extends JFrame {
    class Row{
        int cid;
        String cname;
        String pname;

    }
    Vector<Row> data;

    Vector<Row> getData(){

    }
    public CommoditiesList(){

        String[] columnNames =
                { "商品编号", "商品名称", "商品类别" };
    }
    public static void main(String[] args) {
        new CommoditiesList();
    }
}