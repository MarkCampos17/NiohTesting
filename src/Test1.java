import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test1 {
    public static void main(String[] args) {
        String percorso = "G:\\Backup\\Master\\JavaWeb-Spring\\Spring-workspace\\NiohTesting\\src\\files\\Test1\\";
        String file1 = "60000_parole_italiane.txt";
        String file2 = "other.txt";
        Charset utf8 = Charset.forName("UTF-8");
        try (Reader in = new FileReader(percorso + file1,utf8);
        Writer out = new FileWriter(percorso + file2, utf8)){
            char[] buffer = new char[1024];
            int length = 0;
            while ((length=in.read(buffer))!=-1){
                out.write(buffer,0 ,length);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        try {
            Path p1 = Paths.get(percorso+file1);
            Path p2 = Paths.get(percorso+file2);
            Files.copy(p1,p2);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (Reader in = new FileReader(percorso+file1);
        Writer out = new FileWriter(percorso+file2);){
            long amountOfData = in.transferTo(out);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
