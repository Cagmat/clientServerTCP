public class MainClient{

    public static void main(String[] args) {
        //Client c1 = new Client("caglio", "\u001B[34m");
        //Client c1 = new Client("tosti", "\u001B[33m");
        //Client c1= new Client("matteo", "\u001B[31m");
        Client c1 = new Client("gabriele", "\u001B[35m");

        c1.connetti("localhost", 2000);


        c1.scrivi("Ciao Server");


        System.out.println("Server dice: " + c1.leggi());
        c1.chiudi();


    }
}