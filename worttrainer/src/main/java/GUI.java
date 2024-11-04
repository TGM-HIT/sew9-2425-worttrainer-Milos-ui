

import javax.swing.JOptionPane;

public class GUI {
    public void start(Worttrainer worttrainer) {
        boolean weitermachen = true;

        while (weitermachen) {
            Paar paar = worttrainer.zufaelligesPaarAuswaehlen();
            if (paar == null) {
                JOptionPane.showMessageDialog(null, "Keine Paare vorhanden.");
                break;
            }

            String eingabe = JOptionPane.showInputDialog(null, "Geben Sie das Wort für das Bild ein: " + paar.getBildUrl());

            if (eingabe == null || eingabe.isEmpty()) {
                weitermachen = false;
            } else if (eingabe.equalsIgnoreCase(paar.getWort())) {
                JOptionPane.showMessageDialog(null, "Richtig!");
                worttrainer.incrementiereRichtigeVersuche();
            } else {
                JOptionPane.showMessageDialog(null, "Falsch! Das richtige Wort ist: " + paar.getWort());
                worttrainer.incrementiereFalscheVersuche();
            }
        }

        Speichern speichern = new Speichern();
        speichern.strategy(worttrainer);
    }
}
