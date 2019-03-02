package com.io.oldio;


import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class OldIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8899);
        
        String fileName = "/Users/enn/Documents/win.iso";
        FileInputStream fileInputStream = new FileInputStream(fileName);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        
        byte[] buffer = new byte[4096];
        long total = 0;
        
        long startTime = System.currentTimeMillis();
        while (fileInputStream.read(buffer) >= 0) {
            total += 1;
            dataOutputStream.write(buffer);
        }

        System.out.println("总共发送：" + total + "字节，耗时：" + (System.currentTimeMillis()-startTime));
        
        socket.close();
        fileInputStream.close();
        dataOutputStream.close();
    }
}
