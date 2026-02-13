package org.example.Server;

public class MainServer {
    public static void main(String[] args) {
        Server server = new Server(2000);

        while (true) {
            server.attendi();
            server.leggi();
            server.scrivi();
            server.chiudi();
            server.termina();
        }
    }
}