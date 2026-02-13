package org.example.Client;

public class MainClient {
    public static void main(String[] args) {
        Client client = new Client("eqi");

        client.connetti("localhost", 65535);
        client.scrivi();
    }
}