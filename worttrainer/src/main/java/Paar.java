

public class Paar {
    private String wort;
    private String bildUrl;

    public Paar() {
    }

    public Paar(String wort, String bildUrl) {
        this.wort = wort;
        this.bildUrl = bildUrl;
    }

    public String getWort() {
        return wort;
    }

    public void setWort(String wort) {
        this.wort = wort;
    }

    public String getBildUrl() {
        return bildUrl;
    }

    public void setBildUrl(String bildUrl) {
        this.bildUrl = bildUrl;
    }
}
