package w3resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Es2 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/files");
        Files.list(path).forEach(p -> {
           if (p.getFileName().toString().endsWith(".txt")){
               System.out.println(p.getFileName());
           }
        });
    }
}
