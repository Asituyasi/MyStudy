package com.io;

import java.nio.ByteBuffer;


// slicebuffer 与原有的buffer共享底层数组
public class NIOTest4 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }
        
        buffer.position(2);
        buffer.limit(6);
        
        ByteBuffer sliceBuffer = buffer.slice();
        for (int i = 0; i < sliceBuffer.capacity(); i++) {
            byte b = sliceBuffer.get(i);
            b *= 2;
            sliceBuffer.put(i, b);
        }
        
        buffer.clear();
        
        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println(buffer.get());
        }
    }
}
