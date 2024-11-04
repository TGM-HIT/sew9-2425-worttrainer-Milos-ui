

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Speichern implements SuL {
    @Override
    public Worttrainer strategy(Worttrainer worttrainer) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        try {
            objectMapper.writeValue(new File("worttrainer.json"), worttrainer);
            return worttrainer;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
