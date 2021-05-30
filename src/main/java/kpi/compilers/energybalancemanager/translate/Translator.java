package kpi.compilers.energybalancemanager.translate;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class Translator {

    private static final String path = "translated.txt";

    public void translate(String translated) {
        Path path = Paths.get(Translator.path);
        byte[] strToBytes = translated.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
