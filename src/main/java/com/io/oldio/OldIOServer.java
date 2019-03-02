package com.io.oldio;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class OldIOServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);

        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            byte[] bytes = new byte[4096];
            while (true) {
                int readCount = dataInputStream.read(bytes);
                if (-1 == readCount) {
                    break;
                }
            }
            
            dataInputStream.close();
        }
    }
}
