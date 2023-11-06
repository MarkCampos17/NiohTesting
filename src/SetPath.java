import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.*;
import java.time.Instant;
import java.util.Set;

public class SetPath {
    public static void main(String[] args) throws IOException {
        Path p1 = Path.of("src/files/users/joe/docs/some.txt");
        Files.setLastModifiedTime(p1, FileTime.from(Instant.now()));
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-rw-r--");
        //Files.setPosixFilePermissions(p1,perms);
        FileSystem fs = p1.getFileSystem();
        UserPrincipalLookupService uls = fs.getUserPrincipalLookupService();
        UserPrincipal user = uls.lookupPrincipalByName("joe");
    }
}
