package interaction;

import Gui.Gui;
import csv_txt.OpenTxtData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class Settings extends Gui {
    public JPanel panel;
    public JPanel panel1;
    public JPanel panel2;
    public JButton wybierzButton;
    public JLabel label1;
    public JLabel label3;
    public JLabel wybranaSciezka;
    public JLabel wybranaSciezkaLabel;

    public static String path = "";

    public Settings(){
        super();
        panel1= new JPanel();
        panel1.setLayout(new GridLayout( 1,1 ));
        ImageIcon icon = new ImageIcon( "png/ustawienia.png" );
        wybranaSciezka = new JLabel();
        label3 = new JLabel();

        label3.setIcon(icon);
        panel1.add(label3);
        panel = new JPanel(new BorderLayout());
        panel.setLayout(new GridLayout(1,2,9,9));
        label1 = new JLabel( "Wybór ścieżki zapisu: " );
        panel.add(label1);
        wybierzButton = new JButton( "Wybierz ścieżkę");
        wybierzButton.addActionListener(this::actionPerformed);
        panel.add(wybierzButton, BorderLayout.CENTER);

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout( 1,2 ));
        panel2.setBorder(BorderFactory.createEmptyBorder(10,80,10,100));
        wybranaSciezkaLabel = new JLabel();
        try {
            OpenTxtData openTxtData = new OpenTxtData();
            if(openTxtData.getPathIfExist()!=null){
                wybranaSciezkaLabel.setText("Wybrana ścieżka zapisu: "+openTxtData.getPathIfExist());
            }else{
                wybranaSciezkaLabel.setText("Nie wybrano ścieżki do zapisu.");
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }



        panel2.add(wybranaSciezkaLabel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(label3, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
        pack();
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        String event =  e.getActionCommand();
        if(event.equals("Wybierz ścieżkę")){
            JFileChooser choose = new JFileChooser();
            choose.setCurrentDirectory(new File("."));
            choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            choose.showOpenDialog(panel);

            try{
                path = choose.getSelectedFile().getPath();
                OpenTxtData otd = new OpenTxtData();
                otd.setPathInFile(path);
                JOptionPane.showMessageDialog(null, "Wybrana ścieżka do zapisu: "+path);
                wybranaSciezkaLabel.setText("Wybrana ścieżka do zapisu: "+path);
                new SaveFile();
            }catch (Exception exception){
                JOptionPane.showMessageDialog(null, "Nie wybrano ścieżki zapisu !");
            }
        }
    }

    public static void setPath(String path) {
        Settings.path = path;
    }

    public static String getPath() {
        return path;
    }
}
