package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    JButton b1=new JButton("1");
    JButton b2=new JButton("2");
    JButton b3=new JButton("3");
    JButton b4=new JButton("4");
    JButton b5=new JButton("5");
    JButton b6=new JButton("6");
    JButton b7=new JButton("7");
    JButton b8=new JButton("8");
    JButton b9=new JButton("9");
    JButton b10=new JButton("10");
    JButton b11=new JButton("11");
    JButton b12=new JButton("12");
    JButton b13=new JButton("13");
    JButton b14=new JButton("14");
    JButton b15=new JButton("15");
    JButton b16=new JButton("16");
    public JButton[] lista = {b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16};
    public Board4_4(){
        super();
        panelZMenuDol.setLayout(new GridLayout(1,2));
        panelzMenuGora.setLayout(new GridLayout(1,3));
        panelZGuzikami.setLayout(new GridLayout(4,4));
        panelZGuzikami.add(b1);panelZGuzikami.add(b2);panelZGuzikami.add(b3);panelZGuzikami.add(b4);
        panelZGuzikami.add(b5);panelZGuzikami.add(b6);panelZGuzikami.add(b7);panelZGuzikami.add(b8);
        panelZGuzikami.add(b9);panelZGuzikami.add(b10);panelZGuzikami.add(b11);panelZGuzikami.add(b12);
        panelZGuzikami.add(b13);panelZGuzikami.add(b14);panelZGuzikami.add(b15);panelZGuzikami.add(b16);
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

    }
}
