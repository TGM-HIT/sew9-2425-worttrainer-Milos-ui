
import org.json.JSONObject;

public class Paar {
    private String frage;
    private String antwort;
    private String bildUrl;

    public Paar() {
    }

    public Paar(String frage, String antwort, String bildUrl) {
        this.frage = frage;
        this.antwort = antwort;
        this.bildUrl = bildUrl;
    }

    public String getFrage() {
        return frage;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }

    public String getAntwort() {
        return antwort;
    }

    public void setAntwort(String antwort) {
        this.antwort = antwort;
    }

    public String getBildUrl() {
        return bildUrl;
    }

    public void setBildUrl(String bildUrl) {
        this.bildUrl = bildUrl;
    }

    // Konvertiert ein Paar-Objekt in JSON
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("frage", frage);
        json.put("antwort", antwort);
        json.put("bildUrl", bildUrl);  // Bild-URL zur JSON-Ausgabe hinzufügen
        return json;
    }

    // Erstellt ein Paar-Objekt aus JSON
    public static Paar fromJson(JSONObject json) {
        String frage = json.getString("frage");
        String antwort = json.getString("antwort");
        String bildUrl = json.optString("bildUrl", null); // Bild-URL aus JSON lesen (optional)
        return new Paar(frage, antwort, bildUrl);
    }
}
