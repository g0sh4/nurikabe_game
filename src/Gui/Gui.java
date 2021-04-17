package Gui;

import javax.swing.*;
import java.awt.*;

public class Gui {

    public JFrame frame = new JFrame("Nurikabe");

    public int frameWidth = 400;
    public int frameHeight = 400;


    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();

    public Gui(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLocation((int) (width-400)/2, (int) (height-400)/2);
    }
}
