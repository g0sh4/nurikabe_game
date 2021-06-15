package Gui;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame{

    public int frameWidth = 400;
    public int frameHeight = 400;


    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();

    public Gui(){
        super("Nurikabe");


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(frameWidth, frameHeight);
        setLocation((int) (width-frameWidth)/2, (int) (height-frameHeight)/2);

    }
}
