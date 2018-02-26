package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guigang {
    public guigang() {
        Calculator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tal1 = Integer.parseInt(input1.getText());
                int tal2 = Integer.parseInt(input2.getText());
                answer.setText (""+(tal1+tal2));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("guigang");
        frame.setContentPane(new guigang().calc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(new Dimension(648,480));
        frame.setVisible(true);
    }

    private JPanel calc;
    private JTextField input1;
    private JTextField input2;
    private JButton Calculator;
    private JLabel answer;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
