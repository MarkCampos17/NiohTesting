import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;

public class PathProp {
    public static void main(String[] args) throws IOException {
        Path p1 = Path.of("src/files/users/joe/docs/some.txt");
        Path relativePath = Paths.get("src/files/users/joe/docs/other.txt");

        Path p2 = Path.of("src/files/docs/some.txt");
        Path p3 = Path.of("./pics/s.txt");
        //Files.createSymbolicLink(p1,p3);
        System.out.println(Files.isDirectory(relativePath));
        System.out.println(Files.isExecutable(relativePath));
        System.out.println(Files.isHidden(relativePath));
        System.out.println(Files.isReadable(relativePath));
        System.out.println(Files.isWritable(relativePath));
        System.out.println(Files.isSymbolicLink(p3));
//        System.out.println(Files.isSameFile(p1,p2));
//        System.out.println(Files.isSameFile(p1,p3));
        System.out.println(Files.probeContentType(p1));
        //PosixFileAttributes fa = Files.readAttributes(p1,PosixFileAttributes.class);

    }
}
