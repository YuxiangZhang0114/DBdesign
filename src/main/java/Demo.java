import javax.swing.*;
import java.awt.*;

public class Demo extends JFrame{

    public Demo(){
        setTitle("窗体标题");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        f.setSize(600,450);
//        f.setLocation(550,300);
        setBounds(550,300,600,450);
        Container c = getContentPane();
        c.setBackground(Color.WHITE);//background color
        JLabel l = new JLabel("这是一个组件");
        c.add(l);//添加组件
        c.remove(l);//删除组件
        c.validate();//验证容器中的组件 可以用来刷新
//        f.setContentPane(c);//同样可以刷新，不建议


        setResizable(false);//设施是否可以改变大小
        System.out.println("x="+getX());//窗体位置
    }

    public static void main(String[] args) {
        new Demo();
    }
}
