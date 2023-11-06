import java.io.IOException;
import java.nio.file.*;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CopyMove {
    public static void main(String[] args) throws IOException {
        Path source = Path.of("src/files/users/joe/docs");
        Path backup = Path.of("src/files/users/joe/backup");
        Path archive = Path.of("src/files/archive");

        // Se la cartella archivio non esiste
        if (Files.notExists(archive)) {
            // Crea la cartella con percorso "archive"
            Files.createDirectories(archive);
        }
        // Tramite la funzione list mi esamino i vari child path objects del percorso
        // utilizzo forEach per esaminare ogni entry del percorso selezionato
        Files.list(source).forEach(file -> {
            try {
                //Tramite Files.copy posso copiare il file nel percorso file backup.resolve
                //backup.resolve() mi permette di concatenare il percorso della cartella backup
                //con il nome del file permettendomi di copiarli

                Files.copy(file, backup.resolve(file.getFileName()),
                        StandardCopyOption.COPY_ATTRIBUTES,//Copio gli attributi del file
                        StandardCopyOption.REPLACE_EXISTING);//Ed in caso lo rimpiazzo se gia' esiste
            } catch (IOException e) {
                Logger.getLogger("logger").log(Level.SEVERE, "Error copying file", e);
            }
        });

        try {
            //controllo se la cartella e' vuota
            if (isEmpty(backup))
                //Tramite Files.move() posso muovere i file da backup a archive senza pero' contare la cartella backup
                //sposto il contenuto di backup ad archive
                Files.move(backup, archive,
                    StandardCopyOption.COPY_ATTRIBUTES,
                    StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.ATOMIC_MOVE);
        } catch (IOException e) {
            Logger.getLogger("logger").log(Level.SEVERE, "Error moving directory", e);
        }
        //se la cartella backup e' presente
        if (!Files.notExists(backup)){
            //walk e' una funzione che mi ritorna i child path objects di backup
            Files.walk(backup)
                    .sorted() //ordina la stream
                    .forEach(path-> {
                        try {
                            //se path e' una cartella non vuota vai avanti
                            if (Files.isDirectory(path) && !isEmpty(path)){
                                return;
                            }
                            //elimina il file
                            Files.delete(path);

                        } catch (IOException e){
                            Logger.getLogger("logger").log(Level.SEVERE, "Error deleting file",e);
                        }
                    });
            //Elimina la cartella vuota backup
            //nel nostro caso erano presenti solo file
            Files.deleteIfExists(backup);
        }
    }

    public static boolean isEmpty(Path path) throws IOException{
        if (Files.isDirectory(path)){
            try (DirectoryStream<Path> directory = Files.newDirectoryStream(path)){
                return !directory.iterator().hasNext();
            }
        }
        return false;
    }
}

