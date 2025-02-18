import java.io.IOException;
import java.util.Scanner;

public class MainServer{
    public static void main(String[] args) {
        int i = 0;
        int numClient = 0;
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("quanti client vuoi creare?");
            numClient = scanner.nextInt();
            scanner.close();
        } catch (Exception e){
            System.err.println("numero non valido" + e);
        }
        Server s = new Server(2000);
        while(i<numClient) {
            s.attendi();
            System.out.println("Client dice: " + s.leggi());
            s.scrivi("Ciao Client");
            i++;
        }
            s.chiudi();
    }
}