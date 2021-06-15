package interaction;

import javax.swing.*;

public class GameRules {
    public GameRules(){
        JFrame frame = new JFrame("Zasady gry Nurikabe");
        frame.add(new JLabel( "Zasady gry: " ));
        JOptionPane.showMessageDialog(frame,
                """
                        1. Informację o każdej wyspie przedstawia liczba, która podaję ilość pól, z których składa się wyspa.
                        2. Jakiekolwiek dwie wyspy mogą się stykać tylko kątami.
                        3. Wszystkie wyspy zawierają w swoim opisie tylko jedną liczbę.
                        4. Między wyspami przepływa rzeka.
                        5. Wszystkie pola z rzeką muszą być połączone
                        6. Mapa nie może zawierać żadnego kwadratu rozmiarem 2 x 2, wszystkie pola którego zawierają rzekę""",
                "Zasady gry Nurikabe",
                JOptionPane.INFORMATION_MESSAGE, new ImageIcon( "png/joystick.png" ));

    }

}
