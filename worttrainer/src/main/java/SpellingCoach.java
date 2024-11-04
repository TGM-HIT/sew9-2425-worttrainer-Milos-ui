import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpellingCoach {
    private List<VocabImageAssociation> vocabList;
    private VocabImageAssociation currentVocab;
    private Statistics stats;
    private Random random;

    public SpellingCoach() {
        this.vocabList = new ArrayList<>();
        this.stats = new Statistics();
        this.random = new Random();
    }

    public void addVocab(VocabImageAssociation vocab) {
        if (vocab == null) {
            throw new IllegalArgumentException("Vocab darf nicht null sein.");
        }
        vocabList.add(vocab);
    }

    public VocabImageAssociation selectRandomVocab() {
        if (vocabList.isEmpty()) {
            throw new IllegalStateException("Keine Vokabeln verfügbar.");
        }
        currentVocab = vocabList.get(random.nextInt(vocabList.size()));
        return currentVocab;
    }

    public boolean checkSpelling(String input) {
        if (currentVocab == null) {
            throw new IllegalStateException("Kein aktuelles Wort ausgewählt.");
        }
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Eingabe darf nicht leer sein.");
        }
        boolean isCorrect = currentVocab.getWord().equalsIgnoreCase(input.trim());
        stats.recordAttempt(isCorrect);
        if (isCorrect) {
            vocabList.remove(currentVocab);
            currentVocab = null;
        }
        return isCorrect;
    }

    public Statistics getStatistics() {
        return stats;
    }

    public List<VocabImageAssociation> getVocabList() {
        return vocabList;
    }
}
