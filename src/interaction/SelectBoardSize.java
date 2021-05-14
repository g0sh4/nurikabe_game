package interaction;

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
    JPanel panel = new JPanel();

    public SelectBoardSize(){

        cb1.addActionListener(this::actionPerformed);
        cb2.addActionListener(this::actionPerformed);
        startGame.addActionListener(this::actionPerformed);
        panel.setLayout(new GridLayout( 5,1 ,9,9));
        panel.add(wybierzPoziom);
        panel.add(cb1);
        panel.add(wybierzPlansze);
        panel.add(cb2);
        panel.add(startGame);
        panel.setBorder(BorderFactory.createEmptyBorder(10,100,10,100));
        add(panel);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == startGame){
            String ktoryBoard = (String) cb1.getSelectedItem();
            String ktoraPlansza = (String) cb2.getSelectedItem();


            setVisible(false);
        }
        
    }
}
