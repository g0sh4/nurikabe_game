package interaction;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Print {
    public Print(JPanel panelZGuzikami) {
        if (!Settings.getPath().equals("")){
            JFrame f = new JFrame();
            String printName = JOptionPane.showInputDialog(new JFrame("Wprowadź nazwę pliku"),"Podaj nazwę pliku: ");
            if (printName != null){
                try {
                    BufferedImage img = new BufferedImage(panelZGuzikami.getWidth(), panelZGuzikami.getHeight(), BufferedImage.TYPE_INT_RGB);
                    panelZGuzikami.paint(img.getGraphics());
                    File outputfile = new File(Settings.getPath() + "/" + printName + ".png");

                    ImageIO.write(img, "png", outputfile);
                    JOptionPane.showMessageDialog(new JFrame("INFO"), "Zdjęcie pomyślenie zapisano!");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    JOptionPane.showMessageDialog(new JFrame("INFO"), "Upss coś poszło nie tak :(");
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(new JFrame("UWAGA"), "Zanim wykonasz fukcję print wybierz ścieżkę katalogu w którym zapiszemy zdjęcie!!! \n Ustawienia ścieżki zjadziesz w ustawieniach");
        }
    }
}
