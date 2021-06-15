package interaction;

import javax.swing.*;

public class AboutAuthors {
    public AboutAuthors(){
        JFrame frame = new JFrame("Zasady gry Nurikabe");
        frame.add(new JLabel( "Zasady gry: " ));
        JOptionPane.showMessageDialog(frame,
                """
                        ‣ Jan Sosulski
                        ‣ Jakub Kozłowski
                        ‣ Małgorzata Olech
                        """,
                "Autorzy gierki",
                JOptionPane.INFORMATION_MESSAGE, new ImageIcon( "png/brain.png" ));

    }
}