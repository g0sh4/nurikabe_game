package Gui;

import javax.management.remote.JMXConnectorFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board5_5 extends Gui implements ActionListener {
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
    public char[] wartosciUzytkownika = new char[25];
    public Board5_5(String plansza,String odpowiedz){
        super();
        this.plansza = plansza;
        this.odpowiedz = odpowiedz;

        for ( int i = 0; i < 25; i++){
            listaGuzikow.add(new JButton() );
        }
        //ta petla nizej moze do zmiany
        for(int i=0; i < 25; i++){
            wartosciUzytkownika[i]= plansza.toCharArray()[i];
        }

        panelZMenuDol.setLayout(new GridLayout(1,2));
        panelzMenuGora.setLayout(new GridLayout(1,3));
        panelZGuzikami.setLayout(new GridLayout(5,5));

        addValueToButtons(plansza,listaGuzikow);
        for ( int i = 0; i < 25; i++){
            listaGuzikow.get(i).addActionListener(this::actionPerformed);
        }
        for ( int i = 0; i < 25; i++){
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


    public static void addValueToButtons(String plansza,ArrayList<JButton> listaGuzikow){
        for(int i=0;i<plansza.length();i++){
            if(plansza.toCharArray()[i] == '0'){
                listaGuzikow.get(i).setBackground(Color.WHITE);
            }else{
                listaGuzikow.get(i).setText(String.valueOf(plansza.toCharArray()[i]));
                listaGuzikow.get(i).setEnabled(false);
            }
        }

    }
    public static void change(ArrayList<JButton> listaGuzikow,char[] wartosciUzytkownika,int ktory){
        listaGuzikow.get(ktory).setBackground(wartosciUzytkownika[ktory] == '0' ? Color.BLACK : Color.WHITE);
        if(wartosciUzytkownika[ktory] == '0'){
            wartosciUzytkownika[ktory] = 'B';
        }else{
            wartosciUzytkownika[ktory] = '0';
        }

    }
    //dziala ale mozna zrobic te metody jako osobne klasy we will see i akurat w tej planysz sa 2 opd i nie wiem co z tym zrobimy
    //czy bedziemy szukac plansz z 1 odp czy jakos modyfikowac to
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


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == help){
            System.out.println("help"); //do zmiany
        }else if(e.getSource() == check){
            check(wartosciUzytkownika,odpowiedz);
        }else if(e.getSource() == print){
            System.out.println("print"); //do zmiany
        }else if(e.getSource() == reset){
            addValueToButtons(plansza,listaGuzikow);
            for(int i=0; i < wartosciUzytkownika.length; i++){
                wartosciUzytkownika[i]= plansza.toCharArray()[i];
            }
        }else if(e.getSource() == save) {
            System.out.println("save"); //do zmiany
        }

        for(int i=0; i < listaGuzikow.size(); i++){
            if(e.getSource() == listaGuzikow.get(i)){
                change(listaGuzikow,wartosciUzytkownika,i);
                System.out.println("guzik" + i + " "  +wartosciUzytkownika[i]);
                break;
            }
        }
    }
}
