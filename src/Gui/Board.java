package Gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board {

    public static void addValueToButtons(String plansza, ArrayList<JButton> listaGuzikow) {
        for (int i = 0; i < plansza.length(); i++) {
            if (plansza.toCharArray()[i] == '0') {
                listaGuzikow.get(i).setBackground(Color.WHITE);
            } else {
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
            JOptionPane.showMessageDialog(tymczasowe,"Gratulacje");
        }else{
            JOptionPane.showMessageDialog(tymczasowe,"Próbuj dalej");
        }
    }
}
