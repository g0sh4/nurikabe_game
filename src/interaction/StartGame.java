package interaction;

import Gui.GuiMenu;

import javax.swing.*;
import java.awt.*;

public class StartGame extends JPanel {
    public JPanel panelPicture;
    public JPanel panelButtons;

    public JButton wyborPlanszy;
    public JButton ustawieniaButton;
    public JButton jakGrac;
    public JButton autorzyButton;
    public JButton zamknijButton;


    public StartGame(){
        ImageIcon icon = new ImageIcon( "nurikabe_4.png" );
        JLabel label = new JLabel();

        label.setIcon(icon);

        panelPicture = new JPanel();
        panelPicture.setBackground(new Color(253,245,230));
        panelPicture.add(label);

        wyborPlanszy = new JButton( "WYBÓR PLANSZY" );
        ustawieniaButton = new JButton( "USTAWIENIA" );
        jakGrac = new JButton( "JAK GRAĆ?" );
        autorzyButton = new JButton( "O AUTORACH" );
        zamknijButton = new JButton( "ZAMKNIJ GRE" );
        panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout( 5,1 ,9,9));
        panelButtons.add(wyborPlanszy);
        panelButtons.add(ustawieniaButton);
        panelButtons.add(jakGrac);
        panelButtons.add(autorzyButton);
        panelButtons.add(zamknijButton);
        panelButtons.setBorder(BorderFactory.createEmptyBorder(10,100,10,100));
        panelButtons.setBackground(new Color(253,245,230));

        JFrame frame = new JFrame( "Nurikabe" );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panelPicture, BorderLayout.NORTH);
        frame.add(panelButtons, BorderLayout.CENTER);


        frame.getContentPane().setBackground(Color.pink);
        frame.pack();
        frame.setVisible(true);

    }
    public static void main(String[] args) {

        new StartGame();
    }

}
