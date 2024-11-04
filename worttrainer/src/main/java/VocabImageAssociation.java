import java.util.Objects;

public class VocabImageAssociation {
    private String word;
    private String imageUrl;

    public VocabImageAssociation(String word, String imageUrl) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Das Wort darf nicht leer sein.");
        }
        if (imageUrl == null || !isValidURL(imageUrl)) {
            throw new IllegalArgumentException("Ungültige Bild-URL.");
        }
        this.word = word;
        this.imageUrl = imageUrl;
    }

    private boolean isValidURL(String url) {
        // Einfache URL-Validierung
        return url.startsWith("http://") || url.startsWith("https://");
    }

    public String getWord() {
        return word;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VocabImageAssociation that = (VocabImageAssociation) o;

        return Objects.equals(word, that.word) && Objects.equals(imageUrl, that.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, imageUrl);
    }
}
