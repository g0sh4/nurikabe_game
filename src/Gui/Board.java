package Gui;

import com.opencsv.exceptions.CsvException;
import csv_txt.OpenCsvData;
import interaction.SelectBoardSize;
import interaction.Settings;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Board extends Gui{

    public static void addValueToButtons(String plansza, ArrayList<JButton> listaGuzikow) {
        for (int i = 0; i < plansza.length(); i++) {
            if (plansza.toCharArray()[i] == '0') {
                listaGuzikow.get(i).setBackground(Color.WHITE);
            }else if (plansza.toCharArray()[i] == 'B'){
                listaGuzikow.get(i).setBackground(Color.BLACK);
            }else if (plansza.toCharArray()[i] == 'G'){
                listaGuzikow.get(i).setBackground(new Color(238,238,238));
            }else {
                listaGuzikow.get(i).setText(String.valueOf(plansza.toCharArray()[i]));
                listaGuzikow.get(i).setEnabled(false);
            }
        }

    }

    public static void change(ArrayList<JButton> listaGuzikow, char[] wartosciUzytkownika, int ktory) {
        listaGuzikow.get(ktory).setBackground(wartosciUzytkownika[ktory] == '0' ? new Color(238,238,238) :
                wartosciUzytkownika[ktory] == 'G' ? Color.BLACK : Color.WHITE);
        if (wartosciUzytkownika[ktory] == '0') {
            wartosciUzytkownika[ktory] = 'G';
        } else if (wartosciUzytkownika[ktory] == 'G') {
            wartosciUzytkownika[ktory] = 'B';
        } else {
            wartosciUzytkownika[ktory] = '0';
        }

    }

    public static void check(char[] wartosciUzytkownika,String odpowiedz){
        String uzytkownik = "";
        for(int i=0; i < wartosciUzytkownika.length; i++){
            uzytkownik += String.valueOf(wartosciUzytkownika[i]);
        }
        JFrame tymczasowe = new JFrame();
        if(odpowiedz.equals(uzytkownik)){
            JOptionPane.showMessageDialog(tymczasowe,"Gratulacje udało ci się rozwiązać plansze!!");
        }else{
            char[] odp = odpowiedz.toCharArray();
            int i=0;
            for(int x =0;x<odp.length;x++){
                if(odp[x]!=wartosciUzytkownika[x]){
                    i++;
                }
            }
            JOptionPane.showMessageDialog(tymczasowe,i+" pól jest niepoprawnie zakolorowane");
        }
    }
    public static void help(char[] wartosciUzytkownika,String odpowiedz) {
        String[] odpowiedz1 = odpowiedz.split("");
        JFrame tymczasowe = new JFrame();
        for(int i=0;i<wartosciUzytkownika.length;i++){
            if (!String.valueOf(wartosciUzytkownika[i]).equals(odpowiedz1[i])) {
                int x=0;
                int y=0;
                if(odpowiedz.length()==16){
                    x=1+(i/4);
                    y=1+(i%4);
                }else  if(odpowiedz.length()==25){
                    x=1+(i/5);
                    y=1+(i%5);
                }else{
                    x=1+(i/7);
                    y=1+(i%7);
                }

                if(odpowiedz1[i].equals("B")){
                    JOptionPane.showMessageDialog(tymczasowe, "Pole koloru CZARNEGO na pozycji\n wiersz: "+String.valueOf(x) +" kolumna: "+ String.valueOf(y));
                }else{
                    JOptionPane.showMessageDialog(tymczasowe, "Pole koloru SZAREGO na pozycji\n wiersz: "+String.valueOf(x) +" kolumna: "+  String.valueOf(y));
                }
                break;
            }
        }
    }
    public static void reset(char[] wartosciUzytkownika,String plansza,ArrayList<JButton> listaGuzikow) {
        plansza =plansza.replaceAll("G","0");
        plansza =plansza.replaceAll("B","0");
        Board.addValueToButtons(plansza,listaGuzikow);
        for(int i=0; i < wartosciUzytkownika.length; i++){
            wartosciUzytkownika[i]= plansza.toCharArray()[i];
        }
    }
    public static void save(char[] wartosciUzytkownika) {
        if(Settings.path.length()==0){
            JOptionPane.showMessageDialog(null, "Ustaw ścieżkę zapisu w ustawieniach.");
        }
        else{
            try {
                OpenCsvData openCsvData = new OpenCsvData(Settings.path + "/boards.csv");
                openCsvData.addUserChanges(SelectBoardSize.getRowInCSV(), stanPlanszy(wartosciUzytkownika));
            } catch (IOException | CsvException ioException) {
                ioException.printStackTrace( );
            }

        }
    }
    public static String[] stanPlanszy(char[] wartosciUzytkownika){
        return new String[]{String.valueOf(wartosciUzytkownika)};
    }
}
