import javax.swing.*;
import java.io.IOException;

public class TrainerUI {
    private SpellingCoach coach;
    private SessionManager sessionManager;

    public TrainerUI() {
        sessionManager = new SessionManager();
        try {
            coach = sessionManager.loadSession();
            if (coach.getVocabList().isEmpty()) {
                initializeDefaultVocab();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fehler beim Laden der Session: " + e.getMessage());
            coach = new SpellingCoach();
            initializeDefaultVocab();
        }
    }

    private void initializeDefaultVocab() {
        coach.addVocab(new VocabImageAssociation("Hund", "https://cdn.pixabay.com/photo/2017/09/25/13/12/puppy-2785074_640.jpg"));
        coach.addVocab(new VocabImageAssociation("Katze", "https://cdn.pixabay.com/photo/2016/02/10/16/37/cat-1192026_640.jpg"));
        coach.addVocab(new VocabImageAssociation("Vogel", "https://cdn.pixabay.com/photo/2018/02/16/22/08/bird-3158784_640.jpg"));
    }

    public void startTraining() {
        while (true) {
            VocabImageAssociation vocab = coach.selectRandomVocab();
            String previousResult = coach.getStatistics().getTotalAttempts() > 0 ?
                    (coach.getStatistics().getIncorrectAttempts() > 0 ? "Falsch" : "Richtig") : "Noch kein Versuch";
            String message = String.format("Statistik: %s\nBild-URL: %s\nLetzter Versuch: %s\nBitte gib das Wort ein:",
                    coach.getStatistics().toString(),
                    vocab.getImageUrl(),
                    previousResult);
            String userInput = JOptionPane.showInputDialog(null, message, "Worttrainer", JOptionPane.QUESTION_MESSAGE);

            if (userInput == null || userInput.trim().isEmpty()) {
                break;
            }

            boolean isCorrect = coach.checkSpelling(userInput);
            if (isCorrect) {
                JOptionPane.showMessageDialog(null, "Richtig!", "Ergebnis", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Falsch! Versuch es nochmal.", "Ergebnis", JOptionPane.ERROR_MESSAGE);
            }
        }

        try {
            sessionManager.saveSession(coach);
            JOptionPane.showMessageDialog(null, "Session gespeichert. Auf Wiedersehen!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fehler beim Speichern der Session: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TrainerUI ui = new TrainerUI();
        ui.startTraining();
    }
}
