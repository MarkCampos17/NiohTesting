package w3resource;

import java.nio.file.Files;
import java.nio.file.Path;

public class Es5 {
    public static void main(String[] args) {
        Path path = Path.of("src/files/Testo.txt");
        boolean isDir = Files.isDirectory(path);
        boolean isFile = Files.isRegularFile(path);
        System.out.println(isDir? "Cartella" : "No cartella");
        System.out.println(isFile? "File":"No File");
    }
}
