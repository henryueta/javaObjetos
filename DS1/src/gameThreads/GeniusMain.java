package gameThreads;

import javax.swing.*;

public class GeniusMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GeniusThreads jogo = new GeniusThreads();
            jogo.setVisible(true);
        });
    }
}
