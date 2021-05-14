package interaction;

import javax.swing.*;
import java.awt.*;

public class SelectBoardSize extends Gui.Gui {
    String[] wybor = {"Easy","Medium","Hard"};
    public JComboBox cb1 = new JComboBox(wybor);
    public JComboBox cb2; //tutuj trzeba dodac tytuly plansz z listy

    public JLabel wybierzPoziom = new JLabel("Wybierz poziom");
    public JLabel wybierzPlansze = new JLabel("Wybierz plansze");
    public JButton startGame = new JButton("Start game");

    JPanel panel = new JPanel();

    public SelectBoardSize(){


        panel.setLayout(new GridLayout( 5,1 ,9,9));
    }
}
