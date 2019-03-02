package com.io.newio;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewIOClient {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8899));
        socketChannel.configureBlocking(true);

        String fileName = "/Users/enn/Documents/win.iso";
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();
        
        long startTime = System.currentTimeMillis();
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);

        System.out.println("共传输：" + transferCount + "字节，耗时：" +(System.currentTimeMillis() - startTime));
        
        fileChannel.close();
    }
}
