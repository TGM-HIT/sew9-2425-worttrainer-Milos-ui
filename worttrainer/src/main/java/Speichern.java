
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Speichern implements SuL {
    @Override
    public Worttrainer strategy(Worttrainer worttrainer) {
        try (FileWriter writer = new FileWriter("quiz_data.json")) {
            JSONObject jsonObject = worttrainer.toJson(); // Verwende die toJson-Methode von Worttrainer
            writer.write(jsonObject.toString(4)); // JSON schön formatieren
            return worttrainer;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
