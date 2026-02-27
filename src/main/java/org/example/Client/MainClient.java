package org.example.Client;

public class MainClient {
    public static void main(String[] args) {
        Client client = new Client("eqi");

        Thread thread = new Thread(client);
        thread.run();
    }
}