package java11;

import javax.swing.*;
import java.awt.*;

class NorthPanel extends JPanel {
    public NorthPanel(){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout());
        add(new JLabel("수식입력"));
        add(new JTextField(16));
    }
}

class CenterPanel extends JPanel {
    JButton b[] = {new JButton("+"), new JButton("-"), new JButton("x"), new JButton("/")};
    public CenterPanel(){
        setLayout(new GridLayout(4, 4, 2, 2));
        for (int i = 0; i < 10; i++) {
            add(new JButton(Integer.toString(i)));
        }
        add(new JButton("CE"));
        add(new JButton("계산"));

        for(int i=0; i<4; i++){
            b[i].setBackground(Color.CYAN);
            add(b[i]);
        }
    }
}

class SouthPanel extends JPanel {
    public SouthPanel(){
        setBackground(Color.YELLOW);
        setLayout(new FlowLayout());
        add(new JLabel("계산 결과"));
        add(new JTextField(16));
    }
}
public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("계산기 프레임 (2017E7009)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        contentPane.add(new NorthPanel(), BorderLayout.NORTH);
        contentPane.add(new CenterPanel(), BorderLayout.CENTER);
        contentPane.add(new SouthPanel(), BorderLayout.SOUTH);

        setSize(350,300);
        setVisible(true);
    }

    public static void main(String[] args){
        new MyFrame();
    }
}
