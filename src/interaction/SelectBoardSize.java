package interaction;

import Gui.Board4_4;
import Gui.Board5_5;
import Gui.Board7_7;
import com.opencsv.exceptions.CsvException;
import csv.OpenCsvData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class SelectBoardSize extends Gui.Gui {
    OpenCsvData openCsvData;
    {
        try {
            if (Settings.getPath() == ""){
                openCsvData = new OpenCsvData("csv_files/boards.csv");
                System.out.printf("jol");
            }
            else {
                openCsvData = new OpenCsvData(Settings.path + "/boards.csv");
                System.out.printf("elo");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }
    }

    String[] wybor = {"Easy","Medium","Hard"};
    public JComboBox cb1 = new JComboBox(wybor);


    public JComboBox cb2 = new JComboBox(openCsvData.getBoardNames().get(0));


    public JLabel wybierzPoziom = new JLabel("Wybierz poziom");
    public JLabel wybierzPlansze = new JLabel("Wybierz plansze");


    public JButton startGame = new JButton("Start game");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    public SelectBoardSize(){
        setTitle("Wybór planszy");
        cb1.addActionListener(this::actionPerformed);
        cb2.addActionListener(this::actionPerformed);
        startGame.addActionListener(this::actionPerformed);
        ImageIcon icon = new ImageIcon( "control.png" );

        JLabel label = new JLabel(  );
        label.setIcon(icon);
        panel1.setLayout(new GridLayout( 3,1 ,9,9));
        panel2.setLayout(new GridLayout( 2,1 ,9,9));

        panel1.add(wybierzPoziom);
        panel1.add(cb1);
        panel2.add(wybierzPlansze);

        panel2.add(cb2);
        panel3.add(startGame);
        panel1.setBorder(BorderFactory.createEmptyBorder(10,100,10,100));
        panel2.setBorder(BorderFactory.createEmptyBorder(10,100,10,100));
        panel3.setBorder(BorderFactory.createEmptyBorder(10,100,10,100));

        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);
        pack();
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == startGame){
            String ktoryBoard = (String) cb1.getSelectedItem();
            String ktoraPlansza = (String) cb2.getSelectedItem();
            int sth;
            if(ktoryBoard.equals("Easy")){
                sth=0;
            }else if(ktoryBoard.equals("Medium")){
                sth=1;
            }else{
                sth=2;
            }

            String plansza;

            if (openCsvData.getBoardSaved(ktoraPlansza, sth) == ""){
                plansza = openCsvData.getBoardDescription(ktoraPlansza, sth);
            }
            else {
                plansza = openCsvData.getBoardSaved(ktoraPlansza, sth);
            }

            String odpowiedz = openCsvData.getBoardSolution(ktoraPlansza, sth);
            if(ktoryBoard.equals("Easy")){
                new Board4_4(plansza,odpowiedz);
            }else if(ktoryBoard.equals("Medium")){
                new Board5_5(plansza,odpowiedz);
            }
            else if(ktoryBoard.equals("Hard")){
                new Board7_7(plansza, odpowiedz);
            }

            setVisible(false);
        } // DO ZMIANY !!!!!!!!!!!!!
        /*
        if(cb1.getSelectedItem() == "Easy"){
            cb2.removeAllItems();

            for (int i = 0; i < openCsvData.getBoardNames().get(0).length ; i++) { cb2.addItem(openCsvData.getBoardNames().get(0)[i]); }
        }if(cb1.getSelectedItem() == "Medium"){
            cb2.removeAllItems();

            for (int i = 0; i < openCsvData.getBoardNames().get(1).length ; i++) { cb2.addItem(openCsvData.getBoardNames().get(1)[i]); }
        }if(cb1.getSelectedItem() == "Hard"){
            cb2.removeAllItems();

            //for (int i = 0; i < openCsvData.getBoardNames().get(2).length ; i++) { cb2.addItem(openCsvData.getBoardNames().get(2)[i]); }
        }

         */


        
    }
}
