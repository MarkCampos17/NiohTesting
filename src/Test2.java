import java.io.*;
import java.nio.charset.Charset;

public class Test2 {
    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        String percorso = "G:\\Backup\\Master\\JavaWeb-Spring\\Spring-workspace\\NiohTesting\\src\\files\\Test2\\";
        String file1 = "60000_parole_italiane.txt";
        String file2 = "other.txt";
        /*
        * possiamo concatenare le stream per avere la possibilita' di trasformare, filtrare e buffer data capabilities
        * possiamo concatenare le stream nel modo piu' conveniente per noi
        *
        * Qui BufferedReader ci permette di avere la funzione readLine
        * ci permette di connetterci con una InpuStreamReader che puo' convertire i byte presi da un file in caratteri
        * FileInputStream ci permette di leggere i bytes dal file in lettura
        *
        * PrintWriter ci fornisce il metodo println
        * ci permette di connetterci con una OutputStreamWriter che i caratteri in bytes
        * FileOutputStream ci permette di scrivere questi bytes in un file
        * */
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(percorso+file1),utf8));
             PrintWriter out = new PrintWriter((new OutputStreamWriter(new FileOutputStream((percorso+file2)))));){
            String line = null;
            while ((line = in.readLine())!=null){ // null indica la fine della stream
                /*
                * ci permette di stampare le righe di un file
                * */
                out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
