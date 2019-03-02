package com.io;


import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIoTest2 {

    public static void main(String[] args) throws Exception{
        FileOutputStream out = new FileOutputStream("NioTest2.txt");
        FileChannel channel = out.getChannel();
        
        byte[] bytes = "hello world, nihao!".getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);

        for (int i = 0; i < bytes.length; i++) {
            buffer.put(bytes[i]);
        }
        
        buffer.flip();
        
        channel.write(buffer);
    }
}
