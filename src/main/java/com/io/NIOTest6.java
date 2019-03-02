package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * desc :
 * Created by tiantian on 2018/12/12
 */
public class NIOTest6 {

    public static void main(String[] args) throws  Exception {
        FileInputStream input = new FileInputStream("NioTest.txt");
        FileOutputStream out = new FileOutputStream("NioTest2.txt");

        FileChannel inChannel = input.getChannel();
        FileChannel outChannel = out.getChannel();

        ByteBuffer buffer = ByteBuffer.allocateDirect(512);

        while (true) {
            buffer.clear();

            int read = inChannel.read(buffer);
            System.out.println(read);
            if (-1 == read) {
                break;
            }
            buffer.flip();
            
            outChannel.write(buffer);
        }
        
        inChannel.close();
        outChannel.close();
        
    }
}
