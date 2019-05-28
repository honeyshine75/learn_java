import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;

public class Panel1 {
    public static void main(String[] args) {
        Panel1 gui = new Panel1();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("来啊");
        JButton buttonTwo = new JButton("好啊好啊");
        JButton buttonThree = new JButton("我觉得不好");
        panel.add(button);
        panel.add(buttonTwo);
        panel.add(buttonThree);
        panel.setBackground(Color.darkGray);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}