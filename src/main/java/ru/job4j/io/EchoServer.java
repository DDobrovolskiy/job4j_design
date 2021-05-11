package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream()));
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    System.out.println("Client connect...");
                    String str = in.readLine().split(" ")[1];
                    String serverMessage = "What?";
                    if (str.startsWith("/?msg=")) {
                        if (str.equals("/?msg=Exit")) {
                            try {
                                serverMessage = "Close server...";
                                server.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else if (str.equals("/?msg=Hello")) {
                            serverMessage = "Hello";
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n");
                    out.write(serverMessage);
                    out.flush();
                }
            }
        }
    }
}
