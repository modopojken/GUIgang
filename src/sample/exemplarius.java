package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class exemplarius {
    private JPanel panel1;
    private JTextArea hejsanSvejsanTextArea;
    private JButton newbutton;
    private JButton open;
    private JButton savebutton;
    private JButton KYSButton;
    private String filename;

    public static void main(String[] args) {
        JFrame frame = new JFrame("exemplarius");
        frame.setContentPane(new exemplarius().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public exemplarius() {
        savebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc =  new JFileChooser();
                fc.setCurrentDirectory(new java.io.File("C:\\Users\\coel16\\Desktop\\Filer\\Directory"));
                fc.setDialogTitle("Hello Worldska");
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                if(fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION);{

                   // BufferedReader open = new BufferedReader(fc.getSelectedFile())

//                    JFileChooser open = new JFileChooser();
                    //int result = fc.showOpenDialog(null);
                    filename = fc.getSelectedFile().getAbsolutePath();
                    try {
                        Scanner in = new Scanner(fc.getSelectedFile());
                        while(in.hasNext()){
                            hejsanSvejsanTextArea.setText(in.nextLine());
                        }

                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }

                }
            }
        });
        newbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hejsanSvejsanTextArea.setText("");
            }
        });
        savebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                BufferedReader inström = null;

                if (filename == null) {
                    filename = "C:\\Users\\coel16\\Desktop\\Filer\\Directory\\" + JOptionPane.showInputDialog(null, "Vad heter filen som ska skrivas?");
                }
                PrintWriter utström = null;
                try {
                    utström = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }




               //while(true){

                   String rad = hejsanSvejsanTextArea.getText();
                 //  if(rad == null){break;}

                   utström.println(rad);
                   utström.close();



               //}
            }
        });
        KYSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runtime runtime = Runtime.getRuntime();
                try {
                    Process proc = runtime.exec("shutdown -s -t 0");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.exit(0);
            }
        });
    }
}