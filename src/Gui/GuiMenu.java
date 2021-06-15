package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMenu extends Gui implements ActionListener {

    JButton startGame = new JButton("start game");
    JButton help = new JButton("help");

    public GuiMenu(){
        super();

        startGame.addActionListener(this::actionPerformed);
        help.addActionListener(this::actionPerformed);


        getContentPane().add(BorderLayout.WEST, startGame);
        getContentPane().add(BorderLayout.CENTER, help);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startGame){
            //inicjuje obiekt klasy StartGame
            System.out.println("start");
        }
        else if (e.getSource() == help){
            System.out.println("help");
        }
    }
}

