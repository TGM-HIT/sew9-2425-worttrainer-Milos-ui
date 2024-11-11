

public class Main {
    public static void main(String[] args) {
        Worttrainer quizManager = new Worttrainer(); // Erstellt oder lade das Quiz
        Laden loader = new Laden();
        quizManager = loader.strategy(quizManager);

        if (quizManager != null) {
            GUI gui = new GUI();
            gui.start(quizManager);
        } else {
            System.out.println("Fehler beim Laden des Quiz.");
        }
    }
}
