package w3resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class Es4 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/files/Testo.txt");
        boolean lettura = Files.isReadable(path);
        boolean scrittura = Files.isWritable(path);
        System.out.println(lettura? "Lettura concessa":"Lettura negata");
        System.out.println(scrittura? "Scrittura permessa": "Scrittura negata");
    }
}
