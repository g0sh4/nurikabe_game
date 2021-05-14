package interaction;

import Gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class Settings extends Gui {
    public JPanel panel;
    public JButton wybierzButton;
    public JLabel label;
    public JLabel label2;
    public JLabel label1;

    public String path;
    JComboBox comboBox;
    public boolean autozapis;

    public Settings(){
        super();

        panel = new JPanel();
        panel.setLayout(new GridLayout(3,2,9,9));
        //panel.setBorder(BorderFactory.createEmptyBorder(10,100,10,100));
        label1 = new JLabel( "Wybór ścieżki zapisu: " );
        panel.add(label1);
        wybierzButton = new JButton( "Wybierz ścieżkę do zapisu" );
        wybierzButton.addActionListener(this::actionPerformed);
        panel.add(wybierzButton);

        label = new JLabel( "Dostępne ustawienia: " );
        comboBox = new JComboBox(  );
        comboBox.setEditable(true);
        comboBox.addItem(" ");
        comboBox.addItem("ON");
        comboBox.addItem("OFF");
        comboBox.addActionListener(this::actionPerformed);

        label2 = new JLabel( "Autozapis: " );
        panel.add(label2);
        panel.add(comboBox);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(label, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        pack();
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        String event =  e.getActionCommand();
        if(event.equals("Wybierz ścieżkę do zapisu")){
            JFileChooser choose = new JFileChooser();
            choose.setCurrentDirectory(new File("."));
            choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            choose.showOpenDialog(panel);
            path = choose.getSelectedFile().getPath();
            JOptionPane.showMessageDialog(null, "Wybrano taką ścieżkę zapisu: "+path);
        }
        if(comboBox.getSelectedItem()=="ON"){
            autozapis = true;
            JOptionPane.showMessageDialog(null, "Włączono autozapis.");

        }
        if(comboBox.getSelectedItem()=="OFF"){
            autozapis = false;
            JOptionPane.showMessageDialog(null, "Wyłączono autozapis.");
        }
        if(comboBox.getSelectedItem()==" "){
            JOptionPane.showMessageDialog(null, "Zdecyduj o zapisie, zanim rozpoczniesz grę.");
        }
    }

    public String getPath() {
        return path;
    }



}
