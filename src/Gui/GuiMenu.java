package Gui;

import Gui.Gui;

import javax.swing.*;

public class GuiMenu extends Gui {
    public GuiMenu(){
        super();
        JButton startGame = new JButton("start game");
        frame.add(startGame);
        frame.setVisible(true);
    }
}

