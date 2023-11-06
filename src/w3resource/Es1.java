package w3resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Es1 {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        Path path = Path.of("src/files");
        Files.list(path).forEach(p -> {
            list.add(p.toFile().getName().toString());
        });
        System.out.println(list);
    }
}
