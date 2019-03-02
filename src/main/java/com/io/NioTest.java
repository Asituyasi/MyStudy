package com.io;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * desc : nio test
 * Created by tiantian on 2018/12/10
 */
public class NioTest {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("NioTest.txt");
        FileChannel channel = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(512);
        channel.read(buffer);
        
        buffer.flip();

        while (buffer.remaining() > 0) {
            byte b = buffer.get();
            System.out.println("Charater:" + (char)b);
        }
        
        buffer.flip();
        while (buffer.remaining() > 0) {
            byte b = buffer.get();
            System.out.println("Charater:" + b);
        }
    }
}
