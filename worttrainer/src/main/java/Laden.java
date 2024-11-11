

import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;

public class Laden implements SuL {
    @Override
    public Worttrainer strategy(Worttrainer worttrainer) {
        try (FileReader reader = new FileReader("quiz_data.json")) {
            StringBuilder sb = new StringBuilder();
            int i;
            while ((i = reader.read()) != -1) {
                sb.append((char) i);
            }
            JSONObject jsonObject = new JSONObject(sb.toString());
            return Worttrainer.fromJson(jsonObject); // Verwende die fromJson-Methode von Worttrainer
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
