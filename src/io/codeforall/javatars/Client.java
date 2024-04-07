package io.codeforall.javatars;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket(InetAddress.getLocalHost(), Server.SERVER_PORT);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        while (true) {
            String current = message();
            String exit = "exit";
            out.println(current);
            if (current.equals(exit)) {
                clientSocket.close();
                out.close();
                break;
            }
        }
    }

    public static String message() {
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }
}
