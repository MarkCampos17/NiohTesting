import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;

public class CreatePaths {
    public static void main(String[] args) throws IOException {
        Path source = Path.of("src/files/users/joe/docs");
        Path backup = Path.of("src/files/users/joe/backup/docs");

        //Possiamo controllare se un path object esista o meno, tramite Files.notExists(path)

        if (Files.notExists(backup)){
            //In caso fosse vero creiamo la cartella tramite
            //Files.createDirectories(backup)
            //viene tirata un'eccezione se creiamo una sottocartella all'interno di una
            //cartella parente non esistente usando il metodo createDirectory

            //con il metodo createDirectories ci permette di
            // creare le cartelle parente prima che vengano create le cartelle child
            Files.createDirectories(backup);
        }
        //Possiamo creare un path object andando incontro a il percorso che mettiamo in input
        //normalize ci permettera' di togliere le ridondanze del percorso
        Path readme = backup.resolve("../readme.txt").normalize();
        //Tramite createFile possiamo prendere un path object e creare un oggetto
        Files.createFile(readme);
        //Possiamo scrivere e leggere un file tramite i metodi writeString e lines
        Files.writeString(readme,"Backup time: "+ Instant.now());
        Files.lines(readme, Charset.forName("UTF-8"))
                .forEach(line->System.out.println(line));
    }
}
