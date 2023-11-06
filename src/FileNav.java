import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileNav {
    public static void main(String[] args) throws IOException {
        Path joe = Paths.get("src/files/users/joe");
        Path p1 = Path.of("src/files/users/joe/docs/some.txt");
        /*
        * Ritorna il numero di elementi all'interno del path object
        * */
        for (int i = 0; i<p1.getNameCount(); i++){
            Path p = p1.getName(i);
        }
        Path p2 = Path.of("./pics/s.txt");
        /*
        * Ci permette di creare un collegamento tra due oggetti Path
        * da s.txt a some.txt
        * */
        Files.createSymbolicLink(p2,p1);
        /*
        * sia list e walk ci ritornano delle stream objects su cui possiamo fare peek, filter, map, forEach e etc.
        * list ci ritorna le child path object di un path ad esempio:
        * - /users/joe/docs
        * - /users/joe/pics
        * */
        Files.list(joe).forEach(p -> System.out.println(p));
        /*
        * Ci permette di restituire una stream di child path object immediato ed il suo discendente
        * ad esempio:
        * - /users/joe/docs/some.txt
        * - /users/joe/docs/other.txt
        * - /users/joe/pics/s.txt
        * */
        Files.walk(joe).map(p -> p.toString())
                .filter(s -> s.endsWith("txt"))
                .forEach(p -> System.out.println(p));
        Path p3 = Files.readSymbolicLink(p2);
    }
}
