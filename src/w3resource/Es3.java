package w3resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Es3 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/files");
        boolean ciao = Files.exists(Path.of("src/files/Testo.txt"));
        System.out.println(ciao? "Il file esiste":"Il file non esiste");
    }
}
