import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class Worttrainer {
    private ArrayList<Paar> fragen;
    private int versucheInsgesamt;
    private int richtigeVersuche;

    public Worttrainer() {
        this.fragen = new ArrayList<>();
        this.versucheInsgesamt = 0;
        this.richtigeVersuche = 0;
    }

    public ArrayList<Paar> getFragen() {
        return fragen;
    }

    public void addPaar(Paar question) {
        fragen.add(question);
    }

    public Paar zufaelligesPaarAuswaehlen() {
        if (fragen.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return fragen.get(random.nextInt(fragen.size()));
    }

    public void incrementiereRichtigeAntworten() {
        richtigeVersuche++;
        versucheInsgesamt++;
    }

    public void incrementiereFalscheAntworten() {
        versucheInsgesamt++;
    }

    public int getVersucheInsgesamt() {
        return versucheInsgesamt;
    }

    public int getRichtigeVersuche() {
        return richtigeVersuche;
    }

    // Konvertiert das Worttrainer-Objekt in JSON
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("versucheInsgesamt", versucheInsgesamt);
        json.put("richtigeVersuche", richtigeVersuche);

        JSONArray fragenArray = new JSONArray();
        for (Paar frage : fragen) {
            fragenArray.put(frage.toJson()); // Konvertiere jedes Paar-Objekt zu JSON
        }
        json.put("fragen", fragenArray);
        return json;
    }

    // Erstellt ein Worttrainer-Objekt aus JSON
    public static Worttrainer fromJson(JSONObject json) {
        Worttrainer worttrainer = new Worttrainer();
        worttrainer.versucheInsgesamt = json.getInt("versucheInsgesamt");
        worttrainer.richtigeVersuche = json.getInt("richtigeVersuche");

        JSONArray fragenArray = json.getJSONArray("fragen");
        for (int i = 0; i < fragenArray.length(); i++) {
            JSONObject frageJson = fragenArray.getJSONObject(i);
            worttrainer.addPaar(Paar.fromJson(frageJson)); // Füge jedes konvertierte Paar-Objekt zur Liste hinzu
        }
        return worttrainer;
    }
}
