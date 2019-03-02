package com.io.newio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewIOServer {

    public static void main(String[] args) throws IOException {

        InetSocketAddress address = new InetSocketAddress(8899);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(address);
        
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true); //阻塞模式
            ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
            
            int readCount = 0;
            while (readCount != -1) {
                readCount = socketChannel.read(byteBuffer);
                byteBuffer.rewind();
            }
            
        }
    }
}
