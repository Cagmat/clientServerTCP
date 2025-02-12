
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private int porta;
    BufferedReader input;
    PrintWriter output;

    public Server(int porta) {
        this.porta = porta;
        try {
            // realizza la primitiva listen e bind
            serverSocket = new ServerSocket(porta);
            System.out.println("Server in ascolto");
            System.out.println("Aspettando un client ...");
            clientSocket = serverSocket.accept();
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            output = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            System.err.println("Server non in ascolto " + e);
            e.printStackTrace();
        }

    }

    // public Socket attendi() {
    // try {
    // clientSocket = serverSocket.accept();
    // input = new BufferedReader(new
    // InputStreamReader(clientSocket.getInputStream()));
    // output = new PrintWriter(clientSocket.getOutputStream(), true);
    // System.out.println("Client Accettato");
    // } catch (IOException e) {
    // System.err.println(e);
    // }
    // return clientSocket;
    // }

    public void scrivi(String messaggio) {
        output.println(messaggio);
    }

    public String leggi() {
        try {
            return input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void chiudi() {
        try {
            input.close();
            output.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void termina() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("errore nella fase di chiusura server: " + e);
        }
    }
}
