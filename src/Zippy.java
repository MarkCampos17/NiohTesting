import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zippy {
    public static void main(String[] args) throws IOException {
        Path source = Path.of("src/files/users/joe/docs");
        Path joe = Path.of("src/files/users/joe");
        Path zip = Path.of("src/files/joe.zip");
        if (Files.notExists(zip))Files.createFile(zip);
        try (ZipOutputStream out = new ZipOutputStream(Files.newOutputStream(zip))){
            out.setLevel(Deflater.DEFAULT_COMPRESSION);
            Files.walk(joe).filter(p -> !Files.isDirectory(p))
                    .forEach(p -> {
        ZipEntry zipEntry = new ZipEntry(source.relativize(p).toString());
        try {
            out.putNextEntry(zipEntry);
            out.write(Files.readAllBytes(p));
            out.closeEntry();
        } catch (IOException e){
            Logger.getLogger("logger").log(Level.SEVERE,"Error creating zip entry",e);
        }
                    });
        } catch (IOException e){
            Logger.getLogger("logger").log(Level.SEVERE,"Error creating zip archive");
        }
    }
}
