package com.io;


import java.nio.ByteBuffer;

public class NIOTest3 {

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(64);
        
        buffer.putInt(1);
        buffer.putShort((short)2);
        buffer.putLong(123456L);
        buffer.putDouble(12.345567);
        buffer.putChar('你');
        
        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getShort());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getDouble());
        System.out.println(buffer.getChar());
    }
}
