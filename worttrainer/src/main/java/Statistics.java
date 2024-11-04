public class Statistics {
    private int totalAttempts;
    private int correctAttempts;
    private int incorrectAttempts;

    public Statistics() {
        this.totalAttempts = 0;
        this.correctAttempts = 0;
        this.incorrectAttempts = 0;
    }

    public void recordAttempt(boolean isCorrect) {
        totalAttempts++;
        if (isCorrect) {
            correctAttempts++;
        } else {
            incorrectAttempts++;
        }
    }

    public int getTotalAttempts() {
        return totalAttempts;
    }

    public int getCorrectAttempts() {
        return correctAttempts;
    }

    public int getIncorrectAttempts() {
        return incorrectAttempts;
    }

    @Override
    public String toString() {
        return String.format("Gesamtversuche: %d, Richtig: %d, Falsch: %d",
                totalAttempts, correctAttempts, incorrectAttempts);
    }
}
