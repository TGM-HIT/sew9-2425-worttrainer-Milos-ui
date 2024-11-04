

public class Main {
    public static void main(String[] args) {
        Worttrainer worttrainer = new Worttrainer(); // Erstelle oder lade den Worttrainer
        Laden laden = new Laden();
        worttrainer = laden.strategy(worttrainer);

        if (worttrainer != null) {
            GUI gui = new GUI();
            gui.start(worttrainer);
        } else {
            System.out.println("Fehler beim Laden des Worttrainers.");
        }
    }
}
