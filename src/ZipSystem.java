import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ZipSystem {
    public static void main(String[] args) throws IOException {
        Path joe = Path.of("src/files/users/joe");
        Path zip = Path.of("src/files/users/joe.zip");
        Map<String, String> env = new HashMap<>();
        env.put("create","true");
        URI uri = URI.create("jar:file:/joe.zip");
        try (FileSystem fs = FileSystems.newFileSystem(uri, env)){
            Files.walk(joe).forEach(source -> {
                try {
                    Path target = fs.getPath("/"+source.toString());
                    Files.copy(source, target);
                } catch (IOException e) {
                    Logger.getLogger("logger").log(Level.SEVERE,"Error archiving file",e);
                }
            });
        } catch (Exception e) {
            Logger.getLogger("logger").log(Level.SEVERE,"Error creating file",e);
        }
    }
}
