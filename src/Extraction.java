import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Extraction {
    public static void main(String[] args) throws IOException {
        Path zip = Path.of("src/files/joe.zip");
        if (Files.notExists(zip))Files.createFile(zip);
        Path target = Path.of("src/files/users/extract_to");
        if (Files.notExists(target)){
            Files.createDirectories(target);
        }
        try (ZipInputStream in = new ZipInputStream(Files.newInputStream(zip))){
            ZipEntry e = null;
            while((e = in.getNextEntry()) != null){
                Path p = Paths.get(target.toString(), e.getName());
                if (e.isDirectory()){
                    Files.createDirectories(p);
                } else {
                    Files.copy(in, p, StandardCopyOption.REPLACE_EXISTING);
                }
                in.closeEntry();
            }
        } catch (IOException e) {
            Logger.getLogger("logger").log(Level.SEVERE,"Error extracting zip archive", e);
        }
    }
}
