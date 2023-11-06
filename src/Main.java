import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
//        try {
//            Path sourceFile = Paths.get("G:\\Backup\\Master\\JavaWeb-Spring\\Spring-workspace\\NiohTesting\\src\\files\\60000_parole_italiane.txt");
//            Path destinationFile = Paths.get("G:\\Backup\\Master\\JavaWeb-Spring\\Spring-workspace\\NiohTesting\\src\\files\\Testo.txt");
//            Files.copy(sourceFile,destinationFile);
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }
        String file1 = "G:\\Backup\\Master\\JavaWeb-Spring\\Spring-workspace\\NiohTesting\\src\\files\\60000_parole_italiane.txt";
        String file2 = "G:\\Backup\\Master\\JavaWeb-Spring\\Spring-workspace\\NiohTesting\\src\\files\\Testo.txt";
        try (InputStream in = new FileInputStream(file1);
            OutputStream out = new FileOutputStream(file2)){
            /*
            * FileInputStream ci permette di aprire una connessione con un file
            * FileOutputStream ci permette di creare una stream per scrivere al file con il nome specificato nella uri
            *
            * */
            /*
            * Array di byte che verra' popolato tramite il metodo read
            *
            * */
            byte[] buffer = new byte[1024];
            int length = 0;
            /*
            * il metodo read ci permette di leggere dei byte dal FileInputStream
            * e conservandoli in un array di byte
            *
            * */
            while((length = in.read(buffer))!= -1){
                System.out.println(length);
                /*
                * read e' un metodo per popolare il buffer di dati binari
                * ritorna un int length come indicatore
                *
                * - letture intermedie, questo indicatore e' uguale alla lunghezza del buffer
                * - nella penultima lettura, l'indicatore equivale alla quantita' di dati rimanente nella stream
                * - infine viene restituito -1 per indicare la fine della stream
                * */
                out.write(buffer, 0, length);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        String file3 = "G:\\Backup\\Master\\JavaWeb-Spring\\Spring-workspace\\NiohTesting\\src\\files\\TestoAuto.txt";
        try (InputStream in = new FileInputStream(file1);
        OutputStream out = new FileOutputStream(file3)) {
            /*
            * Un modo automatizzato per copiare il file
            * permette di trasferire tutti i dati da input a output
            * */
            long amountOfData = in.transferTo(out);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}