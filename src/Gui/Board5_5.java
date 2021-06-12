package Gui;

import com.opencsv.exceptions.CsvException;
import csv.OpenCsvData;
import interaction.Print;
import interaction.SelectBoardSize;
import interaction.Settings;

import javax.management.remote.JMXConnectorFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Board5_5 extends Board implements ActionListener {
    JPanel panel = new JPanel();
    JPanel panelZMenuDol = new JPanel();
    JPanel panelZGuzikami= new JPanel();
    JPanel panelzMenuGora = new JPanel();
    JButton help = new JButton("help");
    JButton save = new JButton("save");
    JButton check = new JButton("check");
    JButton print = new JButton("print");
    JButton reset = new JButton("reset");

    public ArrayList<JButton> listaGuzikow = new ArrayList<JButton>();

    String plansza;
    String odpowiedz;
    public static char[] wartosciUzytkownika = new char[25];
    public Board5_5(String plansza,String odpowiedz){
        super();
        this.plansza = plansza;
        this.odpowiedz = odpowiedz;

        for ( int i = 0; i < plansza.length(); i++){
            listaGuzikow.add(new JButton() );
        }
        //ta petla nizej moze do zmiany
        for(int i=0; i < plansza.length(); i++){
            wartosciUzytkownika[i]= plansza.toCharArray()[i];
        }

        panelZMenuDol.setLayout(new GridLayout(1,2));
        panelzMenuGora.setLayout(new GridLayout(1,3));
        panelZGuzikami.setLayout(new GridLayout(5,5));

        Board.addValueToButtons(plansza,listaGuzikow);
        for ( int i = 0; i < plansza.length(); i++){
            listaGuzikow.get(i).addActionListener(this::actionPerformed);
        }
        for ( int i = 0; i < plansza.length(); i++){
            panelZGuzikami.add(listaGuzikow.get(i));
        }

        help.addActionListener(this::actionPerformed);
        save.addActionListener(this::actionPerformed);
        print.addActionListener(this::actionPerformed);
        reset.addActionListener(this::actionPerformed);
        check.addActionListener(this::actionPerformed);


        panelzMenuGora.add(check);panelzMenuGora.add(save);panelzMenuGora.add(help);
        panelZMenuDol.add(reset);panelZMenuDol.add(print);
        panel.setLayout(new BorderLayout());
        panel.add(panelZGuzikami,BorderLayout.CENTER);
        panel.add(panelzMenuGora,BorderLayout.NORTH);
        panel.add(panelZMenuDol,BorderLayout.SOUTH);
        add(panel);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == help){
            Board.help(wartosciUzytkownika,odpowiedz);
        }else if(e.getSource() == check){
            Board.check(wartosciUzytkownika,odpowiedz);
        }else if(e.getSource() == print){
            new Print(panelZGuzikami);
        }else if(e.getSource() == reset){
            Board.reset(wartosciUzytkownika,plansza,listaGuzikow);
        }else if(e.getSource() == save) {
            System.out.println("save");
            if(Settings.path.length()==0){
                JOptionPane.showMessageDialog(null, "Ustaw ścieżkę zapisu w ustawieniach.");
            }
            else{
                try {
                    OpenCsvData openCsvData = new OpenCsvData(Settings.path + "/boards.csv");
                    openCsvData.addUserChanges(SelectBoardSize.getRowInCSV(), stanPlanszy());
                } catch (IOException | CsvException ioException) {
                    ioException.printStackTrace( );
                }

            }
        }

        for(int i=0; i < listaGuzikow.size(); i++){
            if(e.getSource() == listaGuzikow.get(i)){
                Board.change(listaGuzikow,wartosciUzytkownika,i);
                System.out.println("guzik" + i + " "  +wartosciUzytkownika[i]);
                break;
            }
        }
    }
    public static String[] stanPlanszy(){
        return new String[]{String.valueOf(wartosciUzytkownika)};
    }
}
