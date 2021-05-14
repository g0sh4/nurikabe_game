package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board4_4 extends Gui implements ActionListener {
    JPanel panel = new JPanel();
    JPanel panelZMenuDol = new JPanel();
    JPanel panelZGuzikami= new JPanel();
    JPanel panelzMenuGora = new JPanel();
    JButton help = new JButton("help");
    JButton save = new JButton("save");
    JButton check = new JButton("check");
    JButton print = new JButton("print");
    JButton reset = new JButton("reset");
    /*
    JButton b1=new JButton();
    JButton b2=new JButton();
    JButton b3=new JButton();
    JButton b4=new JButton();
    JButton b5=new JButton();
    JButton b6=new JButton();
    JButton b7=new JButton();
    JButton b8=new JButton();
    JButton b9=new JButton();
    JButton b10=new JButton();
    JButton b11=new JButton();
    JButton b12=new JButton();
    JButton b13=new JButton();
    JButton b14=new JButton();
    JButton b15=new JButton();
    JButton b16=new JButton();

     */
    public ArrayList<JButton> listaGuzikow = new ArrayList<JButton>();

    String plansza;
    public char[] wartosciUzytkownika = new char[16];
    public Board4_4(String plansza){
        super();
        this.plansza = plansza;
        for ( int i = 1; i < 17; i++){
            listaGuzikow.add(new JButton() );
        }
        //ta petla nizej moze do zmiany
        for(int i=0; i < 16; i++){
            wartosciUzytkownika[i]= plansza.toCharArray()[i];
        }

        panelZMenuDol.setLayout(new GridLayout(1,2));
        panelzMenuGora.setLayout(new GridLayout(1,3));
        panelZGuzikami.setLayout(new GridLayout(4,4));

        addValueToButtons(plansza,listaGuzikow);
        for ( int i = 0; i < 16; i++){
            listaGuzikow.get(i).addActionListener(this::actionPerformed);
        }
        for ( int i = 0; i < 16; i++){
            panelZGuzikami.add(listaGuzikow.get(i));
        }

        help.addActionListener(this::actionPerformed);
        save.addActionListener(this::actionPerformed);
        print.addActionListener(this::actionPerformed);
        reset.addActionListener(this::actionPerformed);
        check.addActionListener(this::actionPerformed);
        /*
        panelZGuzikami.add(b1);panelZGuzikami.add(b2);panelZGuzikami.add(b3);panelZGuzikami.add(b4);
        panelZGuzikami.add(b5);panelZGuzikami.add(b6);panelZGuzikami.add(b7);panelZGuzikami.add(b8);
        panelZGuzikami.add(b9);panelZGuzikami.add(b10);panelZGuzikami.add(b11);panelZGuzikami.add(b12);
        panelZGuzikami.add(b13);panelZGuzikami.add(b14);panelZGuzikami.add(b15);panelZGuzikami.add(b16);
        */
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


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == help){
            System.out.println("help"); //do zmiany
        }else if(e.getSource() == check){
            System.out.println("check"); //do zmiany
        }else if(e.getSource() == print){
            System.out.println("print"); //do zmiany
        }else if(e.getSource() == reset){
            addValueToButtons(plansza,listaGuzikow);
            for(int i=0; i < 16; i++){
                wartosciUzytkownika[i]= plansza.toCharArray()[i];
            }
        }else if(e.getSource() == save) {
            System.out.println("save"); //do zmiany
        }
        //}else if(e.getSource()==listaGuzikow.get(0)){
            /*
            listaGuzikow.get(0).setBackground(wartosciUzytkownika[0] == "0" ? Color.BLACK : Color.WHITE);
            if(wartosciUzytkownika[0] == "0"){
                wartosciUzytkownika[0] = "B";
            }else{
                wartosciUzytkownika[0] = "0";
            }

            //change(listaGuzikow,wartosciUzytkownika,0);
            //System.out.println(wartosciUzytkownika[0]);
        }
        */
        for(int i=0; i < 16; i++){
            if(e.getSource() == listaGuzikow.get(i)){
                change(listaGuzikow,wartosciUzytkownika,i);
                System.out.println("guzik" + i + " "  +wartosciUzytkownika[i]);
                break;
            }
        }
    }
}
