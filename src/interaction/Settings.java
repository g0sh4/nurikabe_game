package interaction;

import Gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class Settings extends Gui {
    public JPanel panel;
    public JPanel panel1;
    public JPanel panel2;
    public JButton wybierzButton;
    public JLabel label2;
    public JLabel label1;
    public JLabel label3;
    public JLabel wybranaSciezka;
    public JLabel wybranaSciezkaLabel;

    public static String path = "";
    JComboBox comboBox;
    public boolean autozapis;

    public Settings(){
        super();
        panel1= new JPanel();
        panel1.setLayout(new GridLayout( 1,1 ));
        ImageIcon icon = new ImageIcon( "png/ustawienia.png" );
        wybranaSciezka = new JLabel();
        label3 = new JLabel();

        label3.setIcon(icon);
        panel1.add(label3);
        panel = new JPanel();
        panel.setLayout(new GridLayout(3,2,9,9));
        label1 = new JLabel( "Wybór ścieżki zapisu: " );
        panel.add(label1);
        wybierzButton = new JButton( "Wybierz ścieżkę" );
        wybierzButton.addActionListener(this::actionPerformed);
        panel.add(wybierzButton);
        comboBox = new JComboBox(  );
        comboBox.setEditable(true);
        comboBox.addItem(" ");
        comboBox.addItem("ON");
        comboBox.addItem("OFF");
        comboBox.addActionListener(this::actionPerformed);

        label2 = new JLabel( "Autozapis: " );
        panel.add(label2);
        panel.add(comboBox);
        panel.setBorder(BorderFactory.createEmptyBorder(10,80,10,100));
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout( 1,2 ));
        panel2.setBorder(BorderFactory.createEmptyBorder(10,80,10,100));
        wybranaSciezkaLabel = new JLabel();
        wybranaSciezkaLabel.setText("Nie wybrano ścieżki do zapisu.");
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
                JOptionPane.showMessageDialog(null, "Wybrana ścieżka do zapisu: "+path);
                wybranaSciezkaLabel.setText("Wybrana ścieżka do zapisu: "+path);
                new SaveFile();
            }catch (Exception exception){
                JOptionPane.showMessageDialog(null, "Nie wybrano ścieżki zapisu !");
            }

        }
        if(comboBox.getSelectedItem()=="ON"){
            autozapis = true;
            JOptionPane.showMessageDialog(null, "Włączono autozapis.");

        }
        if(comboBox.getSelectedItem()=="OFF"){
            autozapis = false;
            JOptionPane.showMessageDialog(null, "Wyłączono autozapis.");
        }
    }

    public static String getPath() {
        return path;
    }
}
