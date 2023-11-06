import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Extraction {
    public static void main(String[] args) throws IOException {
        /*
        Path zipFilePath = Path.of("src/files/joe.zip");
        Path destDirectory = Path.of("src/files/users/zipFolder/extract_to");

        try {
            // Crea una directory per l'estrazione
            if (Files.notExists(destDirectory)) {
                Files.createDirectories(destDirectory);
            }
            // Apre il file ZIP con ZipInputStream
            try (ZipInputStream in = new ZipInputStream(new FileInputStream(zipFilePath.toFile()))) {
                ZipEntry entry;
                while ((entry = in.getNextEntry()) != null) {
                    Path entryPath = Paths.get(destDirectory.toString(), entry.getName());
                    if (entry.isDirectory()) {
                        // Se l'entry è una directory, crea la directory
                        Files.createDirectories(entryPath);
                    } else {
                        // Se l'entry è un file, estrailo
                        Files.createDirectories(entryPath.getParent().normalize());
                        // Assicura che la directory esista
                        Files.copy(in, entryPath, StandardCopyOption.REPLACE_EXISTING);
                    }
                    in.closeEntry();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        Path fonte = Path.of("src/files/joe.zip");
        Path destinazione = Path.of("src/files/users/zipFolder/extract_to");

        try (ZipInputStream in = new ZipInputStream(Files.newInputStream(fonte))){
            if (Files.notExists(destinazione))Files.createDirectories(destinazione);
            ZipEntry entry;
            while((entry = in.getNextEntry())!=null){
                Path entryPath = Paths.get(destinazione.toString(), entry.getName());
                if (entry.isDirectory()){
                    Files.createDirectories(entryPath);
                } else {
                    Files.createDirectories(entryPath.getParent());
                    //devo copiare dalla stream che connette il file zip
                    System.out.println(entryPath);
                    //entryPath e' il percorso dei file copiati nella nuova destinazione
                    Files.copy(in, entryPath, StandardCopyOption.REPLACE_EXISTING);
                }
                //chiusura della connessione con il file specifico del zip preparando il prossimo entry
                in.closeEntry();
            }
        } catch (IOException e) {
            Logger.getLogger("logger").log(Level.SEVERE,"Errore nell'estrazione dei file zip "+e);
        }
    }
}




