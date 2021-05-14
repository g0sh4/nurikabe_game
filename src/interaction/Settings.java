package interaction;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Settings {
    public Settings(){
        JFileChooser choose = new JFileChooser();
        choose.setCurrentDirectory(new File("."));
        choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        choose.setAcceptAllFileFilterUsed(false);
        JFrame frame = new JFrame("Ustawienia");
        //JOptionPane.showMessageDialog();
    }
    public static void main(String[] args) {
        new Settings();
    }
}
