package io.codeforall.javatars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class Server {

    public static final int SERVER_PORT = 9004;


    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        Socket clientSocket = serverSocket.accept(); // BLOCK

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while (true) {
            String current = in.readLine();
            String exit = "exit";
            System.out.println(current);
            if (current.equals(exit)) {
                System.out.println("Chat ended");
                serverSocket.close();
                clientSocket.close();
                in.close();
                break;
            }
        }

    }
}


