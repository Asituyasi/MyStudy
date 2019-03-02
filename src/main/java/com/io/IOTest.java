package com.io;

import java.io.IOException;
import java.nio.IntBuffer;
import java.security.SecureRandom;


public class IOTest {

    public static void main(String[] args) throws IOException {
        test1();
    }
    
    public static void test1() {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            int rand = new SecureRandom().nextInt(20);
            intBuffer.put(rand);
        }
        
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
