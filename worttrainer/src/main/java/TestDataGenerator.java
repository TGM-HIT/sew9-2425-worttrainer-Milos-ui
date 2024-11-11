public class TestDataGenerator {
    public static void main(String[] args) {
        // Erstelle ein Worttrainer-Objekt und füge drei Fragen mit Bildern hinzu
        Worttrainer worttrainer = new Worttrainer();

        // Frage 1: Hund
        Paar frage1 = new Paar("Was ist das für ein Tier?", "Hund", "https://www.zooroyal.at/magazin/wp-content/uploads/2021/06/sitz.jpg");
        worttrainer.addPaar(frage1);

        // Frage 2: Katze
        Paar frage2 = new Paar("Was ist das für ein Tier?", "Katze", "https://ecommerce.koelle-zoo.de/media/71/6d/ea/1702981372/Steckbrief-Bengal-Katze-Teaser_1.jpg");
        worttrainer.addPaar(frage2);

        // Frage 3: Pinguin
        Paar frage3 = new Paar("Was ist das für ein Tier?", "Pinguin", "https://www.planet-wissen.de/natur/voegel/pinguine/intropinguinfederkleidgjpg100~_v-gseagaleriexl.jpg");
        worttrainer.addPaar(frage3);

        // Speichere die Daten in eine JSON-Datei
        Speichern speichern = new Speichern();
        speichern.strategy(worttrainer);

        System.out.println("Die Testdaten wurden erfolgreich gespeichert.");
    }
}
