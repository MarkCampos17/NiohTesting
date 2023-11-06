import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathGp {
    public static void main(String[] args) throws IOException {
        /*
        * Path.of ci permette di costruire degli oggetti path
        * */
        Path someFile = Path.of("\\","users","joe","docs","some.txt");
        System.out.println(someFile);
        /*
        * Ci permette di prendere il nome del file di questo path object
        * */
        Path justSomeFile = someFile.getFileName();
        System.out.println(justSomeFile);
        /*
        * Prende la cartella che contiene questo file o path object
        * */
        Path docsFolder = someFile.getParent();
        System.out.println(docsFolder);
        /*
        * Ci permette di avere il Path.of(".") il percorso della cartella corrente
        * */
        Path currentFolder = Path.of(".");
        System.out.println(currentFolder);
        /*
        * ci permette di creare un path object relazionato con la stringa
        * che inseriamo e l'oggetto che chiama il metodo
        * */
        Path acmeFile = docsFolder.resolve("..\\pics\\acme.jpg");
        System.out.println(acmeFile);
        /*
        * Possiamo tramite il percorso di un file al percorso
        * di un file che e' presente nella stessa cartella inserendoci il nome di esso
        * */
        Path otherFile = docsFolder.resolveSibling("other.txt");
        System.out.println(otherFile);
        /*
        * Elimina dal path gli elementi ridondanti
        * */
        Path normalisedAcmeFile = acmeFile.normalize();
        System.out.println(normalisedAcmeFile);
        /*
        * Ci permette di controllare se il path e' presente
        * ed ha le funzionalita' di normalize
        * */
//        Path verifiedPath = acmeFile.toRealPath();
//        System.out.println(verifiedPath);
        /*
        * Ci permette di trovare il percorso relativo di un path object
        * */
        Path betweenSomeAndAcme = someFile.relativize(acmeFile);
        System.out.println(betweenSomeAndAcme);
        //------------------------------
        Path someFile1 = Path.of("\\users\\joe\\docs\\some.txt");
        Path someFile2 = Paths.get("\\","users","docs","some.txt");
        Path someFile3 = Paths.get("/users/joe/docs/some.txt");
        FileSystem fs = FileSystems.getDefault();
        Path otherFile1 = fs.getPath("\\","users","joe","pics","artorias.jpg");
        System.out.println(someFile1);
        System.out.println(someFile2);
        System.out.println(someFile3);
        System.out.println(otherFile1);
    }
}
