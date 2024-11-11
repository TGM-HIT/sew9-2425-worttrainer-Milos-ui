import javax.swing.*;

import java.net.URL;
import java.awt.Image;

public class GUI {
    public void start(Worttrainer quizManager) {
        boolean weitermachen = true;
        
        while (weitermachen) {
            Paar frage = quizManager.zufaelligesPaarAuswaehlen();
            if (frage == null) {
                JOptionPane.showMessageDialog(null, "Keine Quizfragen vorhanden.");
                break;
            }
            
            // Lade das Bild von der URL und zeige es an
            ImageIcon bildIcon = ladeBildIcon(frage.getBildUrl());
            if (bildIcon == null) {
                JOptionPane.showMessageDialog(null, "Bild konnte nicht geladen werden: " + frage.getBildUrl());
            }

            // Erstelle das Dialogfenster mit der Frage und dem Bild
            String eingabe = (String) JOptionPane.showInputDialog(
                null,                              // Parent-Komponente
                frage.getFrage(),                  // Frage (Titel)
                "Quizfrage",                       // Titel des Dialogs
                JOptionPane.PLAIN_MESSAGE,         // Dialogtyp
                bildIcon,                          // Bild-Icon, das im Dialog angezeigt wird
                null,                              // Auswahlmöglichkeiten (nicht verwendet)
                ""                                 // Voreingestellter Text
            );

            if (eingabe == null || eingabe.isEmpty()) {
                weitermachen = false;
            } else if (eingabe.equalsIgnoreCase(frage.getAntwort())) {
                JOptionPane.showMessageDialog(null, "Richtig!");
                quizManager.incrementiereRichtigeAntworten();
            } else {
                JOptionPane.showMessageDialog(null, "Falsch! Die richtige Antwort ist: " + frage.getAntwort());
                quizManager.incrementiereFalscheAntworten();
            }
        }
        
        Speichern saver = new Speichern();
        saver.strategy(quizManager);
    }

    // Hilfsmethode zum Laden des Bildes von der URL
    private ImageIcon ladeBildIcon(String bildUrl) {
        try {
            URL url = new URL(bildUrl);
            ImageIcon icon = new ImageIcon(url);
            
            // Bildgröße anpassen (optional)
            Image image = icon.getImage();
            Image resizedImage = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
