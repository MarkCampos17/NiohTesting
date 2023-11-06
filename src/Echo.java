import java.io.Console;
import java.io.PrintWriter;
import java.util.Scanner;

public class Echo {
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        String txt = null;
//        System.out.println("To quit type: exit");
//        System.out.println("Type value and press enter:");
//        while (!(txt = s.nextLine()).equals("exit")){
//            System.out.println("Echo:" +txt);
//        }
          Console c = System.console();
          if (c == null){
              System.out.println("Console is not supported");
              return;
         }
         PrintWriter out = c.writer();
          out.println("To quite type: exit");
          out.println("Type value and press enter: ");
          String txt = null;
          while(!(txt = c.readLine()).equals("exit")){
              out.println("Echo: "+txt);
          }

    }
}
