package w3resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class Es7 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/files");
        Date date = new Date(path.toFile().lastModified());
        System.out.println(date);
    }
}
