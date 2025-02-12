public class MainServer{
    public static void main(String[] args) {

        Server s = new Server(2000);

        System.out.println("Client dice: " + s.leggi());
        s.scrivi("Ciao Client");
        s.chiudi();
        
    }
}