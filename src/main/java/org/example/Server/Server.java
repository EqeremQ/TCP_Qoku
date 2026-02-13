package org.example.Server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int porta;
    private ServerSocket serverSocket;
    private Socket clientSocket;

    public Server(int porta) {
        this.porta = porta;

        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("Server avviato sulla porta: " + porta);
        }
        catch (BindException e) {
            System.err.println("Porta " + porta + " è gia in uso.");
        }
        catch (IOException e) {
            System.err.println("Impossibile ascoltare sulla porta: " + porta);
        }
    }

    public Socket attendi() {
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Client connesso: " + clientSocket.getInetAddress());
        }
        catch (IOException e) {
            System.err.println("Conferma rifiutata.");
        }
        return clientSocket;
    }

    public void scrivi() {
        try {
            clientSocket.getOutputStream().write("Ciao ".getBytes());
            clientSocket.getOutputStream().flush();
        }
        catch (IOException e) {
            System.err.println("Impossibile scrivere sul client socket.");
        }
    }

    public void leggi() {
        try {
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String text = reader.readLine();

            System.out.println("Client: " + text);
        }
        catch (IOException e) {
            System.err.println("Impossibile leggere dal client socket.");
        }
    }

    public void chiudi() {
        try {
            clientSocket.close();
        }
        catch (IOException e) {
            System.err.println("Impossibile chiudere il client socket.");
        }
    }

    public void termina() {
        try {
            serverSocket.close();
        }
        catch (IOException e) {
            System.err.println("Impossibile chiudere il server socket.");
        }
    }

    public int getPorta() {
        return porta;
    }
}