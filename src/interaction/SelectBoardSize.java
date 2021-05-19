package interaction;

import Gui.Board4_4;
import com.opencsv.exceptions.CsvException;
import csv.OpenCsvData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class SelectBoardSize extends Gui.Gui {
    OpenCsvData openCsvData;
    {
        try {
            openCsvData = new OpenCsvData("src/csv/boards.csv");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }
    }

    String[] wybor = {"Easy","Medium","Hard"};
    public JComboBox cb1 = new JComboBox(wybor);
    public JComboBox cb2 = new JComboBox(openCsvData.getBoardNames());


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
        //startGame.setBackground(new Color(222,184,135));
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
            String plansza = openCsvData.getBoardDescription(ktoraPlansza);
            String odpowiedz = openCsvData.getBoardSolution(ktoraPlansza);
            if(ktoryBoard.equals("Easy")){
                new Board4_4(plansza,odpowiedz);
            }else if(ktoryBoard.equals("Medium")){

            }
            else if(ktoryBoard.equals("Hard")){

            }


            setVisible(false);
        }
        
    }
}
