package ru.job4j.io;

import java.io.*;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class EchoServer {
    private static boolean closeServer = false;

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        System.out.println(str);
                        Arrays.asList(str.split(" "))
                                .forEach(msg -> {
                                    if (msg.equals("/?msg=Bye")) {
                                        try {
                                            server.close();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                        str = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                }
            }
        }
    }
}
