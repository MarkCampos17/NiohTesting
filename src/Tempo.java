import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Tempo {
    public static void main(String[] args) throws IOException {
        //metodo per creare file temporanei Files.createTempDirectory("TEMP")
        //serve per creare la cartella che conterra' i file temporanei
        Path p1 = Files.createTempDirectory("TEMP");
        //Ci permette di creare un file temporaneo, scegliendo la cartella creata prima
        //e successivamente scegliento il prefisso e suffisso del file temporaneo
        Path p2 = Files.createTempFile(p1,"TEMP",".tmp");
        //i file temporanei poi vengono cancellati
        Files.deleteIfExists(p2);
        Files.deleteIfExists(p1);
    }
}
