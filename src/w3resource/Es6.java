package w3resource;

import java.nio.file.Path;

public class Es6 {
    public static void main(String[] args) {
        Path path1 = Path.of("src/files/Testo.txt");
        Path path2 = Path.of("src/files/TestoAuto.txt");
        System.out.println("path1 e path2 confronto lessicografico: "+path1.compareTo(path2));
        System.out.println("path2 e path1 confronto lessicografico: "+path2.compareTo(path1));
    }
}
