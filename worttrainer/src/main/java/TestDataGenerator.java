public class TestDataGenerator {
    public static void main(String[] args) {
        // Erstelle ein Worttrainer-Objekt und füge drei Fragen mit Bildern hinzu
        Worttrainer worttrainer = new Worttrainer();

        // Frage 1: Hund
        Paar frage1 = new Paar("Was ist das für ein Tier?", "Hund", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.tierschutzbund.de%2Ftiere-themen%2Fhaustiere%2Fhunde%2Fhundehaltung&psig=AOvVaw1xrq_SzGYivH9BjRfvFSPr&ust=1731404618277000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCOCtroH_04kDFQAAAAAdAAAAABAI");
        worttrainer.addPaar(frage1);

        // Frage 2: Katze
        Paar frage2 = new Paar("Was ist das für ein Tier?", "Katze", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.koelle-zoo.at%2Fblog%2Fkatze%2Fsteckbriefe-katze%2Fsteckbrief-bengal-katze%2F&psig=AOvVaw0SX5E55XKzK04yroxiVEPs&ust=1731404683981000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCKiOtpv_04kDFQAAAAAdAAAAABAE");
        worttrainer.addPaar(frage2);

        // Frage 3: Pinguin
        Paar frage3 = new Paar("Was ist das für ein Tier?", "Pinguin", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.planet-wissen.de%2Fnatur%2Fvoegel%2Fpinguine%2Findex.html&psig=AOvVaw236T64wJkCX--VUB_yLpAH&ust=1731404703902000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCODgrqX_04kDFQAAAAAdAAAAABAE");
        worttrainer.addPaar(frage3);

        // Speichere die Daten in eine JSON-Datei
        Speichern speichern = new Speichern();
        speichern.strategy(worttrainer);

        System.out.println("Die Testdaten wurden erfolgreich gespeichert.");
    }
}
