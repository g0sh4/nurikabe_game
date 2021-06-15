package interaction;

import Gui.Board4_4;
import Gui.Board5_5;
import Gui.Board7_7;
import com.opencsv.exceptions.CsvException;
import csv_txt.OpenCsvData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class SelectBoardSize extends Gui.Gui {
    OpenCsvData openCsvData;
    public static String ktoryBoard;
    public static String ktoraPlansza;
    {
        try {
            if (Settings.getPath() == ""){
                openCsvData = new OpenCsvData("csv_txt_files/boards.csv");
            }
            else {
                openCsvData = new OpenCsvData(Settings.path + "/boards.csv");
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
            ktoryBoard = (String) cb1.getSelectedItem();
            ktoraPlansza = (String) cb2.getSelectedItem();
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
        }

        
    }

    public static int getRowInCSV(){
        if(ktoryBoard=="Easy"){
            return Integer.parseInt(ktoraPlansza);
        }
        if(ktoryBoard=="Medium"){
            return Integer.parseInt(ktoraPlansza)+6;
        }
        if(ktoryBoard=="Hard"){
            return  Integer.parseInt(ktoraPlansza)+13;
        }
        return 0;
    }
}
