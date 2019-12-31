import javax.swing.*;

public class Demo {
    public static void main(String[] args) {
        JFrame f = new JFrame("窗口标题");
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(600,450);
        f.setLocation(550,300);
    }
}
