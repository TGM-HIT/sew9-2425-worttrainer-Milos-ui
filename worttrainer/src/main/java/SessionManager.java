import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class SessionManager {
    private static final String SESSION_FILE = "session.json";
    private Gson gson;

    public SessionManager() {
        this.gson = new Gson();
    }

    public void saveSession(SpellingCoach coach) throws IOException {
        try (Writer writer = new FileWriter(SESSION_FILE)) {
            gson.toJson(coach, writer);
        }
    }

    public SpellingCoach loadSession() throws IOException {
        File file = new File(SESSION_FILE);
        if (!file.exists()) {
            return new SpellingCoach();
        }
        try (Reader reader = new FileReader(file)) {
            return gson.fromJson(reader, SpellingCoach.class);
        } catch (com.google.gson.JsonSyntaxException e) {
            // Ungültiges JSON: Rückfall auf neue Session
            System.err.println("Ungültiges JSON in der Session-Datei. Eine neue Session wird erstellt.");
            return new SpellingCoach();
        }
    }
}
