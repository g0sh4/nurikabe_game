package interaction;

import com.opencsv.exceptions.CsvException;
import csv_txt.OpenTxtData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class StartGame extends Gui.Gui{
    public JPanel panelPicture;
    public JPanel panelButtons;

    public JButton wyborPlanszy;
    public JButton ustawieniaButton;
    public JButton jakGrac;
    public JButton autorzyButton;
    public JButton zamknijButton;

    private OpenTxtData otd = new OpenTxtData();

    public StartGame() throws IOException, CsvException {
        super();
        if(otd.getPathIfExist() != null){
            Settings.setPath(otd.getPathIfExist());
        }

        ImageIcon icon = new ImageIcon( "png/nurikabe_4.png" );
        JLabel label = new JLabel();

        label.setIcon(icon);

        panelPicture = new JPanel();
        panelPicture.setBackground(new Color(253,245,230));
        panelPicture.add(label);

        wyborPlanszy = new JButton( "WYBÓR PLANSZY" );
        wyborPlanszy.addActionListener(this::actionPerformed);
        wyborPlanszy.setBackground(new Color(222,184,135));

        ustawieniaButton = new JButton( "USTAWIENIA" );
        ustawieniaButton.addActionListener(this::actionPerformed);
        ustawieniaButton.setBackground(new Color(222,184,135));

        jakGrac = new JButton( "JAK GRAĆ?" );
        jakGrac.addActionListener(this::actionPerformed);
        jakGrac.setBackground(new Color(222,184,135));

        autorzyButton = new JButton( "O AUTORACH" );
        autorzyButton.addActionListener(this::actionPerformed);
        autorzyButton.setBackground(new Color(222,184,135));

        zamknijButton = new JButton( "ZAMKNIJ GRE" );
        zamknijButton.addActionListener(this::actionPerformed);
        zamknijButton.setBackground(new Color(222,184,135));

        panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout( 5,1 ,9,9));
        panelButtons.add(wyborPlanszy);
        panelButtons.add(ustawieniaButton);
        panelButtons.add(jakGrac);
        panelButtons.add(autorzyButton);
        panelButtons.add(zamknijButton);

        panelButtons.setBorder(BorderFactory.createEmptyBorder(10,100,10,100));
        panelButtons.setBackground(new Color(253,245,230));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panelPicture, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);


        getContentPane().setBackground(Color.pink);
        pack();
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        String event = e.getActionCommand();
    if(event.equals("WYBÓR PLANSZY")){
        if (!Settings.getPath().equals("")){
            new SelectBoardSize();
        }
        else JOptionPane.showMessageDialog(new JFrame("UWAGA"), "Zanim zaczniesz grać wybierz scieżkę do zapisu oraz odczytu plików! " +
                "\n W tym celu udaj się do zakładki USTAWIENIA");

    }if(event.equals("USTAWIENIA")){
        new Settings();
    }
    if(event.equals("JAK GRAĆ?")){
        new GameRules();
    }
    if(event.equals("O AUTORACH")){
        new AboutAuthors();
    }
    if(event.equals("ZAMKNIJ GRE")){
        dispose();
    }
    }
}
