

import java.util.ArrayList;
import java.util.Random;

public class Worttrainer {
    private ArrayList<Paar> paare;
    private int versucheInsgesamt;
    private int richtigeVersuche;

    public Worttrainer() {
        this.paare = new ArrayList<>();
        this.versucheInsgesamt = 0;
        this.richtigeVersuche = 0;
    }

    public ArrayList<Paar> getList() {
        return paare;
    }

    public void addPaar(Paar paar) {
        paare.add(paar);
    }

    public Paar zufaelligesPaarAuswaehlen() {
        if (paare.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return paare.get(random.nextInt(paare.size()));
    }

    public void incrementiereRichtigeVersuche() {
        richtigeVersuche++;
        versucheInsgesamt++;
    }

    public void incrementiereFalscheVersuche() {
        versucheInsgesamt++;
    }

    public int getVersucheInsgesamt() {
        return versucheInsgesamt;
    }

    public int getRichtigeVersuche() {
        return richtigeVersuche;
    }
}
