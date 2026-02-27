package org.example.Client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class Client implements Runnable {
    private final String nome;
    private Socket socket;

    public Client(String nome) {
        this.nome = nome;
    }

    public void connetti(String host, int porta) {
        try {
            socket = new Socket(host, porta);
            System.out.println("Client " + nome + " connesso al server: " + host + ":" + porta);
        }
        catch (IOException e) {
            System.err.println("Impossibile connettersi al server: " + host + ":" + porta);
        }
    }

    public void scrivi() {
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printer = new PrintWriter(outputStream, true);

            printer.print("Ciao\n");
        }
        catch (IOException e) {
            System.err.println("Impossibile scrivere sul server.");
        }
    }

    public void leggi() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String testo = reader.readLine();

            System.out.println("Server: " + testo);
        }
        catch (IOException e) {
            System.err.println("Impossibile leggere dal server socket");
        }
    }

    public void chiudi() {
        try {
            socket.close();
        }
        catch (IOException e) {
            System.err.println("Impossibile chiudere il socket client.");
        }
    }

    @Override
    public void run(){
        connetti("localhost", 3000);
        scrivi();
        chiudi();
    }

}