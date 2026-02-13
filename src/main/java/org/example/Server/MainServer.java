package org.example.Server;

public class MainServer {
    public static void main(String[] args) {
        Server server = new Server(2000);

        while (true) {
            server.connetti();
            server.leggi();
            server.scrivi();
            server.chiudi();
            server.termina();
        }
    }
}