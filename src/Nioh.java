import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;

public class Nioh {
    public static void main(String[] args) throws IOException {
        /*
        * La classe Path rappresenta i files e le cartelle
        * La classe Files provvede operazioni per gestire gli oggetti Path
        * La classe FileSystem descrive filesystem disponibili e le loro proprieta'
        *
        * Nella classe Path abbiamo il metodo toFile() per convertire gli oggetti path in file object
        * Nella classe File abbiamo il metodo toPath() per convertire gli oggetti file in path object
        * */
        /*
        *
        * Ti permette di prendere i fileSystem presenti nel dispositivo
        * */
        FileSystem fs = FileSystems.getDefault();
        /*
        * Fa vedere ogni memoria rigida il suo tipo e nome
        * */
        fs.getFileStores().forEach(s -> System.out.println(s.type()+' '+s.name()));
        /*
        * Fa vedere dove inizia una directory
        * */
        fs.getRootDirectories().forEach(p -> System.out.println(p));
        /*
        * Fa vedere il tipo di separatore utilizzato nel fileSystem di sistema
        * */
        String separator = fs.getSeparator();
        System.out.println(separator);
//        localizzare utenti o gruppi
//        UserPrincipalLookupService ul = fs.getUserPrincipalLookupService();
//        GroupPrincipal group = ul.lookupPrincipalByGroupName("staff");
//        UserPrincipal user = ul.lookupPrincipalByName("Mark");
//        if (user!=null){String name = user.getName();}
//        if (group!=null){String name = group.getName();}
        //possiamo controllare le caratteristiche degli file stores
        fs.getFileStores().forEach(s ->
        {
            try {
                System.out.println(s.name()+" "+s.getTotalSpace()+" "+s.getUnallocatedSpace()+" "+s.getUsableSpace());
            }catch(IOException e){
                System.out.println(e);
            }
        });
    }
}
