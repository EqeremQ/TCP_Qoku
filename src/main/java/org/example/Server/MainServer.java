package org.example.Server;

public class MainServer {
    public static void main(String[] args) {
        Server server = new Server(3000);

        while (true) {
            server.attendi();
            server.leggi();
            server.chiudi();
            server.termina();
        }
    }
}