import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private String nome;
    private String colore = "rosso";
    private Socket socket;
    PrintWriter output;
    BufferedReader input;

    public Client(String nomeDefault, String coloreDefault) {
        nome = nomeDefault;
        colore = coloreDefault;
    }

    public Client(String nomeDefault) {
        nome = nomeDefault;
    }

    public void connetti(String nomeServer, int portaServer) {
        try {
            socket = new Socket(nomeServer, portaServer);
            System.out.println(this.colore + "1) Connessione avvenuta");
            output = new PrintWriter(socket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.err.println("errore nella fase di connessione: " + e);
        }
    }

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
            socket.close();
        } catch (IOException e) {
            System.err.println("errore nella fase di chiusura del socket: " + e);
        }
    }
}